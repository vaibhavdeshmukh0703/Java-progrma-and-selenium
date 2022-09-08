package com.example.JDBCConection;

import java.sql.SQLException;

public class Connection{
  public static Connection connection = null;
  private static final String url = "jdbc:postgresql://localhost:5432/person";
  private static final String user = "postgres";
  private static final String password = "vaibhav@123";
  public static void jdbcConnection() throws SQLException{
  
      //String url = "jdbc:postgresql://localhost:5432/person/postgres/ vaibhav@123";
     //connection = DriverManager.getConnection(url, user, password);
      if(connection!=null) System.out.println("connection !!!");
      else System.out.println("Connection not connected");

  
  }

  public static void main(String[] args) {
    try {
      jdbcConnection();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
