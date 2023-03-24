package com.hoozy.study.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.hoozy.study.entity.Chat;
import com.hoozy.study.entity.Chat.MessageType;
import com.hoozy.study.entity.Room;
import com.hoozy.study.service.ChatService;
import com.hoozy.study.service.RoomService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ChatController {
	
	private final SimpMessagingTemplate template;
	private final ChatService chatService;
	private final RoomService roomService;
	
	
	@MessageMapping("/chat/join") // 입장할 때 실행되는 메소드 -> prefixes 를 /ass 로 해놔서 /add/chat/enter로 요청해야 컨트롤러가 받음
	public void join(Chat chat) {
		Room room = roomService.findById(chat.getId());
		chat.setRoom(room);
		log.info("chatSave {}", chat.getNick().toString());
		template.convertAndSend("/topic/chat/room/" + chat.getRoom().getId(), chat); // /topic 이므로 전체에 전송 -> 환영메시지
		
		
	}
	
	@MessageMapping("/chat/leave") // 입장할 때 실행되는 메소드 -> prefixes 를 /ass 로 해놔서 /add/chat/enter로 요청해야 컨트롤러가 받음
	public void leave(Chat chat) {
		Room room = roomService.findById(chat.getId());
		chat.setRoom(room);
		log.info("chatSave {}", chat.getNick().toString());
		template.convertAndSend("/topic/chat/room/" + chat.getRoom().getId(), chat); 
		
	}
	
	@MessageMapping("/chat/message") // 메시지를 보낼 때 실행되는 메소드
	public void message(Chat chat) {
		Room room = roomService.findById(chat.getId());
		chat.setRoom(room);
		template.convertAndSend("/topic/chat/room" + chat.getRoom().getId(), chat); // 해당 방에 전체 메시지 날리기
		log.info("chatSave {}", chat.getId().toString());

		Chat chatSave = new Chat().create(room, chat.getNick(), chat.getMsg(), MessageType.CHAT);
		chatService.save(chatSave); // DB에 저장
		
		List<Chat> chatList = new ArrayList<>();

		chatList = chatService.findByRoomId(chat.getRoom().getId());
		if(chatList != null) {
			for(Chat c : chatList) {
				log.info("채팅 리스트 {}", c.getNick().toString());
				chat.setNick(c.getNick());
				chat.setMsg(c.getMsg());
			}
		}
	}
}
