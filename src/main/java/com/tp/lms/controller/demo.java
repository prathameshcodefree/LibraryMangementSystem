package com.tp.lms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tp.lms.model.Student;

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
	
	@GetMapping(value = "checkvalues")
	public ResponseEntity<Object> getDemovalues() {
	    Map<String, String> response = new HashMap<>();
	    response.put("message", "Hello Durgesh Prajapati");
	    response.put("hii", "My name is durgesh");
	    return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("/demo")
	public Student one() {
	Student student=new Student();
	student.setEmail("dp@1234GMAIL.COM");
	student.setFirstName("Durgesh");
	return student;
	}
}
