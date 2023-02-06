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
		String priority = request.getParameter("priority");
		String issueType = request.getParameter("issueType");
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));

		ServiceRequest serviceRequest = new ServiceRequest(description, priority, issueType);
//		Employee employee = new Employee(1, "Chandu sai", "sai@gmail.com", "Nellore", 9676351831L, "software developer",
//				serviceRequest);

		ServiceRequestDao dao = new ServiceRequestDao();
		String result = dao.saveRequest(serviceRequest, employeeId);

		PrintWriter writer = response.getWriter();
		writer.print(result);

	}
}
