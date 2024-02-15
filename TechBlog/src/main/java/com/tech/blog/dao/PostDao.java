package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.tech.blog.entities.Category;
import com.tech.blog.entities.Post;

public class PostDao {

	Connection con;

	public PostDao(Connection con) {
		this.con = con;
	}

	public ArrayList<Category> getAllCategories() {
		ArrayList<Category> categories = new ArrayList<Category>();

		try {

			String query = "select * from categories";
			Statement statement = this.con.createStatement();
			ResultSet res = statement.executeQuery(query);

			while (res.next()) {
				int cId = res.getInt("cid");
				String name = res.getString("name");
				String description = res.getString("description");
				Category category = new Category(cId, name, description);
				categories.add(category);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return categories;
	}

	public boolean savePost(Post post) {
		boolean flag = false;

		try {
			String queryString = "insert into posts(pTitle, pContent, pCode, pPick, catId, userId) values(?,?,?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(queryString);
			pstm.setString(1, post.getpTitle());
			pstm.setString(2, post.getpContent());
			pstm.setString(3, post.getpCode());
			pstm.setString(4, post.getpPick());
			pstm.setInt(5, post.getCatId());
			pstm.setInt(6, post.getUserId());

			pstm.executeUpdate();

			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public ArrayList<Post> getAllPosts() {
		ArrayList<Post> posts = new ArrayList<Post>();

		try {

			String queryString = "select * from posts";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(queryString);

			while (resultSet.next()) {
				int pId = resultSet.getInt("pId");
				String pTitle = resultSet.getString("pTitle");
				String pContent = resultSet.getString("pContent");
				String pCode = resultSet.getString("pCode");
				String pPick = resultSet.getString("pPick");
				Timestamp pDate = resultSet.getTimestamp("pDate");
				int catId = resultSet.getInt("catId");
				int userId = resultSet.getInt("userId");

				Post post = new Post(pId, pTitle, pContent, pCode, pPick, pDate, catId, userId);
				posts.add(post);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return posts;
	}
	
	
	public ArrayList<Post> getAllPostByCat(int catId){
		ArrayList<Post> posts = new ArrayList<Post>();

		try {

			String queryString = "select * from posts";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(queryString);

			while (resultSet.next()) {
				int pId = resultSet.getInt("pId");
				String pTitle = resultSet.getString("pTitle");
				String pContent = resultSet.getString("pContent");
				String pCode = resultSet.getString("pCode");
				String pPick = resultSet.getString("pPick");
				Timestamp pDate = resultSet.getTimestamp("pDate");
				int catId1 = resultSet.getInt("catId");
				int userId = resultSet.getInt("userId");
				if(catId == catId1) {					
					Post post = new Post(pId, pTitle, pContent, pCode, pPick, pDate, catId1, userId);
					posts.add(post);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return posts;
	}

}
