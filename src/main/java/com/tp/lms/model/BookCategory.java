package com.tp.lms.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_category")
public class BookCategory extends AuditColumn{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_category_id")
	private Integer id;

	@Column(name = "book_category_name")
	private String bookCategoryName;

	
	
	@JsonIgnore
	@OneToMany(mappedBy = "bookCategory")
	private List<BookMaster> bookMaster;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookCategoryName() {
		return bookCategoryName;
	}

	public void setBookCategoryName(String bookCategoryName) {
		this.bookCategoryName = bookCategoryName;
	}

	public List<BookMaster> getBookMaster() {
		return bookMaster;
	}

	public void setBookMaster(List<BookMaster> bookMaster) {
		this.bookMaster = bookMaster;
	}

}