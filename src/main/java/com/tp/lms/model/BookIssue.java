package com.tp.lms.model;

import java.util.Date;

import jakarta.persistence.*;

enum Status {
	ISSUED, RETURNED
}


@Entity
@Table(name = "bookissue",uniqueConstraints = {@UniqueConstraint(columnNames = {"student_id","book_id"})})
public class BookIssue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Integer bookIssueId;

	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "student_id")	
	private int studentId;

	@OneToOne
	@JoinColumn(name = "book_id", referencedColumnName = "book_id")	
	private int bookId;

	@Column(name = "issue_date",length = 30)
	private Date issueDate;

	@Column(name = "return_date",length = 30)
	private Date returnDate;

	@Column(name = "expected_return_date",length = 30)
	private Date expectedReturnDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@Column(name = "is_delayed")
	private boolean isDelayed;

	public int getBookIssueId() {
		return bookIssueId;
	}

	public void setBookIssueId(int bookIssueId) {
		this.bookIssueId = bookIssueId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
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
		return isDelayed;
	}

	public void setDelayed(boolean isDelayed) {
		this.isDelayed = isDelayed;
	}

	
	
	
}
