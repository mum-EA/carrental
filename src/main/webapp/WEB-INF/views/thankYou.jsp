<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thank You</title>
</head>
<body>
	
	<h1>Thank you for your Reservation.</h1>
	----------------------------------
	
	
			
			
			
			<table class="table table-hover">
		<tr>
			<th>ReservationId</th>
			<th>VehicleId</th>
			<th>Total Price</th>
			<th>pick Up date</th>
			<th>return date</th>
			<th>From</th>
			<th>To</th>
			<th></th>
			<th></th>
		</tr>
	<c:forEach items="${revers }" var="reservation">
			<tr>
				<td>${reservation.reservationId}</td>
				<td>${reservation.vehicle.vehicleId}</td>				
				<td>${reservation.totalPrice}</td>
				<td>${reservation.pickupDate}</td>
				<td>${reservation.returnDate }</td>
				<td>${reservation.locationfrom }</td>
				<td>${reservation.locationto }</td>
		</tr>			
		</c:forEach>
			

</body>
</html>