package com.tp.lms.controller;

import java.util.List;
import java.util.NoSuchElementException;
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

import com.tp.lms.model.BookFine;
import com.tp.lms.model.Staff;
import com.tp.lms.service.BookFineService;
import com.tp.lms.service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	StaffService staffService;

	@GetMapping(" ")
	public List<Staff> getStaff() {

		return staffService.getStaff();

	}


	@GetMapping("/{id}")
	public ResponseEntity<?> getStaffById(@PathVariable Integer id) {
	    Optional<Staff> res = staffService.getStaffById(id);
	    if (res.isEmpty()) {
	       
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    } else {
	        
	        Staff staff = res.get();
	        
	        return ResponseEntity.ok().body(staff);
	    }
	}


	@PostMapping("")
	public ResponseEntity<?> addStaff(@RequestBody Staff staff) {
		List<String> error = staffService.validate(staff);
		if (error.size() != 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}

		staffService.addStaff(staff);
		return ResponseEntity.ok().body("Staff added successfully.");

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateStaff(@PathVariable Integer id, @RequestBody Staff staff) {
		List<String> error = staffService.validate(staff);
		if (!error.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}

		staffService.updateStaff(id,staff);
		return ResponseEntity.ok().body("Staff with ID " + id + " Updated successfully.");

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStaff(@PathVariable Integer id) {

		boolean deleted = staffService.deleteStaff(id);

		if (deleted) {
			return ResponseEntity.ok("Staff with ID " + id + " deleted successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Staff with ID " + id + " not found.");
		}

	}

}
