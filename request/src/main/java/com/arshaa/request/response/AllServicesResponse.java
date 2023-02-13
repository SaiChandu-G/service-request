package com.arshaa.request.response;

import java.util.List;

import com.arshaa.request.model.ServiceRequest;

public class AllServicesResponse {

	private String message;
	private Boolean status;
	private List<ServiceRequest> requests;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<ServiceRequest> getRequests() {
		return requests;
	}

	public void setRequests(List<ServiceRequest> requests) {
		this.requests = requests;
	}

}
