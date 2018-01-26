
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ include file="header.jsp" %>
<head>

<style type="text/css">
.bs-docs-header{
 background:#7171C6;
 }
#featuresimage{
 text-align:center;
}
#featurestext{
 text-align:center;
}
.row
.tabbable img.thumbnail{
margin:0 20px 10px 0;
}
</style>
</head>
<html>
<body>
<div class="bs-docs-header" id="content" tabindex="-1">
<div class="container">

</div> 
</div>

<div class="carousal">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Carousal indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>   
        <!-- Wrapper for carousal items -->
        <div class="carousel-inner">
            <div class="item active">
                <img src="resources/images/maxresdefault.jpg"  alt="First Slide">
            </div>
            <div class="item">
                <img src="resources/images/Jeans-1.jpg"  alt="Second Slide">
            </div>
            <div class="item">
                <img src="resources/images/babyclothes3.jpg"  alt="Third Slide">
            </div>
        </div>
        <!-- Carousal controls -->
        <a class="carousel-control left" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <a class="carousel-control right" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
    </div>
    <div class="container">
	<div class="row" id="featuresHeading">
	 <div class="col-12">
	 <h2>More Features</h2>
	 <p class="lead">This is an exciting website to buy authentic trending new outfits and accessories.</p>
	 </div>
	 </div>
</div> 
 <br>
  <div>
	<div class="row" id="featuresHeading">
	 <div class="col-12">
	 <img src="resources/images/girls.jpg" alt="img" >
	 </div>
	 </div>
</div>
<br> 
<div class="row" id="featuresimage">
  <div class="col-xs-4 col-md-4 feature">
    <div class="panel">
	  <div class="panel-heading">
	  <h3 class="panel-title"><b>Sports Wear</b></h3>
	</div>
	<img src="resources/images/SAU3033_1000_1.jpg" style="width:200px" alt="img" class="img-circle">
	<p><b><i>Lightweight shoes with mesh upper,cushioning and flexible toe box for prolonged running.</i></b></p>
	<a href="Trending.jsp" target="_blanck" class="btn btn-default btn-block"><strong>SHOP BY SPORT</strong></a>
  </div>
</div>

 
  <div class="col-xs-4 col-md-4 feature">
    <div class="panel">
	  <div class="panel-heading">
	  <h3 class="panel-title"><b>Formal Wear</b></h3>
	</div>
	<img src="resources/images/gettyimages-476979420.jpg" alt="img" class="img-circle" style="width:200px">
	<p><b><i>Set a trend and let your style be a spark that brings the party to life & sparkle it.</i></b></p>
	<a href="Summers.jsp" target="_blanck" class="btn btn-default btn-block"><strong>STYLE WITH FORMALS</strong></a>
  </div>
</div>

  <div class="col-xs-4 col-md-4 feature">
    <div class="panel">
	  <div class="panel-heading">
	  <h3 class="panel-title"><b>Casual Wear</b></h3>
	</div>
	<img src="resources/images/cas.jpg" alt="img" class="img-circle" style="width:200px">
	<p><b><i>Sneakers.Loafers.Boots.Printed Espadrilles.High-Tops.Colour Block.Slip-Ons</i></b></p>
	<a href="winters.jsp" target="_blanck" class="btn btn-default btn-block"><strong>IN THE SPOTLIGHT</strong></a>
  </div>
</div>
</div>
<br>
 <div>
	<div class="row" id="featuresHeading">
	 <div class="col-12">
	 <img src="resources/images/boys.jpg" alt="img">
	 </div>
	 </div>
</div> 
</div>
<br>
</body>
<%@ include file="footer.jsp" %>
</html>
