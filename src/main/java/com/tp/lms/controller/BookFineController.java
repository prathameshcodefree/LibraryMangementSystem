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
import com.tp.lms.model.Student;
import com.tp.lms.service.BookFineService;

@RestController
@RequestMapping("/bookfine")
public class BookFineController {

	@Autowired
	BookFineService bookFineService;

	@GetMapping(" ")
	public List<BookFine> getBookFine() {

		return bookFineService.getBookFine();

	}


	@GetMapping("/{id}")
	public ResponseEntity<?> getBookFineById(@PathVariable Integer id) {
	    Optional<BookFine> res = bookFineService.getBookFineById(id);
	    if (res.isEmpty()) {
	       
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    } else {
	        
	        BookFine bookFine = res.get();
	        
	        return ResponseEntity.ok().body(bookFine);
	    }
	}


	@PostMapping("/add")
	public ResponseEntity<?> addStudent(@RequestBody BookFine bookfine) {
		List<String> error = bookFineService.validate(bookfine);
		if (error.size() != 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}

		bookFineService.addBookFine(bookfine);
		return ResponseEntity.ok().body("BookFine added successfully.");

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateBookFine(@PathVariable Integer id, @RequestBody BookFine bookfine) {
		List<String> error = bookFineService.validate(bookfine);
		if (!error.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}

		bookFineService.updateBookFine(id, bookfine);
		return ResponseEntity.ok().body("Bookfine with ID " + id + " Updated successfully.");

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {

		boolean deleted = bookFineService.deleteStudent(id);

		if (deleted) {
			return ResponseEntity.ok("BookFine with ID " + id + " deleted successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("BookFine with ID " + id + " not found.");
		}

	}

}
