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

import com.tp.lms.model.BookMaster;
import com.tp.lms.model.Student;
import com.tp.lms.service.BookMasterService;

@RestController

@RequestMapping("/bookMaster")
public class BookMasterController {
	@Autowired
	BookMasterService bookMasterService;
	
	@GetMapping("")	
	public ResponseEntity<List<BookMaster>> getBookMaster() {
		List<BookMaster> bookMasterCount = bookMasterService.getBookMaster();
		if(bookMasterCount.size()==0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(bookMasterService.getBookMaster(),HttpStatus.OK);
		
	}
	
	
	@GetMapping("/{bookMasterId}")
	public ResponseEntity<?> getBookMasterById(@PathVariable Integer bookMasterId) {
		
		
		Optional<BookMaster> bookMasterByIds= bookMasterService.getBookMasterById(bookMasterId);
		if(bookMasterByIds.isEmpty()) {
			return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(bookMasterService.getBookMasterById(bookMasterId),HttpStatus.OK);

	}
	
	
	@PostMapping("")
	public ResponseEntity<?> addBookMaster(@RequestBody BookMaster bookMaster){
		List<String> error = bookMasterService.validate(bookMaster);
		if (error.size() != 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}

		BookMaster addedBookMaster = bookMasterService.addBookMaster(bookMaster);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedBookMaster);
	
	}
	


	@PutMapping("/{id}")
	public  ResponseEntity<?> updateBookMaster(@PathVariable Integer id, @RequestBody BookMaster bookMaster){
		List<String> error = bookMasterService.validate(bookMaster);
		if (error.size() != 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
		BookMaster updatedBookMaster = bookMasterService.updateBookMaster(id, bookMaster);
		return ResponseEntity.status(HttpStatus.CREATED).body(updatedBookMaster);
		
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBookMaster(@PathVariable Integer id) {
		boolean deleted = bookMasterService.deleteBookMaster(id);
		if (deleted) {
			return ResponseEntity.ok("BookMaster with ID " + id + " deleted successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("BookMaster with ID " + id + " not found.");
		}
	}
	
	
	
	
	
	
	
}
