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
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
	}

	@Override
	protected void doPut(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
			throws ServletException, IOException {

		String description = servletRequest.getParameter("description");
		String priority = servletRequest.getParameter("priority");
		String issueType = servletRequest.getParameter("issueType");
		int id = Integer.parseInt(servletRequest.getParameter("id"));
		int employeeId = Integer.parseInt(servletRequest.getParameter("employeeId"));

		servletResponse.addHeader("Access-Control-Allow-Origin", "*");
		servletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		// servletResponse.addHeader("Access-Control-Max-Age", "3600");
		// servletResponse.addHeader("Access-Control-Allow-Headers",
		// "x-requested-with");
		servletResponse.setContentType("application/json");
		servletResponse.setCharacterEncoding("UTF-8");

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
