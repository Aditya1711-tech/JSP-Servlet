package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;

@MultipartConfig
public class LoginServlet extends HttpServlet {

	public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		try (PrintWriter print = resp.getWriter()) {

			String userEmail = req.getParameter("userEmail");
			String userPassword = req.getParameter("userPassword");

			UserDao uDao = new UserDao(ConnectionProvider.getCon());

			User loggedInUser = uDao.getUserByEmailAndPassword(userEmail, userPassword);

			if (loggedInUser == null) {
				// Error
				Message msg = new Message("Invalid email or password", "error", "alert-danger ");
				HttpSession session = req.getSession();
				session.setAttribute("msg", msg);
				resp.sendRedirect("login.jsp");
			} else {
				// Success
				HttpSession session = req.getSession();
				session.setAttribute("currentUser", loggedInUser);
				resp.sendRedirect("Profile.jsp");
			}

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
