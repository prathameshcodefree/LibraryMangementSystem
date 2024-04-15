package com.tp.lms.practice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tp.lms.model.Student;

@RestController
@RequestMapping("demo")
public class DemoController {
     
	
	@GetMapping("test")
	public String demo() {
		return "Welcome To Mumbai";
	}
	
	
	@GetMapping("fales")
	public Student one() {
	Student  student=new Student();
	student.setEmail("bhandekaustubh24@gmail.com");
	student.setLastName("Bhande");
	return student;
	}

}
