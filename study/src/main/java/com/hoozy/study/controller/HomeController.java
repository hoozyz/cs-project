package com.hoozy.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hoozy.study.entity.User;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String logina(Model model) {
		
		model.addAttribute("user", new User());
		return "home";
	}
}
