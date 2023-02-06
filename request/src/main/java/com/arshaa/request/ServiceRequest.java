package com.arshaa.request;

public class ServiceRequest {

	private int id;
	private String description;
	private String priority;
	private String issueType;
	private int employeeId;

	public ServiceRequest() {
	}

	public ServiceRequest(String description, String priority, String issueType) {
		super();
		this.description = description;
		this.priority = priority;
		this.issueType = issueType;
	}

	public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}

	public String getIssueType() {
		return issueType;
	}

	public String getPriority() {
		return priority;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

}
