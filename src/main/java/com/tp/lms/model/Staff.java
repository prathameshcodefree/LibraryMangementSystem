package com.tp.lms.model;

import java.util.List;


import com.tp.lms.model.enums.StaffStatus;
import com.tp.lms.model.enums.StaffType;
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
@Table(name = "staff")
public class Staff extends AuditColumn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_id")
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = "staff_type",length = 128)
	private StaffType staffType;
	
	@Column(name = "user_name", length = 128)
	private String userName;

	@Column(name = "first_name", length = 128,unique=true)
	private String firstName;

	@Column(name = "middle_name", length = 128,unique=true)
	private String middleName;
	
	@Column(name = "user_name", unique=true)
	private String userName;

	@Column(name = "last_name", length = 128)
	private String lastName;


	@Column(name = "email", length = 64, nullable=false,unique=true)
	private String email;

	@Column(name = "contact_number", length = 10,unique=true)
	private int contactNumber;

	

	

	@Column(name = "gender")
	private String gender;

	@Column(name = "dob")
	private String dob;

	@Column(name = "password")
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "staff_status", length = 128)
	private StaffStatus staffStatus;

	@Column(name = "aadhar_number",unique=true)
	private Integer  aadhaarNumber;

	@Column(name = "pan_number", length = 10,unique=true)
	private String  panNumber;
	
	@OneToMany(mappedBy="staff")
	private List<StaffAttendance> staffattendance;


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


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
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
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<StaffAttendance> getStaffattendance() {
		return staffattendance;
	}

	public void setStaffattendance(List<StaffAttendance> staffattendance) {
		this.staffattendance = staffattendance;
	}

	public void setId(Integer id) {
		this.id = id;
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


	public StaffStatus getStaffStatus() {
		return staffStatus;
	}


	public void setStaffStatus(StaffStatus staffStatus) {
		this.staffStatus = staffStatus;
	}


	public Integer getAadhaarNumber() {
		return aadhaarNumber;
	}


	public void setAadhaarNumber(Integer aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}


	public String getPanNumber() {
		return panNumber;
	}


	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}


	public List<StaffAttendance> getStaffattendance() {
		return staffattendance;
	}


	public void setStaffattendance(List<StaffAttendance> staffattendance) {
		this.staffattendance = staffattendance;
	}
	
	
	
	
}