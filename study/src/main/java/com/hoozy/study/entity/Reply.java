package com.hoozy.study.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "reply")
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no; // 댓글 번호 PK
	
	@ManyToOne
	@JoinColumn(name = "know_no") // FK 적기 foreign key (know_no) references Know (no)
	private Know know; // 참조 테이블
	
	@ManyToOne
	@JoinColumn(name = "nick")
	private User user; // 참조 테이블
	
	
	private int repn; // 댓글이 속한 repl이 0인 댓글 번
	private int repo; // 댓글이 속한 댓글 중 순서
	private int repl; // 댓글의 레벨 -> 모댓글 : 0, 답글 : 1
	private int checks; // 삭제 시 : 1 , 아니면 0
	private Timestamp date; // 수정일(생성일)
	
	@Builder
	public Reply(int repn, int repo, int repl, int checks, Timestamp date) {
		super();
		this.repn = repn;
		this.repo = repo;
		this.repl = repl;
		this.checks = checks;
		this.date = date;
	}
}	
