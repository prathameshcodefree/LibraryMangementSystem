package com.tp.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_fine")

public class BookFine extends AuditColumn {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_fine_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "book_issue_id")
	private BookIssue bookIssue;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;

	@Column(name = "delay_by_days")
	private Integer delayByDays;

	@Column(name = "per_day_fine")
	private Integer perDayFine;

	@Column(name = "fine_amount")
	private float fineAmount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BookIssue getBookIssue() {
		return bookIssue;
	}

	public void setBookIssue(BookIssue bookIssue) {
		this.bookIssue = bookIssue;
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