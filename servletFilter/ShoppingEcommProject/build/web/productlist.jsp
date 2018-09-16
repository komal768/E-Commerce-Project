<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Product Page Desig</title>
        <link rZZzzel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script type="text/javascript" src="./resources/js/jquery-3.2.1.js"></script>

        <script type="text/javascript" src="./resources/js/bootstrap.min.js"></script>

        <!-- Bootstrap Core CSS -->
        <link href="./resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="./resources/css/theme.css" rel="stylesheet">
        <link href="./resources/css/test.css" rel="stylesheet">

    </head>
    <body>
        <%@include file="nav.jsp" %>
        <div class=container>
            <div class="container">
                <div class="row mar-bot-30">
                    <div class="col-md-12">
                        <div class="product-sec-tittle">
                            <h2 class="section-heading"><span>Feature</span> Product</h2>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <c:if test="${empty applicationScope.plist}">
                        <center><h3 style="color: red;">No Products</h3></center></c:if>
        

                    <c:forEach items="${applicationScope.plist}" var="p">

                        <div class="featured-product">
                            <div class="col-md-3">

                                <div class="product-box hover-circle text-center">

                                    <div class="product-item" >
                                        <figure ><img src="./resources/images/${p.img}" width="230" alt="product" /></figure>
                                        <p class="product-drisc">${p.description}</p>

                                        <h4 class="product-price">Price :${p.price}</h4>

                                        <a href="${pageContext.request.contextPath}/getProduct?pid=${p.id}" class="btn btn-default buy-now">View details</a>

                                    </div>

                                </div>
                            </div>

                        </c:forEach>
                    </div>
                </div>


            </div>
        </div>


        <%@include file="footer.jsp" %>
    </body>
</html>