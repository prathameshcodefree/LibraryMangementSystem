package com.tp.lms.model;

import java.util.Date;

import com.tp.lms.model.enums.Gender;
import com.tp.lms.model.enums.StudentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends AuditColumn {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Integer id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name", length = 50)
	private String middleName;

	@Column(name = "last_name", length = 50)
	private String lastName;

	@Column(name = "email_address", length = 64, nullable = false)
	private String email;

	@Column(name="contact_number")
	private String contactNumber;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender_status")
	private Gender gender;

	@Column(name = "date")
	private Date date;

	@Column(name = "college_name", length = 50)
	private String collegeName;

	@Column(name = "roll_no")
	private Integer rollNo;

	@Column(name = "password")
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "student_status")
	private StudentStatus studentstatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
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

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
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

	public Student(Integer id, String firstName, String middleName, String lastName, String email, String contactNumber,
			Gender gender, Date date, String collegeName, Integer rollNo, String password,
			StudentStatus studentstatus) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.gender = gender;
		this.date = date;
		this.collegeName = collegeName;
		this.rollNo = rollNo;
		this.password = password;
		this.studentstatus = studentstatus;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	

}
