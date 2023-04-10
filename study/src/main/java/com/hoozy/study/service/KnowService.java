package com.hoozy.study.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.hoozy.study.entity.Know;
import com.hoozy.study.interfaces.KnowMapping;
import com.hoozy.study.repository.KnowRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KnowService {
	private Random ran = new Random();

	// 카테고리 목록
	private static final String[] cateArr = { "네트워크", "자바", "운영 체제", "데이터베이스" , "API", "웹 보안", "패턴", "가상화", "클라우드", "AWS", "Spring Boot", "자료구조 및 알고리즘"};

	private final KnowRepository knowRepository;

	// 전체 문제 이름 카테고리 별로 가져오기
	public Map<String, List<KnowMapping>> findAllByCate() {
		Map<String, List<KnowMapping>> map = new HashMap<>();

		int i = 0;
		for (String cate : cateArr) { // 카테고리 순서대로 list0 , list1 키로 map에 넣음
			List<KnowMapping> list = new ArrayList<>();
			list = knowRepository.findByCate(cate);

			map.put("list" + i++, list);
		}

		return map;
	}

	// 전체 주관식 문제를 카테고리 별로 가져오기
	public Map<String, List<Know>> findAllByLong() {
		Map<String, List<Know>> map = new HashMap<>();

		int i = 0;
		for (String cate : cateArr) { // 카테고리 순서대로 list0 , list1 키로 map에 넣음
			List<Know> list = new ArrayList<>();
			List<Know> list1 = new ArrayList<>();
			list = knowRepository.findByCateAndContLike(cate, "%*%");
			System.out.println("asdsassdasdaa                   "+list.size());
			Set<Long> set = new HashSet<>();
			while (true) {
				set.add(ran.nextLong(list.size()));

				if (set.size() == 2) { // 랜덤해서 2개 생성
					
					for (Long l : set) {
						list1.add(list.get(l.intValue())); // 새로운 리스트에 담아서 2개만 넘기기
					}
					break;
				}
			}

			map.put("list" + i++, list1);
		}

		return map;
	}

	// 전체 단답형 문제를 카테고리 별로 가져오기 -> 랜덤 3개
	public Map<String, List<Know>> findAllByShort() {
		Map<String, List<Know>> map = new HashMap<>();

		int i = 0;
		for (String cate : cateArr) { // 카테고리 순서대로 list0 , list1 키로 map에 넣음
			List<Know> list = new ArrayList<>();
			List<Know> list1 = new ArrayList<>();
			list = knowRepository.findByCateAndContNotLike(cate, "%*%"); // * 안들어가면 단답형

			Set<Long> set = new HashSet<>();
			while (true) {
				set.add(ran.nextLong(list.size()));

				if (set.size() == 3) { // 랜덤해서 3개 생성

					for (Long l : set) {
						list1.add(list.get(l.intValue())); // 새로운 리스트에 담아서 3개만 넘기기
					}
					break;
				}
			}

			map.put("list" + i++, list1);
		}

		return map;
	}
	
	// 전체 단답형 문제를 카테고리 별로 가져오기 -> 랜덤 3개 (오늘의 문제) -> 매일 24시에만 바뀜
	public Map<String, List<Know>> findAllByToday() {
		Map<String, List<Know>> map = new HashMap<>();

		int i = 0;
		for (String cate : cateArr) { // 카테고리 순서대로 list0 , list1 키로 map에 넣음
			List<Know> list = new ArrayList<>();
			List<Know> list1 = new ArrayList<>();
			list = knowRepository.findByCateAndContNotLike(cate, "%*%"); // * 안들어가면 단답형

			Set<Long> set = new HashSet<>();
			while (true) {
				set.add(ran.nextLong(list.size()));

				if (set.size() == 3) { // 랜덤해서 3개 생성

					for (Long l : set) {
						list1.add(list.get(l.intValue())); // 새로운 리스트에 담아서 3개만 넘기기
					}
					break;
				}
			}

			map.put("list" + i++, list1);
		}

		return map;
	}
	
	// 현재 문제 2개 빼고 가져오기 랜덤
	public Know findByNoNotLike(long no1, long no2, String cate) {
		List<Know> list = new ArrayList<>();
		
		list = knowRepository.notLike(no1, no2, cate);
		
		Know know = new Know();
		know = list.get(ran.nextInt(list.size())); // 랜덤으로 하나 가져오기
		
		return know;
	}
	
	// 현재 문제 3개 빼고 가져오기 랜덤
	public Know findByNoNotLike(long no1, long no2, long no3, String cate) {
		List<Know> list = new ArrayList<>();
		
		list = knowRepository.notLike(no1, no2, no3, cate);
		
		Know know = new Know();
		know = list.get(ran.nextInt(list.size())); // 랜덤으로 하나 가져오기
		
		return know;
	}

	public Know findByName(String name) {
		Know know = new Know();

		know = knowRepository.findByName(name);

		return know;
	}

	public Know findByNo(long no) {
		Know know = new Know();
		know = knowRepository.findByNo(no);

		return know;
	}
	
	public void save(Know know) {
		knowRepository.save(know);
	}
}
