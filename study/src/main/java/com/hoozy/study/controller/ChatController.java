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
	
	
	@MessageMapping("/chat/join") // 입장할 때 실행되는 메소드 -> prefixes 를 /app 로 해놔서 /app/chat/enter로 요청해야 컨트롤러가 받음
	public void join(Chat chat) {
		Room room = roomService.findById(chat.getId());
		chat.setRoom(room);
		
		List<Chat> chatList = new ArrayList<>(); // 현재 채팅
		
		chatList = chatService.findByRoomId(chat.getId()); // 최근 5개 가져옴
		if(!chatList.isEmpty()) {
			Chat dbChat = new Chat(); // db에 있는 메시지 담을 chat
			int size = 5; // 기본 i값
			if(chatList.size() < 5) {
				// 현재 채팅방의 존재하는 메시지 개수가 5개 미만이면 바꾸기
				size = chatList.size(); 
			}
			for(int i = size - 1; i < chatList.size(); i--) { // 최근 5개를 다시 역으로 나중꺼부터 보내기
				
				// db에 있는 메시지 5개를 닉네임 5개를 한 문자열로, 메시지도 5개를 한 문자열로 저장해서 보내기
				if(i == size - 1) { 
					dbChat.setNick(chatList.get(i).getNick());
					dbChat.setMsg(chatList.get(i).getMsg());
				} else {
					dbChat.setNick(dbChat.getNick() + "/" + chatList.get(i).getNick());
					dbChat.setMsg(dbChat.getMsg() + "/" + chatList.get(i).getMsg());
				}
				
				dbChat.setProfile(chatList.get(i).getProfile());
				if(i == 0) {
					dbChat.setType(MessageType.FIRST); // 처음 들어갈 때만 나오는 메시지
					template.convertAndSend("/topic/chat/room/" + chat.getId(), dbChat); // 5개의 메시지를 하나로 보냄 -> 방금 들어온 유저한테만 보내기
					break;
				}
			}
		}
		
		// 마지막에 환영 메시지
		template.convertAndSend("/topic/chat/room/" + chat.getId(), chat); // /topic 이므로 전체에 전송 -> 환영메시지
	}
	
	@MessageMapping("/chat/leave") 
	public void leave(Chat chat) {
		Room room = roomService.findById(chat.getId());
		chat.setRoom(room);
		chat.setType(MessageType.LEAVE);
		template.convertAndSend("/topic/chat/room/" + chat.getId(), chat); 
		
	}
	
	@MessageMapping("/chat/message") // 메시지를 보낼 때 실행되는 메소드
	public void message(Chat chat) {
		Room room = roomService.findById(chat.getId());
		chat.setRoom(room);
		template.convertAndSend("/topic/chat/room/" + chat.getId(), chat); 

		Chat chatSave = new Chat().create(room, chat.getNick(), chat.getMsg(), MessageType.CHAT, chat.getProfile());
		chatService.save(chatSave); // DB에 저장
	}
}
