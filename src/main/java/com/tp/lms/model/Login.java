package com.tp.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Login_credential")
public class Login {
	@Column(name="User_Id")
	@Id
	private int userId;
	@Column(name="UserName")
	private String username;
	@Column(name="password")
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
