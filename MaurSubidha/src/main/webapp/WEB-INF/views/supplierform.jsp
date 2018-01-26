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
.buttun{
text-align:center; 
}

body{
background: #cccccc;
}


</style>
</head>
<body>

<table border="0px" align="center">
		<tr>
			<th>Enter your Supplier Details</th>

		</tr>

	</table>

	<div class="container wrapper">
		<div class="container">

			<c:url var="url" value="/admin/supplier/savesupplier" />
			<form:form action="${url}" modelAttribute="supplier" method="post"
				enctype="multipart/form-data">

				<div class="form-group">
					<label for="supid"></label>
					<form:hidden path="supid"></form:hidden>
					<form:errors path="supid" cssStyle="color:red"></form:errors>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-sm-2">
							<label for="supname">Supplier name</label>
						</div>
						<div class="col-sm-8">
							<form:input path="supname" class="form-control"
								placeholder="Supplier Name"></form:input>
						</div>
						<form:errors path="supname" cssStyle="color:red"></form:errors>

					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-sm-2">
							<label for="address">Supplier Address</label>
						</div>
						<div class="col-sm-8">
							<form:input path="address" class="form-control"
								placeholder="Supplier Address"></form:input>
						</div>
						<form:errors path="address" cssStyle="color:red"></form:errors>

					</div>
				</div>
				<!-- <div class="form-group">
					<div class="row">
						<div class="col-sm-2">
							<label for="image">Upload Image</label>
						</div>
						<div class="col-sm-4">
							<input type="file" name="image" class="form-control">
						</div>
					</div>
				</div> -->
				<div class="buttun">
				<input class="btn btn-primary" type="submit"
					value="Add supplier">
				</div>
				</form:form>
				</div>
				</div>
<br>
<br>
<br>
<br>
<br>				
</body>
<%@ include file="footer.jsp" %>
</html>