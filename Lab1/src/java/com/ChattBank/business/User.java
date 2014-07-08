/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ChattBank.business;

import java.io.Serializable;

/**
 *
 * @author Richard Davy
 */
public class User implements Serializable {
    
    private String id = "admin";
    private String password = "123";
    private String message = "";
    
    public User(){
    }
    
    public User(String id, String password){
        this.id = id;
        this.password = password;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getMessage() {
        return message;
    }   
    
    public boolean validateUser(String id, String password){
        boolean yes_no = false;
            if (id.equals(this.id) && password.equals(this.password)){
                this.message = "Great You Are Logged In!";
                yes_no = true;
            }else{
                this.message = "Your Email and Password Don't seem to match our records Please Try again.";
                yes_no = false;
            }
        return yes_no;
    }
}
