<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Login page</title>
<script type="text/javascript" src="./resources/js/jquery-3.2.1.js"></script>

<script type="text/javascript" src="./resources/js/bootstrap.min.js"></script>

    <!-- Bootstrap Core CSS -->
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="./resources/css/theme.css" rel="stylesheet">
    <link href="./resources/css/login.css" rel="stylesheet">

</head>
                      <%@include file="nav.jsp" %>
<div class="container">
    <div class="row jumbotron">
        <center><h3 style="color: darkgreen;">${success}</h3></center>
                <center><h3 style="color: darkred;">${logout}</h3></center>

        <center><h3 style="color: red;">${error}</h3></center>
t
        <div class="col-sm-6 col-md-4 col-md-offse-4">
            <h1 class="text-center login-title">Sign in</h1>
            <div class="account-wall">
                <img class="profile-img" src="./resources/images/login.png"
                    alt="">
                <form class="form-signin" action="login" method="post">
                    <input type="text" class="form-control" placeholder="Email" name="email" required autofocus>
                    <input type="password" class="form-control" placeholder="Password" name="password" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">
                    Sign in</button>
                <label class="checkbox pull-left">
                   &nbsp;&nbsp; &nbsp;&nbsp;<input type="checkbox" value="remember-me">
                    Remember me
                </label>
                <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
                </form>
            </div>
            <a href="register.jsp" class="text-center new-account">Create an account </a>
        </div>
    </div>
</div>
                      <br><br><br><br><br>
                      <%@include file="footer.jsp" %>
</html>