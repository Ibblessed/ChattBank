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

/**
 *
 * @author AARONS
 */
public class Deposit extends HttpServlet {

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
            out.println("<title>Servlet Deposit</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Deposit at " + request.getContextPath() + "</h1>");
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
        
        Account acct;
        Accounts accts = null;
        List accounts = new ArrayList();
        String id = request.getParameter("id");
        String acctNo = request.getParameter("acctNo");
        String message = "";
        double depAmt = new Double(request.getParameter("depAmt"));
        
        try{
            
            /* Ensure that the user has entered a deposited amount greater than 0 */
            if (!id.isEmpty() && depAmt > 0) {

                /* Establish account to be deposited to */
                acct = new Account(acctNo);
                acct.deposit(acctNo, depAmt);
            
                /* Set message for a successful deposit */
                message = "Thank you Your deposit was successful. <br/> Your new balance for account " + acctNo + " is " + acct.getBalance() + ".";
                request.setAttribute("message", message);
                
                /*This will clear the currently stored information in the business object Accounts and reset the list to the newly updated 
                information*/
                accts = new Accounts();
                accts.clearAccounts();
                accts.setCustAccounts(id);
                accounts.addAll(accts.getCustAccounts());
                request.getSession().setAttribute("acctList",accounts);
                
                /* forward back to the deposit.jsp with updated information */
                request.getRequestDispatcher("/deposit.jsp").forward(request, response);
                
            }
            /* If the deposit amount is less than or equal to 0 return to the deposit page
            with an error message */
            else if (!id.isEmpty() && depAmt <= 0) {
                
                message = "Sorry But You Can't Set A Deposit Amount less than or equal to zero!";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/deposit.jsp").forward(request, response);
                
            }
            /* If id is empty and deposit amount is invalid */
            else{
                
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
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
