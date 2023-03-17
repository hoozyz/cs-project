package com.hoozy.study.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.hoozy.study.entity.Addi;
import com.hoozy.study.entity.Know;
import com.hoozy.study.entity.User;
import com.hoozy.study.service.AddiService;
import com.hoozy.study.service.KnowService;

@Controller
@RequestMapping("/prob")
public class ProbController {

	@Autowired
	private KnowService knowService;
	@Autowired
	private AddiService addiService;

	@GetMapping("/short")
	public String probShort(Model model, @SessionAttribute(name = "loginUser", required = false) User loginUser) {
		model.addAttribute("user", new User());
		
		if(loginUser != null) {
			model.addAttribute("user", loginUser);
		}
		
		Map<String, List<Know>> map = new HashMap<>();
		map = knowService.findAllByShort();
		
		model.addAttribute("map", map);

		return "probShort";
	}

	@GetMapping("/long")
	public String probLong(Model model, @SessionAttribute(name = "loginUser", required = false) User loginUser) {
		model.addAttribute("user", new User());
		
		if(loginUser != null) {
			model.addAttribute("user", loginUser);
		}

		List<Addi> addiList = new ArrayList<>();

		Map<String, List<Know>> knowMap = new HashMap<>();
		Map<String, List<Addi>> addiMap = new HashMap<>();
		
		knowMap = knowService.findAllByLong();
		for (int i = 0; i < knowMap.size(); i++) {
			for (int j = 0; j < knowMap.get("list" + i).size(); j++) {
				
				Know know = knowMap.get("list" + i).get(j);
				if (know.getCont().equals("*")) { // 추가 정보 문제일 때
					addiList = addiService.findByNo(know.getNo());
					addiMap.put("list" + i, addiList);
				}
			}
		}

		model.addAttribute("knowMap", knowMap);
		model.addAttribute("addiMap", addiMap);

		return "probLong";
	}
}
