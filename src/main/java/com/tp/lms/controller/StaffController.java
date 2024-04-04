package com.tp.lms.controller;

import java.util.List;
import java.util.NoSuchElementException;

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

import com.tp.lms.model.Staff;
import com.tp.lms.service.StaffService;

@RestController
@RequestMapping("/Staff")
public class StaffController {

	@Autowired
	private StaffService staffService;

	@GetMapping
	public List<Staff> getAllList() {
		return staffService.GetAllStaff();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Staff> GetStaff(@PathVariable Integer id) {
		try {
			Staff staff = staffService.GetStaff(id);
			return new ResponseEntity<Staff>(staff, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Staff>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public Staff AddStaff(@RequestBody Staff staff) {
		return staffService.AddStaff(staff);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Staff> Update(@PathVariable Integer id, @RequestBody Staff staff1) {
		try {
			staffService.UpdateStaff(staff1, id);
			return new ResponseEntity<Staff>(staff1, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Staff>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public void DeleteMapping(@PathVariable int id) {
		staffService.DeleteStaff(id);
	}
}
