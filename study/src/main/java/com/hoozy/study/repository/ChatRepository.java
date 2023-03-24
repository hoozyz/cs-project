package com.hoozy.study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoozy.study.entity.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long>{
	
	// 룸의 채팅 내역 가져오기 -> Room의 PK인 id로 가져오기
	List<Chat> findByRoomId(String id);
}
