package com.tp.lms.model;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookcategory")
public class BookCategory extends AuditColumn {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_category_id")
    private int bookCategoryId;

    @Column(name = "book_category_name")
    private String bookCategoryName;

	public int getBookCategoryId() {
		return bookCategoryId;
	}

	public String getBookCategoryName() {
		return bookCategoryName;
	}

	public void setBookCategoryId(int bookCategoryId) {
		this.bookCategoryId = bookCategoryId;
	}

	public void setBookCategoryName(String bookCategoryName) {
		this.bookCategoryName = bookCategoryName;
	}
	

	

}


    

