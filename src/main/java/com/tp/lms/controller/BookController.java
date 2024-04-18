package com.tp.lms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tp.lms.model.Book;
import com.tp.lms.service.BookService;

@RestController
@RequestMapping("book")
public class BookController {
	@Autowired
	BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping
	public ResponseEntity<?> getBook() {
		List<Book> book = bookService.getBook();
		if (book.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
		}
		return ResponseEntity.ok(book);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getBookById(@PathVariable Integer id) {
		Optional<Book> bookById = bookService.getBookById(id);
		if (bookById.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book by id not found");
		} else {
			Book book = bookById.get();
			return ResponseEntity.ok().body(book);
		}
	}

	@PostMapping
	public ResponseEntity<?> addBook(@RequestBody Book book) {

		List<String> error = bookService.validate(book);
		if (error.size() != 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}

		bookService.addBook(book);
		return ResponseEntity.ok().body("Book added successfully.");

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateBook(@PathVariable Integer id, @RequestBody Book book) {

		List<String> errors = bookService.validate(book);
		if (!errors.isEmpty()) {
			return ResponseEntity.badRequest().body(errors);
		}

		Optional<Book> existingBook = bookService.getBookById(id);
		if (!existingBook.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with id " + id + "not found.");
		}

		// Update the student
		bookService.updateBook(id, book);
		return ResponseEntity.ok().body("Book with ID " + id + " updated successfully.");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable Integer id) {

		boolean deleted = bookService.deleteBook(id);

		if (deleted) {
			return ResponseEntity.ok("Book with ID " + id + " deleted successfully.");
		}

		else

		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with id " + id + " not found.");

		}

	}

}
