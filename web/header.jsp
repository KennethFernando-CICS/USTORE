<%@page import="java.util.*"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/nav-bar.css" />
        <link rel="styleshett" href="css/index.css" />
        <link rel="icon" type="image/x-icon" href="images/icon.png"/>
    </head>
    <body>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Progma", "no-cache");
            response.setHeader("Expires", "0");
        %>
        <header>
            <div class="container">
                <a href="/USTORE"><img src="images/logo.png" alt="logo" class="logo" /></a>
                <nav>
                    <ul>
                        <li><a href="/USTORE">Home</a></li>
                        <li><a href="cart.jsp">Cart</a></li>    
                        <li><a href="">Categories</a>
                            <div class="sub-menu">
                                <ul class="dropdown">
                                    <%
                                        Map<String, Product> cMap = (HashMap)application.getAttribute("categoryMap");
                                        for(String key: cMap.keySet())
                                        {                                       
                                    %>
                                        <li><a href="/USTORE/?category=<%= key%>"><%= key%></a></li>
                                    <%                                    
                                        }
                                    %>
                                </ul>
                           </div>
                        </li>
                        <%
                            if(session.getAttribute("username") == null)
                            {
                        %>
                            <li class="nav-li"><a href="register.jsp">Register</a></li>
                            <li class="nav-li"><a href="login.jsp">Login</a></li>
                        <%
                            }
                            else if(session.getAttribute("username") != null){
                        %>
                            <li>
                                <a>Welcome ${sessionScope.username}
                                    <div class="sub-menu">
                                        <ul class="dropdown">
                                            <%
                                                String parameters = "";
                                                Map<String,String[]> parameterMap = (HashMap)request.getParameterMap();
                                                for (String key : parameterMap.keySet()) 
                                                {
                                                    parameters += key + "=" + parameterMap.get(key)[0];
                                                }
                                                //System.out.println(parameters);
                                                
                                                if(parameters == "")
                                                {
                                            %>
                                                    <li><a href="logout?origin=<%= request.getRequestURL() %>">Logout</a></li>
                                            <%
                                                }
                                                else
                                                {
                                            %>
                                                    <li><a href="logout?origin=<%= request.getRequestURL() %>?<%= parameters %>">Logout</a></li>
                                            <%
                                                }
                                            %>
                                            
                                        </ul>
                                    </div>
                                </a>
                            </li>
                        <%
                            }
                        %>
                    </ul>
                </nav>
            </div>
        </header>
    </body>
</html>
