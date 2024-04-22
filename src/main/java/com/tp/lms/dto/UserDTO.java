package com.tp.lms.dto;

import java.util.Date;


import com.tp.lms.model.enums.Gender;
import com.tp.lms.model.enums.StudentStatus;


public class UserDTO {

	private Integer id;
	
	private String userName;

	private String firstName;

	private String middleName;

	private String lastName;

	private String email;

	private String contactNumber;

	private Gender gender;

	private Date date;

	private String collegeName;

	private Integer rollNo;

	private StudentStatus studentstatus;	
	
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

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

	public void setRollNo(Integer rollNo)
	
	{
		this.rollNo = rollNo;
	}
	
	public StudentStatus getStudentstatus() 
	{
		return studentstatus;
		
	}

	public void setStudentstatus(StudentStatus studentstatus) {
		this.studentstatus = studentstatus;
	
	}
	
}
