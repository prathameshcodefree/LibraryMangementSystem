package com.tp.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "bookfine")
public class BookFine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_fine_id")
	private Integer bookFineId;

	@Column(name = "book_issue_id")
	private Integer bookIssueId;

	@Column(name = "student_id")
	private Integer studentId;

	@Column(name = "book_id")
	private Integer bookId;

	@Column(name = "delay_by_days")
	private Integer delayByDays;

	@Column(name = "per_day_fine")
	private Integer perDayFine;

	@Column(name = "fine_amount")
	private float fineAmount;

	public Integer getBookFineId() {
		return bookFineId;
	}

	public void setBookFineId(Integer bookFineId) {
		this.bookFineId = bookFineId;
	}

	public Integer getBookIssueId() {
		return bookIssueId;
	}

	public void setBookIssueId(Integer bookIssueId) {
		this.bookIssueId = bookIssueId;
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

	public Integer getDelayByDays() {
		return delayByDays;
	}

	public void setDelayByDays(Integer delayByDays) {
		this.delayByDays = delayByDays;
	}

	public Integer getPerDayFine() {
		return perDayFine;
	}

	public void setPerDayFine(Integer perDayFine) {
		this.perDayFine = perDayFine;
	}

	public float getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(float fineAmount) {
		this.fineAmount = fineAmount;
	}
	
	
	

}
