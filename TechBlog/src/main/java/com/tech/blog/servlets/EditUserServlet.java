package com.tech.blog.servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.jni.File;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.Helper;

@MultipartConfig
public class EditUserServlet extends HttpServlet {
	public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		try (PrintWriter print = resp.getWriter()) {

			// Fetch form data
			String userName = req.getParameter("userName");
			String userEmail = req.getParameter("userEmail");
			String userPassword = req.getParameter("userPassword");
			String userAbout = req.getParameter("userAbout");

			Part part = req.getPart("userProfilePic");
			String profilePicName = part.getSubmittedFileName();

			// Fetch logged-in user data
			HttpSession session = req.getSession();
			User loggedInUser = (User) session.getAttribute("currentUser");

			loggedInUser.setName(userName);
			loggedInUser.setEmail(userEmail);
			loggedInUser.setPassword(userPassword);
			loggedInUser.setAbout(userAbout);
			loggedInUser.setProfile(profilePicName);

			UserDao userDao = new UserDao(ConnectionProvider.getCon());

			boolean isUserUpdated = userDao.updateUser(loggedInUser);

			if (isUserUpdated) {
				String path = req.getRealPath("/") + "pics" + java.io.File.separator + loggedInUser.getProfile();
				Helper.deleteFile(path);
				if (Helper.saveFile(part.getInputStream(), path)) {
					Message msg = new Message("Profile details updated..", "success", "alert-success ");
					session.setAttribute("msg", msg);
				} else {
					Message msg = new Message("Something went wrong", "error", "alert-danger");
					session.setAttribute("msg", msg);
				}

			} else {
				Message msg = new Message("Something went wrong", "error", "alert-danger");
				session.setAttribute("msg", msg);
			}

			resp.sendRedirect("Profile.jsp");

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
