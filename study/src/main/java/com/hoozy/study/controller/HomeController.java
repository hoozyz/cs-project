package com.hoozy.study.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

	private final List<HttpSession> loggedInUsers = LoggedInUsersListener.getLoggedInUsers(); // 현재 로그인 유저 리스트 담겨져있음
	
	private final KnowService knowService;
	private final TodayService todayService;
	private Map<String, List<Know>> map = new HashMap<>(); // 홈페이지 3문제씩 담을 map

	@GetMapping("/")
	public String home(Model model, @SessionAttribute(name = "loginUser", required = false) User loginUser) {
		model.addAttribute("user", new User());

		if (loginUser != null) {
			model.addAttribute("user", loginUser); // 로그인 했을 경우 user 변경
		}

		// 현재 로그인 한 유저 리스트 세션에 넣기
		List<User> userList = new ArrayList<>();
		for (HttpSession session : loggedInUsers) { // 현재 로그인 되어있는 유저 리스트
			userList.add((User) session.getAttribute("loginUser"));
		} 
		model.addAttribute("userList", userList); // 유저 리스트를 모델에 넣기

		// 오늘의 문제가 없을 떄
		if (todayService.findOne() == 0) {
			map = knowService.findAllByShort();

			for (int i = 0; i < map.size(); i++) {
				for (Know k : map.get("list" + i)) {
					Today today = new Today();
					today.setKnow(k);
					System.out.println(k);
					todayService.save(today); // 번호 1씩 추가해서 바꾸기
				}
			}
			map.clear();
		}

		List<Today> list = new ArrayList<>();
		list = todayService.findAll();

		// 오늘의 문제 가져와서 map에 넣기
		for (int i = 0; i < list.size() / 3; i++) {
			List<Know> knowList = new ArrayList<>();
			knowList.add(list.get(i * 3).getKnow());
			knowList.add(list.get((i * 3) + 1).getKnow());
			knowList.add(list.get((i * 3) + 2).getKnow());
			map.put("list" + i, knowList);
		}

		model.addAttribute("map", map);

		return "home";
	}
}
