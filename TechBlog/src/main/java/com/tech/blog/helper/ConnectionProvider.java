package com.tech.blog.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

  private static Connection con;

  public static Connection getCon() {
    String url = "jdbc:mysql://localhost:3306/TechBlog";
    String userName = "Voldemort";
    String password = "#Aditya1711";

    try {
      if (con == null) {
        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(url, userName, password);
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
    }

    return con;
  }
}
