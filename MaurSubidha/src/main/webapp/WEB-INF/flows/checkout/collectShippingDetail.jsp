<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="url"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.btn.btn-primary{
 font-size: 20px;
}
</style>
</head>
<body>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Cutomer</h1>


            <p class="lead">Customer Details:</p>
        </div>
<div class="row">
<div class="col-sm-4">
        <form:form modelAttribute="order" class="form-horizontal">

        <h3>Shipping Address:</h3>

        <div class="form-group">
					<label for="apartmentnumber">Apartment Number</label>
					<form:input path="cart.customer.shippingAddress.apartmentnumber" class="form-control"/>
				</div>
				
        
       <div class="form-group">
					<label for="streetname">Street Name</label>
					<form:input path="cart.customer.shippingAddress.streetname" class="form-control"/>
				</div>

        <div class="form-group">
					<label for="city">City</label>
					<form:input path="cart.customer.shippingAddress.city" class="form-control"/>
				</div>

			
				<div class="form-group">
					<label for="country">Country</label>
					<form:input path="cart.customer.shippingAddress.country" class="form-control"/>
				</div>

				<div class="form-group">
					<label for="zipcode">Zip Code</label>
					<form:input path="cart.customer.shippingAddress.zipcode" class="form-control"/>
				</div>

        <input type="hidden" name="_flowExecutionKey" />

        <br/><br/>
 <div class="modal-footer">	
        <button class="btn btn-primary" name="_eventId_backToCollectCustomerInfo">Back</button>
        <button class="btn btn-primary" name="_eventId_cancel">Cancel</button>
        <input type="submit" value="Next" class="btn btn-primary" name="_eventId_shippingDetailCollected" />

        
</div>
        </form:form>
        </div>
        </div>
</div>
</div>
</body>
<%@ include file="/WEB-INF/views/footer.jsp" %>
</html>