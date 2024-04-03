package com.tp.lms.model;

import java.util.Date;
import com.tp.lms.model.enums.UserType;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class AuditColumn {

	@Enumerated(EnumType.STRING)
	@Column(name = "updated_by_type")
	private UserType updatedByType;

	@Column(name = "updated_by")
	private Integer updatedBy;

	
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "created_by_type")
	private UserType createdByType;

	
	@Column(name = "created_by")
	private Integer createdBy;

	
	@Column(name = "created_at")
	private Date createdAt;

	public UserType getUpdatedByType() {
		return updatedByType;
	}

	public void setUpdatedByType(UserType updatedByType) {
		this.updatedByType = updatedByType;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
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

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
