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

	@GetMapping("/{studentId}")
	public ResponseEntity<?> getStudentById(@PathVariable Integer studentId) {
<<<<<<< HEAD
//		
//		if(studentService.validate(Student student)) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student cannot be empty");
//		}
//
//		Optional studentO = studentService.getStudentById(studentId);
//		
//
//		if (studentO.isPresent()) {
//			return ResponseEntity.ok(studentO.get());
//		} else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found with ID: " + studentId);
//		}
		
		
		Optional<Student> res= studentService.getStudentById(studentId);
		if(res.isEmpty()) {
			return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(studentService.getStudentById(studentId),HttpStatus.OK);
		

	}

	@PostMapping
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		List<String> error=studentService.validate(student);
		if(error.size()!=0) {
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
			
		}
		return new ResponseEntity<>(studentService.addStudent(student),HttpStatus.OK);

}
=======
		List<String> error = studentService.validate(student);
		if(error.size() != 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}

		Optional<Student> studentO = studentService.getStudentById(studentId);
		

		if (studentO.isPresent()) {
			return ResponseEntity.ok(studentO.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found with ID: " + studentId);
		}

	}

	@PostMapping("/add")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		List<String> error = studentService.validate(student);
		if(error.size() != 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}

		
			Student s=studentService.addStudent(student);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(s);
		
		
		
	
	}
>>>>>>> 95604fd468469fab9352473ed059ef95583636f0

	@PutMapping("/{studentId}")
	public ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
		List<String> error=studentService.validate(student);
		if(error.size()!=0) {
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
			
		}
		
		return new ResponseEntity<>(studentService.updateStudent(id, student),HttpStatus.OK);
	}

	 @DeleteMapping("/{studentId}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable int studentId) {
	        try {
	            studentService.deleteStudent(studentId);
	            return ResponseEntity.noContent().build();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }

}
