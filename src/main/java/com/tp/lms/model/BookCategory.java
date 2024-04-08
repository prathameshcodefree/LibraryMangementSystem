package com.tp.lms.model;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_category")
public class BookCategory extends AuditColumn {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_category_id")
	private Integer id;
	
	@Column(name = "book_category_name", length = 128)
	private String bookCategoryName;
	

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

}


    

