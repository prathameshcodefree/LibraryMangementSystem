package com.tp.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rack")
public class Rack {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rack_id")
	private Integer rackId;

	@Column(name = "rack_code", length = 8)
	private String rackCode;

	public Integer getRackId() {
		return rackId;
	}

	public void setRackId(Integer rackId) {
		this.rackId = rackId;
	}

	public String getRackCode() {
		return rackCode;
	}

	public void setRackCode(String rackCode) {
		this.rackCode = rackCode;
	}
	
	
}
