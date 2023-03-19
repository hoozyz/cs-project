package com.hoozy.study.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.hoozy.study.entity.Reply;
import com.hoozy.study.entity.User;
import com.hoozy.study.service.KnowService;
import com.hoozy.study.service.ReplyService;
import com.hoozy.study.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {

	private final ReplyService replyService;
	private final KnowService knowService;
	private final UserService userService;
	
	@PostMapping("/cont")
	@ResponseBody
	public List<Reply> repList(long no) {
		List<Reply> list = new ArrayList<>();
		
		list = replyService.findByKnowNo(no);
		 
		return list;
	}
	
	// 모댓글 작성
	@PostMapping("/write")
	@ResponseBody
	public Reply repWrite(long kno, String cont, @SessionAttribute(name = "loginUser", required = false) User loginUser) {
		Reply reply = new Reply();
		if(!cont.equals("")) {
			reply.setCont(cont);
			reply.setKnow(knowService.findByNo(kno));
			reply.setNick(loginUser.getNick());
			reply.setUser(userService.findByEmail(loginUser.getEmail()));
			reply.setRepo(0); // 모댓글
			reply.setRepl(0); // 모댓글
			
			reply.setRepn(replyService.countByRepl(0) + 1); // 모댓글 개수 + 1 -> 현재 작성하는 모댓글의 모댓글 번호
			
			replyService.save(reply);
		}
		
		return reply;
	}
}
