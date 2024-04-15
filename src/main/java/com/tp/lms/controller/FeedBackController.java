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

import com.tp.lms.model.Feedback;
import com.tp.lms.model.Staff;
import com.tp.lms.service.FeedbackService;
import com.tp.lms.service.StaffService;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {

	@Autowired
	FeedbackService feedbackService;

	@GetMapping(" ")
	public List<Feedback> getFeedbacks() {

		return feedbackService.getFeddBack();

	}


	@GetMapping("/{id}")
	public ResponseEntity<?> getFeedBackById(@PathVariable Integer id) {
	    Optional<Feedback> res = feedbackService.getFeedBackById(id);
	    if (res.isEmpty()) {
	       
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    } else {
	        
	        Feedback feedback = res.get();
	        
	        return ResponseEntity.ok().body(feedback);
	    }
	}


	@PostMapping(" ")
	public ResponseEntity<?> addFeedBack(@RequestBody Feedback feedback) {
		List<String> error = feedbackService.validate(feedback);
		if (error.size() != 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}

		feedbackService.addFeedback(feedback);
		return ResponseEntity.ok().body("FeedBack added successfully.");

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateFeedBack(@PathVariable Integer id, @RequestBody Feedback feedback) {
		List<String> error = feedbackService.validate(feedback);
		if (!error.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}

		feedbackService.updateFeedBack(id,feedback);
		return ResponseEntity.ok().body("FeedBack with ID " + id + " Updated successfully.");

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFeedBack(@PathVariable Integer id) {

		boolean deleted = feedbackService.deleteFeedBack(id);

		if (deleted) {
			return ResponseEntity.ok("Feedback with ID " + id + " deleted successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("FeedBack with ID " + id + " not found.");
		}

	}

}



