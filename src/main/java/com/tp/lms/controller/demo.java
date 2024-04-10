package com.tp.lms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class demo {
	
	@GetMapping("check")
	public String getDemo(@RequestParam String username) {
		return username;
	}
	
	
	@GetMapping("checkvalue")
	public String getDemovalue() {
		return "Hello Durgesh Prajapati";
	}
	
}
