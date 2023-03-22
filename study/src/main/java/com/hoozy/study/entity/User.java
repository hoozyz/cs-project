package com.hoozy.study.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {
	
	@Id // 문자열은 id만 
	private String email; // 안바뀌는 이메일 PK
	
	private String nick;
	private String pwd;
	
	private String salt;
	private String profile; // 프로필 파일 명
	private String kno; // 맞춘 문제 목록
	
	@Builder
	public User(String nick, String email, String pwd, String salt, String profile) {
		super();
		this.nick = nick;
		this.email = email;
		this.pwd = pwd;
		this.salt = salt;
		this.profile = profile;
	}
}
