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
    <title>Login</title>
</head>

<body>
    <header>
        <div class="container">
            <a href="/USTORE"><img src="images/logo.png" alt="logo" class="logo" /></a>
        </div>
    </header>

    <div class="login-container">
        <h1>Login</h1>
        <div class="form-container">
            <form action="" method="POST">
                <fieldset>
                    <label for="username">Username:</label><br>
                    <input placeholder="Username" class="input" name="username" type="text" required /><br>
                    <label for="password">Password:</label><br>
                    <input placeholder="Password" class="input" name="password" type="password" required /><br>
                    <button class="login"> Login </button>
                </fieldset>
            </form>
        </div>
    </div>
</body>

</html>