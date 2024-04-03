package com.tp.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.lms.model.Requirement;
import com.tp.lms.service.RequirementService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/requirement")
public class RequirementConroller {
	
	@Autowired
	private RequirementService reqservice;
	
	@GetMapping("")
	public List<Requirement> getRequirement(Requirement requirement){
		return reqservice.getRequirement();
		
				
	}
	@GetMapping("/{requirementid}")
	public Requirement getRequiremntById(@PathVariable int requirementId) {
		return reqservice.getRequirementById(requirementId);
		
	}
	
	@PostMapping(" ")
	public Requirement addStudent( @RequestBody Requirement requirement) {
		
		 return reqservice.addRequirement(requirement);
		
	}
	
	@PutMapping("/{requirementid}")
	public Requirement putMethodName(@PathVariable int requirementid, @RequestBody Requirement requirement) {
		//TODO: process PUT request
		
		return reqservice.updaterequirement(requirementid, requirement);
	}
	
	@DeleteMapping("/{requirementid}")
	public void deleteMethod (@PathVariable  Requirement requirementid ) {
		
		reqservice.deleteStudentById(requirementid);
		
		
	}
	
	
	

}
