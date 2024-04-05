package com.tp.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	private RequirementService requirementservice;
	
	@GetMapping("")
	public ResponseEntity< List<Requirement>> getRequirement(@RequestBody Requirement requirement){
		
		List<Requirement> ls=requirementservice.getRequirement();
		if(ls.size()==0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(requirementservice.getRequirement(),HttpStatus.OK);
		
				
	}
	@GetMapping("/{requirementid}")
	public ResponseEntity<Requirement> getRequiremntById(@PathVariable int requirementId) {
		Requirement req= requirementservice.getRequirementById(requirementId);
		if(req==null) {
			return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(requirementservice.getRequirementById(requirementId),HttpStatus.OK);
		
		
	}
	
	@PostMapping(" ")
	public Requirement addStudent( @RequestBody Requirement requirement) {
		
		 return requirementservice.addRequirement(requirement);
		 
		
	}
	
	@PutMapping("/{requirementid}")
	public Requirement putMethodName(@PathVariable int requirementid, @RequestBody Requirement requirement) {
		//TODO: process PUT request
		
		return requirementservice.updaterequirement(requirementid, requirement);
	}
	
	@DeleteMapping("/{requirementid}")
	public void deleteMethod (@PathVariable  int requirementid ) {
		
		requirementservice.deleteStudentById(requirementid);
		
		
	}
	
	
	

}
