package com.hoozy.study.interfaces;

// 지식에서 문제 이름만 가져오기 위해 매핑하는 인터페이스 -> jpa 는 인터페이스에 해당하는 컬럼만 가져올 수 있다.
public interface KnowMapping {
	String getName();
}
