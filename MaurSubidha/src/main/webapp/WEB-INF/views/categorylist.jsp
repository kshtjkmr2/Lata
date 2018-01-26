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
</style>

</head>
<body>
 <div class="container">

        <h2>Lists Of Category</h2>

<table border="0" cellspacing="330px" width="100%" >

<tr>
          
          <th>Category Name</th>
          <th>Update</th>
          <th>Delete</th>
</tr>

<c:forEach items="${categories}" var="c" >
<tr>
          <td>${c.categoryDetails}</td>
          <c:url value="/admin/category/editcategory/${c.cid }" var="url"/>
          <td><a href="${url }"><span class="glyphicon glyphicon-pencil"></span></a></td>
          
          <c:url value="/admin/category/deletecategory/${c.cid }" var="url"/>
          <td><a href="${url }"><span class="glyphicon glyphicon-trash"></span></a></td>
</tr>
</c:forEach>
</table>
</div>
<br>
<br>
<br>


</body>
<%@ include file="footer.jsp" %>
</html>