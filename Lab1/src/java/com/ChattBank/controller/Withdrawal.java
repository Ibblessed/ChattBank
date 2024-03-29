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
public class Withdrawal extends HttpServlet {

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
            out.println("<title>Servlet Withdrawal</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Withdrawal at " + request.getContextPath() + "</h1>");
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
        List acctNos = new ArrayList();
        String id = request.getParameter("id");
        String acctNo = request.getParameter("acctNo");
        String message = "";
        double withAmt = new Double(request.getParameter("withAmt"));

        try {
            
            /*We want to ensure that the id is valid and the withdrawal amount is greater than zero*/
            if (!id.isEmpty() && withAmt > 0) {
                
                /*Here we specify the account that we will be making the withdrawal from*/
                acct = new Account(acctNo);
                
                /*In the Account withdraw method if the balance is less than that of the withdrawal we throw a new exception*/
                try {
                    acct.withdraw(acctNo, withAmt);
                } catch (Exception ex) {
                    
                    /*Here we handle that exception by returning to the withdrawal page and displaying an
                    error message so that the customer understands that their funds were insufficient. */
                    
                    message = "We're Sorry But there seems to Have Been An Issue<br/>" + acct.getMessage();
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("/withdrawal.jsp").forward(request, response);
                    
                }
                
                /*Display that the withdrawal was successful and the newly updated balance*/
                message = "Thank you Your Withdrawal was successful. <br/> Your new balance for account " + acctNo + " is " + acct.getBalance() + ".";
                request.setAttribute("message", message);
                
                /*This will clear the currently stored information in the business object Accounts and reset the list to the newly updated 
                information*/
                accts = new Accounts();
                accts.clearAccounts();
                accts.setCustAccounts(id);
                accounts.addAll(accts.getCustAccounts());
                request.getSession().setAttribute("acctList",accounts);
                
                /*Forward back to the withdrawal page where the customer started we only do this after the session and the list
                is updated so that the drop down list shows the new balances*/
                request.getRequestDispatcher("/withdrawal.jsp").forward(request, response);

            } 
            /*If the withdrawal amount is less than 0 it is invalid*/
            else if (!id.isEmpty() && withAmt <= 0) {

                message = "Sorry But You Can't Set A Withdrawal Amount less than or equal to zero!";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/withdrawal.jsp").forward(request, response);

            } 
            /*This message will appear if the id is empty indicating that the user got to this page improperly */
            else {

                message = "We're Sorry Something Went Wrong Please Try Again.";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/withdrawal.jsp").forward(request, response);

            }

        } catch (SQLException ex) {
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