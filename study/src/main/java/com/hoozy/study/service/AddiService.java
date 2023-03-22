package com.hoozy.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hoozy.study.entity.Addi;
import com.hoozy.study.repository.AddiRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddiService {

	private final AddiRepository addiRepository;
	
	public List<Addi> findByNo(Long no) {
		List<Addi> list = new ArrayList<>();
		list = addiRepository.findByAddiNo(no);
		
		return list;
	}
}
