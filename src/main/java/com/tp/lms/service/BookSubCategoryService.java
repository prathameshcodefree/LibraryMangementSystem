package com.tp.lms.service;


import com.tp.lms.model.BookCategory;
import com.tp.lms.model.BookSubCategory;
import com.tp.lms.repository.BookSubCategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookSubCategoryService {

	@Autowired
    BookSubCategoryRepository bookSubCategoryRepository;

    
    public BookSubCategoryService(BookSubCategoryRepository bookSubCategoryRepository) {
        this.bookSubCategoryRepository = bookSubCategoryRepository;
    }
    
    
    public List<String> validate(BookSubCategory bookSubCategory){
    	List<String> error = new ArrayList<>();
    	
    	if (bookSubCategory.getBookSubCategoryName()== null) {
			error.add("Book Sub Category Name can not be empty");
		}
    	
    	if(bookSubCategory.getId() == null) {
    		error.add("Book Sub Category Id can not be empty");
    	}
    
    	return error;	
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
