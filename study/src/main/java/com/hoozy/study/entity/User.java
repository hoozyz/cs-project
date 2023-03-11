package com.hoozy.study.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL -> 자동으로 1 증가 PK
	private String nick; // 닉네임 PK
	
	private String email;
	private String pwd;
	private String profile; // 프로필 파일 명
	private String name;
	
	@OneToMany(mappedBy = "user") // 참조되는 테이블
	private List<Reply> replys = new ArrayList<>();
	
	@Builder
	public User(String email, String pwd, String profile, String name) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.profile = profile;
		this.name = name;
	}
}
