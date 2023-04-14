package com.hoozy.study.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "know")
public class Know {
	// 만약 know의 cont(내용)에 *인 내용은 추가적으로 테이블 형식 지식.
	// 내용이 *이 아니고 *을 포함한다면, 주관식 문제
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no; // 문제 번호 PK
	
	private String cate; // 카테고리 이름
	private String name; // 문제 이름
	private String cont; // 문제 내용
	
	@ColumnDefault("0")
	private int likes; // 좋아요
	private String likenick; // 좋아요 한 유저 닉네임 목록
	
	private Timestamp date; // 수정일(생성일)
	
	@Builder
	public Know(String name, String cont, int likes, Timestamp date) {
		super();
		this.name = name;
		this.cont = cont;
		this.likes = likes;
		this.date = date;
	}
}
