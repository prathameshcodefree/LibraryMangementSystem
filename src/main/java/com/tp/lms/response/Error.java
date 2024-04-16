package com.tp.lms.response;

public class Error {
	private boolean status;
	private String message;

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

	public Error(boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public Error() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Error [status=" + status + ", message=" + message + "]";
	}

}
