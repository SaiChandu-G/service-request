package com.arshaa.request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceRequestDao {

	private static Connection connection() {
		return DB_Connection.getConnection();
	}

	public String saveRequest(ServiceRequest request, int employeeId) {
		Employee employee2 = null;
		String response = "Request submitted successful";
		String employeeSql = "select * from employee where id=?";
		String requestSql = "insert into service_request(description, priority, issue_type, employee_id) values(?,?,?,?)";
		try (Connection connection = connection()) {
			try (PreparedStatement ps1 = connection.prepareStatement(employeeSql)) {
//				ps1.setInt(1, employee.getId());
//				ps1.setString(2, employee.getName());
//				ps1.setString(3, employee.getEmail());
//				ps1.setString(4, employee.getAddress());
//				ps1.setFloat(5, employee.getPhone());
//				ps1.setString(6, employee.getDesignation());
				ps1.setInt(1, employeeId);
				ResultSet rs = ps1.executeQuery();
				while (rs.next()) {
					employee2 = new Employee();
					employee2.setId(rs.getInt("id"));
					employee2.setName(rs.getString("name"));
					employee2.setEmail(rs.getString("email"));
					employee2.setAddress(rs.getString("address"));
					employee2.setPhone(rs.getLong("phone"));
					employee2.setDesignation(rs.getString("designation"));
				}
			}
			try (PreparedStatement ps2 = connection.prepareStatement(requestSql)) {
				ps2.setString(1, request.getDescription());
				ps2.setString(2, request.getPriority());
				ps2.setString(3, request.getIssueType());
				ps2.setInt(4, employee2.getId());
				ps2.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response = "Cannot create request";
		}
		return response;
	}
}
