package com.tp.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name ="requirementbook")
public class RequirementBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "requirement_book_id")
	private Integer requirementBookId;

	

	@Column(name = "requirement_id")	
	private Integer requirementId;

	

	@Column(name = "book_id")
	private Integer bookId;

	public Integer getRequirementBookId() {
		return requirementBookId;
	}

	public void setRequirementBookId(Integer requirementBookId) {
		this.requirementBookId = requirementBookId;
	}

	public Integer getRequirementId() {
		return requirementId;
	}

	public void setRequirementId(Integer requirementId) {
		this.requirementId = requirementId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	
	

}
