/*
     * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

import com.tp.lms.model.Admin;
import com.tp.lms.model.Requirement;
import com.tp.lms.model.Student;
import com.tp.lms.service.AdminService;

/**
 *
 * @author Suhail Tamboli
 */
@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@GetMapping("")
	public ResponseEntity<?> getAdmin() {
		List<Admin> studentCount = adminService.getAdmin();
		if (studentCount.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(adminService.getAdmin(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Integer id) {
		Optional<Admin> res = adminService.getAdminById(id);
		if (res.isEmpty()) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {

			Admin admin = res.get();

			return ResponseEntity.ok().body(admin);
		}
	}

	@PostMapping()
	public ResponseEntity<?> createAdmin(@RequestBody Admin admin) {

		List<String> error = adminService.validate(admin);
		if (!error.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

		}
		adminService.AddAdmin(admin);
		return ResponseEntity.ok().body("Admin added successfully.");

	}
	@PutMapping("/{id}")
	public ResponseEntity<?> putMethodName(@PathVariable Integer id, @RequestBody Admin admin) {
		// TODO: process PUT request

		List<String> error = adminService.validate(admin);
		if (error.size() != 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
		adminService.updateAdmin(id, admin);
		return ResponseEntity.ok().body("Updated Succesfully");

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {

		boolean deleted = adminService.deleteStudent(id);

		if (deleted) {
			return ResponseEntity.ok("Admin with ID " + id + " deleted successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("admin with ID " + id + " not found.");
		}
	}

}
