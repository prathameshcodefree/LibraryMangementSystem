package com.tp.lms.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

enum LinkType{
	ADMIN,
	STAFF,
	STUDENT
}


enum Purpose{
	LOGIN,
	RESET
}





public class TokenLog {
	
	@Id
	@Column(name="token_log_id")
	private int tokenLogId;
	
	@Column(name="link_id")
	private int linkId;
	
	@Enumerated(EnumType.STRING)
	@Column(name="link_type")
	private LinkType linkType;
	
	@Enumerated(EnumType.STRING)
	@Column(name="purpose")
	private Purpose purpose;
	
	@Column(name="user_name")
	private String userName;
	
	
	@Column(name="token")
	private String token;
	
	@Column(name="ip")
	private String ip;
	
	@Column(name="attempt")
	private int attempt;
	
	@Column(name="is_valid")
	private boolean isValid;
	
	@Column(name="created_at")
	private Date createdAt;

	public int getTokenLogId() {
		return tokenLogId;
	}

	public int getLinkId() {
		return linkId;
	}

	public LinkType getLinkType() {
		return linkType;
	}

	public Purpose getPurpose() {
		return purpose;
	}

	public String getUserName() {
		return userName;
	}

	public String getToken() {
		return token;
	}

	public String getIp() {
		return ip;
	}

	public int getAttempt() {
		return attempt;
	}

	public boolean isValid() {
		return isValid;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setTokenLogId(int tokenLogId) {
		this.tokenLogId = tokenLogId;
	}

	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}

	public void setLinkType(LinkType linkType) {
		this.linkType = linkType;
	}

	public void setPurpose(Purpose purpose) {
		this.purpose = purpose;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
