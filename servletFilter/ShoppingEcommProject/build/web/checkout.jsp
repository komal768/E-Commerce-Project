

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>checkout</title>
      
  <script type="text/javascript" src="./resources/js/jquery-3.2.1.js"></script>

<script type="text/javascript" src="./resources/js/bootstrap.min.js"></script>

    <!-- Bootstrap Core CSS -->
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="./resources/css/theme.css" rel="stylesheet">

        </head>
        <body>
            <%@include file="nav.jsp" %>
            <div class="container ">
            <h1>Cheakout Now</h1>
        
            <form  class="form-signin jumbotron" action="${pageContext.request.contextPath}/saveOrder" method="post">

            <fieldset>
                <legend><h2>Customer Information</h2></legend>

                <table  class="table table-striped"cellpadding="5" cellspacing="5">
                    <tr>
                        <td>Customer Name</td>
                        <td><input type="text" class="form-control" name="customerName" required="true" placeholder="Customer Name"/></td>
                    </tr>


                    <tr>
                        <td>Customer Email</td>
                        <td><input type="text"class="form-control" name="email" required="true" placeholder="Customer Email"/></td>
                    </tr>             

                </table>

            </fieldset>
                    <br>
            <fieldset>
                <legend><h2>Additional Information</h2></legend>
                <table class="table table-striped">
<tr>
                        <td>Order Information</td>
                        <td> <input type="text" class="form-control" name="name" placeholder="Order-label"/></td>
                    </tr>
                    <tr>
                        <td>Customer Address</td>
                        <td> <textarea class="form-control" rows="5" name="customerAddress"  placeholder="Customer Address"></textarea></td></tr>
                    <tr>
                        <td>City</td>
                        <td>   <input type="text" class="form-control" name="city" placeholder="city"/></td>
                    </tr>
                     <tr>
                        <td>Phone</td>
                        <td> <input path="phone"class="form-control" placeholder="phone"/></td>
                    </tr>


                    <tr>
                        <td> &nbsp;</td>
                        <td><input type="submit" class="btn-primary" value="Submit"/></td>
                    </tr>




                </table>
            </fieldset>



        </form>
            </div>
            <br><br><br><br><br><br>
            <%@include file="footer.jsp" %>
        </body>
    
    
</html>
