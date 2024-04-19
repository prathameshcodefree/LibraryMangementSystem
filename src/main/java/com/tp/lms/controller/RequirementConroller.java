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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.lms.model.Requirement;

import com.tp.lms.service.RequirementService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/requirement")
public class RequirementConroller {

	@Autowired
	private RequirementService requirementservice;

	@GetMapping("")
	public ResponseEntity<List<Requirement>> getRequirement() {

		List<Requirement> ls = requirementservice.getRequirement();
		if (ls.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(requirementservice.getRequirement(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getRequiremntById(@PathVariable Integer id) {
		Optional<Requirement> req = requirementservice.getRequirementById(id);
		if (req.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Requirement requirement = req.get();
		return ResponseEntity.ok().body(requirement);

	}

	@PostMapping(" ")
	public ResponseEntity<?> addStudent(@RequestBody Requirement requirement) {

		List<String> error = requirementservice.validate(requirement);
		if (!error.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
		requirementservice.addRequirement(requirement);
		return ResponseEntity.ok().body(" Requirement added Succesfully");

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> putMethodName(@PathVariable Integer id, @RequestBody Requirement requirement) {
		// TODO: process PUT request

		List<String> error = requirementservice.validate(requirement);
		if (error.size() != 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
		requirementservice.updateRequirement(id, requirement);
		return ResponseEntity.ok().body(" Requirement Updated Succesfully");

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMethod(@PathVariable Integer id) {
		try {
			requirementservice.deleteRequirement(id);
			return ResponseEntity.ok().body("deleted successfully");

		}

		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}
