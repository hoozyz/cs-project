package com.hoozy.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hoozy.study.entity.User;

@Controller
public class KnowController {
	
	@GetMapping("/know")
	public String know(Model model) {
		model.addAttribute("user", new User());
		return "know";
	}
}
