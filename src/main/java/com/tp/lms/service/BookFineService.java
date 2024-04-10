package com.tp.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tp.lms.model.BookFine;
import com.tp.lms.model.Student;
import com.tp.lms.repository.BookFineRepository;

@Service
public class BookFineService {

	@Autowired
	BookFineRepository bookfineRepository;

	public List<BookFine> getBookFine() {

		return bookfineRepository.findAll();

	}

	public Optional<BookFine> getBookFineById(Integer id) {
		return bookfineRepository.findById(id);

	}

	public List<String> validate(BookFine bookFine) {

		List<String> error = new ArrayList<>();

		if (bookFine.getId() == null) {
			error.add("Id can not be empty");
		}

		if (bookFine.getBookId() == null) {
			error.add(" BookId can not be empty");
		}

		if (bookFine.getBookIssueId() == null) {
			error.add("BookIssueId can not be empty");
		}
		if (bookFine.getFineAmount() != 0.0f) {
			error.add("FineAmount can not be empty");
		}
		if (bookFine.getStudentId() == null) {
			error.add("StudentId can not be empty");
		}

		if (bookFine.getDelayByDays() == null) {
			error.add("Student status can not be empty");
		}

		if (bookFine.getPerDayFine() == null) {
			error.add("College name can not be empty");
		}

		return error;
	}

	public BookFine addBookFine(BookFine bookfine) {

		return bookfineRepository.save(bookfine);

	}

	public BookFine updateBookFine(Integer id, @RequestBody BookFine bookfine) {
		BookFine existingBookFine = bookfineRepository.findById(id).orElse(null);
		existingBookFine.setId(bookfine.getId());
		existingBookFine.setBookFineId(bookfine.getBookId());
		existingBookFine.setBookIssueId(bookfine.getBookIssueId());
		existingBookFine.setDelayByDays(bookfine.getDelayByDays());
		existingBookFine.setDelayByDays(bookfine.getPerDayFine());
		existingBookFine.setStudentId(bookfine.getStudentId());
		return bookfineRepository.save(existingBookFine);
	}

	public boolean deleteStudent(Integer id) {

		boolean exists = bookfineRepository.existsById(id);
		if (exists) {
			bookfineRepository.deleteById(id);
			return true;
		} else {

			return false;
		}

	}

}
