import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.*;

public class Main {
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
            // establish connection to the database using url, and other credentials
            Connection connection = DriverManager.getConnection(url, username, password);

            // creating a statement object to send query to the database
            Statement statement = connection.createStatement();

            String query = "Select * from student";

            // execute the sql query statement and storing the result in resultSet object
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double percentage = resultSet.getDouble("percentage");

                System.out.println("ID: "+id);
                System.out.println("Name: "+ name);
                System.out.println("marks: "+ percentage);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}