package com.vaibhav;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConnection {

    final private static String dbName = "person";
    final private static String url = "http://localhost:5432/" + dbName;
    final private static String userName = "postgres";
    final private static String password = "vaibhav@123";

    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultset = null;

    private static void connectionSetup() {
        try {
            connection = DriverManager.getConnection(url, userName, password);
            if (connection != null) {
                System.out.println("JDBC Connection Succesfully Established");
            } else {
                System.out.println("JDBC not connected");
            }
            // create sql statement

            statement = connection.createStatement();
            String query = "select id,first_name,last_name,country from person limit 10";
            statement.executeQuery(query);
            
            // execute result set and display result
            resultset = statement.getResultSet();
            while (resultset.next()) {

                int id = resultset.getInt("id");
                String firstName = resultset.getString("first_name");
                String lastName = resultset.getString("last_name");
                String country = resultset.getString("country");

                System.out.println(id + " " + firstName + " " + lastName + " " + country);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
                // TODO: handle exception
                e.getStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            connectionSetup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
