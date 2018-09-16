<%-- 
    Document   : home
    Created on : Oct 8, 2017, 8:43:21 AM
    Author     : Bhakti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Style Store Home page</title>
<script type="text/javascript" src="./resources/js/jquery-3.2.1.js"></script>

<script type="text/javascript" src="./resources/js/bootstrap.min.js"></script>

    <!-- Bootstrap Core CSS -->
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="./resources/css/theme.css" rel="stylesheet">


   

</head>
    <%@include file="nav.jsp" %>

<body >
    
    
    
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="./resources/images/banner.jpg" alt="Los Angeles">
    </div>

    <div class="item">
      <img src="./resources/images/banner2.jpg" alt="Chicago">
    </div>

    <div class="item">
      <img src="./resources/images/banner3.jpg" alt="New York">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
  
    <br>
    <br>
&nbsp;&nbsp;&nbsp;
<a href="#"> <img src="./resources/images/pic5.jpg" class="img-rounded" alt="Cinque Terre" width="304" height="236"></a>
   &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
 <a href="#">  <img src="./resources/images/pic2.jpg" class="img-rounded" alt="Cinque Terre" width="304" height="236"></a>
    &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
 <a href="#">  <img src="./resources/images/pic3.jpg" class="img-rounded" alt="Cinque Terre" width="304" height="236"></a>
   &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;

<a href="${pageContext.request.contextPath}/get?id=3">   <img src="./resources/images/pic4.jpg" class="img-rounded" alt="Cinque Terre" width="304" height="236"></a>

   <br>
   <br><br><br> <br>
   <br><br><br>
   <%@include file="footer.jsp" %>
</body>

</html>
