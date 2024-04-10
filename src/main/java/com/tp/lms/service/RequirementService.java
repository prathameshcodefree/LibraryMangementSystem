package com.tp.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tp.lms.model.Requirement;

import com.tp.lms.repository.RequirementRepository;

@Service
public class RequirementService {
	@Autowired
	private RequirementRepository requirementRepository;
	
	public List<String> validate(Requirement requirement) {
		List<String> error = new ArrayList<>();

		if (requirement.getPrice() == 0) {
			error.add("Required price is compulsary ");
		}

		if (requirement.getQuantity() == 0) {
			error.add("Required quantity is compulsary");
		}

		if (requirement.getBookMasterId() < 0) {
			error.add("required book master id");
		}


		return error;
	}

	public List<Requirement> getRequirement() {

		return requirementRepository.findAll();

	}

	public Optional<Requirement> getRequirementById(Integer requirementid) {
		return requirementRepository.findById(requirementid);

	}

	public Requirement addRequirement(Requirement requirement) {

		return requirementRepository.save(requirement);

	}

	public Requirement updaterequirement(int requirementid, Requirement requirement) {

		requirement.setId(requirementid);
		return requirementRepository.save(requirement);

	}
	
	public Void deleteStudentById(int requirementid) {

		requirementRepository.deleteById(requirementid);
		return null;
	
	}

}
