package com.hoozy.study.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class AddiPK implements Serializable {
	// addi 테이블은 PK가 없어서 jpa에 바로 넣을 수 없다.
	// 이때 모든 필드를 PK로 만들기 위해 PK 클래스 생성 -> 가상 PK 클래스
	// 이후 Addi 라는 복합 키(PK) 클래스를 만들어 사용한다.
	
	private long no; // 문제 번호

	private String stand; // 기준
	private String comp1; // 기준 대상 1
	private String comp2;
	private String comp3;
}
