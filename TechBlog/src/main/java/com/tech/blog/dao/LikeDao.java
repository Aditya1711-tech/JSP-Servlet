package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LikeDao {
	Connection con;

	public LikeDao(Connection con) {
		this.con = con;
	}

	public boolean addLike(int uId, int pId) {
		boolean flag = false;

		try {

			String queryString = "insert into likes(pId, uId) values(?, ?)";
			PreparedStatement pstm = con.prepareStatement(queryString);

			pstm.setInt(1, pId);
			pstm.setInt(2, uId);

			pstm.executeUpdate();

			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public int countLikesOfPost(int pId) {
		int cnt = 0;

		try {

			String query = "select count(*) as Likes from likes where pId=?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, pId);

			ResultSet res = pstm.executeQuery();

			if (res.next()) {
				cnt = res.getInt("Likes");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cnt;
	}

	public int getLikeOnPostByUSer(int pId, int uId) {
		int cnt = 0;

		try {

			String queryString = "select count(*) as Likes form likes where pId=? ans uId=?";
			PreparedStatement pstm = con.prepareStatement(queryString);
			pstm.setInt(1, pId);
			pstm.setInt(2, uId);

			ResultSet res = pstm.executeQuery();

			if (res.next()) {
				cnt = res.getInt("Likes");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cnt;
	}

	public boolean removeLike(int uId, int pId) {
		boolean flag = false;

		try {

			String query = "delete from likes where pId=? and uId=?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, pId);
			pstm.setInt(2, uId);

			pstm.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

}
