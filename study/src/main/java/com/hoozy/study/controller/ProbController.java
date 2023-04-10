package com.hoozy.study.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.hoozy.study.entity.Addi;
import com.hoozy.study.entity.Know;
import com.hoozy.study.entity.User;
import com.hoozy.study.service.AddiService;
import com.hoozy.study.service.KnowService;
import com.hoozy.study.util.LoggedInUsersListener;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/prob")
public class ProbController {

	private final List<HttpSession> loggedInUsers = LoggedInUsersListener.getLoggedInUsers(); // 현재 로그인 유저 리스트 담겨져있음

	private final KnowService knowService;
	private final AddiService addiService;

	@GetMapping("/short")
	public String probShort(Model model, @SessionAttribute(name = "loginUser", required = false) User loginUser) {
		model.addAttribute("user", new User());

		if (loginUser != null) {
			model.addAttribute("user", loginUser);
		}

		Map<String, List<Know>> map = new HashMap<>();
		map = knowService.findAllByShort();

		model.addAttribute("map", map);

		// 현재 로그인 한 유저 리스트 세션에 넣기
		List<User> userList = new ArrayList<>();
		for (HttpSession session : loggedInUsers) { // 현재 로그인 되어있는 유저 리스트
			userList.add((User) session.getAttribute("loginUser"));
		}
		model.addAttribute("userList", userList); // 유저 리스트를 모델에 넣기

		return "probShort";
	}

	@GetMapping("/long")
	public String probLong(Model model, @SessionAttribute(name = "loginUser", required = false) User loginUser) {
		model.addAttribute("user", new User());

		if (loginUser != null) {
			model.addAttribute("user", loginUser);
		}

		List<Addi> addiList = new ArrayList<>();

		Map<String, List<Know>> knowMap = new HashMap<>();

		knowMap = knowService.findAllByLong();
		for (int i = 0; i < knowMap.size(); i++) {
			for (int j = 0; j < knowMap.get("list" + i).size(); j++) {

				Know know = knowMap.get("list" + i).get(j);
				if (know.getCont().equals("*")) { // 추가 정보 문제일 때
					for (Addi a : addiService.findByNo(know.getNo())) { // addiList에 추가 정보 다 넣고 나중에 번호로 가져오기
						addiList.add(a);
					}
				}
			}
		}

		// 현재 로그인 한 유저 리스트 세션에 넣기
		List<User> userList = new ArrayList<>();
		for (HttpSession session : loggedInUsers) { // 현재 로그인 되어있는 유저 리스트
			userList.add((User) session.getAttribute("loginUser"));
		}
		model.addAttribute("userList", userList); // 유저 리스트를 모델에 넣기

		model.addAttribute("knowMap", knowMap);
		model.addAttribute("addiList", addiList);

		return "probLong";
	}
}
