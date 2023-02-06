package com.arshaa.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet extends HttpServlet {

	/**
	 * 
	 */
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

		ServiceRequest serviceRequest = new ServiceRequest(description, priority, issueType);

		ServiceRequestDao dao = new ServiceRequestDao();
		String result = dao.saveRequest(serviceRequest, employeeId);

		Response r = new Response();
		r.setMessage(result);
		r.setStatus(true);

		PrintWriter writer = response.getWriter();
		writer.print(r);

	}
}
