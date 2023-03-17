package com.hoozy.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
