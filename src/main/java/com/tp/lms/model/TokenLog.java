package com.tp.lms.model;

import java.util.Date;

import com.tp.lms.model.enums.LinkType;
import com.tp.lms.model.enums.Purpose;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * 
 * 
 @author DURGESH */

@Entity
public class TokenLog {
	
	@Id
	@Column(name="token_log_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tokenLogId;
	
	@Column(name="link_id")
	private int linkId;
	
	@Enumerated(EnumType.STRING)
	@Column(name="link_type")
	private LinkType linkType;
	
	@Enumerated(EnumType.STRING)
	@Column(name="purpose")
	private Purpose purpose;
	
	@Column(name="user_name", length = 128)
	private String userName;
	
	
	@Column(name="token", length = 128)
	private String token;
	
	@Column(name="ip" , length = 128)
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
