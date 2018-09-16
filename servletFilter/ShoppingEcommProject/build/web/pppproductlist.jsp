
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Product List page</title>
<script type="text/javascript" src="./resources/js/jquery-3.2.1.js"></script>

<script type="text/javascript" src="./resources/js/bootstrap.min.js"></script>

    <!-- Bootstrap Core CSS -->
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="./resources/css/theme.css" rel="stylesheet">


</head>
    <body>
           <%@include file="nav.jsp" %>

            
            
             <table class="table table-hover">
    <thead>
      <tr>
        <th>Name</th>
        <th>Brand</th>
        <th>Description</th>
        <th>price</th>
        <th>image</th>
        
        
      </tr>
    </thead>
    <tbody>
        <c:if test="${empty applicationScope.plist}">
            <tr class="danger"><td colspan="5"><center><h3>No Products</h3></center></td> </tr></c:if>
        
                          <c:forEach items="${applicationScope.plist}" var="p">

      <tr class="success">
          
        <td>${p.name}</td>
        <td>${p.brand}</td>
                <td>${p.description}</td>
        <td>${p.price}</td>
        <td><a href="${pageContext.request.contextPath}/getProduct?pid=${p.id}"><img src="./resources/images/${p.img}" height="60px" width="60px"/></a></td>
        
                 
     
      </tr>
       </c:forEach>
    </tbody>
  </table>
               <%@include file="footer.jsp" %>

    </body>
</html>
