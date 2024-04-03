package com.tp.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tp.lms.model.BookIssue;
import com.tp.lms.repository.BookIssueRepository;


@Service
public class BookIssueService {

	@Autowired
	BookIssueRepository bookissuerepository;

	public List<BookIssue> getBookIssue() {

		return bookissuerepository.findAll();

	}

	public BookIssue getBookIssue(int bookIssueId) {
		return bookissuerepository.findById(bookIssueId).get();

	}

	public BookIssue addBookIssue(BookIssue bookissue) {

		return bookissuerepository.save(bookissue);

	}

	public BookIssue updateBookIssue(int bookIssueId, @RequestBody BookIssue bookissue) {

		bookissue.setStudentId(bookIssueId);
		return bookissuerepository.save(bookissue);

	}

	public void deleteBookIssue(int bookIssueId) {

		bookissuerepository.deleteById(bookIssueId);

	}

}
