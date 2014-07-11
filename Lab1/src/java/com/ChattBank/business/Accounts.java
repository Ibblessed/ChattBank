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
import java.util.ArrayList;

/**
 *
 * @author Richard Davy
 */
public class Accounts implements Serializable {
    
    private static ArrayList<Account> custAccounts = new ArrayList();
    private String userID = "";
    
    /**
     * No Arg Constructor
     */
    public Accounts(){
    
    }
    
    /**
     * Sets the user Id for current account object
     * @param userID from the userID data table 
     */
    public Accounts(String userID){
        this.userID = userID;
    }
    
    /**
     * Sets the user Id for the Current account
     * @param userID
     */
    public void setUserID(String userID){
        this.userID = userID;
    }
    
    /**
     * Returns the user Id for the current account 
     * @return String 
     */
    public String getUserID(){
        return this.userID;
    }
    
    /**
     * Accepts the customer id and establishes a connection to the account 
     * database. Using the customer id the method will get the acctNo from 
     * the database and store it in an arrrayList. If this customer id is 
     * associated with more than one account all accounts will be added to
     * the array list.
     * @param custId
     * @throws SQLException for the database query
     */
    public void setCustAccounts(String custId) throws SQLException{
        
        Connection connect = acctsConnect();
        Statement statement = null;
        ResultSet result = null;
        String sql = "SELECT acctNo FROM Accounts Where Cid = '" + custId + "';";
        
        try{
            statement = connect.createStatement();
            result = statement.executeQuery(sql);
            
            /*loop through the database and gather all account numbers associated
            with the current customer Id and add them to an array list*/
            while (result.next()){
                result.getRow();
                Account acct = new Account(result.getString("acctNo"));
                custAccounts.add(acct);                
            }
        }catch(SQLException e){
            System.out.println("Error: " + e);
        }
        
        /*Close the database connection*/
        connect.close();
    }
    
    /**
     * Returns the array list of customer accounts that are stored for 
     * the current customer id
     * @return ArrayList
     */
    public ArrayList<Account> getCustAccounts (){
        return custAccounts;
    }
    
    /**
     * Clears the current array list of accounts 
     */
    public void clearAccounts(){
        this.custAccounts.clear();
    }
    
    /**
     * Establishes a connection with the database containing the 
     * customer account information.
     * @return Connection for the connection to the database
     */
    public Connection acctsConnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println("Error: " + e);
        }
        
        Connection connect = null;
        
        try{
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ChattBank", "root", "sesame");
        }catch(SQLException e){
            System.out.println("Error: " + e);
        }
        
        return connect;
    }
    
//    public static void set(){
//        Accounts acc = new Accounts();
//        try {
//            acc.setCustAccounts("3006");
//        } catch (SQLException ex) {
//            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public static void main(String[] args){
//        Accounts.set();
//        
//        for (Account custAccount : custAccounts) {
//            System.out.println(custAccount.getCustId() + " " + custAccount.getAcctNo() + " " + custAccount.getAcctType()  + " " + custAccount.getBalance());
//        }
//    }            
}
