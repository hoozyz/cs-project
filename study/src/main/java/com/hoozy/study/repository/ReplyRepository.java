package com.hoozy.study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoozy.study.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long>{
	
	// 지식의 댓글 모두 가져오기
	// findBy + (FK를 관리하는 엔티티(참조 테이블)의 첫 글자를 대문자) + '_' + (FK 엔티티의 식별자 필드명에서 첫 글자를 대문자) 
	// findBy + (FK가 PK인 테이블) + '_' + (FK 보유 테이블)
	List<Reply> findByKnowNo(long no);
	
	// 모댓글 개수 가져오기
	List<Reply> findByReplLike(int repl);
}
