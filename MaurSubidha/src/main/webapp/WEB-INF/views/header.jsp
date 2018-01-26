<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="url" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ecommerce Site</title>
<meta name="viewport" content="width=device-width,initial-scale=1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Angular js -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script> -->

<!-- JQuery -->
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
    
<link href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" rel="stylesheet">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 



<style type="text/css">
.glyphicon.glyphicon-shopping-cart {
    font-size: 20px;
}
.glyphicon.glyphicon-search{
font-size: 20px;
}
body{
background:#867979;
}
.header{
background:white;
}
</style>
</head>
<body>

      <nav class="navbar navbar-inverse ">
           <div class="container-fluid">
                 <div class="navbar-header">
                       <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                             <span class="sr-only">Toggle navigation</span>
                             <span class="icon-bar"></span>
                             <span class="icon-bar"></span>
                             <span class="icon-bar"></span>
                       </button>
                         <a class="navbar-brand">MAYUR</a>
                </div>
                   <div id="navbarCollapse" class="collapse navbar-collapse">
                       <ul class="nav navbar-nav">
                       <url:url value="/home" var="url"></url:url>
                             <li class="active"><a href="${url}">Home</a></li>
                             <url:url value="/about" var="url"></url:url>
                              <li><a href="${url}">About Us</a> </li>
                              
                              <security:authorize access="hasRole('ROLE_ADMIN')">
                              <li class="dropdown">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">Add<b class="caret"></b></a>
                       <ul role="menu" class="dropdown-menu">
                             <url:url value="/admin/product/productform" var="url"></url:url>
                             <li><a href="${url}">Add New Product</a></li>
                             <url:url value="/admin/category/categoryform" var="url"></url:url>
                              <li><a href="${url}">Add New Category</a></li>  
                              <url:url value="/admin/supplier/supplierform" var="url"></url:url>
                              <li><a href="${url}">Add New Supplier</a></li>                  
                       </ul>
                            </li>
                            </security:authorize>
                            <li class="dropdown">
                                 <a data-toggle="dropdown" class="dropdown-toggle" href="#">View<b class="caret"></b></a>
                       <ul role="menu" class="dropdown-menu">
                             <url:url value="/all/product/productlist" var="url"></url:url>
                             <li><a href="${url}">All Products</a></li>
                            <security:authorize access="hasRole('ROLE_ADMIN')">
                             <url:url value="/admin/category/categorylist" var="url"></url:url>
                              <li><a href="${url}">Category</a></li>  
                              <url:url value="/admin/supplier/supplierlist" var="url"></url:url>
                              <li><a href="${url}">Supplier</a></li>
                              </security:authorize>                  
                       </ul>
                            </li>
                             <li class="dropdown">
                               <a data-toggle="dropdown" class="dropdown-toggle" href="#">Category<b class="caret"></b></a>
                       <ul class="dropdown-menu">
                     <c:forEach var="c" items="${categories}">
                       <li><a href="<c:url value="/all/product/productByCategory?searchCondition=${c.categoryDetails}"></c:url>">${c.categoryDetails}</a>
                       </li>
                       </c:forEach>      
                       </ul>
                        </li>
                             
                     </ul>
  <ul class="nav navbar-nav navbar-right">
          <c:if test="${pageContext.request.userPrincipal.name!=null}">
          <li><a href="">Welcome: ${pageContext.request.userPrincipal.name}</a></li>
          </c:if>
          <c:if test="${pageContext.request.userPrincipal.name==null}">
                  <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#"><span class="glyphicon glyphicon-user"> Account</span><b class="caret"></b></a>
                    <ul role="menu" class="dropdown-menu">
                     <url:url value="/login" var="url"></url:url>
                        <li><a href="${url}">Login</a></li>
                         <url:url value="/all/registrationform" var="url"></url:url>
                        <li><a href="${url}">Sign Up</a></li>
                    </ul>
                </li>
                </c:if>
                 <c:if test="${pageContext.request.userPrincipal.name!=null}">
                 <li>
                 
                 <a href="<c:url value="/j_spring_security_logout"></c:url>"><span class="glyphicon glyphicon-log-out">&nbsp</span>Logout</a>
                 
                 </li>
                 </c:if>
            </ul>
        <form role="search" class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" placeholder="search" class="form-control">
                    <button type="button" class="btn btn-info">
          <span class="glyphicon glyphicon-search"></span>
        </button>
                </div>
         </form>
            
     </div>
     </div>
  </nav>

</body>
</html>