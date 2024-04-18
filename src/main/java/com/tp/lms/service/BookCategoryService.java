package com.tp.lms.service;

import com.tp.lms.model.BookCategory;
import com.tp.lms.repository.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookCategoryService {

	@Autowired
	BookCategoryRepository bookCategoryRepository;

	public BookCategoryService(BookCategoryRepository bookCategoryRepository) {
		this.bookCategoryRepository = bookCategoryRepository;
	}

	public List<String> validate(BookCategory bookCategory) {
		List<String> error = new ArrayList<>();

		if (bookCategory.getBookCategoryName() == null) {
			error.add("Book Category Name can not be empty");
		}

		return error;

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

	public BookCategory updateBookCategory(Integer id, BookCategory bookCategory) {
		BookCategory existingBookCategory = bookCategoryRepository.findById(id).orElse(null);
		existingBookCategory.setBookCategoryName(bookCategory.getBookCategoryName());
		return bookCategoryRepository.save(existingBookCategory);
	}

	public void deleteBookCategory(Integer id) {
		bookCategoryRepository.deleteById(id);
	}
}
