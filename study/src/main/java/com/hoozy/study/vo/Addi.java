package com.hoozy.study.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Addi {
	private int no; // 문제 번호
	private String stand; // 기준
	private String comp1; // 기준 대상 1
	private String comp2;
	private String comp3;
}
