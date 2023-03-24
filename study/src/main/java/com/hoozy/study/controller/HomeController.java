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
import com.hoozy.study.util.LoggedInUsersListener;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {
	
	private final List<HttpSession> loggedInUsers = LoggedInUsersListener.getLoggedInUsers(); // 현재 로그인 유저 리스트 담겨져있음
	
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
	public String home(Model model, @SessionAttribute(name = "loginUser", required = false) User loginUser, HttpServletRequest req) {
		model.addAttribute("user", new User());
		
		if(loginUser != null) {
			model.addAttribute("user", loginUser); // 로그인 했을 경우 user 변경
		}

		// 현재 로그인 한 유저 리스트 세션에 넣기
		List<User> userList = new ArrayList<>();
		for(HttpSession session : loggedInUsers) { // 현재 로그인 되어있는 유저 리스트
			userList.add((User) session.getAttribute("loginUser"));
		}
		model.addAttribute("userList", userList); // 유저 리스트를 모델에 넣기
		
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
