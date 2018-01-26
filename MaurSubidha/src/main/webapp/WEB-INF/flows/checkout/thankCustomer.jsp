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
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Thank you for online Shopping!</h1>

                    <p>Your order will be shipped in four business days!</p>
                </div>
            </div>
        </section>

        <section class="container">
            <p><a href="<c:url value="/" />" class="btn btn-primary">OK</a></p>
        </section>
        </div>
        </div>
        <br><br><br><br>
</body>
<%@ include file="/WEB-INF/views/footer.jsp" %>
</html>