package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;

@MultipartConfig
public class RegisterServlet extends HttpServlet {
	public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter pr = resp.getWriter();

		String checked = req.getParameter("userCheck");

		if (checked == null) {

			pr.println("Please accept terms and conditions..");

		} else {

			String userName = req.getParameter("userName");
			String userEmail = req.getParameter("userEmail");
			String userPassword = req.getParameter("userPassword");
			String userGender = req.getParameter("userGender");
			String userAbout = req.getParameter("userAbout");

			User newUser = new User(userName, userEmail, userPassword, userGender, userAbout);

			UserDao uDao = new UserDao(ConnectionProvider.getCon());
			boolean isUserSaved = uDao.saveUser(newUser);

			if (isUserSaved) {
				pr.println("Success");
			} else {
				pr.println("Error");
			}

		}
		pr.close();

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
