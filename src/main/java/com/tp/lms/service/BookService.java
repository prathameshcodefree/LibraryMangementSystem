package com.tp.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	public List<String> validate(Book book) {
		List<String> error = new ArrayList<>();

		if (book.getBookRemark() == null) {
			error.add("Book Remark can not be empty");
		}

		if (book.getBookStatus() == null) {
			error.add("Book Status can not be empty");
		}

		if (book.getIsbnCode() == null) {
			error.add("Book ISBN Code can not be empty");
		}

		return error;

	}

	public List<Book> getBook() {
		return bookRepository.findAll();
	}

	public Optional<Book> getBookById(Integer id) {
		return bookRepository.findById(id);
	}

	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	public Book updateBook(Integer id, Book book) {
		Book existingBook = bookRepository.findById(id).orElse(null);
		existingBook.setIsbnCode(book.getIsbnCode());
		existingBook.setBookStatus(book.getBookStatus());
		existingBook.setBookRemark(book.getBookRemark());
		return bookRepository.save(book);
	}

	public boolean deleteBook(Integer id) {

		boolean exists = bookRepository.existsById(id);
		if (exists) {
			bookRepository.deleteById(id);
			return true;
		} else {

			return false;
		}

	}

}
