package com.tp.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.lms.model.Student;
import com.tp.lms.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	
	@Autowired
	StudentService studentservice;
	
	@GetMapping(" ")
	public List<Student>  getStudent() {
		
		 return studentservice.getStudent();
		
	}
	
	
	@GetMapping("/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {
		
		 return studentservice.getStudent(studentId);
		
	}
	
	@PostMapping
	public Student addStudent(Student student) {
		
		 return studentservice.addStudent(student);
		
	}
	
	@PutMapping("{/studentId}")
      public Student updateStudent(@PathVariable int studentId, @RequestBody Student student) {
		
		return studentservice.updateStudent(studentId, student);

	}

	
	@DeleteMapping("{/studentId}")
	public void deleteStudent(@PathVariable int studentId) {

		 studentservice.deleteStudent(studentId);
	}
		

}
