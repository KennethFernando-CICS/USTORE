<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<!DOCTYPE html>
<html lang="en">
    
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/nav-bar.css" />
        <link rel="stylesheet" href="css/index.css" />
        <title>Index</title>
    </head>

    <body>
        <div class="content-container">
            <%
                List<Product> productList = (ArrayList)request.getServletContext().getAttribute("productList");
                for (int i = 0; i < productList.size(); i++) {
                    Product currentProduct = productList.get(i);
                    
            %>
            <div class="product">
                <img alt="product image" src="<%= currentProduct.getPictureName()%>">
                <p><%= currentProduct.getName()%></p>
                <p>$<%= currentProduct.getPrice()%></p>
                <p><%= currentProduct.getSizeString()%></p>
                <p>In Stock:<%= currentProduct.getStock()%></p>
            </div>
            <%
                }
             %> 
        </div>

    </body>

</html>