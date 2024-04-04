package com.tp.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Staff GetStaff(@PathVariable int id) {
		return staffService.GetStaff(id);
	}

	@PostMapping
	public Staff AddStaff(@RequestBody Staff staff) {
		return staffService.AddStaff(staff);
	}

	@PutMapping("/{id}")
	public Staff UpdateStaff(@RequestBody Staff staff, @PathVariable int id) {
		return staffService.UpdateStaff(staff, id);
	}

	@DeleteMapping("/{id}")
	public void DeleteMapping(@PathVariable int id) {
		staffService.DeleteStaff(id);
	}
}
