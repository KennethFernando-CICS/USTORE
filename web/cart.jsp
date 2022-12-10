<%@page import="model.*"%>
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/nav-bar.css" />
        <link rel="stylesheet" href="css/cart-style.css" />
        <title>Cart</title>
    </head>
    <%        if (session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
        }
        else
        {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Progma", "no-cache");
        response.setHeader("Expires", "0");
    %>
    <body>
        <div class="container-container"> <!--red color main container-->
            <div class="container-row">
                <%
                    User user = (User)session.getAttribute("user");
                    Map<String,String[]> cart = user.getCart();    
                    List<Product> productList = (ArrayList)request.getServletContext().getAttribute("productList");
                    String[] cartDetails = {};
                    String quantity = "";
                    String selectedSize = "";
                    double total = 0;
                    for (String cartId: cart.keySet()) 
                    {
                        cartDetails = cart.get(cartId);
                        quantity =   cartDetails[0];
                        selectedSize = cartDetails[1];
                        int productId = Integer.parseInt(cartDetails[2]);
                        Product product = productList.get(productId);
                        total += product.getPrice() * Integer.parseInt(quantity);
                        System.out.println("CART: P:" + product + ",QTY:" + quantity + ",SIZE:" + selectedSize);
                %>
                    <div class="content-container"> <!--for one row (2 items) (blue color)-->
                        <div class="selected">
                            <input type="checkbox" class="ch-box" name="cb_<%= cartId %>">
                        </div>
                        <div class="image">
                            <img src="images/<%= product.getPictureName() %>" alt="Black T-shirt"/>
                        </div>
                        <div class="information">
                            <div class="item-information">
                                <div class="item-name">
                                    <h1><%= product.getName() %></h1>
                                </div>
                                <div class="other-info">
                                    <h4>Size: <span><%= selectedSize %></span></h4>
                                    <h4>Price: <span>$<%= product.getPrice()%></span></h4>
                                    <h4>Number of Stocks left: <span><%= product.getStock() %></span></h4>
                                    <label for="quantity">Quantity: <input type="number" value="<%= quantity %>" min="1"></label>
                                </div>
                            </div>                       
                        </div>
                    </div>
                <%
                    }
                %>
            </div>
        </div>
        <form action="">
            <div class="buttons">
                <h2 class="total">Total price: <span class="total-price">$<%= total %></span></h2>
                <button>
                    <div class="svg-wrapper-1">
                        <div class="svg-wrapper">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24">
                            <path fill="none" d="M0 0h24v24H0z"></path>
                            <path fill="currentColor" d="M1.946 9.315c-.522-.174-.527-.455.01-.634l19.087-6.362c.529-.176.832.12.684.638l-5.454 19.086c-.15.529-.455.547-.679.045L12 14l6-8-8 6-8.054-2.685z"></path>
                            </svg>
                        </div>
                    </div>
                    <span>Purchase</span>
                </button>
                <button>
                    <div class="svg-wrapper-1">
                        <div class="svg-wrapper">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24">
                            <path fill="none" d="M0 0h24v24H0z"></path>
                            <path fill="currentColor" d="M1.946 9.315c-.522-.174-.527-.455.01-.634l19.087-6.362c.529-.176.832.12.684.638l-5.454 19.086c-.15.529-.455.547-.679.045L12 14l6-8-8 6-8.054-2.685z"></path>
                            </svg>
                        </div>
                    </div>
                    <span>Remove</span>
                </button>
            </div>
        </form>
    </body>
</html>
<%}%>