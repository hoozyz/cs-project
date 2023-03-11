package com.hoozy.study.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "know")
public class Know {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no; // 문제 번호 PK
	
	@ManyToOne 
	@JoinColumn(name = "cate_no") // 조인하는 테이블(상대 테이블) PK 컬럼 명
	private Cate cate; // 카테고리 번호 FK
	
	private String name; // 문제 이름
	private String cont; // 문제 내용
	
	@ColumnDefault("0")
	private int likes; // 좋아요
	private Timestamp date; // 수정일(생성일)
	
	@OneToMany(mappedBy = "know")
	private List<Reply> replys = new ArrayList<>();
	
	@Builder
	public Know(String name, String cont, int likes, Timestamp date) {
		super();
		this.name = name;
		this.cont = cont;
		this.likes = likes;
		this.date = date;
	}
}
