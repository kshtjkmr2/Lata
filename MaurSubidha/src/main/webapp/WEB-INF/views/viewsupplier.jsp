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

      
          <%-- <c:url  value="/resources/images/${supplier.sup_Id}.png" var="url"/>
          <img src="${url}" height="250" width="250"><p> --%>
         
   SUPPLIER NAME:           ${supplier.sup_name}<p>
   SUPPLIER ADDRESS:        ${supplier.address}<p>
    

 <url:url value="/all/supplier/supplierlist" var="url"></url:url>
 <span class="btn btn-info"><a href="${url }">Back</a></span>
 <br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
</body>
<%@ include file="footer.jsp" %>
</html>