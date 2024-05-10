/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tp.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tp.lms.dto.LoginRequestDTO;
import com.tp.lms.dto.LoginResponseDTO;
import com.tp.lms.dto.StaffDTO;
import com.tp.lms.dto.UserDTO;
import com.tp.lms.model.Admin;
import com.tp.lms.model.Staff;
import com.tp.lms.model.Student;
import com.tp.lms.model.TokenLog;
import com.tp.lms.model.enums.StaffType;
import com.tp.lms.repository.StudentRepository;
import com.tp.lms.service.AdminService;
import com.tp.lms.service.StaffService;
import com.tp.lms.service.StudentService;
import com.tp.lms.service.TokenLogService;



/**
 *
 * @author Suhail Tamboli
 */
@RestController
@RequestMapping("auth")
public class AuthController {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	StudentService studentService;

	@Autowired
	AdminService adminService;

	@Autowired
	StaffService staffService;


	@Autowired
	TokenLogService tokenLogservice;


	@Autowired
	TokenLogService tokenLogService;
	
	@Autowired
	TokenLog tokenlog;

	@GetMapping("converttohash")
	public String convertToHash(@RequestParam String clearText) {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String cipherText = passwordEncoder.encode(clearText);

		return cipherText;

	}


	@PostMapping("/student/login")
	public LoginResponseDTO studentLogstafin(@RequestBody LoginRequestDTO loginRequestDto) {

		LoginResponseDTO loginResponseDto = new LoginResponseDTO();

		// Logic flow start
		Student student = studentService.login(loginRequestDto);

		// if not found send error
		if (student == null) {
			loginResponseDto.setStatus(false);
			loginResponseDto.setMessage("User credentials are not correct");
			return loginResponseDto;
		}

		// generate token

		// token = tokenLogservice.generateToken();
		// tokenLogservice.addLogForStudentLogin(token, student.getId(),
		// student.getEmail());
		// logic flow end

		// response preparation

		// Response preparation

		UserDTO userDto = new UserDTO();
		userDto.setFirstName(student.getFirstName());
		userDto.setMiddleName(student.getMiddleName());
		userDto.setUserName(student.getUserName());
		userDto.setStudentstatus(student.getStudentstatus());
		userDto.setDate(student.getDob());
		

		loginResponseDto.setStatus(true);
		loginResponseDto.setMessage("Login Successfully");
		loginResponseDto.setUser(userDto);
		//loginResponseDto.setToken(token);
		// Response preparation end

		// Response send
		return loginResponseDto;

	}

	@PostMapping("inventory/login")
	public LoginResponseDTO inventoryLogin(@RequestBody LoginRequestDTO loginRequestDto) {
		LoginResponseDTO loginResponseDto = new LoginResponseDTO();

		Staff staff = staffService.login(loginRequestDto);

		if (staff != null) {

			StaffDTO staffDto = new StaffDTO();
			staffDto.setStaffType(StaffType.INVENTORY);
			staffDto.setFirstName(staff.getFirstName());
			staffDto.setMiddleName(staff.getMiddleName());
			staffDto.setUserName(staff.getUserName());
			staffDto.setLastName(staff.getLastName());
			staffDto.setEmail(staff.getEmail());
			staffDto.setAadhaarNumber(staff.getAadhaarNumber());
			staffDto.setContactNumber(staff.getContactNumber());
			staffDto.setGender(staff.getGender());
			staffDto.setPassword(staff.getPassword());

			loginResponseDto.setStatus(true);
			loginResponseDto.setMessage("Login Successfully");
			loginResponseDto.setStaff(staffDto);
		} else {
			loginResponseDto.setStatus(false);
			loginResponseDto.setMessage("user credentials are not correct");
		}
		return loginResponseDto;

	}

	@PostMapping("admin/login")
	public LoginResponseDTO adminLogin(@RequestBody LoginRequestDTO loginRequestDto) {
		LoginResponseDTO loginResponseDto = new LoginResponseDTO();
        System.out.println("adminLogin 1");
		Admin admin = adminService.login(loginRequestDto);
		System.out.println("adminLogin 2");
		if (admin == null) {
			loginResponseDto.setStatus(false);
			loginResponseDto.setMessage("user credentials are not correct 111");
			return loginResponseDto;
		}
		System.out.println("adminLogin 3");

		String token = tokenLogservice.generateToken(admin.getId(),admin.getEmail());
		System.out.println("adminLogin 4");
		//tokenLogservice.addLogForAdminLogin(token, admin.getId());
		System.out.println("adminLogin 5");
		UserDTO userDto = new UserDTO();
		userDto.setFirstName(admin.getFirstName());
		userDto.setUserName(admin.getUserName());

		loginResponseDto.setStatus(true);
		loginResponseDto.setToken(token);
		loginResponseDto.setMessage("Login Successfully");
		loginResponseDto.setUser(userDto);
		System.out.println("adminLogin Final");
		return loginResponseDto;

	}

	@PostMapping("librarian/login")
	public LoginResponseDTO librarianLogin(@RequestBody LoginRequestDTO loginRequestDto) {
		LoginResponseDTO loginResponseDto = new LoginResponseDTO();

		Staff staff = staffService.login(loginRequestDto);

		if (staff != null) {

		//	String token = tokenLogservice.generateToken(staff.getId(), staff.getEmail());

			UserDTO userDto = new UserDTO();
			userDto.setFirstName(staff.getFirstName());
			userDto.setMiddleName(staff.getMiddleName());
			userDto.setUserName(staff.getUserName());

			loginResponseDto.setStatus(true);
			//loginResponseDto.setToken(token);
			loginResponseDto.setMessage("Login Successfully");
			loginResponseDto.setUser(userDto);

			return loginResponseDto;

		}

		else

		{

			loginResponseDto.setStatus(false);
			loginResponseDto.setMessage("user credentials are not correct");

		}

		return loginResponseDto;

	}

	@PostMapping("/student/logout")
	public ResponseEntity<?> logout(@RequestParam String token) {
		tokenLogservice.invalidateToken1(token);
		return ResponseEntity.status(HttpStatus.OK).body("Done");


	/*
	 * @PostMapping("/student/logout") public ResponseEntity<?> logout(@RequestParam
	 * String token){ tokenLogService.inValidateToken(token); return
	 * ResponseEntity.status(HttpStatus.OK).body("Done"); }
	 */

	}

	@PostMapping("/admin/logout")
	public ResponseEntity<?> logout1(@RequestParam String token) {
		tokenLogservice.invalidateToken1(token);
		return ResponseEntity.status(HttpStatus.OK).body("Token Logout SucessFully");

	}
	

}
