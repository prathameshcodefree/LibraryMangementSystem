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
			error.add("Price is required");
		}

		if (requirement.getQuantity() == 0) {
			error.add("Quantity is required");
		}

		if (requirement.getExpectedFulfilmentDate() == null) {
			error.add("Expectedfulfilmentdate is required");
		}

		if (requirement.getRequirementReason() == null) {
			error.add("Requirement reason is required");
		}

		if (requirement.getRequirementStatus() == null) {
			error.add("Requirement status is required");
		}

		return error;
	}

	public List<Requirement> getRequirement() {

		return requirementRepository.findAll();

	}

	public Optional<Requirement> getRequirementById(Integer id) {
		return requirementRepository.findById(id);

	}

	public Requirement addRequirement(Requirement requirement) {

		return requirementRepository.save(requirement);

	}

	public Requirement updateRequirement(Integer id, Requirement requirement) {
		Requirement requirementToUpdate = requirementRepository.findById(id).orElse(null);

		requirementToUpdate.setQuantity(requirement.getQuantity());
		requirementToUpdate.setPrice(requirement.getPrice());
		requirementToUpdate.setExpectedFulfilmentDate(requirement.getExpectedFulfilmentDate());
		requirementToUpdate.setRequirementStatus(requirement.getRequirementStatus());
		requirementToUpdate.setRequirementReason(requirement.getRequirementReason());

		return requirementRepository.save(requirementToUpdate);
	}

	public void deleteRequirement(Integer id) {

		requirementRepository.deleteById(id);

	}

}
