package com.hoozy.study.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.hoozy.study.entity.Room;
import com.hoozy.study.entity.User;
import com.hoozy.study.service.RoomService;
import com.hoozy.study.util.LoggedInUsersListener;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/chat")
public class RoomController {

	private final List<HttpSession> loggedInUsers = LoggedInUsersListener.getLoggedInUsers(); // 현재 로그인 유저 리스트 담겨져있음

	private final RoomService roomService;

	// 채팅방 전체 가져오기
	@GetMapping("/rooms") // 오픈 채팅 페이지
	public String findAll(Model model) {
		List<Room> list = new ArrayList<>();

		model.addAttribute("user", new User());
		model.addAttribute("room", new Room());

		// 현재 로그인 한 유저 리스트 세션에 넣기
		List<User> userList = new ArrayList<>();
		for (HttpSession session : loggedInUsers) { // 현재 로그인 되어있는 유저 리스트
			userList.add((User) session.getAttribute("loginUser"));
		}
		model.addAttribute("userList", userList); // 유저 리스트를 모델에 넣기

		list = roomService.findAll();

		model.addAttribute("roomList", list); // 최신 생성방이 먼저

		return "room";
	}

	// 채팅방 검색
	@GetMapping("/room/search")
	@ResponseBody
	public List<Room> findByName(String name) { 
		List<Room> list = new ArrayList<>();
		log.info("name {}", name);
		list = roomService.findByName(name);
		log.info("list {}", list);

		return list;
	}

	// 채팅방 생성 -> 채팅방 이름으로
	@PostMapping("/room/create")
	@ResponseBody
	public Room create(@RequestParam String name, @SessionAttribute(name = "loginUser", required = false) User loginUser) {
		Room room = new Room();

		room = roomService.create(name, loginUser.getNick());

		return room;
	}
}
