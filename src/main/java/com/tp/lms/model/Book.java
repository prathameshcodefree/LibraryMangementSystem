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

<<<<<<< HEAD

=======
>>>>>>> f75e4debf1d972227d85603a09b7ca3b31602c1a

@Entity
@Table(name = "book")
public class Book  extends AuditColumn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Integer bookId;

	@ManyToOne
	@JoinColumn(name = "book_master_id", referencedColumnName = "book_master_id")	
	private int bookMasterId;

	@Column(name = "isbn_code", length = 20)
	private int isbnCode;

	@Enumerated(EnumType.STRING)
	@Column(name = "book_status")
	private BookStatus bookStatus;

	@Column(name = "remark", length = 30)
	private String bookRemark;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getBookMasterId() {
		return bookMasterId;
	}

	public void setBookMasterId(int bookMasterId) {
		this.bookMasterId = bookMasterId;
	}

	public int getIsbnCode() {
		return isbnCode;
	}

	public void setIsbnCode(int isbnCode) {
		this.isbnCode = isbnCode;
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
