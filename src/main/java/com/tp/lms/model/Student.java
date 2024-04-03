package com.tp.lms.model;

import java.util.Date;

import com.tp.lms.model.enums.Gender;
import com.tp.lms.model.enums.StudentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends AuditColumn {
	@Id
	@Column(name = "student_id")
	private int studentId;
	
	@Column(name = "first_name", length = 50)
	private String firstName;
	
	@Column(name = "middle_name", length = 50)
	private String middleName;
	
	@Column(name = "last_name", length = 50)
	private String lastName;
	
	@Column(name = "email_address", length = 64, nullable = false)
	private String email;
	
	 
	 private Integer contactNumber;
	 
	@Enumerated(EnumType.STRING)
	@Column(name = "gender_status")
	private Gender gender;
	@Column(name = "date")
	private Date date;
	@Column(name = "college_name", length = 50)
	private String collegeName;
	@Column(name = "roll_no")
	private int rollNo;
	@Column(name = "password", length = 50)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(name = "student_status")
	private StudentStatus studentstatus;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public StudentStatus getStudentstatus() {
		return studentstatus;
	}

	public void setStudentstatus(StudentStatus studentstatus) {
		this.studentstatus = studentstatus;
	}

}
