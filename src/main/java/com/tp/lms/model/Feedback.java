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
	

	@Column(name="student_id")
	private Integer studentid;
	
	@Column(name="feedback")
	private String feedback;
	
//	@ManyToOne(fetch=FetchType.LAZY)
	@Column(name = "Student_id")
	private Student studentId;

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


	public Integer getStudentid() {
		return studentid;
	}

	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}

	

	public Feedback(Integer id, Integer student_id, String feedback, AuditColumn auditcolumn) {
		super();
		this.id = id;
		this.studentid = student_id;
		this.feedback = feedback;
		
	}

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	

}
