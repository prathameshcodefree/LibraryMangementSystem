package com.tp.lms.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	
//	@ManyToOne(fetch=FetchType.LAZY)
	@Column(name = "Student_id")
	private Student studentId;
	
	
	@Column(name = "feedback")
	private String feedback;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Student getStudentId() {
		return studentId;
	}


	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}


	public String getFeedback() {
		return feedback;
	}


	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	

}
