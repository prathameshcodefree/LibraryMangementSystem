package com.tp.lms.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tp.lms.model.enums.Status;

import jakarta.persistence.*;

@Entity
@Table(name = "book_issue")
public class BookIssue extends AuditColumn {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_issue_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;

	@JsonIgnore
	@OneToMany(mappedBy = "bookIssue")
	// @JoinColumn(name = "book_fine_id")
	private List<BookFine> bookFine;

	@Column(name = "title")
	private String title;

	@Column(name = "issue_date")
	private Date issueDate;

	@Column(name = "return_date")
	private Date returnDate;

	@Column(name = "expected_return_date")
	private Date expectedReturnDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@Column(name = "is_delayed")
	private boolean delayed;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<BookFine> getBookFine() {
		return bookFine;
	}

	public void setBookFine(List<BookFine> bookFine) {
		this.bookFine = bookFine;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getExpectedReturnDate() {
		return expectedReturnDate;
	}

	public void setExpectedReturnDate(Date expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean isDelayed() {
		return delayed;
	}

	public void setDelayed(boolean delayed) {
		this.delayed = delayed;
	}

}
