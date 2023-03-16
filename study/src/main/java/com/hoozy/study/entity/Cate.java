package com.hoozy.study.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "cate")
public class Cate {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no; // 카테고리 번호 PK
	
	private String cate1;
	private String cate2;
	private String link;
	
	@Builder
	public Cate(String cate1, String cate2, String link) {
		super();
		this.cate1 = cate1;
		this.cate2 = cate2;
		this.link = link;
	}
}
