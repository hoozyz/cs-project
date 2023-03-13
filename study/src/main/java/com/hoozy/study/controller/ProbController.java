package com.hoozy.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hoozy.study.entity.User;

@Controller
@RequestMapping("/prob")
public class ProbController {

	@GetMapping("/short")
	public String probShort(Model model) {
		model.addAttribute("user", new User());
		return "probShort";
	}
	
	@GetMapping("/long")
	public String probLong(Model model) {
		model.addAttribute("user", new User());
		return "probLong";
	}
}
