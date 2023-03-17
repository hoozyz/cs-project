package com.hoozy.study.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoozy.study.entity.Addi;
import com.hoozy.study.service.AddiService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AddiController {

	private final AddiService addiService;
	
	@PostMapping("/addi/cont")
	@ResponseBody
	public List<Addi> addiCont(long no) {
		List<Addi> list = new ArrayList<>();
		
		list = addiService.findByNo(no);
		
		return list;
	}
}
