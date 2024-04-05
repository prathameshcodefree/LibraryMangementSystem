package com.tp.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tp.lms.model.Student;
import com.tp.lms.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public List<Student> getStudent() {

		return studentRepository.findAll();

	}
	
	public List<String> validate(Student student) {
		List<String> error = new ArrayList<>();
		
<<<<<<< HEAD
		boolean isEmail = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
	      .matcher(student.getEmail())
	      .matches();
=======
>>>>>>> 95604fd468469fab9352473ed059ef95583636f0
		
		
		if (student.getFirstName() == null) {
			error.add("first name can not be empty");
		}
		
		if (student.getLastName() == null) {
			error.add("last name can not be empty");
		}
		
		if(student.getEmail()== null) {
			error.add("Email can not be empty");
		}
		if(student.getPassword()==null)
		{
			error.add("Passwor can not be empty");
		}
		if (student.getGender() == null) {
			error.add("Gender name can not be empty");
		}
		
		if (student.getStudentstatus() == null) {
			error.add("Student status can not be empty");
		}
		
		if (student.getCollegeName() == null) {
			error.add("College name can not be empty");
		}
		
		if (student.getDate() == null) {
			error.add("Date can not be empty");
		}
		
		if (student.getRollNo() == null) {
			error.add("Date can not be empty");
		}
		
		boolean isEmail = Pattern.compile("^(.+)@(\\\\S+)$")
			      .matcher(student.getEmail())
			      .matches();
				
		boolean isPassword = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$")
					      .matcher(student.getPassword())
					      .matches();
		if (!isEmail) {
			error.add("email is not correct");
		}
		
		if (!isPassword) {
			error.add("password is not correct");
		}
		
		return error;
	}

	public Optional<Student> getStudentById(Integer studentId) {

		return studentRepository.findById(studentId);

	}

	
	
<<<<<<< HEAD
//	public ResponseEntity<?> addStudent(Student student) {		if (student == null) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student data cannot be null");
//		}
//		if (student.getFirstName() == null || student.getFirstName().isEmpty() || student.getEmail().isEmpty()) {
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid student data");
//		}
//		studentRepository.save(student);
//		return ResponseEntity.status(HttpStatus.CREATED).body("Student added successfully");
//	}
	
	
	public Student  addStudent(Student student) {
        
//        if (student.getFirstName()== null) {
//            return new ResponseEntity<>("First name is required", HttpStatus.BAD_REQUEST);
//        }
//        if (student.getLastName() == null || student.getLastName().isEmpty()) {
//            return new ResponseEntity<>("Last name is required", HttpStatus.BAD_REQUEST);
//        }
//        if (student.getEmail() == null || student.getEmail().isEmpty()) {
//            return new ResponseEntity<>("Email is required", HttpStatus.BAD_REQUEST);
//        }
       
        Student savedStudent = studentRepository.save(student);
        return savedStudent;
=======
	public Student addStudent(Student student) {
       
       
        return studentRepository.save(student);
        
>>>>>>> 95604fd468469fab9352473ed059ef95583636f0
    }

	
	
	public Student updateStudent(Integer studentId, Student student) {
//		if (studentId == null) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student ID cannot be empty");
//		}
//
//		if (updatedStudent == null || updatedStudent.getFirstName() == null || updatedStudent.getFirstName().isEmpty()
//				|| updatedStudent.getEmail().isEmpty()) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid updated student data");
//		}
//
//		Student existingStudent = studentRepository.findById(studentId).orElse(null);
//		if (existingStudent != null) {
//			existingStudent.setStudentId(updatedStudent.getId());
//			studentRepository.save(existingStudent);
//			return ResponseEntity.ok("Student updated successfully");
//		} else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found with ID: " + studentId);
//		}
		student.setStudentId(studentId);
		return studentRepository.save(student);
	}

	
	
	public void deleteStudent(Integer studentId) {
		

		studentRepository.deleteById(studentId);
		
	}
}
