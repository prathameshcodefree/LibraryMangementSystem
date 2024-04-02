package com.tp.lms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Feedback extends AuditColumns {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedback_id;
	private int student_id;
	private String feedback;
	
	private AuditColumns auditcolumn;
	
	
	

}
