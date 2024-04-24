package com.tp.lms.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Token {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String token;

	@ManyToOne()
	@JoinColumn(name = "student_id")
	private Student student;

	private LocalDateTime expiryTime;

	private boolean isValid;

	private LocalDateTime logoutTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public LocalDateTime getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(LocalDateTime expiryTime) {
		this.expiryTime = expiryTime;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public LocalDateTime getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(LocalDateTime logoutTime) {
		this.logoutTime = logoutTime;
	}

}
