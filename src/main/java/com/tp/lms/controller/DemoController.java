package com.tp.lms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("home")
public class DemoController {
	
	
	@GetMapping("check")
	public String gethome(@RequestParam String user) {
		
		return user;
		
	}
	
	
	@GetMapping("/demo")
	public String gethello() {
		
		return " hello sheela";
		
	}
	
	

}
