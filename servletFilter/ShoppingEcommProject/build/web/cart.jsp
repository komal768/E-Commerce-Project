
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
    <body>
            <%@include file="nav.jsp" %>

            
  
            <div class="container">
                
                <h2 class="well">Cart Information</h2>
  <p></p>      
  <form action="${pageContext.request.contextPath}/qUpdate" method="post">

  <table class="table table-hover well ">
    <thead>
      <tr>
      <th>Option</th>
<th>Name</th>
<th>Price</th>

<th>Quantity <input type="submit" value="Update"/></th>
        <th>image</th>

<th>total</th>
      </tr>
    </thead>
    
    
    <c:set var="total" value="0"></c:set>
<c:forEach var="c" items="${sessionScope.newCart}">
<c:set var="total" value="${total + c.p.price * c.quantity }"></c:set>
    
    <tbody>
    <c:if test="${emptyCart!=null}">
    <tr class="danger"><td colspan="6"><center><h3>No Product added to cart </h3></center></td> </tr>
    </c:if>

        
        
         <c:if test="${empty sessionScope.newCart}">
            <tr class="danger"><td colspan="6"><center><h3>No Product added to cart </h3></center></td> </tr></c:if>
                
          
  <tr>    
      <td align="center"><b><a href="${pageContext.request.contextPath}/deleteCartP?pid=${c.p.id}">Delete</a></b></td>
<td><c:out value="${c.p.name }"></c:out></td>
<td><c:out value="Rs.${c.p.price }"></c:out></td>
<td><input type="text" name="quantity" value="<c:out value="${c.quantity}"></c:out>"  style="width: 60px;"/></td>
        <td><img src="./resources/images/${c.p.img}" height="60px" width="60px"/></td>

    <td><c:out value="Rs.${c.p.price * c.quantity }"></c:out></td>

<td></td>

      </tr>
</c:forEach>
      
    <tr>

<td colspan="5" align="right">Sum</td>
<td><b>Rs.${total}</b></td>
</tr>



<br>
<tr><td colspan="3">
        <h4><a href="${pageContext.request.contextPath}/home">Continue Shopping</a></h4></td> &nbsp; <td colspan="3"><h4><a href="${pageContext.request.contextPath}/cartClear">Clear Cart</a></h4> </td></tr>
<tr><td colspan="6"><h3><center><a href="${pageContext.request.contextPath}/checkout">Checkout</a></center></h3></td></tr>
  
      
    </tbody>
  </table>
  </form>

</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
            
            
            
            
            
            
            
            
            
            
            
            
        
            <%@include file="footer.jsp" %>
    </body>
    
</html>