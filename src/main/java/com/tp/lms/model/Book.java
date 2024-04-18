package com.tp.lms.model;


import com.tp.lms.model.enums.BookStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "book")
public class Book  extends AuditColumn {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;

    @Column(name = "isbn_code")
    private String isbnCode;

   
    @ManyToOne
    @JoinColumn(name = "book_master_id")
    private BookMaster bookMaster;

	@Enumerated(EnumType.STRING)
	@Column(name = "book_status")
	private BookStatus bookStatus;

	@Column(name = "remark")
	private String bookRemark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbnCode() {
		return isbnCode;
	}

	public void setIsbnCode(String isbnCode) {
		this.isbnCode = isbnCode;
	}

	public BookMaster getBookMaster() {
		return bookMaster;
	}

	public void setBookMaster(BookMaster bookMaster) {
		this.bookMaster = bookMaster;
	}

	public BookStatus getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(BookStatus bookStatus) {
		this.bookStatus = bookStatus;
	}

	public String getBookRemark() {
		return bookRemark;
	}

	public void setBookRemark(String bookRemark) {
		this.bookRemark = bookRemark;
	}
		
}
