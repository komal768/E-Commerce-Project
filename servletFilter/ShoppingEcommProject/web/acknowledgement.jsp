
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
           
  <script type="text/javascript" src="./resources/js/jquery-3.2.1.js"></script>

<script type="text/javascript" src="./resources/js/bootstrap.min.js"></script>

    <!-- Bootstrap Core CSS -->
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="./resources/css/theme.css" rel="stylesheet">

    </head>
    <body>
        <%@include file="nav.jsp" %>
      <div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Thank you for purchasing!</h1>

                    <h3><a href="${pageContext.request.contextPath}/home">Continue Shopping</a></h3>
                </div>
            </div>
        </section>
        <%@include file="footer.jsp" %>
    </body>
</html>
