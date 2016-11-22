<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>

<%@ taglib prefix="imgtag" uri="/WEB-INF/tlds/img_tag"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<link href="<c:url value='/resources/css/bootstrap-min.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>

<body>
	<!-- Carousel
        ================================================== -->
	<%-- <div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="first-slide home-image"
					src="<c:url value="/resources/images/back1.jpg" />"
					alt="First slide">
			</div>
			<div class="item">
				<img class="second-slide home-image"
					src="<c:url value="/resources/images/back2.jpg" />"
					alt="Second slide">
			</div>
			<div class="item">
				<img class="third-slide home-image "
					src="<c:url value="/resources/images/back3.jpg" />"
					alt="Third slide">
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div> --%>
	<!-- /.carousel -->
<div class = "categoryMarker">
	<c:forEach items="${vehicles }" var="vehicle">
	<div class = "eachcategorymarker">
		<div style="float: left; padding-right: 100px; width: 300px; height: 300px">
		<div class="col-lg-4">
			<p><img class = "img-circle" src="data:image/png;charset=utf-8;base64,${vehicle.base64imageFile}" width="140" height="140" /></p>
			</div>
<%-- 			<p>Vehicle Id : ${vehicle.vehicleId }</p>
 --%>			<p class = "frontp">Vehicle Brand :  ${vehicle.brand }</p>
			<p class = "frontp">Vehicle Daily Price : ${vehicle.dailyPrice } </p>
			<p class = "frontp"> Manufactured year: ${vehicle.manufacturedYear }</p>
			<p class = "frontp">Number of seats : ${vehicle.numberOfSeats }</p>
			<p class = "frontp">Plate Number : ${vehicle.plateNumber }</p>
			<p class = "frontp">Status : ${vehicle.status }</p> 
			<p class = "frontp">Type of Vehicle :  ${ vehicle.vehicleType}</p>

			<p>
				<c:if test="${vehicle.status == 'Available' }">
					<a class = "reserve"
						href=" <c:url value='/rentReservation?id=${vehicle.vehicleId}' />">Reserve
					</a>
					<br />
				</c:if>
			</p>
		</div>
		</div>
	</c:forEach>
	</div>

	<!-- Marketing messaging and featurettes
        ================================================== -->
	<!-- Wrap the rest of the page in another container to center all the content. -->

		<%-- <div class="container">
			<!-- Three columns of text below the carousel -->
			<h2>Categories:</h2>
			<div class="row">
				<div class="col-lg-4">
					<a class="btn btn-default"
						href="<c:url value="/product/productList?searchCondition=Television" />"
						role="button"> <img class="img-circle"
						src="<c:url value="/resources/images/toyota.jpg"/>"
						alt="Instrument Image" width="140" height="140">
					</a>

					<h2>Toyota</h2>

				</div>



				<div class="col-lg-4">
					<a class="btn btn-default"
						href="<c:url value="/product/productList?searchCondition=Computers" />"
						role="button"> <img class="img-circle"
						src="<c:url value="/resources/images/mitsubishi.jpg"/>"
						alt="Instrument Image" width="140" height="140">
					</a>

					<h2>Mitsubishi</h2>

				</div>


				<div class="col-lg-4">
					<a class="btn btn-default"
						href="<c:url value="/product/productList?searchCondition=Cell Phones" />"
						role="button"> <img class="img-circle"
						src="<c:url value="/resources/images/lamburghini.jpg"/>"
						alt="Instrument Image" width="140" height="140">
					</a>

					<h2>Lamburghini</h2>

				</div>
			</div>
			<hr />
			<h2>Newly added cars</h2>
			<div class="row"></div>
		</div> --%>
<%-- <div class = "Customerssay">
<blockquote>
We are delighted to rent cars from ABC car rental company. Awesome service
<cite>Mr President</cite>
</blockquote>
</div> --%>
<div class = "footerarea2">
		<%@ include file="/WEB-INF/views/template/footer.jsp"%>
		</div>
</body>
</html>
