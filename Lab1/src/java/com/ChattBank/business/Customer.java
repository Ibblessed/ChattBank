/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ChattBank.business;

import java.io.Serializable;
import java.sql.*;

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

    /**
     * No arg constructor that sets the default value of all
     * customer properties to an empty string value.
     */
    public Customer() {
        this.custId = "";
        this.custPassword = "";
        this.custFirstName = "";
        this.custLastName = "";
        this.custAddress = "";
        this.custEmail = "";
    }
    
    /**
     * Sets the customer Id for the current customer
     * @param custId 
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }
    
    /**
     * Sets the password for the current customer
     * @param custPassword 
     */
    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }
    
    /**
     * Sets the current customer first Name
     * @param custFirstName 
     */
    public void setCustFirstName(String custFirstName) {
        this.custFirstName = custFirstName;
    }

    /**
     * Sets the current customer last name
     * @param custLastName 
     */
    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }
    
    /**
     * Sets the current customer address
     * @param custAddress 
     */
    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }
    
    /**
     * Sets the current customer email
     * @param custEmail 
     */
    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }
    
    /**
     * Returns current customer Id
     * @return String
     */
    public String getCustId() {
        return custId;
    }
    
    /**
     * Returns Current customer password
     * @return String
     */
    public String getCustPassword() {
        return custPassword;
    }

    /**
     * Returns current customer first name
     * @return String
     */
    public String getCustFirstName() {
        return custFirstName;
    }

    /**
     * Returns current customer last name
     * @return String
     */
    public String getCustLastName() {
        return custLastName;
    }

    /**
     * Returns current customer address
     * @return String
     */
    public String getCustAddress() {
        return custAddress;
    }
    
    /**
     * Returns current customer email
     * @return String
     */
    public String getCustEmail() {
        return custEmail;
    }

    /**
     * Returns current message
     * @return String
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Accepts customer and compares it to the password on file for the current
     * customer Id if they match the file then the return is true allowing
     * for the customer to gain access to the system if false however a new 
     * error message is set telling the customer that their credentials didn't 
     * match.
     * @param custPassword
     * @return boolean
     * @throws SQLException 
     */
    public boolean login(String custPassword) throws SQLException {
        boolean yes_no = false;
        
        /* Verify password against database password for the userId */
        if (custPassword.equals(this.custPassword)) {
            this.message = "Thank you, you are logged in.";
            yes_no = true;
        } else {
            this.message = "Sorry Your Login Information seems to be incorrect.";
            yes_no = false;
        }
        
        /* Returns true or false based on the condition statement above */
        return yes_no;
    }

    /**
     * Establishes connection with the database containing the customer information 
     * @return Connection
     */
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
    
    /**
     * Takes the customer Id and retrieves the information from the customers
     * data table and stores it in the properties of the customer object.
     * @param custID
     * @throws SQLException 
     */
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

    /**
     * Takes in the parameters of the customer database and inserts the parameters taken into 
     * the database for the addition of customers to the database.
     * @param custID
     * @param custPassword
     * @param custFirstName
     * @param custLastName
     * @param custAddress
     * @param custEmail
     * @throws SQLException 
     */
    public void insertDB(String custPassword, String custFirstName, String custLastName, String custAddress, String custEmail) throws SQLException {
        Connection con = custConnect();
        Statement statement;
        ResultSet result;
        int resultVal;
        String sql = "INSERT INTO Customers (custPassword, custFirstName, custLastName, custAddress, custEmail) VALUES ('" + custPassword
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

    /**
     * Takes in customer id and locates the customer in the database, performs
     * an sql update and deletes the customer from the database.
     * @param custID
     * @throws SQLException 
     */
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
