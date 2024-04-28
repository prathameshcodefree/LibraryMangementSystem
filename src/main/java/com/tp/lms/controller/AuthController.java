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
import com.tp.lms.model.Staff;
import com.tp.lms.model.Student;

import com.tp.lms.model.enums.StaffType;

import com.tp.lms.repository.StudentRepository;
import com.tp.lms.service.StaffService;
import com.tp.lms.service.StudentService;
import com.tp.lms.service.TokenLogService;

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
	StaffService staffService;

	@Autowired
	TokenLogService tokenlogservice;

	@Autowired
	TokenLogService tokenLogService;

	@GetMapping("converttohash")
	public String convertToHash(@RequestParam String clearText) {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String cipherText = passwordEncoder.encode(clearText);

		return cipherText;

	}

	/*
	 * @PostMapping("student/login") public LoginResponseDTO
	 * studentLogstafin(@RequestBody LoginRequestDTO loginRequestDto) {
	 * LoginResponseDTO loginResponseDto = new LoginResponseDTO();
	 * 
	 * // validate user input // static validation : email not null and password not
	 * null, partten checking // for email and password
	 * 
	 * // Logic flow start Student student = studentService.login(loginRequestDto);
	 * 
	 * // if not found send error if (student == null) {
	 * loginResponseDto.setStatus(false);
	 * loginResponseDto.setMessage("user credentials are not correct"); return
	 * loginResponseDto; }
	 * 
	 * // generate token and save record in db // generate token // save token //
	 * send in response
	 * 
	 * String token = tokenlogservice.genrateToken();
	 * tokenlogservice.addLogForStudentLogin(token, student.getId(),
	 * student.getEmail()); // logic flow end
	 * 
	 * // response preparation UserDTO userDto = new UserDTO();
	 * userDto.setFirstName(student.getFirstName());
	 * userDto.setMiddleName(student.getMiddleName());
	 * userDto.setUserName(student.getUserName());
	 * 
	 * loginResponseDto.setStatus(true);
	 * loginResponseDto.setMessage("Login Successfully");
	 * loginResponseDto.setUser(userDto); loginResponseDto.setToken(token); //
	 * response preparation end
	 * 
	 * // response send return loginResponseDto;
	 * 
	 * }
	 */

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
		String token = tokenLogService.generateToken(student.getId(), student.getEmail());

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
		loginResponseDto.setToken(token);
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

	@PostMapping("librarian/login")
	public LoginResponseDTO librarianLogin(@RequestBody LoginRequestDTO loginRequestDto) {
		LoginResponseDTO loginResponseDto = new LoginResponseDTO();

		Staff staff = staffService.login(loginRequestDto);

		if (staff != null) {

			String token = tokenLogService.generateToken(staff.getId(), staff.getEmail());

			UserDTO userDto = new UserDTO();
			userDto.setFirstName(staff.getFirstName());
			userDto.setMiddleName(staff.getMiddleName());
			userDto.setUserName(staff.getUserName());

			loginResponseDto.setStatus(true);
			loginResponseDto.setMessage("Login Successfully");
			loginResponseDto.setUser(userDto);

		} else

		{
			loginResponseDto.setStatus(false);
			loginResponseDto.setMessage("user credentials are not correct");

		}

		return loginResponseDto;

	}

	/*
	 * @PostMapping("/student/logout") public ResponseEntity<?> logout(@RequestParam
	 * String token){ tokenLogService.inValidateToken(token); return
	 * ResponseEntity.status(HttpStatus.OK).body("Done"); }
	 */
	
	@PostMapping("/logout")
	public ResponseEntity<String> logout(@RequestParam String token) {
	    if (tokenLogService.invalidateToken(token)) {
	        return ResponseEntity.ok("Logout successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Token not found");
	    }
	}

}
