package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tech.blog.dao.PostDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.Post;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.Helper;

@MultipartConfig
public class AddPostServlet extends HttpServlet {
	public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		try (PrintWriter print = resp.getWriter()) {
			// Get form data
			int cId = Integer.parseInt(req.getParameter("postCatagory"));
			String pTitle = req.getParameter("postTitle");
			String pContent = req.getParameter("postContent");
			String pCode = req.getParameter("postCode");
			Part part = req.getPart("postPic");

			// Get user data
			HttpSession session = req.getSession();
			User loggedInUser = (User) session.getAttribute("currentUser");
			int userId = loggedInUser.getId();

			Post newPost = new Post(pTitle, pContent, pCode, part.getSubmittedFileName(), null, cId, userId);

			PostDao postDao = new PostDao(ConnectionProvider.getCon());
			boolean isPostSaved = postDao.savePost(newPost);

			if (isPostSaved) {
				String path = req.getRealPath("/") + "blogPics" + java.io.File.separator + part.getSubmittedFileName();
//				Helper.deleteFile(path);
				Helper.saveFile(part.getInputStream(), path);
				print.println("Seccess");
			} else {
				print.println("Error");
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
