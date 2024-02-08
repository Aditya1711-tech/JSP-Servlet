package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Register extends HttpServlet{
	public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter pr = resp.getWriter();
		
		// Getting all the details
		String user = req.getParameter("userName");
		String password = req.getParameter("userPassword");
		String email = req.getParameter("userEmail");
		
		pr.println(user + password + email);
		
		
		// Creating connection..
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Registration", "Voldemort", "#Aditya1711");
			
			String q = "insert into user(name, password, email) values(?,?,?)";
			PreparedStatement prs = con.prepareStatement(q);
			prs.setString(1, user);
			prs.setString(2, password);
			prs.setString(3, email);
			
			prs.executeUpdate();
			
			pr.println(user + password + email);
			pr.println("<h1>done</h1>");
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			pr.println("<h1>not done</h1>");
		}		
		
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
