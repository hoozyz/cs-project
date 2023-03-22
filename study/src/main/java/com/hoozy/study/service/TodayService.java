package com.hoozy.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hoozy.study.entity.Today;
import com.hoozy.study.repository.TodayRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodayService {
	
	private final TodayRepository todayRepository;
	
	// 오늘의 문제 번호 목록 가져오기
	public List<Today> findAll() {
		List<Today> list = new ArrayList<>();
		
		list = todayRepository.findAll();
		
		return list;
	}
	
	// 문제 바꾸기
	public void update(long no, int kno) { // 매일 지식 번호 업데이트
		todayRepository.update(no, kno);
	}
	
	// 문제 넣기
	public void save(Today today) {
		todayRepository.save(today);
	}
}
