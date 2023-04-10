package com.hoozy.study.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.hoozy.study.entity.Know;
import com.hoozy.study.entity.User;
import com.hoozy.study.interfaces.KnowMapping;
import com.hoozy.study.service.KnowService;
import com.hoozy.study.util.LoggedInUsersListener;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class KnowController {

	private final List<HttpSession> loggedInUsers = LoggedInUsersListener.getLoggedInUsers(); // 현재 로그인 유저 리스트 담겨져있음
	
	private final KnowService knowService;
	
	// 지식 페이지
	@GetMapping("/know")
	public String know(Model model, @SessionAttribute(name = "loginUser", required = false) User loginUser) {
		model.addAttribute("user", new User());
		
		if(loginUser != null) {
			model.addAttribute("user", loginUser); // 로그인 했을 경우 user 변경
		}
		
		Map<String, List<KnowMapping>> map = new HashMap<>();
		
		map = knowService.findAllByCate();
		
		model.addAttribute("map", map);
		
		// 현재 로그인 한 유저 리스트 세션에 넣기
		List<User> userList = new ArrayList<>();
		for(HttpSession session : loggedInUsers) { // 현재 로그인 되어있는 유저 리스트
			userList.add((User) session.getAttribute("loginUser"));
		}
		model.addAttribute("userList", userList); // 유저 리스트를 모델에 넣기
		
		return "know";
	}
	
	// 지식 가져오기
	@PostMapping("/know/cont")
	@ResponseBody
	public Know knowCont(String name) {
		Know know = new Know();
		 
		know = knowService.findByName(name);
		
		return know;
	}
	
	// 좋아요 수정
	@PostMapping("/know/like")
	@ResponseBody
	public void like(String name, int check, @SessionAttribute(name = "loginUser", required = false) User loginUser) {
		Know know = new Know();
		System.out.println(name);
		know = knowService.findByName(name);
		if(check == 1) { // 좋아요 추가
			know.setLikes(know.getLikes() + 1);
			if(know.getLikenick() == null) { // 첫 유저
				know.setLikenick(loginUser.getNick()); // 현재 로그인 한 유저 좋아요 닉네임 목록에 추가
			} else {
				know.setLikenick(know.getLikenick() + " " + loginUser.getNick()); // 현재 로그인 한 유저 좋아요 닉네임 목록에 추가
			}
		} else { // 좋아요 제거
			know.setLikes(know.getLikes() - 1);
			String userStr = ""; // 유저 닉네임 목록 문자열 생성
			for(String user : know.getLikenick().split(" ")) { // user 목록 가져오고 현재 로그인 한 닉네임 제거
				 if(user.equals(loginUser.getNick())) {
					 continue; // 추가 안함.
				 }
				 userStr += user;
			}
			know.setLikenick(userStr); 
		}
		knowService.save(know);
	}
	
	// 문제 바꾸기
	@PostMapping("/know/throw")
	@ResponseBody
	public Know knowThrow(long no1, long no2, long no3, String cate) {
		Know know = new Know();
		
		if(no3 == 0) { // 주관식 문제일 때
			know = knowService.findByNoNotLike(no1, no2, cate);
		} else { // 단답형 문제일 때
			know = knowService.findByNoNotLike(no1, no2, no3, cate);
			while(know.getCont().contains("*")) { // 주관식이면
				know = knowService.findByNoNotLike(no1, no2, no3, cate);
			}
		}
		
		return know;
	}
}
