package com.tp.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tp.lms.dto.LoginRequestDTO;
import com.tp.lms.model.Student;

import com.tp.lms.repository.StudentRepository;


@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;



	public List<String> validates(Student student) {
		List<String> errors = new ArrayList<>();
		if (student.getUserName() == null || student.getUserName().isEmpty()) {
			errors.add("Username cannot be null or empty");
		}
		if (student.getPassword() == null || student.getPassword().isEmpty()) {
			errors.add("Password cannot be null or empty");
		}
		return errors;
	}

	public boolean checkUserExists(String username, String password) {
		List<Student> logins = studentRepository.findAll();

		for (Student login : logins) {
			String loginUsername = login.getUserName();
			String loginPassword = login.getPassword();
			if (loginUsername != null && loginPassword != null && loginUsername.equals(username)
					&& loginPassword.equals(password)) {
				return true;
			}
		}

		return false;
	}

	public Student login(LoginRequestDTO loginRequestDto) {
		Optional<Student> studentO = studentRepository.findByUserName(loginRequestDto.getUserName());

		System.out.println(studentO);
		Student student = null;

		if (studentO.isPresent()) {

			Student studentdb = studentO.get();
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//        	System.out.print("passwrod user: " + loginRequestDto.getPassword() + " from db:" + studentdb.getPassword());
			if (passwordEncoder.matches(loginRequestDto.getPassword(), studentdb.getPassword())) {
				student = studentdb;
			}

		}


		return student;
	}

	public List<Student> getStudent() {

		return studentRepository.findAll();

	}

	
	public List<String> validate(Student student) {

		List<String> error = new ArrayList<>();

		if (student.getFirstName() == null) {
			error.add("first name can not be empty");
		}

		if (student.getLastName() == null) {
			error.add("last name can not be empty");
		}

		if (student.getEmail() == null) {
			error.add("Email can not be empty");
		}
		if (student.getPassword() == null) {
			error.add("Passwor can not be empty");
		}
		if (student.getGender() == null) {
			error.add("Gender name can not be empty");
		}

		if (student.getCollegeName() == null) {
			error.add("College name can not be empty");
		}


		boolean isEmail = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
				.matcher(student.getEmail()).matches();

		boolean isPassword = Pattern.compile("^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[@$!%?&])[A-Za-z\\d@$!%?&]{8,}$")
				.matcher(student.getPassword()).matches();

		if (!isEmail) {

			error.add("email is not correct");
		}

		/*
		 * if (!isPassword) { error.add("password is not correct"); }
		 */

		return error;
	}

	public Optional<Student> getStudentById(Integer id) {

		return studentRepository.findById(id);

	}
	

	public Student addStudent(Student student) {

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		String hashcode = bCryptPasswordEncoder.encode(student.getPassword());
		student.setPassword(hashcode);
		Student st = studentRepository.save(student);

		return st;

	}

	public Student updateStudent(Integer id, Student student) {

		Student existingStudent = studentRepository.findById(id).orElse(null);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setMiddleName(student.getMiddleName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setContactNumber(student.getContactNumber());
		existingStudent.setGender(student.getGender());
		existingStudent.setDob(student.getDob());;
		existingStudent.setCollegeName(student.getCollegeName());
		existingStudent.setRollNo(student.getRollNo());
		existingStudent.setPassword(student.getPassword());
		existingStudent.setStudentstatus(student.getStudentstatus());
		existingStudent.setUserName(student.getUserName());
		return studentRepository.save(existingStudent);

	}

	public boolean deleteStudent(Integer id) {

		boolean exists = studentRepository.existsById(id);
		if (exists) {
			studentRepository.deleteById(id);
			return true;
		} else {

			return false;
		}

	}

	

}