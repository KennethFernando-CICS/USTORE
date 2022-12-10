<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/success-style.css" />
        <link rel="stylesheet" href="css/nav-bar.css" />
        <title>Successful Purchase</title>
    </head>
    <body>
        <header>
            <div class="container">
                <a href="/USTORE"><img src="images/logo.png" alt="logo" class="logo" /></a>
            </div>
        </header>
        <div class="content-container">            
            <h1>The purchase is successful!</h1>
            <h3>The following items were purchased:</h3>
            <ul>
                <%
                    String totalString = String.valueOf(session.getAttribute("purchaseTotal"));
                    Double total = Double.parseDouble(totalString);
                    List<String> purchasedList = (ArrayList)session.getAttribute("purchasedList");
                    for(String item: purchasedList )
                    {
                %>                                                              
                    <li><span><%= item%></span></li>
                
                <%
                    }
                %>
            </ul>
                <h3>The total amount is: <span class="total">$<%= String.format("%.2f", total) %></span></h3>
            <h2>Thank you for purchasing our UST Merchandise, we hope to see you again!</h2>
            <h2>To return to the homepage, Please <a href="/USTORE/">click here.</a></h2>
        </div>
    </body>
</html>