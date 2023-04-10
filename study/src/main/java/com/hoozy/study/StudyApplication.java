package com.hoozy.study;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.hoozy.study.entity.Know;
import com.hoozy.study.service.KnowService;
import com.hoozy.study.service.TodayService;

import lombok.RequiredArgsConstructor;

@EnableScheduling // 스케쥴링 추가
@RequiredArgsConstructor
@SpringBootApplication
public class StudyApplication {

	private final KnowService knowService;
	private final TodayService todayService;
	private Map<String, List<Know>> map = new HashMap<>(); // 홈페이지 3문제씩 담을 map
	
	// 매일 0시에 오늘의 문제 바꾸기
	@Scheduled(cron = "0 0 0 * * *") // 0초 0분 0시 매일 매주 모든요일
	public void knowToday() {
		map = knowService.findAllByShort();
		
		long no = todayService.findOne(); // 첫 번호
		for (int i = 0; i < map.size(); i++) {
			for (Know k : map.get("list" + i)) {
				int kno = (int) k.getNo();
				todayService.update(no++, kno); // 번호 1씩 추가해서 바꾸기
			}
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}

}
