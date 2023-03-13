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
	private String nick; // 닉네임 PK
	
	private String email;
	private String pwd;
	
	private String salt;
	private String profile; // 프로필 파일 명
	
	@OneToMany(mappedBy = "user") // 참조되는 테이블
	private List<Reply> replys = new ArrayList<>();
	
	@Builder
	public User(String email, String pwd, String salt, String profile) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.salt = salt;
		this.profile = profile;
	}
}
