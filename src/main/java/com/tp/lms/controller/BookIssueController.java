package com.tp.lms.controller;

import java.util.List;
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

import com.tp.lms.model.BookFine;
import com.tp.lms.model.BookIssue;
import com.tp.lms.model.Student;
import com.tp.lms.service.BookIssueService;


@RestController
@RequestMapping("/bookissue")
public class BookIssueController {
	
		
		
		@Autowired
		BookIssueService bookIssueService;
		
		@GetMapping("")
		public ResponseEntity<String> getStudent () {

			List<BookIssue> bookIssue= bookIssueService.getBookIssue();
			if(bookIssue.size()==0) {
				return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			 return ResponseEntity.ok().body("BookIssue with ID " + bookIssue + " ");

		}
		

		@GetMapping("/{id}")
		public ResponseEntity<?> getBookIssueById(@PathVariable Integer id) {
		    Optional<BookIssue> res = bookIssueService.getBookIssueById(id);
		    if (res.isEmpty()) {
		       
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    } else {
		        
		        BookIssue bookIssue = res.get();
		        
		        return ResponseEntity.ok().body(bookIssue);
		    }
		}

		
		@PostMapping("/add")
		public ResponseEntity<?> addStudent(@RequestBody BookIssue bookissue) {
			List<String> error = bookIssueService.validate(bookissue);
			if (error.size() != 0) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
			}

			bookIssueService.addBookIssue(bookissue);
			 return ResponseEntity.ok().body("Student added successfully.");


		}
		
		@PutMapping("/{bookIssueId}")
		public ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody BookIssue bookissue) {
	        List<String> error = bookIssueService.validate(bookissue);
	        if (!error.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	        }

	        bookIssueService.updateBookIssue(id, bookissue);
	        return ResponseEntity.ok().body("Book Issue with ID " + id + " Updated successfully.");

	    }

		
		@DeleteMapping("/{bookIssueId}")
		public ResponseEntity<?> deleteBookIssue(@PathVariable Integer id) {
		
		        boolean deleted = bookIssueService.deleteBookIssue(id);


		        if (deleted) {
		            return ResponseEntity.ok("Book Issue with ID " + id + " deleted successfully.");
		        } else {
		            return ResponseEntity.status(HttpStatus.NOT_FOUND)
		                                 .body("Book Issue with ID " + id + " not found.");
		        }
		    }
			


}
