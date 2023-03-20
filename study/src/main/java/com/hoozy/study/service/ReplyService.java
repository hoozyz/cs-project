package com.hoozy.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoozy.study.entity.Reply;
import com.hoozy.study.repository.ReplyRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReplyService {
	
	@Autowired
	private ReplyRepository replyRepository;
	
	// 지식 번호로 모댓글 가져오기
	public List<Reply> findByKnowNo(long no) {
		List<Reply> list = new ArrayList<>();
		
		list = replyRepository.findByKnowNoAndRepl(no, 0); // 모댓글은 repl = 0
		
		return list;
	}
	
	// 댓글 번호로 가져오기
	public Reply findByNo(long no) {
		Reply reply = new Reply();
		
		reply = replyRepository.findByNo(no);
		
		return reply;
	}
	
	// 댓글 작성
	public void save(Reply reply) {
		replyRepository.save(reply);
	}
	
	// 모댓글의 답글 가져오기 -> 예전거부터
	public List<Reply> findByRepn(int repn) {
		
		List<Reply> list = new ArrayList<>();
		list = replyRepository.findByRepnLike(repn);
		
		return list;
	}
	
	// 댓글 삭제
	public Reply deleteReply(long no) {
		Reply reply = new Reply();
		
		replyRepository.deleteReply(no); // checks 를 1로 만들어 삭제
		reply = replyRepository.findByNo(no); // 1이면 삭제 성공, 0이면 삭제 실패
		
		return reply;
	}
}
