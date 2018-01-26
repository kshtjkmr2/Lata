<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="url"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Enter Products</title>
<style type="text/css">

body{
background: #cccccc;
}


</style>
</head>
<body>
	<table border="0px" align="center">
		<tr>
			<th>Enter your Product Details</th>

		</tr>

	</table>

	<div class="container wrapper">
		<div class="container">

			<c:url var="url" value="/admin/product/saveproduct" />
			<form:form action="${url}" modelAttribute="product" method="post"
				enctype="multipart/form-data">

				<div class="form-group">
					<label for="productid"></label>
					<form:hidden path="productid"></form:hidden>
					<form:errors path="productid" cssStyle="color:red"></form:errors>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-sm-2">
							<label for="name">Product name</label>
						</div>
						<div class="col-sm-8">
							<form:input path="name" class="form-control"
								placeholder="Product Name"></form:input>
						</div>
						<form:errors path="name" cssStyle="color:red"></form:errors>

					</div>
				</div>


				<div class="form-group">
					<div class="row">
						<div class="col-sm-2">
							<label for="manufacturer">Product Manufacturer</label>
						</div>
						<div class="col-sm-8">
							<form:input path="manufacturer" class="form-control"
								placeholder="Manufacturer"></form:input>
						</div>
						<form:errors path="manufacturer" cssStyle="color:red"></form:errors>
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-sm-2">
							<label for="price">Product Price</label>
						</div>
						<div class="col-sm-8">
							<form:input path="price" class="form-control" palceholder="Price"></form:input>
						</div>
						<form:errors path="price" cssStyle="color:red"></form:errors>
					</div>
				</div>


				<div class="form-group">
					<div class="row">
						<div class="col-sm-2">
							<label for="unitInStock">Unit In Stock</label>
						</div>
						<div class="col-sm-8">
							<form:input path="unitInStock" class="form-control"
								placeholder="Unit"></form:input>
						</div>
						<form:errors path="unitInStock" cssStyle="color:red"></form:errors>
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-sm-2">
							<label for="description">Enter Description</label>
						</div>
						<div class="col-sm-8">
							<form:input path="description" class="form-control"
								placeholder="Description"></form:input>
						</div>
						<form:errors path="description" cssStyle="color:red"></form:errors>
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-sm-2">
							<label for="image">Upload Image</label>
						</div>
						<div class="col-sm-4">
							<input type="file" name="image" class="form-control">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-sm-2">
							<label for="category">Select Category</label>
						</div>
						<div class="col-sm-3">
							<form:select path="category.categoryDetails" placeholder="Select"
								items="${categorydetails}" itemValue="categoryDetails"
								itemLabel="categoryDetails" />
								
						</div>
						<form:errors path="category" cssStyle="color:red"></form:errors>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-sm-2">
							<label for="supplier">Select Supplier</label>
						</div>
						<div class="col-sm-3">
							<form:select path="supplier.supname" placeholder="Select"
								items="${supplierdetails}" itemValue="supname"
								itemLabel="supname" />
						</div>
						<form:errors path="supplier" cssStyle="color:red"></form:errors>
					</div>
				</div>
				<input class="btn btn-primary btn-lg btn-block" type="submit"
					value="Add Product">

			</form:form>
		</div>
	</div>
	<p>
</body>
<%@ include file="footer.jsp"%>
</html>