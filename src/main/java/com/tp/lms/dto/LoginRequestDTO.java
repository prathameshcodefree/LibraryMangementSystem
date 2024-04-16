package com.tp.lms.dto;

public class LoginRequestDTO {
	
	private String userName;
	
	private String password;
	
	
	public String getUserName() {
		return this.userName;
	}
	

	public String getPassword() {
		return this.password;
	}
	
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}
