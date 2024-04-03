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
	private Integer bookSubCategoryId;
	
	@Column(name = "book_sub_category_name", length = 128)
	private String bookSubCategoryName;
	
	@Column(name = "audit_columns", length = 128)
	private String auditColumns;

	public Integer getBookSubCategoryId() {
		return bookSubCategoryId;
	}

	public void setBookSubCategoryId(Integer bookSubCategoryId) {
		this.bookSubCategoryId = bookSubCategoryId;
	}

	public String getBookSubCategoryName() {
		return bookSubCategoryName;
	}

	public void setBookSubCategoryName(String bookSubCategoryName) {
		this.bookSubCategoryName = bookSubCategoryName;
	}

	public String getAuditColumns() {
		return auditColumns;
	}

	public void setAuditColumns(String auditColumns) {
		this.auditColumns = auditColumns;
	}
	
	

	

}
