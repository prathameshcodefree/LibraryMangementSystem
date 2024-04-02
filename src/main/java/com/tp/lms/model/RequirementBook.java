package com.tp.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name ="requirementbook",uniqueConstraints = {@UniqueConstraint(columnNames = {"book_id"})})
public class RequirementBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "requirement_book_id")
	private Integer requirementBookId;

	
	@OneToOne
	@JoinColumn(name = "requirement_id", referencedColumnName = "requirement_id")	
	private Integer requirementId;

	
	@OneToOne
	@JoinColumn(name = "book_id", referencedColumnName = "book_id")
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
