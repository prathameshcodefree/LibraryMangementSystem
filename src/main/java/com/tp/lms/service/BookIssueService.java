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

		return error;
	}

	public Optional<BookIssue> getBookIssueById(Integer id) {
		return bookIssueRepository.findById(id);

	}

	public BookIssue addBookIssue(BookIssue bookissue) {

		return bookIssueRepository.save(bookissue);

	}

	public BookIssue updateBookIssue(Integer id, @RequestBody BookIssue bookissue) {

		BookIssue existingBookIssue = bookIssueRepository.findById(id).get();

		existingBookIssue.setIssueDate(bookissue.getIssueDate());
		existingBookIssue.setReturnDate(bookissue.getReturnDate());
		existingBookIssue.setExpectedReturnDate(bookissue.getExpectedReturnDate());
		existingBookIssue.setStatus(bookissue.getStatus());
		existingBookIssue.setDelayed(bookissue.isDelayed());

		return bookIssueRepository.save(existingBookIssue);

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