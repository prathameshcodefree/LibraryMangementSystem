/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tp.lms.dto.LoginRequestDTO;
import com.tp.lms.model.Admin;

import com.tp.lms.model.Student;
import com.tp.lms.model.Token;
import com.tp.lms.model.TokenLog;
import com.tp.lms.repository.AdminRepository;

/**
 *
 * @author Suhail Tamboli
 */
@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;

	public List<String> validate(Admin admin) {
		
		List<String> error = new ArrayList<>();
		boolean isEmail = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$").matcher(admin.getEmail())
				.matches();

		if (!isEmail) {
			error.add("email is not correct");
		}

		if (admin.getFirstName() == null) {
			error.add("Required first name");
		}

		if (admin.getLastName() == null) {
			error.add("required last name");
		}

		Pattern passwordPattern = Pattern
				.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
		Matcher passwordMatcher = passwordPattern.matcher(admin.getPassword());
		if (!passwordMatcher.matches()) {
			error.add("Password is not correct");
		}

		return error;
	}

	// Create Admin
	public Admin AddAdmin(Admin admin, String token) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		String cipherText = passwordEncoder.encode(admin.getPassword());
		admin.setPassword(cipherText);
		admin = adminRepository.save(admin);

		return admin;
	}

	// Get Admin
	public List<Admin> getAdmin() {

		return adminRepository.findAll();
	}

	// Get Admin by Id
	public Optional<Admin> getAdminById(Integer adminId) {

		return adminRepository.findById(adminId);

	}

	// Delete Admin by id
	public boolean deleteStudent(Integer id) {
		boolean exists = adminRepository.existsById(id);
		if (exists) {
			adminRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	// update admin by id
	public Admin updateAdmin(int requirementid, Admin admin) {

		admin.setId(requirementid);
		return adminRepository.save(admin);

	}

	public Admin login(LoginRequestDTO loginRequestDto) {
		Optional<Admin> adminO = adminRepository.findByUserName(loginRequestDto.getUserName());
		System.out.println(adminO);
		Admin admin = null;

		if (adminO.isPresent()) {

			Admin admindb = adminO.get();
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

			System.out.println("Admin Name" + admindb);

			System.out.print("passwrod user: " + loginRequestDto.getPassword() + " from db:" + admindb.getPassword());
			if (passwordEncoder.matches(loginRequestDto.getPassword(), admindb.getPassword())) {
				admin = admindb;
			}

		}

		return admin;

	}

}
