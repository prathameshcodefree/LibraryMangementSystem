package com.tp.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tp.lms.model.BookFine;

import com.tp.lms.repository.BookFineRepository;


@Service
public class BookFineService {

	@Autowired
	BookFineRepository bookfinerepository;

	public List<BookFine> getBookFine() {

		return bookfinerepository.findAll();

	}

	public BookFine getBookFine(int bookFineId) {
		return bookfinerepository.findById(bookFineId).get();

	}

	public BookFine addBookFine(BookFine bookfine) {

		return bookfinerepository.save(bookfine);

	}

	public BookFine updateBookFine(int bookFineId, @RequestBody BookFine bookfine) {

		bookfine.setStudentId(bookFineId);
		return bookfinerepository.save(bookfine);

	}

	public void deleteBookFine(int bookFineId) {

		bookfinerepository.deleteById(bookFineId);

	}

}
