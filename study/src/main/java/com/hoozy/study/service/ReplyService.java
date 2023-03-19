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
	
	// 지식 번호로 댓글 가져오기
	public List<Reply> findByKnowNo(long no) {
		List<Reply> list = new ArrayList<>();
		
		list = replyRepository.findByKnowNo(no);
		
		return list;
	}
	
	// 댓글 작성
	public void save(Reply reply) {
		replyRepository.save(reply);
	}
	
	// 모댓글 개수 가져오기
	public int countByRepl(int repl) {
		int count = 0;
		List<Reply> list = new ArrayList<>();
		list = replyRepository.findByReplLike(repl);
		count = list.size();
		
		return count;
	}
}
