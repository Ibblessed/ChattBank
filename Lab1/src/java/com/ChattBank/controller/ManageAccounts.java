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
public class ManageAccounts extends HttpServlet {

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
            out.println("<title>Servlet ManageAccounts</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageAccounts at " + request.getContextPath() + "</h1>");
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
        
        /*Set variables by requesting parameters from url*/
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        String message;

        /*If the id is empty at this point the customer is redirected 
        to the login page and notified that their session has timed out*/
        if (id.equals("") && action.equals("manage")) {

            message = "Sorry Your Session Has Timed Out Please Login Again";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/login.jsp").forward(request, response);

        } 
        /*If id is not empty the customer is redirected to the manage accounts
        jsp so that they can select which action to take */
        else if (!id.isEmpty() && action.equals("manage")) {
            
            request.getRequestDispatcher("/manageAccounts.jsp").forward(request, response);
            
        }
        /*If the action is a deposit then the customer is redirected to the deposit form*/
        else if (!id.isEmpty() && action.equals("Deposit")){
                        
            message = "Hi There Welcome To Mobile Deposit";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/deposit.jsp").forward(request, response);
            
        }
        /*If the action is withdraw then the customer will be directed to the withdraw form*/
        else if (!id.isEmpty() && action.equals("Withdraw")){
            
            message = "Hi There Welcome To Mobile Withdrawal";
            request.setAttribute("message", message);           
            request.getRequestDispatcher("/withdrawal.jsp").forward(request, response);
            
        }
        /*If the action is transfer then the customer will be directed to the transfer form*/
        else if (!id.isEmpty() && action.equals("Transfer")){
            
            message = "Hi There Welcome To Mobile Transfer";
            request.setAttribute("message", message);           
            request.getRequestDispatcher("/transfer.jsp").forward(request, response);
            
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
