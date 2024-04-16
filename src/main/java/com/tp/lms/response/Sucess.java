package com.tp.lms.response;

public class Sucess {
	private boolean status;
	private String message;
	public Sucess() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sucess(boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	@Override
	public String toString() {
		return "Sucess [status=" + status + ", message=" + message + "]";
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
