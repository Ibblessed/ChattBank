/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ChattBank.controller;

import com.ChattBank.business.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AARONS
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
        String id = "";
        String password = "";
        String message = "";
        
        if (action == null){
            request.getRequestDispatcher("/Welcome.jsp").forward(request, response);
        }else if (action.equals("login")){
            request.setAttribute("id", id);
            request.setAttribute("password", password);
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
        String action = request.getParameter("action");
        
        if(action == null){
            request.getRequestDispatcher("/Welcome.jsp");
        }else if(action.equals("doLogin")){
            String id = request.getParameter("id");
            String password = request.getParameter("password");
            String emptyPassword = "";
            
            request.setAttribute("id", id);
            request.setAttribute("password", emptyPassword);
            
            User user = new User();            
            boolean yes_no = user.validateUser(id, password);
            
            if(yes_no == true){
                request.setAttribute("message", user.getMessage());
                request.getRequestDispatcher("/welcomeUsers.jsp").forward(request, response);
                System.out.println(yes_no);
                System.out.println(user.getMessage());
            }else{
                request.setAttribute("message", user.getMessage());
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                System.out.println(yes_no);
                System.out.println(user.getMessage());
            }
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
