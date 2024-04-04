package com.tp.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.lms.model.Feedback;
import com.tp.lms.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {
         @Autowired
         private FeedbackService feedbackService;
         
         @GetMapping
         public List<Feedback> GetAllFeedBack() {
         return feedbackService.GetAllFeedBack();
         }
         
         @GetMapping("/{id}")
         public Feedback GetFeedBack(@PathVariable int id) {
          return feedbackService.GetFeedBack(id);	 
         }
         
         @PostMapping
         public Feedback AddFeedBack(@RequestBody Feedback feedback) {
        	return feedbackService.AddFeedBack(feedback);
         }
         
         @DeleteMapping("/{id}")
         public void DeleteFeedback(@PathVariable int id) {
        	 feedbackService.DeleteFeedback(id);
         }
         @PutMapping("/{id}")
         public Feedback UpdateFeedback(@RequestBody Feedback feedback,@PathVariable int id) {
          return feedbackService.UpdateFeedback(feedback, id); 
         }
}
