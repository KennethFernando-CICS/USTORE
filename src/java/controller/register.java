package controller;

import java.io.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

public class register extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        ServletContext context = getServletContext();
        Map<String, String> credentials = (Map) context.getAttribute("credentials");
        List<User> userList = (ArrayList) context.getAttribute("userList");
        
        try ( PrintWriter out = response.getWriter()) {
            credentials.put(user, pass);
            System.out.println("REGISTER: Put " + user + "in cred map.");
            User u = new User(user, pass); //create a new user object
            //set the attributes given by the user to the user object
            u.setFirstName(request.getParameter("fname"));
            u.setLastName(request.getParameter("lname"));
            u.setUsername(user);
            u.setPassword(pass);
            u.setEmail(request.getParameter("email"));
            userList.add(u); //add the user to the list of users
            //pass username password to login servlet
            request.getSession().setAttribute("username", user); //set the given username to be used for display in navbar
            RequestDispatcher view = request.getRequestDispatcher("index.jsp"); 
            view.include(request, response); //redirect user back to the index
        }
        catch(IOException e){
            response.sendError(440);
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
