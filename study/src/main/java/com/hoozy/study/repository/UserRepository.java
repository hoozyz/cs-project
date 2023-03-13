package com.hoozy.study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoozy.study.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	// PK인 닉네임으로 유저 가져오기
	User findByNick(String nick);
	
	// 로그인할 때 email로 salt 찾기
	User findByEmail(String email);
	
	// 자신 빼고 유저 가져오기
	List<User> findAllByNickNotLike(String nick);
}
