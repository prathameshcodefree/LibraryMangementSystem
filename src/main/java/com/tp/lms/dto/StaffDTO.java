package com.tp.lms.dto;

import com.tp.lms.model.enums.StaffType;

public class StaffDTO {
    private Integer id;
    private StaffType staffType; // Enum to specify the staff type (INVENTORY or LIBRARIAN)
    private String firstName;
    private String middleName;
    private String lastName;
    private String userName;
    private String email;
    private int contactNumber;
    private String gender;
    private String dob;
    private String password;
    private String panNumber;
    private Integer aadhaarNumber;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public StaffType getStaffType() {
		return staffType;
	}
	public void setStaffType(StaffType staffType) {
		this.staffType = staffType;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public Integer getAadhaarNumber() {
		return aadhaarNumber;
	}
	public void setAadhaarNumber(Integer aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}
	public StaffDTO(Integer id, StaffType staffType, String firstName, String middleName, String lastName,
			String userName, String email, int contactNumber, String gender, String dob, String password,
			String panNumber, Integer aadhaarNumber) {
		super();
		this.id = id;
		this.staffType = staffType;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.gender = gender;
		this.dob = dob;
		this.password = password;
		this.panNumber = panNumber;
		this.aadhaarNumber = aadhaarNumber;
	}
	public StaffDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


    
}
