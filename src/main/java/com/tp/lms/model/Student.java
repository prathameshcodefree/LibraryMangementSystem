package com.tp.lms.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tp.lms.model.enums.Gender;
import com.tp.lms.model.enums.Standard;
import com.tp.lms.model.enums.Stream;
import com.tp.lms.model.enums.StudentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends AuditColumn {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Integer id;

	@Column(name = "username", unique = true)
	private String userName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_address", unique = true)
	private String email;

	@Column(name = "contact_number")
	private String contactNumber;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender_status")
	private Gender gender;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "college_name")
	private String collegeName;

	@Column(name = "roll_no")
	private Integer rollNo;

	@Column(name = "password")
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "std")
	private Standard standard;

	@Enumerated(EnumType.STRING)
	@Column(name = "stream")
	private Stream stream;

	@Enumerated(EnumType.STRING)
	@Column(name = "student_status")
	private StudentStatus studentstatus;

	@JsonIgnore
	@OneToMany(mappedBy = "student")
	//@JoinColumn(name = "book_issue_id")
	private List<BookIssue> bookIssue;

	@JsonIgnore
	@OneToMany(mappedBy = "student")
	//@JoinColumn(name = "book_fine_id")
	private List<BookFine> bookFine;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public StudentStatus getStudentstatus() {
		return studentstatus;
	}

	public void setStudentstatus(StudentStatus studentstatus) {
		this.studentstatus = studentstatus;
	}

	public List<BookIssue> getBookIssue() {
		return bookIssue;
	}

	public void setBookIssue(List<BookIssue> bookIssue) {
		this.bookIssue = bookIssue;
	}

	public List<BookFine> getBookFine() {
		return bookFine;
	}

	public void setBookFine(List<BookFine> bookFine) {
		this.bookFine = bookFine;
	}	
	

}
