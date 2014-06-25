/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ChattBank.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author AARONS
 */
public class Account {

    private String acctNo;
    private String custId;
    private String acctType;
    private double balance;

    Account() {

    }

    public Account(String acctNo) throws SQLException {
        Connection connect = null;
        Statement statement = null;
        ResultSet result = null;
        String sql = "SELECT * FROM Accounts WHERE acctNo = '" + acctNo + "';";

        try {
            connect = acctConnect();
            statement = connect.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()) {
                this.acctNo = result.getString("acctNo");
                this.custId = result.getString("Cid");
                this.acctType = result.getString("acctType");
                this.balance = result.getDouble("Balance");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            connect.close();
        }
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public String getCustId() {
        return custId;
    }

    public String getAcctType() {
        return acctType;
    }

    public double getBalance() {
        return balance;
    }

    public static Connection acctConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Errors: " + e);
        }

        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ChattBank", "root", "sesame");
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return con;
    }

    public void findDB() throws SQLException {
        Connection connect = null;
        Statement statement = null;
        ResultSet result = null;
        String sql = "SELECT * FROM Accounts WHERE acctNo = '" + acctNo + "';";

        try {
            connect = acctConnect();
            statement = connect.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()) {
                this.acctNo = result.getString("acctNo");
                this.custId = result.getString("Cid");
                this.acctType = result.getString("acctType");
                this.balance = result.getDouble("Balance");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            connect.close();
        }
    }
    
    //Testing purposes for the Account Class
    /*public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Account acct = null;
        System.out.println("Please Enter Your User Account Number.");
        String acctNumber = input.nextLine();

        try {
            acct = new Account(acctNumber);
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        System.out.println("Account Number: " + acct.getAcctNo());
        System.out.println("Customer Id: " + acct.getCustId());
        System.out.println("Account Type: " + acct.getAcctType());
        System.out.println("Balance: " + acct.getBalance());

    }*/
}
