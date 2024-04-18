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
@Table(name = "book_sub_category")
public class BookSubCategory extends AuditColumn {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_sub_category_id")
	private Integer id;

	@Column(name = "book_sub_category_name")
	private String bookSubCategoryName;

	
	@JsonIgnore
	@OneToMany(mappedBy = "bookSubCategory")
	private List<BookMaster> bookMaster;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookSubCategoryName() {
		return bookSubCategoryName;
	}

	public void setBookSubCategoryName(String bookSubCategoryName) {
		this.bookSubCategoryName = bookSubCategoryName;
	}

	public List<BookMaster> getBookMaster() {
		return bookMaster;
	}

	public void setBookMaster(List<BookMaster> bookMaster) {
		this.bookMaster = bookMaster;
	}

}