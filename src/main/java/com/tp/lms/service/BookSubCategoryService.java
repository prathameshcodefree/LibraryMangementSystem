package com.tp.lms.service;


import com.tp.lms.model.BookSubCategory;
import com.tp.lms.repository.BookSubCategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookSubCategoryService {

	@Autowired
    BookSubCategoryRepository bookSubCategoryRepository;

    
    public BookSubCategoryService(BookSubCategoryRepository bookSubCategoryRepository) {
        this.bookSubCategoryRepository = bookSubCategoryRepository;
    }

    public List<BookSubCategory> getAllBookSubCategories() {
        return bookSubCategoryRepository.findAll();
    }

    public BookSubCategory getBookSubCategoryById(Integer id) {
        return bookSubCategoryRepository.findById(id).get();
    }

    public BookSubCategory addBookSubCategory(BookSubCategory bookSubCategory) {
        return bookSubCategoryRepository.save(bookSubCategory);
    }
    
    public BookSubCategory updateBookSubCategory(int id, BookSubCategory bookSubCategory) {
    	bookSubCategory.getId();
    	return bookSubCategoryRepository.save(bookSubCategory);
    }

    public void deleteBookSubCategory(Integer id) {
    	bookSubCategoryRepository.deleteById(id);
    }
}
