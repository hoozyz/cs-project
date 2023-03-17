package com.hoozy.study.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoozy.study.entity.Know;
import com.hoozy.study.interfaces.KnowMapping;
import com.hoozy.study.repository.KnowRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KnowService {
	private Random ran = new Random();

	// 카테고리 목록
	private static final String[] cateArr = { "네트워크" , "자바(기초)", "자바(심화)" /* , "자바(프레임워크)" */ };

	@Autowired
	private KnowRepository knowRepository;
	
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

//	public Map<String, List<Know>> findAll() { // 전체 문제를 카테고리 별로 가져오기 -> 지식 페이지
//		Map<String, List<Know>> map = new HashMap<>();
//
//		int i = 0;
//		for (String cate : cateArr) { // 카테고리 순서대로 list0 , list1 키로 map에 넣음
//			List<Know> list = new ArrayList<>();
//			list = knowRepository.findByCate(cate);
//
//			map.put("list" + i++, list);
//		}
//
//		return map;
//	}

	public Map<String, List<Know>> findAllByLong() { // 전체 주관식 문제를 카테고리 별로 가져오기 
		Map<String, List<Know>> map = new HashMap<>();

		int i = 0;
		for (String cate : cateArr) { // 카테고리 순서대로 list0 , list1 키로 map에 넣음
			List<Know> list = new ArrayList<>();
			List<Know> list1 = new ArrayList<>();
			list = knowRepository.findByCateAndContLike(cate, "%*%");
			log.info("리스트 {}", list);
			Set<Long> set = new HashSet<>();
			while(true) {
				set.add(ran.nextLong(list.size()));
				
				if(set.size() == 2) { // 랜덤해서 2개 생성
					
					for(Long l : set) {
						list1.add(list.get(l.intValue())); // 새로운 리스트에 담아서 2개만 넘기기
					}
					break;
				}
			}

			map.put("list" + i++, list1);
		}

		return map;
	}

	public Map<String,List<Know>> findAllByShort() { // 전체 단답형 문제를 카테고리 별로 가져오기 -> 랜덤 3개
		Map<String, List<Know>> map = new HashMap<>();

		int i = 0;
		for (String cate : cateArr) { // 카테고리 순서대로 list0 , list1 키로 map에 넣음
			List<Know> list = new ArrayList<>();
			List<Know> list1 = new ArrayList<>();
			list = knowRepository.findByCateAndContNotLike(cate, "%*%"); // * 안들어가면 단답형
			
			Set<Long> set = new HashSet<>();
			while(true) {
				set.add(ran.nextLong(list.size()));
				
				if(set.size() == 3) { // 랜덤해서 3개 생성
					
					for(Long l : set) {
						list1.add(list.get(l.intValue())); // 새로운 리스트에 담아서 3개만 넘기기
					}
					break;
				}
			}
			
			map.put("list" + i++, list1);
		}

		return map;
	}

	public Know findByNo(long no) {
		Know know = new Know();
		know = knowRepository.findByNo(no);

		return know;
	}
}
