package com.hoozy.study.entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "room")
public class Room {
	
	@Id
	private String id; // 방 고유 아이디 PK
	
	private String name; // 방 이름
	private String master; // 방장(생성자) 닉네임

	private Timestamp date; // 생성일
	
	@OneToMany(mappedBy = "room", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Chat> chatList = new ArrayList<>();
	
	public static Room create(String name, String master) { // 채팅방 이름으로 채팅방 만들기
		Room room = new Room();
		room.id = UUID.randomUUID().toString(); // UUID : 네트워크 상에서 중복되지 않는 ID를 만들기 위한 표준
		
		Timestamp time = new Timestamp(System.currentTimeMillis()); // 현재시간 밀리초까지
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		room.date = Timestamp.valueOf(sdf.format(time).replace(".0","")); // 밀리초 제거 후 타임스탬프로 바꾸기
		room.name = name;
		room.master = master;
		
		return room;
	}
}
