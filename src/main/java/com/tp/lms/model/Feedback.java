package com.tp.lms.model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="feeedback")
public class Feedback extends AuditColumn {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private Integer student_id;
	
	private String feedback;
	
	private AuditColumn auditcolumn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public AuditColumn getAuditcolumn() {
		return auditcolumn;
	}

	public void setAuditcolumn(AuditColumn auditcolumn) {
		this.auditcolumn = auditcolumn;
	}
	
	
	

}
