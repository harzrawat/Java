package com.sitare.CRUD_operations;
import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class InsertMultiple {
    private static final String url = "jdbc:mysql://localhost:3306/jdbc_db";
    private static final String username = "harsh";
    private static final String password = "Harsh@517";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "insert into student (name, percentage) values (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1,"Student4");
            preparedStatement.setDouble(2,94.2);

            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected>0){
                System.out.println("successfully inserted using format specifiers");
            }
            else{
                System.out.println("insertion not successful");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }


    }
}
