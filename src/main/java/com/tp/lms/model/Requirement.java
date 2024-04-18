package com.tp.lms.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tp.lms.model.enums.RequirementStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "requirement")
public class Requirement extends AuditColumn {

	@Id
	@Column(name = "requirement_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonIgnore
	@OneToMany(mappedBy = "requirement")
	private List<BookMaster> bookMaster;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "price")
	private float price;

	@Column(name = "expected_fulfilment_date")
	private Date expectedFulfilmentDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "requirement_status", nullable = false)
	private RequirementStatus requirementStatus;

	@Column(name = "requirement_reason")
	private String requirementReason;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<BookMaster> getBookMaster() {
		return bookMaster;
	}

	public void setBookMaster(List<BookMaster> bookMaster) {
		this.bookMaster = bookMaster;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getExpectedFulfilmentDate() {
		return expectedFulfilmentDate;
	}

	public void setExpectedFulfilmentDate(Date expectedFulfilmentDate) {
		this.expectedFulfilmentDate = expectedFulfilmentDate;
	}

	public RequirementStatus getRequirementStatus() {
		return requirementStatus;
	}

	public void setRequirementStatus(RequirementStatus requirementStatus) {
		this.requirementStatus = requirementStatus;
	}

	public String getRequirementReason() {
		return requirementReason;
	}

	public void setRequirementReason(String requirementReason) {
		this.requirementReason = requirementReason;
	}

}
