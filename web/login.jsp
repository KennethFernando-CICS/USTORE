<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@include file="header.jsp" %>--%> 

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/nav-bar.css" />
        <link rel="stylesheet" href="css/login.css" />
        <link rel="icon" type="image/x-icon" href="images/icon.png"/>
        <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet"  type='text/css'>
        <title>Login</title>
    </head>

    <body>
        <header>
            <div class="container">
                <a href="/USTORE"><img src="images/logo.png" alt="logo" class="logo" /></a>
            </div>
        </header>

        <div class="login-container">
            <h1>LOGIN</h1>
            <div class="form-container">
                <form action="" method="POST">
                    <fieldset>
                        <label for="username">Username:</label><br>
                        <input placeholder="Username" class="input" name="username" type="text" required /><br>
                        <label for="password">Password:</label><br>
                        <input placeholder="Password" class="input" name="password" type="password" required /><br>
                        <button class="login"> Login </button>
                        <h4>Forgot your <a href="">username</a> or <a href="">password</a>?</h4>
                        <h4>New to UStore? <a href="">Register</a>
                    </fieldset>
                </form>
            </div>
            
            <div class="others-container">
                <div class="or">
                    <div class="bar"></div>
                    <h3>or you can use other credentials</h3>
                    <div class="bar"></div>
                </div>

                <button class="others"> <i class="fa fa-facebook"></i> Facebook </button>
                <button class="others"> <i class="fa fa-google"></i> Gmail </button>
                <button class="others"> <i class="fa fa-twitter"></i> Twitter </button>
            </div>
            
        </div>

    </body>
</html>