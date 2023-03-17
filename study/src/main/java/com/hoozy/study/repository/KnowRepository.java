package com.hoozy.study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoozy.study.entity.Know;
import com.hoozy.study.interfaces.KnowMapping;

public interface KnowRepository extends JpaRepository<Know, Long> {
	// 문제 번호로 문제 하나 가져오기
	Know findByNo(Long no);

	// 문제 이름으로 문제 가져오기
	Know findByName(String name);

	// 카테고리 별로 가져오기 -> 단답형
	List<Know> findByCateAndContNotLike(String cate, String star); // star = "*", * 포함하면 주관식

	// 카테고리 별로 가져오기 -> 주관식
	List<Know> findByCateAndContLike(String cate, String star); // star = "*", * 포함하면 주관식

	// 문제 이름만 가져오기 -> 지식 페이지 -> 인터페이스 이용
	List<KnowMapping> findByCate(String cate);
}
