package com.tp.lms.service;

import java.util.ArrayList;
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
    
    public List<String> validate(Book book){
    	List<String> error = new ArrayList<>();
    	
    	
    	if(book.getId() == null) {
    		error.add("Book Id can not be empty");
    	}
    	
    	if (book.getBookRemark()== null) {
			error.add("Book Remark can not be empty");
		}
    	
    	if(book.getBookStatus() == null) {
    		error.add("Book Status can not be empty");
    	}
    	
    	if(book.)
    	
    	
    	if(book.getIsbnCode() == null) {
    		error.add("Book ISBN Code can not be empty");
    	}
    	
    	
    	return error;
    	
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
