package com.tp.lms.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


enum UpdatedByType{
	ADMIN , 
	STAFF , 
	STUDENT
};


enum CreatedByType{
	ADMIN , 
	STAFF, 
	STUDENT
}



public class AuditColumns {
	
	@Enumerated(EnumType.STRING)
	@Column(name="updated_by_type")
	private UpdatedByType updatedByType;
	
	@ManyToOne
	@JoinColumn(name = "updated_by")
	private String updatedBy;
	
	@Column(name="updatedAt")
	private Date updatedAt;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Created_by_type")
	private CreatedByType createdByType;
	
	@ManyToOne
	@JoinColumn(name = "created_by")
	private String createdBy;
	
	@Column(name="created_at")
	private Date createdAt;

	public UpdatedByType getUpdatedByType() {
		return updatedByType;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public CreatedByType getCreatedByType() {
		return createdByType;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setUpdatedByType(UpdatedByType updatedByType) {
		this.updatedByType = updatedByType;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setCreatedByType(CreatedByType createdByType) {
		this.createdByType = createdByType;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
