package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

public class addToCart extends HttpServlet {

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
        
        if (request.getSession().getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
        }       
        else
        {       
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Progma", "no-cache");
            response.setHeader("Expires", "0");    
                
            try ( PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                String quantity = request.getParameter("quantity");
                String productId = request.getParameter("productId");
                String selectedSize = request.getParameter("selectedSize");

                String[] toAdd = {quantity,selectedSize,productId};

                User user = (User)request.getSession().getAttribute("user");            
                Map<String,String[]> cart = user.getCart();
                String cartId = String.valueOf(cart.size());
                cart.put(cartId, toAdd);
                if(cart.containsKey(cartId))
                {
                    System.out.println("ADD: PID:" + productId + ",QTY:" + toAdd[0] + ",SIZE:" + toAdd[1]);
                }
                response.sendRedirect(request.getHeader("referer"));
            }
            catch(NullPointerException npe)
            {
                System.out.println("NPE");            
            }
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
