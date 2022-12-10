<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/nav-bar.css" />
        <link rel="stylesheet" href="css/login.css" />
        <link rel="icon" type="image/x-icon" href="images/icon.png"/>
        <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet"  type='text/css'>
        <title>Register</title>
    </head>

    <body>
        <header>
            <div class="container">
                <a href="/USTORE"><img src="images/logo.png" alt="logo" class="logo" /></a>
            </div>
        </header>

        <div class="login-container"> 
            <h1>REGISTER</h1>
            <div class="form-container">
                <p>By filling out this form you agree to the <a href="privacy">Privacy Agreement</a> and <a href="user">User Agreement</a></p>           
                <form action="register" method="POST">
                    <fieldset>
                        <label for="fname">First Name: <input placeholder="First Name" class="input" name="fname" type="text" required /></label>
                        <label for="lname">Last Name: <input placeholder="Last Name" class="input" name="lname" type="text" required /></label>
                        <label for="username">Username: <input placeholder="Username" class="input" name="username" type="text" required /></label>
                        <label for="email">Email Address: <input placeholder="Email" class="input" name="email" type="text" required /></label>
                        <label for="password">Password: <input placeholder="Password" class="input" name="password" type="password" required /></label>
                        <input type="checkbox" />By clicking this button, you agree to have your information stored for advertisement purposes
                        <br>
                        <input type="checkbox" />just click this button
                        <br>
                        <input type="checkbox" />I dunno this is just a button
                        <br>
                        <button class="register"> Register </button>
                        <h4>Already have an account? <a href="login.jsp">Click Here!</a></h4>
                    </fieldset>
                </form>
            </div>
            <div class="others-container">
                <div class="or">
                    <div class="bar"></div>
                    <h3>or you can use other credentials</h3>
                    <div class="bar"></div>
                </div>
                <div class="other-buttons">
                    <button class="others"> <i class="fa fa-facebook"></i> Facebook </button>
                    <button class="others"> <i class="fa fa-google"></i> Gmail </button>
                    <button class="others"> <i class="fa fa-twitter"></i> Twitter </button>
                </div>
            </div>
        </div>
    </body>
</html>