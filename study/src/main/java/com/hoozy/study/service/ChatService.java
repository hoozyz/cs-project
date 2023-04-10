package com.hoozy.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hoozy.study.entity.Chat;
import com.hoozy.study.repository.ChatRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {

	private final ChatRepository chatRepository;

	// 현재 채팅방의 기존 댓글 가져오기 -> 최근 5개만
	public List<Chat> findByRoomId(String id) {
		List<Chat> list = new ArrayList<>();

		list = chatRepository.findByRoomId(id);

		return list;
	}

	// 챗 메시지 저장
	public void save(Chat chat) {
		chatRepository.save(chat);
	}

	// 채팅방의 채팅 삭제하기
	@Transactional
	public void deleteChatById(String id) {
		chatRepository.deleteByRoomId(id);
	}
}
