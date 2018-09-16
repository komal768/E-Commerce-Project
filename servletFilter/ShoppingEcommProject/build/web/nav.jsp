<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="home.jsp">StyleStore</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="home.jsp">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Men <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <%--<li><a href="#">Footwear</a> </li>
          <li><a href="#">Top Wear</a></li>
          <li><a href="#">Bottom Wear</a></li>--%>
            <c:forEach items="${applicationScope.list}" var="ll">
                <li><a href="${pageContext.request.contextPath}/get?id=${ll.id}">${ll.name}</a></li>
            </c:forEach>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Women <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <%--<li><a href="#">Footwear</a> </li>
          <li><a href="#">Top Wear</a></li>
          <li><a href="#">Bottom Wear</a></li>--%>
           <c:forEach items="${applicationScope.list2}" var="ll2">
                 <li><a href="${pageContext.request.contextPath}/get?id=${ll2.id}">${ll2.name}</a></li>
            </c:forEach>
        </ul>
      </li>
    </ul>
      
    <ul class="nav navbar-nav navbar-right">
                      <c:if test="${sessionScope.user!=null}">

        <li class="navbar-brand glyphicon glyphicon-user">${sessionScope.user}</li>
                      </c:if>
        
        
        
        
        
        
        <c:set var="srk" value="0"></c:set>
<c:forEach var="c" items="${sessionScope.newCart}">
    <c:set var="srk" value="${srk +  c.quantity }"></c:set></c:forEach>

        
    <li style="color: whitesmoke; padding-bottom: 0px;"><a href="${pageContext.request.contextPath}/showCart"><img  src="./resources/images/cart_1.png" height="20px" width="40px"/>ShowCart &nbsp;&nbsp; ${srk}</a><li>
        
            
            
            
            
            
        <c:if test="${sessionScope.user==null}">
        <li><a href="register.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
       </c:if> 
              <c:if test="${sessionScope.user!=null}">

      <li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </c:if>
    </ul>
  </div>
</nav>