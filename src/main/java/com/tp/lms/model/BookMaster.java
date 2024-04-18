package com.tp.lms.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_master")
public class BookMaster extends AuditColumn {
	
	private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_master_id")
	private Integer id;
	
	
	@ManyToOne
    @JoinColumn(name = "book_category_id")
    private BookCategory bookCategory;

    @ManyToOne
    @JoinColumn(name = "book_subcategory_id")
    private BookSubCategory bookSubCategory;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private Float price;

    @Column(name = "publish_by")
    private String publishBy;

    @ManyToOne
    @JoinColumn(name = "rack_id")
    private Rack rack;

    
    @JsonIgnore
    @OneToMany(mappedBy = "bookMaster")
    private List<Book> book;
	
	@ManyToOne
    @JoinColumn(name = "requirement_id")
    private Requirement requirement;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getPublishBy() {
		return publishBy;
	}

	public void setPublishBy(String publishBy) {
		this.publishBy = publishBy;
	}

	public Rack getRack() {
		return rack;
	}

	public void setRack(Rack rack) {
		this.rack = rack;
	}

	

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}
	
	
}