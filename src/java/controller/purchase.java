package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class purchase extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            System.out.println(request.getParameter("action"));
            if("removeOnly".equals(request.getParameter("action")))
            {
                System.out.println("went here");
                RequestDispatcher rd = request.getRequestDispatcher("remove");
                rd.forward(request, response);
            }                       
            else
            {
                HttpSession session = request.getSession();
                session.setAttribute("purchaseTotal", "");
                session.setAttribute("purchasedList", "");
                User user = (User)session.getAttribute("user");
                Map<String,String[]> cart = user.getCart();    
                List<Product> productList = (ArrayList)request.getServletContext().getAttribute("productList");
                String[] cartDetails = {};
                int quantity = 0;
                String selectedSize = "";
                double total = 0;
                double subTotal = 0;
                List<String> purchased = new ArrayList<>();
                List<String> toDelete = new ArrayList<>();
                List<Integer> toReduce = new ArrayList<>();
                String[] checkboxValues = request.getParameterValues("checkbox_hidden");
                System.out.println(Arrays.toString(checkboxValues));            
                int cbCtr = 0;
                for (String cartId : cart.keySet()) 
                {                             
                    if(Integer.parseInt(checkboxValues[cbCtr]) == 1)
                    {
                        cartDetails = cart.get(cartId);
                        quantity =   Integer.parseInt(cartDetails[0]);
                        selectedSize = cartDetails[1];
                        int productId = Integer.parseInt(cartDetails[2]);
                        Product product = productList.get(productId);

                        if(Integer.parseInt(request.getParameter("quantity")) != quantity)
                        {
                            quantity = Integer.parseInt(request.getParameter("quantity"));
                        }

                        if(quantity < product.getStock() && quantity > 0)
                        {
                            subTotal = product.getPrice() * quantity;
                            String purchasedDets = quantity + "x [" + selectedSize + "] " + product.getName() + "(" + String.format("%.2f", subTotal) + ")";
                            purchased.add(purchasedDets);
                            total += subTotal;
                            toDelete.add(cartId);
                            toReduce.add(productId);
                            System.out.println("PURCHASED: P:" + product + ",QTY:" + quantity + ",SIZE:" + selectedSize);

                        }
                        else
                        {
                            response.sendError(420);
                        }
                    }
                    cbCtr++;
                }
                if(!purchased.isEmpty() && !toDelete.isEmpty())
                {
                    int i = 0;
                    for(Integer prodId : toReduce)
                    {
                        cartDetails = cart.get(toDelete.get(i));
                        Product reduceStock = productList.get(prodId);
                        int curStock = reduceStock.getStock();
                        int reduction = Integer.parseInt(cartDetails[0]);
                        reduceStock.setStock(curStock - reduction);
                        System.out.println("REDUCE: P:" + reduceStock + " removed from cart. Stock:" + reduceStock.getStock());
                        i++;
                    }

                    for(String deleteCartId : toDelete)
                    {                    
                        cart.remove(deleteCartId);                    
                    }
                    session.setAttribute("purchaseTotal",total);
                    session.setAttribute("purchasedList", purchased);
                    response.sendRedirect("success-buy.jsp");
                }
                else
                {
                    response.sendRedirect("/USTORE/");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
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
