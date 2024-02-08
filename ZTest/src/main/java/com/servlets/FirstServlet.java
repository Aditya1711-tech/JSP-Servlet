package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.*;

public class FirstServlet implements Servlet{
	
	ServletConfig conf;
	
	
	// Life cycle methods
	@Override
	public void init(ServletConfig config) throws ServletException {
		conf = config;
		System.out.println("Creating object......");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("This is first servlet Servicing....");
		res.setContentType("text/html");
		PrintWriter printWriter = res.getWriter();
		
		printWriter.println("<h1>This is my first servlet</h1>");
		printWriter.println("Current time is: " + new Date());
	}
	
	@Override
	public void destroy() {
		System.out.println("Going to destroy...");
	}
	
	
	// Non life cycle methods
	@Override
	public ServletConfig getServletConfig() {
		return conf;
	}

	@Override
	public String getServletInfo() {
		return "This servlet is created by Aditya";
	}

	
}