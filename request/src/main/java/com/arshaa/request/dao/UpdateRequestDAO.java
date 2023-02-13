package com.arshaa.request.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.arshaa.request.model.UpdateRequestDTO;
import com.arshaa.request.response.UpdateResponse;
import com.arshaa.request.util.DB_Connection;

public class UpdateRequestDAO {

	private static Connection getConnection() {
		return DB_Connection.getConnection();
	}

	public UpdateResponse updateRequest(UpdateRequestDTO requestDTO, int id, int employeeId) {
		UpdateResponse response = new UpdateResponse();
		int updatedTables = 0;
		String selectRequestQuery = "select * from service_request where id=? and employee_id=?";
		String updateRequestQuery = "update service_request set description=?, priority=?, issue_type=? where id=? and employee_id=?";
		try (Connection connection = getConnection()) {
			PreparedStatement ps1 = connection.prepareStatement(selectRequestQuery);
			ps1.setInt(1, id);
			ps1.setInt(2, employeeId);
			ResultSet rs = ps1.executeQuery();
			if (!rs.next()) {
				throw new Exception("No request found");
			}
			while (rs.next()) {
				PreparedStatement ps2 = connection.prepareStatement(updateRequestQuery);
				ps2.setString(1, requestDTO.getDescription());
				ps2.setString(2, requestDTO.getPriority());
				ps2.setString(3, requestDTO.getIssueType());
				ps2.setInt(4, id);
				ps2.setInt(5, employeeId);
				updatedTables = ps2.executeUpdate();
				ps2.close();
				if (updatedTables > 0) {
					response.setStatus(true);
					response.setMessage("Request updated successfull");
					return response;
				}
			}
			ps1.close();
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage(e.getLocalizedMessage());
		}
		response.setStatus(false);
		return response;
	}
}
