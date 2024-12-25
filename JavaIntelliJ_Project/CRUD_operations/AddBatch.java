package com.sitare.CRUD_operations;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

public class AddBatch {
    private static final String url = "jdbc:mysql://localhost:3306/jdbc_db";
    private static final String user = "harsh";
    private static final String pass = "Harsh@517";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            Connection connection = DriverManager.getConnection(url, user, pass);
            String query = "Insert into student (name, percentage) values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.println("Enter name: ");
                String name = scanner.next();

                System.out.println("Enter marks: ");
                double marks = scanner.nextDouble();

                System.out.println("Do you want to enter further (Y/N):");
                String choice = scanner.next();

//                String query = String.format("Insert into student (name, percentage) values ('%s',%f)",name,marks);

                preparedStatement.setString(1,name);
                preparedStatement.setDouble(2,marks);

                preparedStatement.addBatch();

                if (choice.toUpperCase(Locale.ROOT).equals("N")){
                    break;
                }
            }
            int[] arr = preparedStatement.executeBatch();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i]==0){
                    System.out.println("this query not executed properly");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
