package com.tp.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tp.lms.model.Feedback;
import com.tp.lms.repository.FeedBackRespository;

@Service

public class FeedbackService  {
     
	@Autowired
	private FeedBackRespository feedBackRespository;
	
	public List<Feedback> GetAllFeedBack(){
	return (List<Feedback>) feedBackRespository.findAll();
	}
	
	public Feedback GetFeedBack(int id) {
	return feedBackRespository.findById(id).get();
	}
	
	public Feedback AddFeedBack(Feedback feedback) {
	return feedBackRespository.save(feedback);	
	}
	
	public void DeleteFeedback(int id) {
	feedBackRespository.deleteById(id);
	}
	
	public Feedback UpdateFeedback(Feedback feedback,int id) {
	feedback.setId(id);
	return feedBackRespository.save(feedback);
	}
}
