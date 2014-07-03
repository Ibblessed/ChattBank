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
 * @author Richard Davy
 */
public class Account {

    private String acctNo;
    private String custId;
    private String acctType;
    private double balance;

    public Account() {

    }

    public Account(String acct) throws SQLException {
        Connection connect = null;
        Statement statement = null;
        ResultSet result = null;
        String sql = "SELECT * FROM Accounts WHERE acctNo = '" + acct + "';";

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

    public String getAcct() {
        return this.acctNo + " " + this.custId + " " + this.acctType + " " + this.balance;
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

    public void deposit(String acctNo, double depAmount) throws SQLException {
        Connection connect = acctConnect();
        Statement statement = connect.createStatement();
        ResultSet result = null;
        String sql = "Select balance From Accounts Where acctNO = '" + acctNo + "';";
        String update = null;
        int updateSet = 0;
        double balance = 0.00;
        double newBalance;

        result = statement.executeQuery(sql);
        while (result.next()) {
            balance = result.getDouble("Balance");
        }

        newBalance = balance + depAmount;
        update = "Update Accounts Set Balance = '" + newBalance + "' Where acctNO = '" + acctNo + "';";
        updateSet = statement.executeUpdate(update);

        connect.close();
    }

    public void withdraw(String acctNo, double withdrawal) throws SQLException {

        Connection connect = acctConnect();
        Statement statement = connect.createStatement();
        ResultSet result = null;
        String sql = "Select balance From Accounts Where acctNO = '" + acctNo + "';";
        String update = null;
        int updateSet = 0;
        double balance = 0.00;
        double newBalance;

        result = statement.executeQuery(sql);
        while (result.next()) {
            balance = result.getDouble("Balance");
        }

        newBalance = balance - withdrawal;
        update = "Update Accounts Set Balance = '" + newBalance + "' Where acctNo = '" + acctNo + "';";
        updateSet = statement.executeUpdate(update);
        System.out.println("Update Success: " + updateSet);
        connect.close();
    }

    public void transfer(String fromAcct, String toAcct, double transfer) throws SQLException {
        withdraw(fromAcct, transfer);
        deposit(toAcct, transfer);
    }

    public void estabAccount(String acctNo, String custID, String type, double balance) throws SQLException {
        Connection connect = acctConnect();
        Statement statement = connect.createStatement();
        int result = 0;
        String sql = "Insert Into accounts (acctNO, Cid, acctType, Balance) Values ('" + acctNo + "', " + custID + "', " + type + "', " + balance + "');";

        result = statement.executeUpdate(sql);
        connect.close();

    }

    //Testing purposes for the Account Class
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        Account fromAcct1 = null;
//        Account toAccount1 = null;
//        System.out.println("Please Enter The Account Number You Wish To Transfer From");
//        String acctNumber = input.nextLine();
//        System.out.println("Please Enter The Acct Number You Wish To Transfer To");
//        String acctNumber2 = input.nextLine();
//        System.out.println("Please Enter The Amount You Wish To Transfer");
//        double transfer = input.nextDouble();
//
//        try {
//            fromAcct1 = new Account(acctNumber);
//            toAccount1 = new Account(acctNumber2);
//            System.out.println(fromAcct1.getBalance());
//            System.out.println(toAccount1.getBalance());
//            fromAcct1.transfer(acctNumber, acctNumber2, transfer);
//            Account fromAcct = new Account(acctNumber);
//            Account toAccount = new Account(acctNumber2);
//            System.out.println(fromAcct.getBalance());
//            System.out.println(toAccount.getBalance());
//        } catch (SQLException e) {
//            System.out.println("Error: " + e);
//        }
//
//        System.out.println("From Account: " + fromAcct1.getAcct());
//        System.out.println("To Account: " + toAccount1.getAcct());
//
//    }
}
