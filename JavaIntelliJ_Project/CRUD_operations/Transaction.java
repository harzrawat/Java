package com.sitare.CRUD_operations;
import java.sql.*;
import java.util.Scanner;

public class Transaction {
    private static final String url = "jdbc:mysql://localhost:3306/jdbc_db";
    private static final String username = "harsh";
    private static final String password = "Harsh@517";

    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            String debitquery = "update transaction set Amount = Amount-? where Acc_no = ? ";
            String creditquery = "update transaction set Amount = Amount+? where Acc_no = ? ";

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the amount to transfer: ");
            double amount = scanner.nextDouble();

            System.out.print("Enter the debit account number: ");
            int debitAcc = scanner.nextInt();

            if (isvalid(connection, debitAcc, amount)){
                PreparedStatement preparedStatement1 = connection.prepareStatement(debitquery);
                PreparedStatement preparedStatement2 = connection.prepareStatement(creditquery);


                preparedStatement1.setDouble(1,amount);
                preparedStatement1.setInt(2,debitAcc);

                System.out.print("Enter the credit account number: ");
                int creditAcc = scanner.nextInt();

                preparedStatement2.setDouble(1,amount);
                preparedStatement2.setInt(2,creditAcc);

                int rowAffected1 = preparedStatement1.executeUpdate();
                int rowAffected2 = preparedStatement2.executeUpdate();

                connection.commit();
                if (rowAffected1>0 && rowAffected2>0){
                    System.out.println(" Updated successfully");
                }
            }else {
                connection.rollback();
                System.out.println("insufficient bank balance for transaction");
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static boolean isvalid(Connection connection, int acc_no, double amount){
        try{
            String query = "Select Amount from transaction where Acc_no = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1,acc_no);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                double available = resultSet.getDouble("Amount");
                System.out.println("Amount: "+ available);

                if (available<amount){
                    return false;
                }
            }return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            if (connection!=null){
                try {
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
