package com.sitare.CRUD_operations;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.*;

public class PreparedSelect {
    private static final String url = "jdbc:mysql://localhost:3306/jdbc_db";
    private static final String username = "harsh";
    private static final String password = "Harsh@517";

    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection(url,username, password);
            String query = "select name from student where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1,4);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String name = resultSet.getString("name");
                System.out.println(name);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
