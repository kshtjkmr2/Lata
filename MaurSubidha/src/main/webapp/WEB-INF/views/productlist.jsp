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

<title>Insert title here</title>
<style type="text/css">
body{
background: #cccccc;
}
.btn.btn-primary{
 font-size: 20px;
 margin-top:30px;
 margin-left:1030px;
}
</style>

<script>
$(document).ready(function() {
	var searchCondition = '${searchCondition}';
	$('.table').DataTable({
	"lengthMenu" : [ [ 3, 5, 7, -1 ], [ 3, 5, 7, "All" ] ],
	"oSearch" : {
	"sSearch" : searchCondition
	}
	})
	});

</script>
</head>
<body>
<div class="container">
<h2>Lists Of Products</h2>
<table class="table table-hover">
<tr>
          <th>Image</th>
          <th>Product Name</th>
          <th>Unit</th>
          <th>Price</th>
          <th>Category</th>
          <th>Action</th>
</tr>

<c:forEach items="${products}" var="p" >
<tr>
          <c:url  value="/resources/images/${p.productid}.png" var="url"/>
          <td><img src="${url}" height="100" width="100"> </td>
          <td>${p.name}</td>
          <td>${p.unitInStock}</td>
          <td>${p.price }</td>
         <td>${p.category.categoryDetails }</td>
          <td>
          <c:url value="/all/product/viewproduct/${p.productid }" var="url"/>
          <a href="${url }"><span class="glyphicon glyphicon-info-sign"></span></a>
          
          <security:authorize access="hasRole('ROLE_ADMIN')">
          <c:url value="/all/product/editproduct/${p.productid }" var="url"/>
          <a href="${url }"><span class="glyphicon glyphicon-pencil"></span></a>
          
          <c:url value="/admin/product/deleteproduct/${p.productid }" var="url"/>
          <a href="${url }"><span class="glyphicon glyphicon-trash"></span></a>
          </security:authorize>
          </td>
</tr>
</c:forEach>
</table>
 <section class="container">
<security:authorize access="hasRole('ROLE_USER')">
<url:url value="/all/cart" var="url"></url:url>
<p><a href="${url}"><span class="btn btn-primary btn-large">My Cart</span></a></p>
</security:authorize>
</section>
</div>
<br>
<br>
<br>
<br>
<br>
</body>
<%@ include file="footer.jsp" %>
</html>