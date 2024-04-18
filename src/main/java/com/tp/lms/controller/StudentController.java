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
	public ResponseEntity<?> getStudent() {
		List<Student> students = studentService.getStudent();
		if (students.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
		}
		return ResponseEntity.ok(students);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Integer id) {
		Optional<Student> studentById = studentService.getStudentById(id);
		if (studentById.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student by id not found");
		} else {
			Student student = studentById.get();
			return ResponseEntity.ok().body(student);
		}
	}

	@PostMapping(" ")
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

		List<String> errors = studentService.validate(student);
		if (!errors.isEmpty()) {
			return ResponseEntity.badRequest().body(errors);
		}

		// Check if student exists
		Optional<Student> existingStudent = studentService.getStudentById(id);
		if (!existingStudent.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with id " + id + "not found.");
		}

		// Update the student
		studentService.updateStudent(id, student);
		return ResponseEntity.ok().body("Student with ID " + id + " updated successfully.");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {

		boolean deleted = studentService.deleteStudent(id);

		if (deleted) {
			return ResponseEntity.ok("Student with ID " + id + " deleted successfully.");
		}

		else

		{

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with id " + id + " not found.");

		}

	}
}
