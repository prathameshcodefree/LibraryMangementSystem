package com.tp.lms.controller;

import com.tp.lms.model.BookSubCategory;
import com.tp.lms.service.BookSubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booksubcategory")
public class BookSubCategoryController {

	@Autowired
	BookSubCategoryService bookSubCategoryService;

    
    public BookSubCategoryController(BookSubCategoryService bookSubCategoryService) {
        this.bookSubCategoryService = bookSubCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<BookSubCategory>> getAllBookSubCategories() {
        List<BookSubCategory> bookSubCategories = bookSubCategoryService.getAllBookSubCategories();
        return new ResponseEntity<>(bookSubCategories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookSubCategory> getBookSubCategoryById(@PathVariable Integer id) {
        BookSubCategory bookSubCategory = bookSubCategoryService.getBookSubCategoryById(id);
        if (bookSubCategory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookSubCategory, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addBookSubCategory(@RequestBody BookSubCategory bookSubCategory) {
    	List<String> error = bookSubCategoryService.validate(bookSubCategory);
		if (error.size() != 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
        BookSubCategory savedBookSubCategory = bookSubCategoryService.addBookSubCategory(bookSubCategory);
        return new ResponseEntity<>(savedBookSubCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBookSubCategory(@PathVariable Integer id, @RequestBody BookSubCategory bookSubCategory) {
    	List<String> error = bookSubCategoryService.validate(bookSubCategory);
		if (error.size() != 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
        BookSubCategory updatedBookSubCategory = bookSubCategoryService.updateBookSubCategory(id, bookSubCategory);
        if (updatedBookSubCategory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedBookSubCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookSubCategory(@PathVariable Integer id) {
        bookSubCategoryService.deleteBookSubCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
