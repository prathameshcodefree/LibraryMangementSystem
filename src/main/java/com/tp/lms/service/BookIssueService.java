package com.tp.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tp.lms.model.BookIssue;
import com.tp.lms.repository.BookIssueRepository;

@Service
public class BookIssueService {

	@Autowired
	BookIssueRepository bookIssueRepository;

	public List<BookIssue> getBookIssue() {

		return bookIssueRepository.findAll();

	}

	public List<String> validate(BookIssue bookIssue) {

		List<String> error = new ArrayList<>();

		if (bookIssue.getId() == null) {
			error.add("Id can not be empty");
		}

		if (bookIssue.getBookId() == null) {
			error.add("Book Id can not be empty");
		}

		if (bookIssue.getStudentId() == null) {
			error.add("StudentId can not be empty");
		}
		if (bookIssue.getIssueDate() == null) {
			error.add("IssueDate can not be empty");
		}
		if (bookIssue.getReturnDate() == null) {
			error.add("Return date can not be empty");
		}

		if (bookIssue.getExpectedReturnDate() == null) {
			error.add("Expected Return date can not be empty");
		}

		if (bookIssue.getStatus() == null) {
			error.add("Status can not be empty");
		}

		if (!bookIssue.isDelayed()) {
			error.add("Delayed cannot be empty");
		}

		return error;
	}

	public Optional<BookIssue> getBookIssueById(Integer id) {
		return bookIssueRepository.findById(id);

	}

	public BookIssue addBookIssue(BookIssue bookissue) {

		return bookIssueRepository.save(bookissue);

	}

	public BookIssue updateBookIssue(Integer id, @RequestBody BookIssue bookissue) {

		BookIssue bookIssue = bookIssueRepository.findById(id).get();

		bookIssue.setIssueDate(bookissue.getIssueDate());
		bookIssue.setReturnDate(bookissue.getReturnDate());
		bookIssue.setExpectedReturnDate(bookissue.getExpectedReturnDate());
		bookIssue.setStatus(bookissue.getStatus());
		bookIssue.setDelayed(bookissue.isDelayed());

		return bookIssueRepository.save(bookIssue);

	}

	public boolean deleteBookIssue(Integer id) {

		boolean exists = bookIssueRepository.existsById(id);
		if (exists) {
			bookIssueRepository.deleteById(id);
			return true;
		} else {

			return false;
		}

	}

}
