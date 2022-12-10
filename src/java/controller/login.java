package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected int i = 5;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = getServletContext();
        Map<String, String> credentials = (Map) context.getAttribute("credentials");
        List<User> userList = (ArrayList)context.getAttribute("userList");
                
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            //get the username/password input
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            
            if (pass.equals(credentials.get(user))) {
                for (User selectedUser : userList) 
                {
                    if(user.equals(selectedUser.getUsername()))
                    {
                        System.out.println("LOGIN: Logged in " + selectedUser + " as user.");
                        request.getSession().setAttribute("user", selectedUser); 
                        
                        request.getSession().setAttribute("username", user);                
                        response.sendRedirect("/USTORE/"); //redirect the user back to the main homepage
                    }
                }                               
                               
            } else {
                if(i != 0){ //refresh the page whenever the user puts a wrong credential
                    response.sendRedirect("/USTORE/login.jsp");
                    i--; //up to 5 wrong inputs are only allowed
                }
                else    
                    response.sendError(440); //if the user failed to give the correct pass 5 times
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
