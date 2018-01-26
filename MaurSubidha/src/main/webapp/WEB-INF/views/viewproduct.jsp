<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="url"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

<title>Insert title here</title>
<style type="text/css">
body{
background: #cccccc;
}
.btn.btn-primary{
 font-size: 20px;
}
</style>

</head>
<body>
<div class="container" ng-app="cartApp">
<div class="row">
<div class="col-sm-4">
 <c:url  value="/resources/images/${product.productid}.png" var="url"/>
 <img src="${url}" height="300" width="300">
 </div>
 
 <div class="col-sm-5">
  PRODUCT NAME  :     ${product.name}<p> 
  PRICE         :     ${product.price}<p> 
  MANUFACTURER  :     ${product.manufacturer}<p> 
  DESCRIPTION   :     ${product.description}<p>
  <br>
  <br>
  
  <p ng-controller="cartCtrl">  
  <security:authorize access="hasRole('ROLE_USER')">
<url:url value="/all/product/productlist" var="url"></url:url>
<a href="${url}"><span class="btn btn-primary btn-large">Continue Shopping</span></a>
<a href="#" class="btn btn-primary btn-large" ng-click="addToCart(${product.productid})"><span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a>
<url:url value="/all/cart" var="url"></url:url>
<a href="${url}"><span class="btn btn-primary btn-large">My Cart</span></a>
</security:authorize>
</p>
</div>
</div>
</div>
</body>
<br/>
<br/>
<br/>
<br/>

<script src="<c:url value="/resources/js/controller.js" />"></script>
<%@ include file="footer.jsp" %>
</html>