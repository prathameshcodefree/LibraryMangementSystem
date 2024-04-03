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
	private int feedback_id;
	
	@ManyToOne
	private int student_id;
	
	private String feedback;
	
	private AuditColumn auditcolumn;
	
	
	

}
