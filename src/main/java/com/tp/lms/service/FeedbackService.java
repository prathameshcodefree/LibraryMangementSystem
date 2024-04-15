package com.tp.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tp.lms.model.Feedback;
import com.tp.lms.repository.FeedBackRespository;

@Service
public class FeedbackService {

	@Autowired
	FeedBackRespository feedBackRespository;

	public List<Feedback> getFeddBack() {

		return (List<Feedback>) feedBackRespository.findAll();

	}

	public Optional<Feedback> getFeedBackById(Integer id) {
		return feedBackRespository.findById(id);

	}

	public List<String> validate(Feedback feedback) {

		List<String> error = new ArrayList<>();

		if (feedback.getId() == null) {
			error.add("Id can not be empty");
		}

		if (feedback.getStudentid() == null) {
			error.add("FeedBack Student can not be empty");
		}

		if (feedback.getFeedback() == null) {
			error.add("FeedBack can not be empty");
		}
		return error;
	}

	public Feedback addFeedback(Feedback feedback) {

		return feedBackRespository.save(feedback);

	}

	public Feedback updateFeedBack(Integer id, @RequestBody Feedback feedback) {
		Feedback existingStaff = feedBackRespository.findById(id).orElse(null);
		existingStaff.setId(feedback.getId());
		existingStaff.setStudentid(feedback.getStudentid());
		existingStaff.setFeedback(feedback.getFeedback());
		return feedBackRespository.save(existingStaff);
	}

	public boolean deleteFeedBack(Integer id) {

		boolean exists = feedBackRespository.existsById(id);
		if (exists) {
			feedBackRespository.deleteById(id);
			return true;
		} else {

			return false;
		}

	}

}