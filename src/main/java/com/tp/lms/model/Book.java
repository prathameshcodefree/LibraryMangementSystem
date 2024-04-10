package com.tp.lms.model;

import com.tp.lms.model.enums.BookStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "book")
public class Book  extends AuditColumn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Integer id;
	

	@ManyToOne
	@JoinColumn(name = "book_master_id")
	private BookMaster bookMaster;

	@Column(name = "isbn_code", length = 20)
	private Integer isbnCode;
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book_category_id",nullable=false)
	private BookCategory bookCategory;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book_subcategory_id",nullable=false)
	private BookSubCategory bookSubCategory;
	

	@Enumerated(EnumType.STRING)
	@Column(name = "book_status")
	private BookStatus bookStatus;

	@Column(name = "remark", length = 30)
	private String bookRemark;

	public Integer getId() {
		return id;
	}

	public BookMaster getBookMaster() {
		return bookMaster;
	}

	public Integer getIsbnCode() {
		return isbnCode;
	}

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public BookSubCategory getBookSubCategory() {
		return bookSubCategory;
	}

	public BookStatus getBookStatus() {
		return bookStatus;
	}

	public String getBookRemark() {
		return bookRemark;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBookMaster(BookMaster bookMaster) {
		this.bookMaster = bookMaster;
	}

	public void setIsbnCode(Integer isbnCode) {
		this.isbnCode = isbnCode;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

	public void setBookSubCategory(BookSubCategory bookSubCategory) {
		this.bookSubCategory = bookSubCategory;
	}

	public void setBookStatus(BookStatus bookStatus) {
		this.bookStatus = bookStatus;
	}

	public void setBookRemark(String bookRemark) {
		this.bookRemark = bookRemark;
	}

	
}
