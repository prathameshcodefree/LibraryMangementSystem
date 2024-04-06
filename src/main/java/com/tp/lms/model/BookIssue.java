package com.tp.lms.model;

import java.util.Date;

import com.tp.lms.model.enums.Status;

import jakarta.persistence.*;


@Entity
@Table(name = "book_issue")
public class BookIssue extends AuditColumn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_issue_id")
	private Integer id;

	
	@Column(name = "student_id")	
	private Integer studentId;

	@Column(name = "book_id")	
	private Integer bookId;

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
	private boolean isDelayed;

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
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
