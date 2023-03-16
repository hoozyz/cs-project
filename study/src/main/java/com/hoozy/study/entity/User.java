package com.hoozy.study.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
