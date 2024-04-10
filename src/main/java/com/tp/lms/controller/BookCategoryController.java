package com.tp.lms.controller;

import com.tp.lms.model.BookCategory;
import com.tp.lms.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookcategory")
public class BookCategoryController {

	@Autowired
    BookCategoryService bookCategoryService;

    
    public BookCategoryController(BookCategoryService bookCategoryService) {
        this.bookCategoryService = bookCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<BookCategory>> getAllBookCategories() {
        List<BookCategory> bookCategories = bookCategoryService.getAllBookCategories();
        return new ResponseEntity<>(bookCategories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookCategory> getBookCategoryById(@PathVariable Integer id) {
        BookCategory bookCategory = bookCategoryService.getBookCategoryById(id);
        if (bookCategory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookCategory, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveBookCategory(@RequestBody BookCategory bookCategory) {
    	List<String> error = bookCategoryService.validate(bookCategory);
		if (error.size() != 0) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
		}
        BookCategory savedBookCategory = bookCategoryService.addBookCategory(bookCategory);
        return new ResponseEntity<>(savedBookCategory, HttpStatus.CREATED);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBookCategory(@PathVariable Integer id, @RequestBody BookCategory bookCategory) {
    	List<String> error = bookCategoryService.validate(bookCategory);
		if (error.size() != 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
		
        BookCategory updatedBookCategory = bookCategoryService.updateBookCategory(id, bookCategory );
        if (updatedBookCategory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedBookCategory, HttpStatus.OK);
    }
    
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookCategory(@PathVariable Integer id) {
        bookCategoryService.deleteBookCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
