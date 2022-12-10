<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/nav-bar.css" />
        <link rel="stylesheet" href="css/item-page-style.css" />
        <title>Content</title>
    </head>

    <%        int productId = Integer.parseInt(request.getParameter("productId"));
        List<Product> productList = null;
        productList = (ArrayList) request.getServletContext().getAttribute("productList");
        Product shownProduct = productList.get(productId);
    %>

    <body>
        <div class="content-container">
            <div class="image">
                <img src="images/<%= shownProduct.getPictureName()%>" alt="Black T-shirt"/>
            </div>
            <div class="information">
                <div class="item-information">
                    <form action="" id="addToCart">
                        <div class="item-name">
                            <h1><%= shownProduct.getName()%></h1>
                        </div>                       
                        <div class="other-info">
                            <h2>Price: <span>$<%= shownProduct.getPrice()%></span></h2>
                            <div class="quantity-container">
                                <label for="quantities">Quantity: <input name="quantity" type="number" min="1" value="1" max="<%= shownProduct.getStock()%>" required>
                                    <%= shownProduct.getStock()%> available items</span></label>
                            </div>
                            <div class="selections">
                                <h4>Size Options:</h4>
                                
                                <input name="productId" type="hidden" value="<%= productId %>">                                
                                <select name="selectedSize" required>
                                    <option value="" disabled selected>Select a size:</option>
                                    <%
                                        List<String> Sizes = shownProduct.getSizeList();
                                        for (String size : Sizes) 
                                        {
                                    %>
                                            <option value="<%= size%>"><%= size%></option>
                                    <%            
                                        }
                                    %>
                                </select>
                                
                            </div>
                        </div>                        
                        <div class="button">
                            <button><span class="button_top">Add to Cart</span></button>
                        </div>
                    </form>
                </div>
                <div class="recommendations">
                    <h1>Other items:</h1>
                    <div class="recommendations-container"> 
                        <%
                            String category = shownProduct.getCategory();
                            Map<String, List<Product>> categoryMap = (HashMap) application.getAttribute("categoryMap");
                            productList = categoryMap.get(category);
                            for (int i = 0; i < productList.size(); i++) {
                                Product currentProduct = productList.get(i);
                                if (currentProduct == shownProduct) {
                                    continue;
                                }
                        %>
                        <div class="product">
                            <a href="content.jsp?productId=<%= currentProduct.getProductId()%>">    
                                <img alt="product image" src="images/<%= currentProduct.getPictureName()%>">
                                <a href="content.jsp?productId=<%= currentProduct.getProductId()%>" id="pName"><%= currentProduct.getName()%></a>
                                <p id="pPrice">$<%= currentProduct.getPrice()%></p>
                                <p id="pStock">In Stock:<%= currentProduct.getStock()%></p>
                            </a>
                        </div>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>