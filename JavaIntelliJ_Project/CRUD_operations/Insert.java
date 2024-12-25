package com.sitare.CRUD_operations;

import java.sql.SQLException;
import java.sql.*;

public class Insert {
    private static final String url = "jdbc:mysql://localhost:3306/jdbc_db";
    private static final String username = "harsh";
    private static final String password = "Harsh@517";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
//            String query = "insert into student (name, percentage) values ('Rahul',45.5) ";
            String query = String.format("insert into student (name, percentage) values ('%s', %f)","Student3",98.7);


            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected>0){
                System.out.println("Data inserted successfully in one line");
            }else {
                System.out.println("No data to be inserted");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
