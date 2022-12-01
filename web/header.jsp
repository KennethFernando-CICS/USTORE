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
        <header>
            <div class="container">
                <a href="/USTORE"><img src="images/logo.png" alt="logo" class="logo" /></a>
                <nav>
                    <ul>
                        <li><a href="">Home</a></li>
                        <li><a href="">Cart</a></li>    
                        <li><a href="">Categories</a>
                            <div class="sub-menu">
                                <ul class="dropdown">
                                    <li><a href="">Item1</a></li>
                                    <li><a href="">Item2</a></li>
                                    <li><a href="">Item3</a></li>
                                    <li><a href="">Item4</a></li>
                                    <li><a href="">Item5</a></li>
                                </ul>
                           </div>
                        </li>
                        <li><a href="register.jsp">Sign up</a></li>
                        <li><a href="login.jsp">Login</a></li>
                    </ul>
                </nav>
            </div>
        </header>
    </body>
</html>
