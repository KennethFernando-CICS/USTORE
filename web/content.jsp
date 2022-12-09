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
    
    <body>
        <div class="content-container">
            <div class="image">
                <img src="images/growling-hang-front-yb-1229x1536.jpg" alt="Black T-shirt"/>
            </div>
            <div class="information">
                <div class="item-information">
                    <div class="item-name">
                        <h1>UST Growling Tiger T-shirt</h1>
                    </div>
                    <div class="other-info">
                        <h2>Price: <span>$4.99</span></h2>
                        <h3>Number of Stocks left: <span>93</span></h3>

                        <div class="selections">
                            <h4>Size Options:</h4>
                            <select>
                                <option value="N/A">Select a size:</option>
                                <option value="XS">XS</option>
                                <option value="S">S</option>
                                <option value="M">M</option>
                                <option value="L">L</option>
                                <option value="XL">XL</option>
                                <option value="XXL">XXL</option>
                            </select>
                        </div>
                    </div>
                    <div class="button">
                        <button><span class="button_top">Add to Cart</span></button>
                    </div>
                </div>
                <div class="recommendations">
                    <h1>Other items:</h1>
                </div>
            </div>
        </div>
    </body>
</html>