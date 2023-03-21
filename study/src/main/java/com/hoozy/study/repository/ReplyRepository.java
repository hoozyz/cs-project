package com.hoozy.study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hoozy.study.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long>{
	
	// 지식의 댓글 모두 가져오기
	// findBy + (FK를 관리하는 엔티티(참조 테이블)의 첫 글자를 대문자) + '_' + (FK 엔티티의 식별자 필드명에서 첫 글자를 대문자) 
	// findBy + (FK가 PK인 테이블) + '_' + (FK 보유 테이블)
	List<Reply> findByKnowNoAndRepl(long no, int repl);
	
	// 댓글 번호로 댓글 정보 가져오기
	Reply findByNo(long no);
	
	// 모댓글의 답글 가져오기
	List<Reply> findByRepnLike(int repn);
	
	// 현재 댓글의 마지막 번호 -> 댓글 수정할 때 필요
	@Query("select r.no from Reply r order by r.no desc limit 1")
	long findLastNo();
	
	// 댓글 삭제
	@Transactional
	@Modifying // select 문이 아님을 표시
	@Query("update Reply r set r.checks = 1 where r.no = :no")
	void deleteReply(@Param("no") long no);
}
