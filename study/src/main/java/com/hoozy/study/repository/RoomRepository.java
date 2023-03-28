package com.hoozy.study.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoozy.study.entity.Room;

public interface RoomRepository extends JpaRepository<Room, String>{
	
	// 방 하나 가져오기 -> 번호
	Optional<Room> findById(String id);
	
	// 방 이름 검색으로 가져오기
	List<Room> findByNameLike(String name);
}
