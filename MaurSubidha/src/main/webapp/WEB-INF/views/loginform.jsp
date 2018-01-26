<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="url" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<style type="text/css">
body{
background: #cccccc;
}
span.psw {
    float: right;
    padding-top:0px;
}
.glyphicon.glyphicon-log-in {font-size: 30px;}
.btn.btn-primary{font-size: 20px;}
</style>

</head>
<body>
${error}
${logout}
${registrationSuccess}
	<form action="<c:url value="/j_spring_security_check"/>" method="post">
<div class="modal-dialog">
	  <div class="modal-content">
	    <div class="modal-header">
	     
	     <h4 class="modal-title"><span class="glyphicon glyphicon-log-in">&nbsp</span>Please Fill the Required for Login</h4>
	   </div>
         <div class="modal-body">
         <div class="form-group has-feedback">
    <label class="control-label">Username</label>
    <input type="text" class="form-control" placeholder="Username"  name="j_username"/>
    <i class="glyphicon glyphicon-user form-control-feedback"></i>
             </div>
             
          <div class="form-group has-feedback">
         <label class="control-label"><b>Password</b></label><br>
         <input type="password" class="form-control" placeholder="Enter Password" name="j_password" />
         <i class="glyphicon glyphicon-lock form-control-feedback"></i>
         </div>
         
         <span class="psw"> <a href="#">Forgot password?</a></span>
         <br>
		 <div class="modal-footer">	  
		   <button class="btn btn-primary" type="submit" value="submit">Login</button>
		 </div>
	   </div>
	</div>
  </div>
  
</form>
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