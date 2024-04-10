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
import com.tp.lms.service.BookFineService;

@RestController
@RequestMapping("/bookfine")
public class BookFineController {

	@Autowired
	BookFineService bookFineService;

	@GetMapping("")
	public ResponseEntity<?> getBookFine() {
		List<BookFine> bookFine = bookFineService.getBookFine();
		if (bookFine.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book Fine not found");
		}
		return ResponseEntity.ok(bookFine);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getBookFineById(@PathVariable Integer id) {
		Optional<BookFine> bookFineById = bookFineService.getBookFineById(id);
		if (bookFineById.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book Fine id not found");
		} else {
			BookFine bookFine = bookFineById.get();
			return ResponseEntity.ok().body(bookFine);
		}
	}

	@PostMapping("")
	public ResponseEntity<?> addBookFine(@RequestBody BookFine bookfine) {
		List<String> error = bookFineService.validate(bookfine);
		if (error.size() != 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}

		bookFineService.addBookFine(bookfine);
		return ResponseEntity.ok().body("Book Fine  added successfully.");

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateBookFine(@PathVariable Integer id, @RequestBody BookFine bookfine) {

		List<String> errors = bookFineService.validate(bookfine);
		if (!errors.isEmpty()) {
			return ResponseEntity.badRequest().body(errors);
		}

		Optional<BookFine> existingStudent = bookFineService.getBookFineById(id);
		if (!existingStudent.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bookfine with id " + id + " not found.");
		}

		bookFineService.updateBookFine(id, bookfine);
		return ResponseEntity.ok().body("Book Fine with ID " + id + " updated successfully.");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBookFine(@PathVariable Integer id) {

		boolean deleted = bookFineService.deleteBookFine(id);

		if (deleted) {
			return ResponseEntity.ok("BookFine with ID " + id + " deleted successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bookfine with id " + id + " not found.");
		}

	}

}