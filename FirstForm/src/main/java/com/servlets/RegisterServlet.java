package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<h1>Welcome to register page</h1>");
		
		String name = req.getParameter("userName");
		String password = req.getParameter("userPassword");
		String email = req.getParameter("userEmail");
		String gender = req.getParameter("userGender");
		String course = req.getParameter("userCourse");
		String condition = req.getParameter("condition");
		
		if(condition == null){
			printWriter.println("<h2>You hav not accepted condition</h2>");
			
			// Using requestDispatcher
			// similarly we can transfer control to another servlet also.
			// For that pass url-mapping of that servlet to this getRequestDispatcher()
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}else {	
			printWriter.println("<h2>Name: " + name + "</h2>");
			printWriter.println("<h2>Password: " + password + "</h2>");
			printWriter.println("<h2>Email: " + email + "</h2>");
			printWriter.println("<h2>Gender: " + gender + "</h2>");
			printWriter.println("<h2>Course: " + course + "</h2>");
			
			RequestDispatcher rd = req.getRequestDispatcher("success");
			// here we have used forward so it will not diaply all the things above
//			rd.forward(req, resp);
			
			//But if we use include here then it will print above data and plus success message
			rd.include(req, resp);
		}
	}
	
}
