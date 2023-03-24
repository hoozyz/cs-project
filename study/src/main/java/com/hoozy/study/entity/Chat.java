package com.hoozy.study.entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "chat")
public class Chat {
	
	public enum MessageType { // 메시지 타입 입장, 퇴장, 메시지전송
		JOIN, LEAVE, CHAT
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long no; // 채팅 PK
	
	private MessageType type;
	
	@ManyToOne
	@JoinColumn(name = "roomid")
	private Room room; // FK
	
	@Transient // 엔티티 내부의 필드지만 DB와는 연동안됨
	private String id;
	
	private String nick; // 작성자 닉네임
	private String profile; // 작성자 프로필
	private String msg; // 메시지 내용
	private Timestamp date; // 작성 날짜
	
	public Chat create(Room room, String nick, String msg, MessageType type) {
		Chat chat = new Chat();
		
		Timestamp time = new Timestamp(System.currentTimeMillis()); // 현재시간 밀리초까지
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		chat.date = Timestamp.valueOf(sdf.format(time).replace(".0","")); // 밀리초 제거 후 타임스탬프로 바꾸기
		chat.setMsg(msg);
		chat.setType(type);
		chat.setNick(nick);
		chat.setRoom(room);
		
		return chat;
	}
}
