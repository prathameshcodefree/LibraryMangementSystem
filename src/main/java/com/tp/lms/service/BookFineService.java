package com.tp.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tp.lms.model.BookFine;
import com.tp.lms.repository.BookFineRepository;

@Service
public class BookFineService {

	@Autowired
	BookFineRepository bookFineRepository;

	public List<BookFine> getBookFine() {

		return bookFineRepository.findAll();

	}

	public Optional<BookFine> getBookFineById(Integer id) {
		return bookFineRepository.findById(id);

	}

	public List<String> validate(BookFine bookFine) {

		List<String> error = new ArrayList<>();

		if (bookFine.getBook() == null) {
			error.add(" BookId can not be empty");
		}

		if (bookFine.getBookIssue() == null) {
			error.add("BookIssueId can not be empty");
		}

		if (Float.compare(bookFine.getFineAmount(), 0.0f) == 0) {
			error.add("FineAmount cannot be empty");
		}

		if (bookFine.getStudent() == null) {
			error.add("StudentId can not be empty");
		}

		if (bookFine.getDelayByDays() == null) {
			error.add("delay by days  can not be empty");
		}

		if (bookFine.getPerDayFine() == null) {
			error.add("Per day fine can not be empty");
		}

		return error;
	}

	public BookFine addBookFine(BookFine bookfine) {

		return bookFineRepository.save(bookfine);

	}

	public BookFine updateBookFine(Integer id, @RequestBody BookFine bookfine) {
		BookFine existingBookFine = bookFineRepository.findById(id).orElse(null);
		existingBookFine.setId(bookfine.getId());
		existingBookFine.setBookFineId(bookfine.getId());
		existingBookFine.setBook(bookfine.getBook());
		existingBookFine.setDelayByDays(bookfine.getDelayByDays());
		existingBookFine.setDelayByDays(bookfine.getPerDayFine());
		existingBookFine.setStudent(bookfine.getStudent());
		return bookFineRepository.save(existingBookFine);
	}


	public boolean deleteBookFine(Integer id) {

		boolean exists = bookFineRepository.existsById(id);
		if (exists) {
			bookFineRepository.deleteById(id);
			return true;
		} else {


			return false;
		}

	}

}