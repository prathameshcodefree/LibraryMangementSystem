package com.tp.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
>>>>>>> 8fec34955021f88a1f541e895fea70a265cdce3f
>>>>>>> 5ed82dddbfa0ee2173b323dc68bbbd113d92c094
import jakarta.persistence.Table;

@Entity
@Table(name = "book_master")
public class BookMaster {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_master_id")
	private Integer bookMasterId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book_category_id",nullable=false)
	private int bookCategoryId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book_sub_category_id",nullable=false)
	@Column(name = "book_subcategory_id")
	private int bookSubCategoryId;
	
	@Column(name = "title", length = 128)
	private String title;
	
	@Column(name = "author", length = 128)
	private String author;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "publish_by", length = 128)
	private String publishBy;
	
	@OneToMany(fetch=FetchType.LAZY)
	@Column(name = "rack_id")
	private int rackId;
	
	@Column(name = "audit_columns", length = 128)
    private String auditColumns;

	@ManyToOne
    @JoinColumn(name = "requirement_id")
    private Requirement requirement;
	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

	public String getAuditColumns() {
		return auditColumns;
	}

	public void setAuditColumns(String auditColumns) {
		this.auditColumns = auditColumns;
	}

	public int getBookMasterId() {
		return bookMasterId;
	}

	public void setBookMasterId(int bookMasterId) {
		this.bookMasterId = bookMasterId;
	}

	public int getBookCategoryId() {
		return bookCategoryId;
	}

	public void setBookCategoryId(int bookCategoryId) {
		this.bookCategoryId = bookCategoryId;
	}

	public int getBookSubCategoryId() {
		return bookSubCategoryId;
	}

	public void setBookSubCategoryId(int bookSubCategoryId) {
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

	public int getRackId() {
		return rackId;
	}

	public void setRackId(int rackId) {
		this.rackId = rackId;
	}
	
	
	
	

	
	
}
