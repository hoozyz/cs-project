package com.hoozy.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoozy.study.entity.User;
import com.hoozy.study.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

	@Autowired
	private final UserService userService;

	@GetMapping("/login")
	public String login(@ModelAttribute User user, Model model, HttpServletRequest req,
		HttpServletResponse resp, boolean emailStore) throws Exception {
		String location = req.getHeader("referer");
		model.addAttribute("url", location);
		
		// 세션 생성
		HttpSession session = req.getSession();
		
		if(!userService.login(user)) {
			model.addAttribute("msg", "로그인 실패");
			return "msg";
		} 
		log.info("아이디 저장 체크 {}", emailStore);
		// 이메일를 쿠키에 저장
		if(emailStore) {
			Cookie cookie = new Cookie("email", String.valueOf(user.getEmail()));
		    resp.addCookie(cookie);
		    log.info("쿠키 정보 {}", cookie);
		} else {
			Cookie cookie = new Cookie("email", null);
			cookie.setMaxAge(0); // 쿠키시간 0으로 삭제하는 법
		    resp.addCookie(cookie);
		}
		
		session.setAttribute("loginUser", user);
		model.addAttribute("loginUser", user);
		model.addAttribute("msg", "로그인 성공");
		
		return "msg";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "home";
	}
	
	
	@PostMapping("/register")
	public String register(@ModelAttribute User user, Model model, HttpServletRequest req) throws Exception {
		String location = req.getHeader("referer");
		model.addAttribute("url", location);
		
		log.info("이전페이지 {}", location);
		log.info("회원가입 정보 {}", user);
		if(user.getNick() == null) {
			log.info("회원가입 실패");
			model.addAttribute("msg", "회원가입 실패");
			return "msg";
		} else {
			model.addAttribute("msg", "회원가입 성공");
			userService.create(user);
		}
		
		
		return "msg";
	}
	
	@GetMapping("/logout")
	public String logout(Model model, HttpServletRequest req) {
		String location = req.getHeader("referer");
		
		HttpSession session = req.getSession();
		session.invalidate(); // 세션 삭제
		
		return "redirect:" + location;
	}
	
	// check 기능
	@GetMapping("/check/nick")
	@ResponseBody
	public String nickCheck(String nick) {
		return userService.checkNick(nick);
	}
	
	@GetMapping("/check/email")
	@ResponseBody
	public String emailCheck(String email) {
		return userService.checkEmail(email);
	}
}
