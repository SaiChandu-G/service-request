package com.arshaa.request.model;

public class UpdateRequestDTO {

	private String description;
	private String priority;
	private String issueType;

	public UpdateRequestDTO() {
	}

	public UpdateRequestDTO(String description, String priority, String issueType) {
		super();
		this.description = description;
		this.priority = priority;
		this.issueType = issueType;
	}

	public String getDescription() {
		return description;
	}

	public String getIssueType() {
		return issueType;
	}

	public String getPriority() {
		return priority;
	}
}
