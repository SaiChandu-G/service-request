package com.arshaa.request.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.arshaa.request.model.ServiceRequest;
import com.arshaa.request.util.DB_Connection;

public class AllRequestsDAO {

	private static Connection getConnection() {
		return DB_Connection.getConnection();
	}

	public List<ServiceRequest> getAllServiceRequests() {
		List<ServiceRequest> requests = new ArrayList<>();
		ServiceRequest request = null;
		String getAllRequestsQuery = "select * from  service_request";
		try (Connection connection = getConnection()) {
			PreparedStatement ps = connection.prepareStatement(getAllRequestsQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				request = new ServiceRequest(rs.getInt("id"), rs.getString("description"), rs.getString("priority"),
						rs.getString("issue_type"));
				requests.add(request);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}

		return requests;
	}
}
