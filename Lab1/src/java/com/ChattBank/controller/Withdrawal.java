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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        Accounts accts = new Accounts();
        List accounts = new ArrayList();
        List acctNos = new ArrayList();
        String id = request.getParameter("id");
        String acctNo = request.getParameter("acctNo");
        String message = "";
        double withAmt = new Double(request.getParameter("withAmt"));

        try {
            
            accts.setCustAccounts(id);
            accounts.addAll(accts.getCustAccounts());
            
            for (int i = 0; i < accounts.size(); i++) {
                acct = (Account) accounts.get(i);
                acctNos.add(acct.getAcctNo());
            }
            
            if (!id.isEmpty() && acctNos.contains(acctNo) && withAmt > 0) {

                acct = new Account(acctNo);
                acct.withdraw(acctNo, withAmt);
                message = "Thank you Your Withdrawal was successful. <br/> Your new balance for account " + acctNo + " is " + acct.getBalance() + ".";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/withdrawal.jsp").forward(request, response);
                
            }else if (!id.isEmpty() && acctNos.contains(acctNo) && withAmt <= 0) {
                
                message = "Sorry But You Can't Set A Withdrawal Amount less than or equal to zero!";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/withdrawal.jsp").forward(request, response);
                
            }else{
                
                message = "We're Sorry Something Went Wrong Please Try Again.";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/withdrawal.jsp").forward(request, response);
                
            }
            
        }catch(SQLException ex){
            log("Problem: " + ex + ".");
        }
        
        accounts.clear();
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
