package com.hoozy.study.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
@Table(name = "reply")
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no; // 댓글 번호 PK
	
	@ManyToOne
	@JoinColumn(name = "kno") // FK 적기 foreign key (kno) references Know (no)
	private Know know; // 참조 테이블
	
	@ManyToOne
	@JoinColumn(name = "email")
	private User user; // 참조 테이블
	
	private String profile;
	
	private String nick; // 작성자
	private String cont; // 댓글 내용
	private int repn; // repl이 0인 댓글 번호 -> 첫 댓글 : 1 , 첫 답글 : 1
	private int repo; // 댓글이 속한 댓글 중 순서 -> 첫 댓글 : 0 , 첫 답글 : 1
	private int repl; // 댓글의 레벨 -> 모댓글 : 0, 답글 : 1 -> 첫 댓글 : 0, 첫 답글 : 1
	
	@ColumnDefault("0")
	private int checks; // 삭제 시 : 1 , 아니면 0
	private int likes;
	private String likenick; // 좋아요 한 유저 닉네임 목록
	private Timestamp date; // 수정일(생성일)
	
	@Builder
	public Reply(String nick, int repn, int repo, int repl, int checks, Timestamp date) {
		super();
		this.nick = nick;
		this.repn = repn;
		this.repo = repo;
		this.repl = repl;
		this.checks = checks;
		this.date = date;
	}
}	
