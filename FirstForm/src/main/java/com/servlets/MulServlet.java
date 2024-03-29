package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MulServlet extends HttpServlet{

	public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter pr = resp.getWriter();
		
		int nn1 = Integer.parseInt(req.getParameter("n1"));
		int nn2 = Integer.parseInt(req.getParameter("n2"));
		
		int product = nn1*nn2;
		
		int sum = (int) req.getAttribute("sum");
		
		pr.println("Sum of " + nn1 + " and " + nn1 +" is: "  + sum);
		pr.print("<br/>");
		pr.println("Product of " + nn1 + " and " + nn1 +" is: "  + product);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
}
