package com.tp.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tp.lms.model.Student;
import com.tp.lms.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentrepository;

	public List<Student> getStudent() {

		return  studentrepository.findAll();

	}

	public Student getStudent(int studentId) {
		return studentrepository.findById(studentId).get();
	
	}

	public Student addStudent(Student student) {

		return studentrepository.save(student);

	}

	public Student updateStudent(int studentId, @RequestBody Student student) {
		
		
		student.setStudentId(studentId);
		return studentrepository.save(student);

	}

	public void deleteStudent(int studentId) {

		studentrepository.deleteById(studentId);
	
	}

}
