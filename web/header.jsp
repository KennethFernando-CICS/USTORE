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
                                    <li><a href="">T-shirt</a></li>
                                    <li><a href="">Windbreaker</a></li>
                                    <li><a href="">Jacket</a></li>

                                </ul>
                           </div>
                        </li>
                        <li><a href="register.jsp">Register</a></li>
                        <li><a href="login.jsp">Login</a></li>
                    </ul>
                </nav>
            </div>
        </header>
    </body>
</html>
