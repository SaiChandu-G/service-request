package com.arshaa.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arshaa.request.dao.AllRequestsDAO;
import com.arshaa.request.model.ServiceRequest;
import com.arshaa.request.response.AllServicesResponse;
import com.google.gson.Gson;

public class AllRequestsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
			throws ServletException, IOException {
		servletResponse.addHeader("Access-Control-Allow-Origin", "*");
		servletResponse.setContentType("application/json");
		servletResponse.setCharacterEncoding("UTF-8");

		PrintWriter writer = servletResponse.getWriter();
		Gson gson;
		String jsonResponse;

		AllRequestsDAO requestsDAO = new AllRequestsDAO();
		List<ServiceRequest> allRequests = requestsDAO.getAllServiceRequests();
		AllServicesResponse response = setAllServicesResponse(allRequests);
		gson = new Gson();
		jsonResponse = gson.toJson(response);
		writer.print(jsonResponse);

	}

	private AllServicesResponse setAllServicesResponse(List<ServiceRequest> requests) {
		AllServicesResponse allServicesResponse = new AllServicesResponse();
		if (requests.isEmpty()) {
			allServicesResponse.setMessage("No service requests available");
			allServicesResponse.setStatus(false);
			allServicesResponse.setRequests(Collections.emptyList());
			return allServicesResponse;
		}
		allServicesResponse.setMessage("All Requests fetched successful");
		allServicesResponse.setStatus(true);
		allServicesResponse.setRequests(requests);
		return allServicesResponse;

	}
}
