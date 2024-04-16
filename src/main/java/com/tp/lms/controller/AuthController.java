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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tp.lms.dto.LoginRequestDTO;
import com.tp.lms.dto.LoginResponseDTO;
import com.tp.lms.dto.UserDTO;
import com.tp.lms.model.Student;
import com.tp.lms.service.StudentService;

/**
 *
 * @author Suhail Tamboli
 */
@RestController
@RequestMapping("auth")
public class AuthController {
    
	
	@Autowired
	StudentService studentService;
	
	
	@GetMapping("converttohash")
	public String convertToHash(@RequestParam String clearText) {
		
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
			userDto.setUserName(student.getUserName());
			
			
			
			loginResponseDto.setStatus(true);
			loginResponseDto.setMessage("Login Successfully");
			loginResponseDto.setUser(userDto);
		}else {
			loginResponseDto.setStatus(false);
			loginResponseDto.setMessage("user credentials are not correct");
		}
		return loginResponseDto;
		
	}
}
