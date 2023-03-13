package com.hoozy.study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoozy.study.entity.Addi;
import com.hoozy.study.entity.AddiPK;

public interface AddiRepository extends JpaRepository<Addi, AddiPK>{
	
	// 만약 know의 cont(내용)에 *인 내용은 추가적으로 테이블 형식 지식.
	List<Addi> findAllByAddiNo(Long no); // Addi 엔티티의 addi 필드의 no -> addi.no와 같은 의미
}
