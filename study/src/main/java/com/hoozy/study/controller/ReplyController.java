package com.hoozy.study.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoozy.study.entity.Reply;
import com.hoozy.study.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReplyController {

	private final ReplyRepository replyRepository;
	
	@PostMapping("/reply/cont")
	@ResponseBody
	public List<Reply> repList(long no) {
		List<Reply> list = new ArrayList<>();
		
		list = replyRepository.findByKnowNo(no);
		 
		return list;
	}
}
