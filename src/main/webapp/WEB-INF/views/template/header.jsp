<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>ABC car rental company</title>

<!-- Angular.JS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

<!-- JQuery -->
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>


<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- MaCarouselin CSS -->
<link href="<c:url value="/resources/css/carousel.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">

<!-- Main CSS -->
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">


<link
	href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css"
	rel="stylesheet">
<script>
	var contextPath = "${pageContext.request.contextPath}";
</script>
</head>
<!-- NAVBAR
================================================== -->
<body>
	<div class="navbar-background">
		<div class="navbar-wrapper">
			<div class="container">

				<nav class="navbar navbar-inverse navbar-static-top">
					<div class="container">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse" data-target="#navbar"
								aria-expanded="false" aria-controls="navbar">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="<c:url value="/" />">ABC car
								rental</a>
						</div>
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav">
								<li><sec:authorize access="hasAnyRole('ROLE_ADMIN')">
										<a href="<c:url value="/allcustomers" />">Manage customers</a>
									</sec:authorize></li>
									<li><sec:authorize access="hasAnyRole('ROLE_ADMIN')">
										<a href="<c:url value="/admin/vehicles/addvehicle" />">Add new vehicle</a>
									</sec:authorize></li>
								
								<li><sec:authorize access="hasAnyRole('ROLE_ADMIN')">
										<a href="<c:url value="/admin/vehicles" />">Manage Vehicles</a>
									</sec:authorize></li>
								
								<li><sec:authorize access="hasAnyRole('ROLE_CUSTOMER')">
										<a href="<c:url value="/myreservations" />">My
											reservations</a>
									</sec:authorize></li>
								<li><sec:authorize
										access="hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER')">
										<a href="<c:url value="/customerdetail" />">Account
											settings</a>
									</sec:authorize></li>
								<li><sec:authorize
										access="!hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER')">
										<a href="<c:url value="/login" />">Login</a>
									</sec:authorize></li>
								<li><sec:authorize
										access="hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER')">
										<a href="<c:url value="/logout" />">Logout</a>
									</sec:authorize></li>
								<%-- <li><a href="<c:url value="/about" />">About Us</a></li>
								<li><sec:authorize access="hasRole('ROLE_ADMIN')">
										<p>If you are admin only</p>
									</sec:authorize></li> --%>
								<li class="welcometext"><sec:authorize
										access="hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER')">
										Welcome: <strong>${username}</strong>
									</sec:authorize></li>
							</ul>
							<ul class="nav navbar-nav pull-right">

							</ul>
						</div>
					</div>
				</nav>

			</div>
		</div>
	</div>