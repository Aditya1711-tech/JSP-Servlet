package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookie extends HttpServlet{
	public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter pr = resp.getWriter();
		
		Cookie[] cookies = req.getCookies();	
		boolean flag = false;
		String name = "";
		
		if(cookies == null) {
			pr.println("<h2>You are not loggedin</h2>");
		}else {
			for(Cookie c:cookies) {
				if(c.getName().equals("userName")) {
					name = c.getValue();
					flag = true;
				}
				if(flag)break;
			}
		}
		if(flag)
			pr.println("<h2>Welcome back " + name + "</h2>");
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