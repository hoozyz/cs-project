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

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/chat")
public class RoomController {
	
	private final RoomService roomService; 

	// 채팅방 전체 가져오기
	@GetMapping("/rooms") // 오픈 채팅 페이지
	public String findAll(Model model) {
		List<Room> list = new ArrayList<>();
		
		model.addAttribute("user", new User());
		model.addAttribute("room", new Room());
		
		list = roomService.findAll();
		log.info("채팅방 목록 {}", list);
		
		model.addAttribute("roomList", list); // 최신 생성방이 먼저

		return "room";
	}
	
	// 채팅방 검색
	@GetMapping("/room/{name}")
	@ResponseBody
	public List<Room> findByName(@PathVariable String name) { // requestmapping 에서 url에 {}내부의 변수를 바로 받음
		List<Room> list = new ArrayList<>();
		
		list = roomService.findByName(name);
		
		return list;
	}
	
	// 룸 아이디로 가져오기
	@GetMapping("/room/{roomId}")
	@ResponseBody
	public Room findById(@PathVariable String roomId) { // requestmapping 에서 url에 {}내부의 변수를 바로 받음
		Room room = new Room();
		log.info("id {}", roomId);
		room = roomService.findById(roomId);
		
		return room;
	}
	
	// 채팅방 생성 -> 채팅방 이름으로
	@PostMapping("/room/create")
	@ResponseBody
	public Room create(@RequestParam String name, @RequestParam String pwd, @SessionAttribute(name = "loginUser", required = false) User loginUser) {
		Room room = new Room();
		
		room = roomService.create(name, pwd, loginUser.getNick());
		
		return room;
	}
	
	// 채팅방 입장
	@PostMapping("/room/enter")
	@ResponseBody
	public Room enter(@RequestParam String id) {
		Room room = new Room();
		
		room = roomService.findById(id);
		
		return room;
	}
}
