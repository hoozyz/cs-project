package com.hoozy.study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
	// 문제 2개를 제외하고 가져오기
	@Query(value = "select * from Know k where cate = :cate and k.no != :no1 and k.no != :no2", nativeQuery = true) // nativeQuery는 JPQL 말고 순수 SQL 구문을 사용한다고 선언하는 것이다.
	List<Know> notLike(@Param("no1") long no1, @Param("no2") long no2, @Param("cate") String cate);
	
	// 문제 3개를 제외하고 가져오기
	@Query(value = "select * from Know k where cate = :cate and k.no != :no1 and k.no != :no2 and k.no != :no3", nativeQuery = true)
	List<Know> notLike(@Param("no1") long no1, @Param("no2") long no2, @Param("no3") long no3, @Param("cate") String cate);
}
