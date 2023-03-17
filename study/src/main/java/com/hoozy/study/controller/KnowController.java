package com.hoozy.study.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.hoozy.study.entity.User;
import com.hoozy.study.interfaces.KnowMapping;
import com.hoozy.study.service.KnowService;

@Controller
public class KnowController {
	
	@Autowired
	private KnowService knowService;
	
	@GetMapping("/know")
	public String know(Model model, @SessionAttribute(name = "loginUser", required = false) User loginUser) {
		model.addAttribute("user", new User());
		
		if(loginUser != null) {
			model.addAttribute("user", loginUser); // 로그인 했을 경우 user 변경
		}
		
		Map<String, List<KnowMapping>> map = new HashMap<>();
		
		map = knowService.findAllByCate();
		
		model.addAttribute("map", map);
		
		return "know";
	}
	
	
}
