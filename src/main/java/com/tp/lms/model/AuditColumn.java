package com.tp.lms.model;

import java.util.Date;
import com.tp.lms.model.enums.UserType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

<<<<<<< HEAD
=======

<<<<<<< HEAD
=======

@Table(name = "auditcolumn")
>>>>>>> 5ed82dddbfa0ee2173b323dc68bbbd113d92c094
>>>>>>> de49d812334ea83479284ccda14687c34a0263a4
public class AuditColumn {

	@Enumerated(EnumType.STRING)
	@Column(name = "updated_by_type")
	private UserType updatedByType;

	@Column(name = "updated_by")
	private String updatedBy;

	
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "created_by_type")
	private UserType createdByType;

	
	@Column(name = "created_by")
	private String createdBy;

	
	@Column(name = "created_at")
	private Date createdAt;

	public UserType getUpdatedByType() {
		return updatedByType;
	}

	public void setUpdatedByType(UserType updatedByType) {
		this.updatedByType = updatedByType;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public UserType getCreatedByType() {
		return createdByType;
	}

	public void setCreatedByType(UserType createdByType) {
		this.createdByType = createdByType;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
