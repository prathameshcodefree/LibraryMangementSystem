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

import com.tp.lms.model.BookIssue;
import com.tp.lms.service.BookIssueService;


@RestController
@RequestMapping("/bookissue")
public class BookIssueController {
	
		
		
		@Autowired
		BookIssueService bookissueservice;
		
		@GetMapping(" ")
		public List<BookIssue> getBookIssue() {
			
			 return bookissueservice.getBookIssue();
			
		}
		
		
		@GetMapping("/{bookIssueId}")
		public BookIssue getBookIssue(@PathVariable int bookIssueId) {
			
			 return bookissueservice.getBookIssue(bookIssueId);
			
		}
		
		@PostMapping
		public BookIssue addBookIssue(BookIssue bookissue) {
			
			 return bookissueservice.addBookIssue(bookissue);
			
		}
		
		@PutMapping("/{bookIssueId}")
	      public BookIssue updateBookIssue(int bookIssueId, @RequestBody BookIssue bookissue) {
			
			return bookissueservice.updateBookIssue(bookIssueId,bookissue);

		}

		
		@DeleteMapping("/{bookIssueId}")
		public void deleteBookIssue(@PathVariable int bookIssueId) {

			bookissueservice.deleteBookIssue(bookIssueId);
		}
			


}
