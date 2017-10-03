/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.factorizerjspservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dbb09
 */
@WebServlet(name = "FactorizerServlet", urlPatterns = {"/FactorizerServlet"})
public class FactorizerServlet extends HttpServlet {

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
        //A list for our factors
        List<Integer> factorList = new ArrayList<>();
        // A sum to help us calc whether the number is perfect
        int factorSum = 0;
        boolean isPrime = false;
        boolean isPerfect = false;
        //get the input from user, convert to int
        String input = request.getParameter("numberToFactor");
        int numberToFactor = Integer.parseInt(input);
        //factor the number (not the best way to do this...)
        for (int i = 1; i < numberToFactor; i++) {
            if (numberToFactor % i == 0) {
                //i goes into nTF evenly, so it is a factor, add it to the list
                //and add it to the sum
                factorList.add(i);
                factorSum += i;
            }
        }
        
        if (factorSum == numberToFactor) {
             isPerfect = true;   
            }
        
        if (factorSum == 1) {
            isPrime = true;
        }
        // set all results as attributes on the req so they are available
        // to result.jsp
        request.setAttribute("numberToFactor", numberToFactor);
        request.setAttribute("factors", factorList);
        request.setAttribute("isPrime", isPrime);
        request.setAttribute("isPerfect", isPerfect);
        // get the req dispatcher for result.jsp, forward req to result.jsp
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }

//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet FactorizerServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet FactorizerServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
