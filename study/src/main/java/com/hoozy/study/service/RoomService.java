package com.hoozy.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hoozy.study.entity.Room;
import com.hoozy.study.repository.RoomRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomService {

	private final RoomRepository roomRepository;

	// 채팅방 전체 다 가져오기
	public List<Room> findAll() {
		List<Room> list = new ArrayList<>();

		list = roomRepository.findAll(Sort.by(Sort.Direction.DESC, "date")); // 최근 생성된 채팅방 순으로 정렬

		return list;
	}

	// 채팅방 하나 가져오기
	public Room findById(String id) {
		Room room = new Room();

		room = roomRepository.findById(id).get(); // Optinal의 get() : 있으면 가져오기

		return room;
	}
	
	// 채팅방 검색해서 가져오기
	public List<Room> findByName(String name) {
		List<Room> list = new ArrayList<>();
		name = "%" + name + "%";
		list = roomRepository.findByNameLike(name);

		return list;
	}

	// 채팅방 생성 -> 채팅방 이름으로
	@Transactional
	public Room create(String name, String nick) {
		Room room = new Room();
		
		room = Room.create(name, nick);
		roomRepository.save(room);
		room = findById(room.getId());
		return room;
	}
}
