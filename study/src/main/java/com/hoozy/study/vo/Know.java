package com.hoozy.study.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Know {
	private int no; // 문제 번호
	private int cate_no; // 카테고리 번호
	private String name; // 문제 이름
	private String cont; // 문제 내용
	private int likes;
	private Date date;
}
