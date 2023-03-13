package com.hoozy.study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoozy.study.entity.Know;

public interface KnowRepository extends JpaRepository<Know, Long>{
	
	// 문제 번호로 문제 하나 가져오기
	Know findByNo(Long no);
	
	// 카테고리 별로 가져오기
	List<Know> findByCate(String cate);
	
	
//	List<Know> 
}
