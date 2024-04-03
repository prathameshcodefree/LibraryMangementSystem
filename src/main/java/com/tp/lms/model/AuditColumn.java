package com.tp.lms.model;

import java.util.Date;

import com.tp.lms.model.enums.UserType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Table(name = "auditcolumn")
public class AuditColumn {

	@Enumerated(EnumType.STRING)
	@Column(name = "updated_by_type", length = 128)
	private UserType updatedByType;

	@ManyToOne
	@JoinColumn(name = "updated_by", referencedColumnName = "updated_by")
	private String updatedBy;

	@Column(name = "updated_at", length = 128)
	private Date updatedAt;

	@Column(name = "created_by_type", length = 128)
	private UserType createdByType;

	@ManyToOne
	@JoinColumn(name = "created_by", referencedColumnName = "created_by")
	private String createdBy;

	@Column(name = "created_at", length = 128)
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
