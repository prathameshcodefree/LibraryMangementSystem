package com.tp.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tp.lms.model.Requirement;

import com.tp.lms.repository.RequirementRepository;

@Service
public class RequirementService {
	@Autowired
	private RequirementRepository reqrepo;

	public List<Requirement> getRequirement() {

		return reqrepo.findAll();

	}

	public Requirement getRequirementById(int requirementid) {
		return reqrepo.findById(requirementid).get();

	}

	public Requirement addRequirement(Requirement requirement) {

		return reqrepo.save(requirement);

	}

	public Requirement updaterequirement(int requirementid, Requirement requirement) {

		requirement.setRequirementId(requirementid);
		return reqrepo.save(requirement);

	}
	
	public void deleteStudentById(int requirementid) {

		reqrepo.deleteById(requirementid);
	
	}

}
