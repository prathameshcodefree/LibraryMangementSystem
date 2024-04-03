package com.tp.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_sub_category")
public class BookSubCategory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_sub_category_id")
	private Integer id;
	
	@Column(name = "book_sub_category_name", length = 128)
	private String bookSubCategoryName;
	

	public Integer getId() {
		return id;
	}

	public void setBookSubCategoryId(Integer id) {
		this.id = id;
	}

	public String getBookSubCategoryName() {
		return bookSubCategoryName;
	}

	public void setBookSubCategoryName(String bookSubCategoryName) {
		this.bookSubCategoryName = bookSubCategoryName;
	}

	

	

}
