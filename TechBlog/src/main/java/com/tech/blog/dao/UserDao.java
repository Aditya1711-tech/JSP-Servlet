package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.ResultsetRow;
import com.tech.blog.entities.User;

public class UserDao {
	private Connection con;

	public UserDao(Connection con) {
		this.con = con;
	}

	// Register new user
	public boolean saveUser(User user) {
		boolean flag = false;
		try {
			String query = "insert into user(name, email, password, gender, about) values(?, ?, ?, ?, ?)";

			PreparedStatement prs = this.con.prepareStatement(query);
			prs.setString(1, user.getName());
			prs.setString(2, user.getEmail());
			prs.setString(3, user.getPassword());
			prs.setString(4, user.getGender());
			prs.setString(5, user.getAbout());

			prs.executeUpdate();

			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// Get user by email and password
	public User getUserByEmailAndPassword(String email, String password) {
		User user = null;

		try {

			String query = "select * from user where email=? and password=?";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, email);
			pst.setString(2, password);

			ResultSet res = pst.executeQuery();

			if (res.next()) {

				user = new User();
				user.setId(res.getInt("id"));
				user.setName(res.getString("name"));
				user.setEmail(res.getString("email"));
				user.setGender(res.getString("gender"));
				user.setDataTime(res.getTimestamp("rdate"));
				user.setAbout(res.getString("about"));
				user.setPassword(res.getString("password"));
				user.setProfile(res.getString("profile"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	public boolean updateUser(User user) {
		boolean flag = false;
		try {

			String query = "update user set  name=?, email=?, password=?, gender=?, about=?, profile=? where id=? ";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getAbout());
			ps.setString(6, user.getProfile());
			ps.setInt(7, user.getId());

			ps.executeUpdate();
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
}
