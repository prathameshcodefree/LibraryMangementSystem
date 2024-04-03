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
@Table(name = "book_master")
public class BookMaster {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_master_id")
	private Integer bookMasterId;
	
	@Column(name = "book_category_id")
	private Integer bookCategoryId;
	
	@Column(name = "book_subcategory_id")
	private Integer bookSubCategoryId;
	
	@Column(name = "title", length = 128)
	private String title;
	
	@Column(name = "author", length = 128)
	private String author;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "publish_by", length = 128)
	private String publishBy;
	
	@Column(name = "rack_id")
	private Integer rackId;
	
	@Column(name = "audit_columns", length = 128)
    private String auditColumns;

	public String getAuditColumns() {
		return auditColumns;
	}

	public void setAuditColumns(String auditColumns) {
		this.auditColumns = auditColumns;
	}

	public Integer getBookMasterId() {
		return bookMasterId;
	}

	public void setBookMasterId(Integer bookMasterId) {
		this.bookMasterId = bookMasterId;
	}

	public Integer getBookCategoryId() {
		return bookCategoryId;
	}

	public void setBookCategoryId(int bookCategoryId) {
		this.bookCategoryId = bookCategoryId;
	}

	public Integer getBookSubCategoryId() {
		return bookSubCategoryId;
	}

	public void setBookSubCategoryId(Integer bookSubCategoryId) {
		this.bookSubCategoryId = bookSubCategoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPublishBy() {
		return publishBy;
	}

	public void setPublishBy(String publishBy) {
		this.publishBy = publishBy;
	}

	public Integer getRackId() {
		return rackId;
	}

	public void setRackId(int rackId) {
		this.rackId = rackId;
	}
	
	
	
	

	
	
}
