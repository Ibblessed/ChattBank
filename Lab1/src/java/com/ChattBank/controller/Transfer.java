/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ChattBank.controller;

import com.ChattBank.business.Account;
import com.ChattBank.business.Accounts;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AARONS
 */
public class Transfer extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Transfer</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Transfer at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /*Set variables and retrieve parameters for the actions needed to be completed*/
        Account acct;
        Accounts accts = null;
        List accounts = new ArrayList();
        String id = request.getParameter("id");
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String message = "";
        double tranAmt = new Double(request.getParameter("tranAmt"));
        
        try{
            
            /*ensuring that the session hasn't expired and that the transfer amount is greater 
            than zero*/
            if (!id.isEmpty() && tranAmt > 0) {

            
                acct = new Account();
                
                /*try catch clause to handle insufficient funds*/
                try {
                    
                    /*calling the transfer method to transfer the funds*/
                    acct.transfer(from, to, tranAmt);
                    
                } catch (Exception ex) {
                    
                    /*Here we catch a thrown exception for the transfer noting that the from account has insufficient
                    funds if the customer is attempting a transfer of more than the account has available*/
                    message = "We're Sorry but it Appears that the account you wish to transfer money from.<br/>"
                            + "Contains insufficient funds for the transfer";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("/transfer.jsp").forward(request, response);
                    
                }
            
                /*set up accounts to get updated data for the customer*/                
                Account fromAcct = new Account(from);
                Account toAcct = new Account(to);
                
                /*Set the message with the updated account balances*/
                message = "Thank you Your Transfer was successful. <br/> Your new balance for account " + from + " is " + fromAcct.getBalance() + ".<br/>"
                        + "And your new balance for account " + to + " is " + toAcct.getBalance() + ".<br/>";
                request.setAttribute("message", message);
                
                /*This will clear the currently stored information in the business object Accounts and reset the list to the newly updated 
                information*/
                accts = new Accounts();
                accts.clearAccounts();
                accts.setCustAccounts(id);
                accounts.addAll(accts.getCustAccounts());
                request.getSession().setAttribute("acctList",accounts);
                
                /*forward the user back to the transfer page with the new data*/
                request.getRequestDispatcher("/transfer.jsp").forward(request, response);
                
            }
            /*If tranAmt is less than or equal to zero the customer is asked to enter a new amount*/
            else if (!id.isEmpty() && tranAmt <= 0) {
                
                message = "Sorry But You Can't Set A Deposit Amount less than or equal to zero!";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/deposit.jsp").forward(request, response);
                
            }else{
                
                message = "We're Sorry Something Went Wrong Please Try Again.";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/deposit.jsp").forward(request, response);
                
            }
            
        }catch(SQLException ex){
            log("Problem: " + ex + ".");
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
