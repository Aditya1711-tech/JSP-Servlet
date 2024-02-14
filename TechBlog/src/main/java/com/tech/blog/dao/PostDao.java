package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tech.blog.entities.Category;

public class PostDao {
	
	Connection con;

	public PostDao(Connection con) {
		this.con = con;
	}
	
	public ArrayList<Category> getAllCategories(){
		ArrayList<Category> categories = new ArrayList<Category>();
		
		try {
			
			String query = "select * from categories";
			Statement statement = this.con.createStatement();
			ResultSet res = statement.executeQuery(query);
			
			while(res.next()) {
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
	
	
}
