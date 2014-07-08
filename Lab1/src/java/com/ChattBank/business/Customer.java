/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ChattBank.business;

import java.io.Serializable;
import java.sql.*;
import java.util.Scanner;
import myLibraries.DataManager;

/**
 *
 * @author Richard Davy
 */
public class Customer implements Serializable {

    private String custId;
    private String custPassword;
    private String custFirstName;
    private String custLastName;
    private String custAddress;
    private String custEmail;
    private String message;

    public Customer() {
        this.custId = "";
        this.custPassword = "";
        this.custFirstName = "";
        this.custLastName = "";
        this.custAddress = "";
        this.custEmail = "";
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }

    public void setCustFirstName(String custFirstName) {
        this.custFirstName = custFirstName;
    }

    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustId() {
        return custId;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public String getCustFirstName() {
        return custFirstName;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean login(String custPassword) throws SQLException {
        boolean yes_no = false;
        System.out.println(custPassword + "cust Password");
        System.out.println(this.custPassword + "db Password");
        if (custPassword.equals(this.custPassword)) {
            this.message = "Thank you, you are logged in.";
            yes_no = true;
        } else {
            this.message = "Sorry Your Login Information seems to be incorrect.";
            yes_no = false;
        }
        return yes_no;
    }

    public Connection custConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Errors: " + e);
        }

        Connection connect = null;
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ChattBank", "root", "sesame");
        } catch (SQLException e) {
            System.out.println("You have Errors: " + e);
        }

        return connect;
    }

    public void findDB(String custID) throws SQLException {

        Connection con = custConnect();
        Statement statement = null;
        ResultSet result = null;

        String sql = "Select * From Customers Where custID = '" + custID + "';";

        try {
            statement = con.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                this.custId = result.getString("custID");
                this.custPassword = result.getString("custPassword");
                this.custFirstName = result.getString("custFirstName");
                this.custLastName = result.getString("custLastName");
                this.custAddress = result.getString("custAddress");
                this.custEmail = result.getString("custEmail");
            }
        } catch (SQLException e) {
            System.out.println("Errors: " + e);
        } finally {
            con.close();
        }
    }

    public void insertDB(String custID, String custPassword, String custFirstName, String custLastName, String custAddress, String custEmail) throws SQLException {
        Connection con = custConnect();
        Statement statement;
        ResultSet result;
        int resultVal;
        String sql = "INSERT INTO Customers (custID, custPassword, custFirstName, custLastName, custAddress, custEmail) VALUES ('" + custID + "','" + custPassword
                + "','" + custFirstName + "','" + custLastName + "','" + custAddress + "','" + custEmail + "');";

        try {
            statement = con.createStatement();
            resultVal = statement.executeUpdate(sql);

            System.out.println(resultVal);
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            System.out.println(e.getStackTrace());
        } finally {
            con.close();
        }
    }

    public void deleteDB(String custID) throws SQLException {
        Connection con = custConnect();
        Statement statement;
        int resultVal;

        String sql = "DELETE FROM Customers WHERE custID = '" + custID + "';";

        try {
            statement = con.createStatement();
            resultVal = statement.executeUpdate(sql);
            System.out.println(resultVal);
        } catch (SQLException e) {
            System.out.println("Errors: " + e);
        } finally {
            con.close();
        }
    }

    //Testing purposes for the Customer Class.
//    public static void main(String[] args) throws SQLException {
//     Customer customer = new Customer();
//
//     Scanner userLog = new Scanner(System.in);
//     System.out.print("Please Enter your user name: ");
//     String userName = userLog.nextLine();
//     System.out.print("Please Enter Your Password: ");
//     String passWord = userLog.nextLine();
//     try {
//     customer.findDB(userName);
//     } catch (SQLException e) {
//     System.out.println("Errors: " + e);
//     }
//
//     if (customer.login(passWord) == true) {
//     System.out.println("Customer Id: " + customer.getCustId());
//     System.out.println("Customer Password is: " + customer.getCustPassword());
//     System.out.println("Customer Name: " + customer.getCustFirstName() + " " + customer.getCustLastName());
//     System.out.println("Customer Address Is: " + customer.getCustAddress());
//     System.out.println("Customer Email: " + customer.getCustEmail());
//
//     try {
//     customer.insertDB("3000", "4273", "Richard", "Davy", "White", "RichardDavy42@gmail.com");
//     customer.deleteDB("3000");
//     } catch (SQLException e) {
//     System.out.println("Errors: " + e);
//     }
//     } else {
//     System.out.println("Sorry Your Login Information Seems To Be Incorrect!");
//     }
//     }
}
