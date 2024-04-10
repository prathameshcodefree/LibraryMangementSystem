package com.tp.lms.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("demo")
public class DemoController {

	@GetMapping("check")
	public String getDemo(@RequestParam String user,@RequestParam String password) {
		
		
		return "HELLO "+ user + password;
	}
	@GetMapping("test")
	public String sayHello() {
		
		return "Hello ghhgng";
	}


}
