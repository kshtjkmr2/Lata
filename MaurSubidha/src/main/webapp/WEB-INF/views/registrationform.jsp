<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="url"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<%@ include file="header.jsp"%>
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
	<c:url var="url" value="/all/register" />
	<form:form action="${url}" modelAttribute="customer" method="post">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					
					<h4 class="modal-title"><span class="glyphicon glyphicon-user" id="new"></span>&nbsp Please Fill the Required for Sign Up</h4>
				</div>
				<div class="modal-body">
				<div class="form-group">
					<label for="customerid"></label>
					<form:hidden path="customerid"></form:hidden>
					<form:errors path="customerid" cssStyle="color:red"></form:errors>
				</div>
					<div class="form-group">
						<label for="firstname">Enter First Name</label>
						<form:input path="firstname" class="form-control"/>
						<form:errors path="firstname" cssStyle="colour:red"></form:errors>
					</div>
					<div class="form-group">
						<label for="lastname">Enter Last Name</label>
						<form:input path="lastname" class="form-control"/>
						<form:errors path="lastname" cssStyle="colour:red"></form:errors>
					</div>
					<div class="form-group">
						<label for="phone">Enter Phone No</label>
						<form:input path="phone" class="form-control"/>
						<form:errors path="phone" cssStyle="colour:red"></form:errors>
					</div>
					<div class="form-group">
						<label for="email">Enter Email</label>
						<form:input path="email" class="form-control" />
						<form:errors path="email" cssStyle="colour:red"></form:errors>
						<span style="color:red">${duplicateemail}</span>
					</div>
				    <div class="form-group">
						<label for="users.username">Enter Username</label>
						<form:input path="users.username" class="form-control" />
						<form:errors path="users.username" cssStyle="colour:red"></form:errors>
					    <span style="color:red">${duplicateusername}</span>
					</div>
					 <div class="form-group">
						<label for="users.password" >Enter Password</label>
						<form:input path="users.password" type="password" class="form-control" />
						<form:errors path="users.password" cssStyle="colour:red"></form:errors>
					</div>
					<h4>Enter Billing Address</h4>
					 <div class="form-group">
						<label for="billingAddress.apartmentnumber">Enter Apartmentnumber</label>
						<form:input path="billingAddress.apartmentnumber" class="form-control" />
						<form:errors path="billingAddress.apartmentnumber" cssStyle="colour:red"></form:errors>
					</div>
					<div class="form-group">
						<label for="billingAddress.streetname">Enter Streetname</label>
						<form:input path="billingAddress.streetname" class="form-control" />
						<form:errors path="billingAddress.streetname" cssStyle="colour:red"></form:errors>
					</div>
					<div class="form-group">
						<label for="billingAddress.city">Enter City</label>
						<form:input path="billingAddress.city" class="form-control" />
						<form:errors path="billingAddress.city" cssStyle="colour:red"></form:errors>
					</div>
					<div class="form-group">
						<label for="billingAddress.state">Enter Stare</label>
						<form:input path="billingAddress.state" class="form-control" />
						<form:errors path="billingAddress.state" cssStyle="colour:red"></form:errors>
					</div>
					<div class="form-group">
						<label for="billingAddress.country">Enter Country</label>
						<form:input path="billingAddress.country" class="form-control" />
						<form:errors path="billingAddress.country" cssStyle="colour:red"></form:errors>
					</div>
					<div class="form-group">
						<label for="billingAddress.zipcode">Enter zipcode</label>
						<form:input path="billingAddress.zipcode" class="form-control" />
						<form:errors path="billingAddress.zipcode" cssStyle="colour:red"></form:errors>
					</div>
					<h4>Enter Shipping Address</h4>
					 <div class="form-group">
						<label for="shippingAddress.apartmentnumber">Enter Apartmentnumber</label>
						<form:input path="shippingAddress.apartmentnumber" class="form-control" />
						<form:errors path="shippingAddress.apartmentnumber" cssStyle="colour:red"></form:errors>
					</div>
					<div class="form-group">
						<label for="shippingAddress.streetname">Enter Streetname</label>
						<form:input path="shippingAddress.streetname" class="form-control" />
						<form:errors path="shippingAddress.streetname" cssStyle="colour:red"></form:errors>
					</div>
					<div class="form-group">
						<label for="shippingAddress.city">Enter City</label>
						<form:input path="shippingAddress.city" class="form-control" />
						<form:errors path="shippingAddress.city" cssStyle="colour:red"></form:errors>
					</div>
					<div class="form-group">
						<label for="shippingAddress.state">Enter Stare</label>
						<form:input path="shippingAddress.state" class="form-control" />
						<form:errors path="shippingAddress.state" cssStyle="colour:red"></form:errors>
					</div>
					<div class="form-group">
						<label for="shippingAddress.country">Enter Country</label>
						<form:input path="shippingAddress.country" class="form-control" />
						<form:errors path="shippingAddress.country" cssStyle="colour:red"></form:errors>
					</div>
					<div class="form-group">
						<label for="shippingAddress.zipcode">Enter zipcode</label>
						<form:input path="shippingAddress.zipcode" class="form-control" />
						<form:errors path="shippingAddress.zipcode" cssStyle="colour:red"></form:errors>
					</div>
					
					
					<div class="modal-footer">
						
						<button class="btn btn-primary" type="submit" value="submit">Submit</button>
					</div>
				</div>
			</div>
		</div>
	</form:form>

</body>
<%@ include file="footer.jsp" %>
</html>