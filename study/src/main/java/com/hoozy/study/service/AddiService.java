package com.hoozy.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoozy.study.entity.Addi;
import com.hoozy.study.repository.AddiRepository;

@Service
public class AddiService {

	@Autowired
	private AddiRepository addiRepository;
	
	public List<Addi> findByNo(Long no) {
		List<Addi> list = new ArrayList<>();
		list = addiRepository.findByAddiNo(no);
		
		return list;
	}
}
