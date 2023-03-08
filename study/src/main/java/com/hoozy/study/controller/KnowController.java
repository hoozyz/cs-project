package com.hoozy.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KnowController {
	
	@GetMapping("/know")
	public String know() {
		return "know";
	}
}
