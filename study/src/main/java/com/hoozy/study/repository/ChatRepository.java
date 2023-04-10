package com.hoozy.study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hoozy.study.entity.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long>{
	
	// 룸의 채팅 내역 가져오기 -> Room의 PK인 id로 가져오기 -> 최근 5개만
	@Query( value = "select * from Chat c where c.roomid = :id order by c.no desc limit 5", nativeQuery = true)
	List<Chat> findByRoomId(@Param("id") String id);

	// 채팅방 채팅 삭제
	void deleteByRoomId(String id);
}
