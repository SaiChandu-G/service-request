package com.arshaa.request;

public class Response {

	private String message;
	private Boolean status;

	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public Boolean getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Response [message=" + message + ", status=" + status + "]";
	}
	
	
}
