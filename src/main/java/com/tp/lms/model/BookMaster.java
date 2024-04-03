package com.tp.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	private Integer id;
	
	
	@Column(name = "book_category_id")
	private Integer bookCategoryId;

	@Column(name = "book_subcategory_id")
	private Integer bookSubCategoryId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book_category_id",nullable=false)
	private BookCategory bookCategory;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book_subcategory_id",nullable=false)
	private BookSubCategory bookSubCategory;
	
	@Column(name = "title", length = 128)
	private String title;
	
	@Column(name = "author", length = 128)
	private String author;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "publish_by", length = 128)
	private String publishBy;
	
	@JoinColumn(name = "rack_id")
	private Integer rackId;
	


	@ManyToOne
    @JoinColumn(name = "requirement_id")
    private Requirement requirement;
	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}


	public int getId() {

		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBookCategoryId() {
		return bookCategoryId;
	}

	public void setBookCategoryId(Integer bookCategoryId) {
		this.bookCategoryId = bookCategoryId;
	}

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

	public BookSubCategory getBookSubCategory() {
		return bookSubCategory;
	}

	public void setBookSubCategory(BookSubCategory bookSubCategory) {
		this.bookSubCategory = bookSubCategory;
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

	public void setRackId(Integer rackId) {
		this.rackId = rackId;
	}

	

	

	
	
}
