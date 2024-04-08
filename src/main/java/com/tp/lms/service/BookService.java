package com.tp.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.lms.model.Book;
import com.tp.lms.repository.BookRepository;


@Service
public class BookService {
	@Autowired
    private final BookRepository bookRepository;

    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    public List<Book> getBook(){
		return bookRepository.findAll();
    }
    
    public Book getById(int id) {
    	return bookRepository.findById(id).get();
    }
    
    public Book addBook(Book book) {
    	return bookRepository.save(book);
    }
    
    public Book updateById(int id, Book book) {
    	book.setId(id);
    	return bookRepository.save(book);
    }
    
    public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}
    
}
