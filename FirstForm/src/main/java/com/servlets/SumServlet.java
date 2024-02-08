package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SumServlet extends HttpServlet{
	
	public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter pr = resp.getWriter();
		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		
		int nn1 = Integer.parseInt(n1);
		int nn2 = Integer.parseInt(n2);
		
		int sum = nn1 + nn2;
		
		req.setAttribute("sum", sum);
		
		RequestDispatcher rd = req.getRequestDispatcher("mul");
		rd.forward(req, resp);
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
