package com.hoozy.study.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.hoozy.study.entity.Know;
import com.hoozy.study.entity.Today;
import com.hoozy.study.entity.User;
import com.hoozy.study.service.KnowService;
import com.hoozy.study.service.TodayService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final KnowService knowService;
	private final TodayService todayService;
	private Map<String, List<Know>> map = new HashMap<>(); // 홈페이지 3문제씩 담을 map
	
	// 매일 9시에 오늘의 문제 바꾸기
	@Scheduled(cron = "0 0 9 * * *") // 0초 0분 9시 매일 매주 모든요일
	public void knowToday() {
		map = knowService.findAllByShort();
		
		long no = 0L;
		for(int i = 0; i < map.size(); i++) {
			for(Know k : map.get("list"+i)) {
				int kno = (int) k.getNo();
				todayService.update(no++, kno); // 번호 1씩 추가해서 바꾸기
			}
		}
	}
	
	@GetMapping("/")
	public String logina(Model model, @SessionAttribute(name = "loginUser", required = false) User loginUser) {
		model.addAttribute("user", new User());
		
		if(loginUser != null) {
			model.addAttribute("user", loginUser); // 로그인 했을 경우 user 변경
		}
		
		// 오늘의 문제가 없을 때
//		map = knowService.findAllByShort();
//		
//		for(int i = 0; i < map.size(); i++) {
//			for(Know k : map.get("list"+i)) {
//				Today today = new Today();
//				today.setKnow(k);
//				System.out.println(k);
//				todayService.save(today); // 번호 1씩 추가해서 바꾸기
//			}
//		}
//		map.clear();
		
		List<Today> list = new ArrayList<>();
		list = todayService.findAll();
		
		// 오늘의 문제 가져와서 map에 넣기
		for(int i = 0; i < list.size() / 3; i++) {
			List<Know> knowList = new ArrayList<>();
			knowList.add(list.get(i*3).getKnow());
			knowList.add(list.get((i*3)+1).getKnow());
			knowList.add(list.get((i*3)+2).getKnow());
			map.put("list"+i, knowList);
		}
		
		model.addAttribute("map", map);
		
		return "home";
	}
}
