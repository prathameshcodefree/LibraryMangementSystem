package com.tp.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tp.lms.model.Requirement;

import com.tp.lms.repository.RequirementRepository;

@Service
public class RequirementService {
	@Autowired
	private RequirementRepository requirementRepository;

	public List<Requirement> getRequirement() {

		return requirementRepository.findAll();

	}

	public Requirement getRequirementById(int requirementid) {
		return requirementRepository.findById(requirementid).get();

	}

	public Requirement addRequirement(Requirement requirement) {

		return requirementRepository.save(requirement);

	}

	public Requirement updaterequirement(int requirementid, Requirement requirement) {

		requirement.setId(requirementid);
		return requirementRepository.save(requirement);

	}
	
	public void deleteStudentById(int requirementid) {

		requirementRepository.deleteById(requirementid);
	
	}

}
