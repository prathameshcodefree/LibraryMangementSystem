/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.lms.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tp.lms.dto.LoginRequestDTO;
import com.tp.lms.dto.LoginResponseDTO;
import com.tp.lms.dto.UserDTO;
import com.tp.lms.model.Admin;
import com.tp.lms.model.Student;
import com.tp.lms.service.AdminService;
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
	StudentService studentService;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	TokenLogService tokenLogService;
	
	
	@GetMapping("converttohash")
	public String convertToHash(String clearText) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String cipherText = passwordEncoder.encode(clearText);
		
		return cipherText;
	}
	
	@PostMapping("student/login")
	public LoginResponseDTO studentLogin(@RequestBody LoginRequestDTO loginRequestDto) {
		LoginResponseDTO loginResponseDto = new LoginResponseDTO();
		
		Student student = studentService.login(loginRequestDto);
		
		
		
		if(student != null) {
			UserDTO userDto = new UserDTO();
			userDto.setFirstName(student.getFirstName());
			userDto.setMiddleName(student.getMiddleName());
			
			
			
			loginResponseDto.setStatus(true);
			loginResponseDto.setMessage("Login Successfully");
			loginResponseDto.setUser(userDto);
		}else {
			loginResponseDto.setStatus(false);
			loginResponseDto.setMessage("user credentials are not correct");
		}
		return loginResponseDto;
		
	}
	
	
	
	
	
	
	@PostMapping("admin/login")
	public LoginResponseDTO adminLogin(@RequestBody LoginRequestDTO loginRequestDto) {
		LoginResponseDTO loginResponseDto = new LoginResponseDTO();
		
		Admin admin = adminService.login(loginRequestDto);
		
		String token =tokenLogService.generateToken();
		
		if(admin != null) {
			UserDTO userDto = new UserDTO();
			userDto.setFirstName(admin.getFirstName());
			userDto.setLastName(admin.getLastName());
			userDto.setUserName(admin.getUserName());
			loginResponseDto.setStatus(true);
			loginResponseDto.setMessage("Login Successfully");
			loginResponseDto.setUser(userDto);
			loginResponseDto.setToken(token);
		}else {
			loginResponseDto.setStatus(false);
			loginResponseDto.setMessage("user credentials are not correct");
		}
		return loginResponseDto;
		
	}
	
}
