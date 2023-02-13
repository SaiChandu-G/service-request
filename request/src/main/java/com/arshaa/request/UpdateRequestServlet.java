package com.arshaa.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arshaa.request.dao.UpdateRequestDAO;
import com.arshaa.request.model.UpdateRequestDTO;
import com.arshaa.request.response.UpdateResponse;
import com.google.gson.Gson;

public class UpdateRequestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPut(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
			throws ServletException, IOException {

		String description = servletRequest.getParameter("description");
		String priority = servletRequest.getParameter("priority");
		String issueType = servletRequest.getParameter("issueType");
		int id = Integer.parseInt(servletRequest.getParameter("id"));
		int employeeId = Integer.parseInt(servletRequest.getParameter("employeeId"));

		PrintWriter writer = servletResponse.getWriter();
		Gson gson;
		String jsonResponse;

		UpdateRequestDTO requestDTO = new UpdateRequestDTO(description, priority, issueType);
		UpdateRequestDAO updateDAO = new UpdateRequestDAO();
		UpdateResponse updateResponse = updateDAO.updateRequest(requestDTO, id, employeeId);
		gson = new Gson();
		jsonResponse = gson.toJson(updateResponse);
		writer.print(jsonResponse);

	}

}
