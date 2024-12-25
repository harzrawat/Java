package com.sitare.CRUD_operations;
import java.sql.*;

public class Update {
    private static final String url = "jdbc:mysql://localhost:3306/jdbc_db";
    private static final String username = "harsh";
    private static final String password = "Harsh@517";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");      // by the way now a days this driver is not necessary
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

//            String query = "update student set name = 'Vikas' where id = 3";
            String query = String.format("update student set name = '%s' where id = %d", "Vimal",3);

            int rowAffected = statement.executeUpdate(query);
            if (rowAffected>0){
                System.out.println("table updated successfully");
            }else {
                System.out.println("update failed");
            }
        }catch (SQLException e){
            System.out.println("SQL Exception occured");
            e.printStackTrace();
        }
    }

}
