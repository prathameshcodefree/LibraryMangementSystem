package com.tp.lms.controller;

import java.util.List;

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
    public ResponseEntity<List<Book>> getAllBook(){
    	List<Book> book = bookService.getBook();
    	return new ResponseEntity<>(book, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable int id) {
    	Book book = bookService.getById(id);
    	if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK); 
    }
    
    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book) {
    	List<String> error = bookService.validate(book);
		if (error.size() != 0) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
		}
    	Book addbook = bookService.addBook(book);
    	return new ResponseEntity<>(addbook, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable int id, @RequestBody Book book) {
    	List<String> error = bookService.validate(book);
		if (error.size() != 0) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
		}
    	Book updatebook = bookService.updateById(id, book);
    	if (updatebook == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatebook, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
    	bookService.deleteBook(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
   
}
