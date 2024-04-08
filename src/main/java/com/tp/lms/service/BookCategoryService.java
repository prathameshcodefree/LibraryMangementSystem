package com.tp.lms.service;




import com.tp.lms.model.BookCategory;
import com.tp.lms.repository.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryService {

	@Autowired
    BookCategoryRepository bookCategoryRepository;

    
    public BookCategoryService(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }

    public List<BookCategory> getAllBookCategories() {
        return bookCategoryRepository.findAll();
    }

    public BookCategory getBookCategoryById(Integer id) {
        return bookCategoryRepository.findById(id).get();
    }

    public BookCategory addBookCategory(BookCategory bookCategory) {
        return bookCategoryRepository.save(bookCategory);
    }
    
    public BookCategory updateBookCategory(int id, BookCategory bookCategory) {
    	bookCategory.setId(id);
    	return bookCategoryRepository.save(bookCategory);
    }

    public void deleteBookCategory(Integer id) {
        bookCategoryRepository.deleteById(id);
    }
}
