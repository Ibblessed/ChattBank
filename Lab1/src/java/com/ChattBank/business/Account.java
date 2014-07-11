/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ChattBank.business;

import java.io.Serializable;
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
public class Account implements Serializable{

    private String acctNo;
    private String custId;
    private String acctType;
    private double balance;
    private String message;
    
    /**
     * No-Arg Constructor
     */
    public Account() {

    }
    
    /**
     * Single Arg constructor accepts one parameter
     * connects to database and builds the customers 
     * account object 
     * @param acct
     */
    public Account(String acct) throws SQLException {
        
        Connection connect = null;
        Statement statement = null;
        ResultSet result = null;
        String sql = "SELECT * FROM Accounts WHERE acctNo = '" + acct + "';";

        try {
            /*establishes connection and creates statement */
            connect = acctConnect();
            statement = connect.createStatement();
            result = statement.executeQuery(sql);
            
            /*loops through the database row containing the information
            and builds the row*/
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
    
    /**
    *sets account number 
    *@param acctNo
    */
    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }
    
    /**
     *sets customer id
     * @param custId
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }
    
    /**
     * sets account type 
     * @param acctType
     */
    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    /**
     * sets balance for the account
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    /**
     * returns account number
     * @return String
     */
    public String getAcctNo() {
        return acctNo;
    }

    /**
     * returns customer id
     * @return String
     */
    public String getCustId() {
        return custId;
    }

    /**
     * returns account type
     * @return String
     */
    public String getAcctType() {
        return acctType;
    }
    
    /**
     * returns account balance
     * @return double
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * returns account information into string form
     * @return String 
     */
    public String getAcct() {
        return this.acctNo + " " + this.custId + " " + this.acctType + " " + this.balance;
    }
    
    /**
     * returns message set by other methods in class
     * @return String
     */
    public String getMessage(){
        return this.message;
    };
    
    /**
     * Establishes connection to database
     * @return Connection
     */
    public static Connection acctConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Errors: " + e);
        }
        
        /*Declare new connection*/
        Connection con = null;
        try {
            
            /*Define connection*/
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ChattBank", "root", "sesame");
        
        } catch (SQLException e) {
        
            System.out.println("Error: " + e);
        
        }
        
        /*Returns connection con*/
        return con;
    }
    
    /**
     * Uses object account number to get all information from the database
     * where the account number is valid
     */
    public void findDB() throws SQLException {
        Connection connect = null;
        Statement statement = null;
        ResultSet result = null;
        String sql = "SELECT * FROM Accounts WHERE acctNo = '" + acctNo + "';";

        try {
            
            connect = acctConnect();
            statement = connect.createStatement();
            result = statement.executeQuery(sql);
            
            /*Loop through the result to gather all of the information from the 
            row in the database*/
            while (result.next()) {
                this.acctNo = result.getString("acctNo");
                this.custId = result.getString("Cid");
                this.acctType = result.getString("acctType");
                this.balance = result.getDouble("Balance");
            }
            
        } catch (SQLException e) {
            
            System.out.println("Error: " + e);
        
        } finally {
            
            /*Closes the connection to the database so that access can be gained 
            by others*/
            connect.close();
        
        }
    }
    
    /**
     * Connects to the database accesses the desired account and deposits to that 
     * account. Updates the database. and finally closes the connection. This
     * method throws the sql exception.
     * @param acctNo
     * @param depAmount
     * @throws SQLException
     */
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
        
        /* retrieves the balance of the current account */
        while (result.next()) {
            balance = result.getDouble("Balance");
        }
        
        /* updates the balance in this object and the database */
        newBalance = balance + depAmount;
        update = "Update Accounts Set Balance = '" + newBalance + "' Where acctNO = '" + acctNo + "';";
        updateSet = statement.executeUpdate(update);
        this.balance = newBalance;
        
        /* closes connection */
        connect.close();
    }
    
    /**
     * Withdraws funds from the current account. Throws an exception 
     * for insufficient funds
     * @param acctNo
     * @param withdrawal
     * @throws SQLException
     * @throws Exception
     */
    public void withdraw(String acctNo, double withdrawal) throws SQLException, Exception {

        Connection connect = acctConnect();
        Statement statement = connect.createStatement();
        ResultSet result = null;
        String sql = "Select balance From Accounts Where acctNO = '" + acctNo + "';";
        String update = null;
        int updateSet = 0;
        double balance = 0.00;
        double newBalance;

        result = statement.executeQuery(sql);
        
        /* gets balance of the current account from the database */
        while (result.next()) {
            balance = result.getDouble("Balance");
        }
        
        /* checks to see if the withdrawal amount is more than the balance
        and if so the exception is thrown and an insufficient funds message is 
        set */
        if (balance < withdrawal){
            this.message = "Insufficcient Funds";
            throw new Exception();
        }else{
        
        /* sets new balance and updates the current database account balance */
        newBalance = balance - withdrawal;
        update = "Update Accounts Set Balance = '" + newBalance + "' Where acctNo = '" + acctNo + "';";
        updateSet = statement.executeUpdate(update);
        this.balance = newBalance;
        
        }
        
        /* closes connection to database */
        connect.close();
    }
    
    /**
     * Transfers funds from one account to another by calling the withdrawal 
     * and deposit methods.
     * @param fromAcct
     * @param toAcct
     * @param transfer
     * @throws SQLException
     * @throws Exception
     */
    public void transfer(String fromAcct, String toAcct, double transfer) throws SQLException, Exception {
        
        /* Call withdraw method on from account */
        withdraw(fromAcct, transfer);
        
        /* deposit to to account */
        deposit(toAcct, transfer);
        
        /* both methods close their own database connection so it is not necessary to do so here */
    }
    
    /**
     * Sets up new account for existing customers 
     * @param acctNo
     * @param custID
     * @param type
     * @param balance
     * @throws SQLException
     */
    public void estabAccount(String acctNo, String custID, String type, double balance) throws SQLException {
        
        /* Establish connection and update the database with a new row containing the new account info */
        Connection connect = acctConnect();
        Statement statement = connect.createStatement();
        String sql = "Insert Into accounts (acctNO, Cid, acctType, Balance) Values ('" + acctNo + "', " + custID + "', " + type + "', " + balance + "');";
        
        /* Execute Query and close connection */
        statement.executeUpdate(sql);
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
