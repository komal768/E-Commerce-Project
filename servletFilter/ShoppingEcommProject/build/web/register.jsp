<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <script type="text/javascript" src="./resources/js/jquery-3.2.1.js"></script>
        <script type="text/javascript" src="./resources/js/bootstrap.min.js"></script>

        <!-- Bootstrap Core CSS -->
        <link href="./resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="./resources/css/theme.css" rel="stylesheet">
        <title>Register Page</title>
    </head>


    <%@include file="nav.jsp" %>
    <div class="container well">
        <h1 class="well">Registration Form</h1>
        
        <div class="col-lg-12 well">
            <div class="row">
                <form action="register" method="post">
                    <div class="col-sm-12">
                        <div class="row">
                            <div class="col-sm-6 form-group">
                                <label>User Name</label>
                                <input type="text" placeholder="Enter User Name Here.." class="form-control" name="un" required>
                            </div>
                            <div class="col-sm-6 form-group">
                                <label>Password</label>
                                <input type="text" placeholder="Enter Password Here.." class="form-control" name="pass" required>
                            </div>
                        </div>					

                        <div class="form-group">
                            <label>Full Name</label>
                            <input type="text" placeholder="Enter Full Name Here.." class="form-control" name="fn" required>
                        </div>				
                        <div class="form-group">
                            <label>Phone Number</label>
                            <input type="text" placeholder="Enter Phone Number Here.." class="form-control" name="ph" required>
                        </div>		
                        <div class="form-group">
                            <label>Email Address</label>
                            <input type="text" placeholder="Enter Email Address Here.." class="form-control" name="email" required>
                        </div>	
                        <div class="form-group">
                            <label>Address</label>
                            <textarea placeholder="Enter Address Here.." rows="3" class="form-control" name="address" required></textarea>
                        </div>	

                        <input type="submit" class="btn btn-lg btn-info" value="Submit"/>
                    </div>
                </form> 
            </div>
        </div>
    </div>
    <br><br><br><br>
    <%@include file="footer.jsp" %>


</html>