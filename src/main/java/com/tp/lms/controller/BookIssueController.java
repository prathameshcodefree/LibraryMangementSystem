package com.tp.lms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tp.lms.model.BookIssue;
import com.tp.lms.service.BookIssueService;
import com.tp.lms.service.TokenLogService;

@RestController
@RequestMapping("/bookissue")
public class BookIssueController {

	@Autowired
	BookIssueService bookIssueService;
	
	@Autowired
	TokenLogService tokenLogService;

	@GetMapping("")
	public ResponseEntity<?> getBookIssue(@RequestParam String token) {
		
		if(!tokenLogService.verifyToken(token)) {
			
			return ResponseEntity.status(HttpStatusCode.valueOf(401)).body("Unauthorized Access");
		}
		
		
		List<BookIssue> bookIssue = bookIssueService.getBookIssue();
		if (bookIssue.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book Issue not found");
		}
		return ResponseEntity.ok(bookIssue);
	}

	
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBookIssueById(@PathVariable Integer id) {
		Optional<BookIssue> bookIssueById = bookIssueService.getBookIssueById(id);
		if (bookIssueById.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book Issue by id  " + id + "  not found");
		} else {
			BookIssue bookIssue = bookIssueById.get();
			return ResponseEntity.ok().body(bookIssue);
		}
	}

	@PostMapping("")
	public ResponseEntity<?> addBookIssue(@RequestBody BookIssue bookissue) {
		
		
		List<String> error = bookIssueService.validate(bookissue);
		if (error.size() != 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}

		bookIssueService.addBookIssue(bookissue);
		return ResponseEntity.ok().body("BookIssue added successfully.");

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateBookIssue(@PathVariable Integer id, @RequestBody BookIssue bookissue) {

		List<String> errors = bookIssueService.validate(bookissue);
		if (!errors.isEmpty()) {
			return ResponseEntity.badRequest().body(errors);
		}

		Optional<BookIssue> existingStudent = bookIssueService.getBookIssueById(id);
		if (!existingStudent.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book Issue with " + id + " not found." );
		}

		bookIssueService.updateBookIssue(id, bookissue);
		return ResponseEntity.ok().body("Book Issue with ID " + id + " updated successfully.");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBookIssue(@PathVariable Integer id) {

		boolean deleted = bookIssueService.deleteBookIssue(id);

		if (deleted) {
			return ResponseEntity.ok("Book Issue with ID " + id + " deleted successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book Issue with ID " + id + " not found.");
		}
	}

}