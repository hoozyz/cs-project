package com.hoozy.study.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.hoozy.study.entity.Know;
import com.hoozy.study.entity.User;
import com.hoozy.study.service.KnowService;
import com.hoozy.study.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor // final 옵션 필드 전부 포함한 생성자 만들어줌
@Slf4j
public class UserController {

	private final UserService userService;
	private final KnowService knowService;

	@PostMapping("/login")
	public String login(@ModelAttribute User user, Model model, HttpServletRequest req, HttpServletResponse resp,
			boolean emailStore) throws Exception {

		// 세션 생성
		HttpSession session = req.getSession();

		if (!userService.login(user)) {
			model.addAttribute("msg", "로그인 실패");
			return "home";
		}

		// 이메일를 쿠키에 저장
		if (emailStore) {
			Cookie cookie = new Cookie("email", String.valueOf(user.getEmail()));
			resp.addCookie(cookie);
			log.info("쿠키 정보 {}", cookie);
		} else {
			Cookie cookie = new Cookie("email", null);
			cookie.setMaxAge(0); // 쿠키시간 0으로 삭제하는 법
			resp.addCookie(cookie);
		}
		user = userService.findByEmail(user.getEmail());
		user.setPwd("");
		user.setSalt("");

		// 홈페이지 랜덤 문제 3개 가져오기
		Map<String, List<Know>> map = new HashMap<>();
		map = knowService.findAllByShort();
		model.addAttribute("map", map);
		
		session.setAttribute("loginUser", user);
		model.addAttribute("user", user);
		model.addAttribute("msg", "로그인 성공");
		
		log.info("로그인 유저 {}", user);

		return "home";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "home";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "home";
	}

	@GetMapping("/user/update")
	public String update(Model model) {
		model.addAttribute("user", new User());
		return "home";
	}

	@PostMapping("/user/update")
	public String update(User user, Model model, HttpSession session, MultipartFile file,
			@SessionAttribute(name = "loginUser", required = false) User loginUser, HttpServletRequest req)
			throws Exception {

		loginUser = userService.findByEmail(loginUser.getEmail());
		if(!user.getNick().equals("")) {
			loginUser.setNick(user.getNick()); // 바뀐 닉네임 저장
		}

		if(!user.getPwd().equals("")) {
			// 바뀐 비밀번호 해싱
			loginUser.setPwd(userService.hashing(user.getPwd().getBytes(), loginUser.getSalt()));
		}

		// 파일 변경 시
		if (!file.isEmpty()) {
			String rootPath = "C:\\Users\\kimyo\\Documents";
			String savePath = rootPath + "\\upload\\images\\";
			String renameFileName = userService.saveFile(file, savePath);

			loginUser.setProfile(renameFileName);
		}
		userService.update(loginUser);
		loginUser.setPwd("");
		loginUser.setSalt("");

		// 홈페이지 랜덤 문제 3개 가져오기
		Map<String, List<Know>> map = new HashMap<>();
		map = knowService.findAllByShort();
		model.addAttribute("map", map);

		session.setAttribute("loginUser", loginUser);
		model.addAttribute("user", loginUser);
		model.addAttribute("msg", "정보 변경이 완료되었습니다.");

		return "home";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute User user, Model model, HttpServletRequest req) throws Exception {
		String location = req.getHeader("referer");
		model.addAttribute("url", location);

		log.info("회원가입 정보 {}", user);
		if (user.getNick() == null) {
			log.info("회원가입 실패");
			model.addAttribute("msg", "회원가입 실패");
			return "msg";
		} else {
			model.addAttribute("msg", "회원가입 성공");
			userService.create(user);
		}

		// 홈페이지 랜덤 문제 3개 가져오기
		Map<String, List<Know>> map = new HashMap<>();
		map = knowService.findAllByShort();
		model.addAttribute("map", map);

		return "home";
	}

	@GetMapping("/logout")
	public String logout(Model model, HttpServletRequest req) {

		HttpSession session = req.getSession();
		session.invalidate(); // 세션 삭제
		model.addAttribute("msg", "로그아웃 되었습니다.");
		model.addAttribute("user", new User());

		// 홈페이지 랜덤 문제 3개 가져오기
		Map<String, List<Know>> map = new HashMap<>();
		map = knowService.findAllByShort();
		model.addAttribute("map", map);
		
		return "home";
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

	@PostMapping("/check/pwd")
	@ResponseBody
	public String pwdCheck(String email, String pwd) throws Exception {
		return userService.checkPwd(email, pwd);
	}
}
