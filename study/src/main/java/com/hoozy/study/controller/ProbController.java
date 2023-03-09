package com.hoozy.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prob")
public class ProbController {

	@GetMapping("/short")
	public String probShort() {
		return "probShort";
	}
	
	@GetMapping("/long")
	public String probLong() {
		return "probLong";
	}
}
