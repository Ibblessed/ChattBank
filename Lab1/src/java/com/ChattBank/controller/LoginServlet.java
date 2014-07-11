/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ChattBank.controller;

import com.ChattBank.business.Account;
import com.ChattBank.business.Accounts;
import com.ChattBank.business.Customer;
import com.ChattBank.business.User;
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
 * @author Richard Davy
 */
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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

        String action = request.getParameter("action");
        String id = request.getParameter("id");
        String password = "";

        String message = "";

        if (action == null) {

            request.getRequestDispatcher("/Welcome.jsp").forward(request, response);

        } else if (action.equals("login")) {

            request.setAttribute("id", id);
            request.setAttribute("message", message);

            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
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

        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        List<Account> acctList = new ArrayList();
        String id = null;
        String password = "";

        session.setMaxInactiveInterval(-0);

        /* If action equals null direct user to Welcome.jsp so that customers don't 
         land here unintentionally */
        if (action == null) {

            request.getRequestDispatcher("/Welcome.jsp");

        } /* If action equals doLogin collect parameters and validate the customers
         id and password */ else if (action.equals("doLogin")) {

            id = request.getParameter("id");
            password = request.getParameter("password");
            
            /* Stores id in session attribute and use it to instantiate new customer
            and accounts objects */
            session.setAttribute("id", id);
            Customer customer = new Customer();
            Accounts accounts = new Accounts();

            try {
                
                /* set new customer information */
                customer.findDB(id);

                /* validates customer id with customer password to  */
                if (customer.login(password)) {
                    accounts.setCustAccounts(id);
                    acctList.addAll(accounts.getCustAccounts());

                    /* Store new customer and account list in session for use in the rest
                     of the application */
                    session.setAttribute("customer", customer);
                    session.setAttribute("acctList", acctList);
                    
                    /* direct the user to welcome users jsp after  */
                    request.setAttribute("message", customer.getMessage());
                    request.getRequestDispatcher("/welcomeUsers.jsp").forward(request, response);

                } else {
                    
                    /* If user password and id do not match the systems return them to the 
                    login page with an error message allowing them to attempt the login again. */
                    id = request.getParameter("id");
                    request.setAttribute("id", id);
                    request.setAttribute("message", customer.getMessage());
                    request.getRequestDispatcher("/login.jsp").forward(request, response);

                }
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        } else if (action.equals("newAcct")) {

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
