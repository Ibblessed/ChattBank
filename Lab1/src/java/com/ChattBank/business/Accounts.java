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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Richard Davy
 */
public class Accounts {
    
    private static ArrayList<Account> custAccounts = new ArrayList();
    private String userID = "";
    public Accounts(){
    
    }
    
    public Accounts(String userID){
        this.userID = userID;
    }
    
    public void setUserID(String userID){
        this.userID = userID;
    }
    
    public String getUserID(){
        return this.userID;
    }
    
    public void setCustAccounts(String custId) throws SQLException{
        Connection connect = acctsConnect();
        Statement statement = null;
        ResultSet result = null;
        String sql = "SELECT acctNo FROM Accounts Where Cid = '" + custId + "';";
        
        try{
            statement = connect.createStatement();
            result = statement.executeQuery(sql);
            
            while (result.next()){
                result.getRow();
                Account acct = new Account(result.getString("acctNo"));
                custAccounts.add(acct);                
            }
        }catch(SQLException e){
            System.out.println("Error: " + e);
        }
        connect.close();
    }
    
    public ArrayList<Account> getCustAccounts (){
        return custAccounts;
    }
    
    public void clearAccounts(){
        this.custAccounts.clear();
    }
    
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
