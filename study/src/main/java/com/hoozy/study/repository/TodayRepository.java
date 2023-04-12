package com.hoozy.study.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hoozy.study.entity.Today;

public interface TodayRepository extends JpaRepository<Today, Long>{
	
	// 오늘의 문제 첫 번호 가져오기
	@Query(value = "select * from today limit 1", nativeQuery = true)
	Optional<Today> findOne();
	
	// 문제 바꾸기
	@Transactional
	@Modifying // select 문이 아님을 표시
	@Query( value = "update today set kno = :kno where no = :no", nativeQuery = true)
	void update(@Param("no") long no,@Param("kno") int kno);
}
