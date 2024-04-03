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

import com.tp.lms.model.BookFine;
import com.tp.lms.service.BookFineService;

@RestController
@RequestMapping("/bookfine")
public class BookFineController {
	
		
		
		@Autowired
		BookFineService Bookfineservice;
		
		@GetMapping(" ")
		public List<BookFine> getBookFine() {
			
			 return Bookfineservice.getBookFine();
			
		}
		
		
		@GetMapping("/{bookFineId}")
		public BookFine getBookFine(@PathVariable int bookFineId) {
			
			 return Bookfineservice.getBookFine(bookFineId);
			
		}
		
		@PostMapping
		public BookFine addBookFine(BookFine bookfine) {
			
			 return Bookfineservice.addBookFine(bookfine);
			
		}
		
		@PutMapping("/{bookFineId}")
	      public BookFine updateBookFine(int bookFineId, @RequestBody BookFine bookfine) {
			
			return Bookfineservice.updateBookFine(bookFineId,bookfine);

		}

		
		@DeleteMapping("/{bookFineId}")
		public void deleteBookFine(@PathVariable int bookFineId) {

			Bookfineservice.deleteBookFine(bookFineId);
		}
			


}

