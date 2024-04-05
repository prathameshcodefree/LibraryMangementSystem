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
		BookIssueService bookIssueService;
		
		@GetMapping(" ")
		public List<BookIssue> getBookIssue() {
			
			 return bookIssueService.getBookIssue();
			
		}
		
		
		@GetMapping("/{bookIssueId}")
		public BookIssue getBookIssue(@PathVariable Integer id) {
			
			 return bookIssueService.getBookIssue(id);
			
		}
		
		@PostMapping
		public BookIssue addBookIssue(BookIssue bookissue) {
			
			 return bookIssueService.addBookIssue(bookissue);
			
		}
		
		@PutMapping("/{bookIssueId}")
	      public BookIssue updateBookIssue( @PathVariable Integer id, @RequestBody BookIssue bookissue) {
			
			return bookIssueService.updateBookIssue(id,bookissue);

		}

		
		@DeleteMapping("/{bookIssueId}")
		public void deleteBookIssue(@PathVariable Integer id) {

			bookIssueService.deleteBookIssue(id);
		}
			


}
