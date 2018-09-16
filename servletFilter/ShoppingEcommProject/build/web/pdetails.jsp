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

        <div class="container">
        	<div class="row">
               <div class="col-xs-4 item-photo">
                   <img style="max-width:100%;" src="./resources/images/${applicationScope.p.img}" />
                </div>
                <div class="col-xs-5" style="border:0px solid gray">
                    <!-- Datos del vendedor y titulo del producto -->
                    <h3>${applicationScope.p.description}</h3>    
                    <h5 style="color:#337ab7">BRAND-${applicationScope.p.brand}</h5>
        
                    <!-- Precios -->
                    <h6 class="title-price"><small>Product Price</small></h6>
                    <h3 style="margin-top:0px;">${applicationScope.p.price} Rs.</h3>
        
                      
                              
                             <form action="${pageContext.request.contextPath}/orderNow">

                    <!-- Botones de compra -->
                    <div class="section" style="padding-bottom:20px;">
                        <div>
                            <input type="hidden" value="${applicationScope.p.id}" name="pid"/>
                                
                            <%--  <input class="form-group" type="text" name="quantity" placeholder="quantity" required/>--%>
                        </div>
                        <button class="btn btn-success"><span style="margin-right:20px" class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Add To Cart</button>
                        <h6><a href="#"><span class="glyphicon glyphicon-heart-empty" style="cursor:pointer;"></span> Add To Cart</a></h6>
                    </div>   
                             </form>
                </div>                              
        
                <div class="col-xs-9">
                    <ul class="menu-items">
                        <li class="active">Details of Product</li>
                       
                       
                    </ul>
                    <div style="width:100%;border-top:1px solid silver">
                        <p style="padding:15px;">
                            <small>
                                ${applicationScope.p.description}<br>
                                Product Name -  <b> ${applicationScope.p.name}</b><br>
                                Product Brand-   <b>${applicationScope.p.brand}</b>
                            </small>
                        </p>
                       
                    </div>
                </div>		
            </div>
        </div> 
                            <br><br><br><br>
                                       <%@include file="footer.jsp" %>

    </body>
</html>
