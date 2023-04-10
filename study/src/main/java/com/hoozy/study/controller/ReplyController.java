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

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {

	private final ReplyService replyService;
	private final KnowService knowService;
	
	@PostMapping("/cont")
	@ResponseBody
	public List<Reply> repList(long no) {
		List<Reply> list = new ArrayList<>();
		
		list = replyService.findByKnowNo(no);
		for(Reply r : list) {
			r.getUser().setPwd("");
			r.getUser().setSalt("");
		}
		 
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
			reply.setUser(loginUser);
			reply.setRepo(0); // 모댓글
			reply.setRepl(0); // 모댓글
			reply.setRepn(0); // 모댓글은 자기 번호의 첫 번째
			
			replyService.save(reply);
		}
		reply.setNo(replyService.findLastNo()); // 마지막 번호 + 1 -> 방금 넣은 댓글 번호
		reply = replyService.findByNo(reply.getNo()); // 실제 db 데이터 가져오기
		
		return reply;
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public Reply repDelete(long no) {
		Reply reply = new Reply();
		
		reply.setCont("삭제된 댓글입니다.");
		reply.setChecks(1); // 댓글 삭제 -> checks = 1
		reply = replyService.deleteReply(no);
		reply.getUser().setPwd("");
		reply.getUser().setSalt("");
		
		return reply;
	}
	
	// 답글 작성
	@PostMapping("/nestWrite")
	@ResponseBody
	public Reply nestWrite(long kno, int no, String cont, @SessionAttribute(name = "loginUser", required = false) User loginUser) {
		Reply reply = new Reply();

		if(!cont.equals("")) {
			reply.setCont(cont);
			reply.setKnow(knowService.findByNo(kno));
			reply.setNick(loginUser.getNick());
			reply.setUser(loginUser);
			reply.setRepo(replyService.findByRepn(no).size() + 1); // 답글중의 순서 -> 현재 모댓글의 답글 개수 + 1 번째
			reply.setRepn(no); // 모댓글 번호
			reply.setRepl(1); // 답글
			replyService.save(reply);
		}
		reply.setNo(replyService.findLastNo()); // 마지막 번호 -> 방금 넣은 댓글 번호
		reply = replyService.findByNo(reply.getNo()); // 실제 db 데이터 가져오기
		
		return reply;
	}
	
	// 댓글 수정
	@PostMapping("/update")
	@ResponseBody
	public Reply update(long no, String cont) {
		Reply reply = new Reply();
		
		reply = replyService.findByNo(no);
		
		if(!cont.equals("")) {
			reply.setCont(cont);
			replyService.save(reply);
		}
		
		return reply;
	}
	
	// 좋아요 수정
	@PostMapping("/like")
	@ResponseBody
	public Reply updateLike(long no, int check, @SessionAttribute(name = "loginUser", required = false) User loginUser) {
		Reply reply = new Reply();
		reply = replyService.findByNo(no);
		if (check == 1) { // 추가
			reply.setLikes(reply.getLikes() + 1);
			if(reply.getLikenick() == null) { // 첫 유저
				reply.setLikenick(loginUser.getNick()); // 현재 로그인 한 유저 좋아요 닉네임 목록에 추가
			} else {
				reply.setLikenick(reply.getLikenick() + " " + loginUser.getNick()); // 현재 로그인 한 유저 좋아요 닉네임 목록에 추가
			}
		} else { // 제거
			reply.setLikes(reply.getLikes() - 1);
			String userStr = ""; // 유저 닉네임 목록 문자열 생성
			for(String user : reply.getLikenick().split(" ")) { // user 목록 가져오고 현재 로그인 한 닉네임 제거
				 if(user.equals(loginUser.getNick())) {
					 continue; // 추가 안함.
				 }
				 userStr += user;
			}
			reply.setLikenick(userStr);
		}
		replyService.save(reply);
		
		return reply;
	}
	
	// 현재 모댓글의 답글 가져오기
	@PostMapping("/repn")
	@ResponseBody
	public List<Reply> repRepn(int no) {
		List<Reply> list = new ArrayList<>();
		
		list = replyService.findByRepn(no);
		for(Reply r : list) { // 비밀번호, 솔트 없애기
			r.getUser().setPwd("");
			r.getUser().setSalt("");
		}
		
		return list;
	}
}
