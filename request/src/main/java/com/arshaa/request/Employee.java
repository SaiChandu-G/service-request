package com.arshaa.request;

public class Employee {

	private int id;
	private String name;
	private String email;
	private String address;
	private long phone;
	private String designation;
	private ServiceRequest request;

	public Employee() {
	}

	public Employee(int id, String name, String email, String address, long phone, String designation,
			ServiceRequest request) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.designation = designation;
		this.request = request;
	}

	public String getAddress() {
		return address;
	}

	public String getDesignation() {
		return designation;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getPhone() {
		return phone;
	}

	public ServiceRequest getRequest() {
		return request;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public void setRequest(ServiceRequest request) {
		this.request = request;
	}

}
