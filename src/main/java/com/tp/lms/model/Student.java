package com.tp.lms.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student extends AuditColumns {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	@Column(name = "student_fname", length = 128)
	private String firstName;
	@Column(name = "student_mname", length = 128)
	private String middleName;
	@Column(name = "student_lname", length = 128)
	private String lastName;
	@Column(name = "email", length = 64, nullable = false)
	private String email;
	@Column(name = "contact_number" ,length=10)
	private String contactNumber;
	
	
	private Gender gender;
	@Column(name = "Date_of_birth")
	private Date dob;
	@Column(name = "School_college_name")
	private String schoolCollegeName;
	private Standard standard;
	private Stream stream;
	private int rollNumber;
	private String password; // Assuming password is a String for simplicity
	@Column(name = "password", length = 64, nullable = false)
	private StudentStatus studentStatus;
	@OneToOne(mappedBy = "student_id"  ,cascade = CascadeType.ALL)
	private AuditColumns auditColumns;
	@OneToMany(mappedBy = "student_id"  ,cascade = CascadeType.ALL)
	private Feedback feedback;

	// Getters and setters

	// Enum definitions
	public enum Gender {
		MALE, FEMALE, OTHER
	}

	public enum Standard {
		ELEVENTH, TWELFTH
		// Add more standards as needed
	}

	public enum Stream {
		SCIENCE, COMMERCE, ARTS
		// Add more streams as needed
	}

	public enum StudentStatus {
		ACTIVE, INACTIVE, PENDING
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSchoolCollegeName() {
		return schoolCollegeName;
	}

	public void setSchoolCollegeName(String schoolCollegeName) {
		this.schoolCollegeName = schoolCollegeName;
	}

	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public Stream getStream() {
		return stream;
	}

	public void setStream(Stream stream) {
		this.stream = stream;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public StudentStatus getStudentStatus() {
		return studentStatus;
	}

	public void setStudentStatus(StudentStatus studentStatus) {
		this.studentStatus = studentStatus;
	}

	public AuditColumns getAuditColumns() {
		return auditColumns;
	}

	public void setAuditColumns(AuditColumns auditColumns) {
		this.auditColumns = auditColumns;
	}
	 

}
