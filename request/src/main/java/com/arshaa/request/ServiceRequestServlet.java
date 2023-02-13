package com.arshaa.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arshaa.request.dao.ServiceRequestDao;
import com.arshaa.request.model.ServiceRequest;
import com.arshaa.request.response.ServiceCreationResponse;
import com.google.gson.Gson;

public class ServiceRequestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String description = request.getParameter("description");
		String priority = request.getParameter("priorityLevel");
		String issueType = request.getParameter("issueType");
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));

		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();

		ServiceRequest serviceRequest = new ServiceRequest(description, priority, issueType);

		ServiceRequestDao dao = new ServiceRequestDao();
		String result = dao.saveRequest(serviceRequest, employeeId);

		ServiceCreationResponse r = new ServiceCreationResponse();
		r.setMessage(result);
		r.setStatus(true);

		Gson gson = new Gson();
		String jsonString = gson.toJson(r);

		writer.print(jsonString);

	}
}
