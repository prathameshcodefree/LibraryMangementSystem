package com.tp.lms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
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
	StudentService studentService;

	Student student;

	@GetMapping("")
	public ResponseEntity<List<Student>> getStudent () {

		List<Student> studentCount= studentService.getStudent();
		if(studentCount.size()==0) {
			return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(studentService.getStudent(),HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Integer id) {
	    Optional<Student> res = studentService.getStudentById(id);
	    if (res.isEmpty()) {
	       
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    } else {
	        
	        Student student = res.get();
	        
	        return ResponseEntity.ok().body(student);
	    }
	}

	
		

	@PostMapping("")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		List<String> error = studentService.validate(student);
		if (error.size() != 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}

		studentService.addStudent(student);
		 return ResponseEntity.ok().body("Student added successfully.");


	}


	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        List<String> error = studentService.validate(student);
        if (!error.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }

        studentService.updateStudent(id, student);
        return ResponseEntity.ok().body("Student with ID " + id + " Updated successfully.");

    }

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
	
	        boolean deleted = studentService.deleteStudent(id);


	        if (deleted) {
	            return ResponseEntity.ok("Student with ID " + id + " deleted successfully.");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                                 .body("Student with ID " + id + " not found.");
	        }
	    }
}
