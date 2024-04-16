package com.tp.lms.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tp.lms.model.Student;

@RestController
@RequestMapping("demo")
public class DemoController {

	@GetMapping("check")
	public String getDemo(@RequestParam String user, @RequestParam String password) {

		return "HELLO " + user + password;
	}

	@GetMapping("test")
	public Student sayHello() {
		Student student =new Student() ;
		
		student.setFirstName("Prathamesh");
		student.setEmail("prathameshmane@gmail.com");
		student.setCollegeName("LKY");
		return student;
	}

	
	
}
