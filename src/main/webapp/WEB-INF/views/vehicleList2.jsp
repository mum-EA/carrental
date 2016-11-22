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
<title>Add Vehicle</title>
</head>
<body>
	
	<%-- <c:forEach items="${vehicles }" var="vehicle">
	<span>
				${vehicle.vehicleId }<br/>
				${vehicle.brand }<br/>
				${vehicle.dailyPrice }<br/>
				<td>${vehicle.manufacturedYear }</td>
				${vehicle.numberOfSeats }<br/>
				${vehicle.plateNumber }<br/>
				${vehicle.status }<br/>
				${ vehicle.vehicleType}<br/>
				<c:if test="${vehicle.status == 'true' }">
					<a href = " <c:url value='/rentReservation?id=${vehicle.vehicleId}' />" >Reserve </a><br/>
				</c:if>
	</span>
	</c:forEach> --%>
	
	<c:forEach items="${vehicles }" var="vehicle">
	<div style="float: left; padding: 10px ;width: 300px; height:300px">
			<p><img class = "img-circle" src="data:image/png;base64,${vehicle.base64imageFile}" width="400" height="300" /></p>
			<p>Vehicle Id : ${vehicle.vehicleId }</p>
			<p>Vehicle Brand : ${vehicle.brand }</p>
			<p>Vehicle Daily Price : ${vehicle.dailyPrice }</p>
			<p> Manufactured year: ${vehicle.manufacturedYear }</p>
			<p>Number of seats : ${vehicle.numberOfSeats }</p>
			<p>Plate Number : ${vehicle.plateNumber }</p>
			<p>Status : ${vehicle.status }</p> 
			<p>Type of Vehicle : ${ vehicle.vehicleType}</p>
			
			<p>	<c:if test="${vehicle.status == 'Available' }">
					<a href = " <c:url value='/rentReservation?id=${vehicle.vehicleId}' />" >Reserve </a><br/>
				</c:if></p>
		</div>
</c:forEach>
	<%-- <h1>Vehicle List</h1>
	<table border=1>
		<tr>
			<th>Vehicle Id</th>
			<th>Brand</th>
			<th>Daily price</th>
			<!-- <th>Manufactured Year</th> -->
			<th>Number Of Seats</th>
			<th>Plate Number</th>
			<th>Status</th>
			<th>Vehicle Type</th>
		</tr>
		<c:forEach items="${vehicles }" var="vehicle">
			<tr>
				<td>${vehicle.vehicleId }</td>
				<td>${vehicle.brand }</td>
				<td>${vehicle.dailyPrice }</td>
				<td>${vehicle.manufacturedYear }</td>
				<td>${vehicle.numberOfSeats }</td>
				<td>${vehicle.plateNumber }</td>
				<td>${vehicle.status }</td>
				<td>${ vehicle.vehicleType}</td>
				<c:if test="${vehicle.status == 'true' }">
					
					<td> <a href = " <c:url value='/rentReservation?id=${vehicle.vehicleId}' />" >Reserve </a> </td>
				</c:if>
			</tr>
		</c:forEach>
	</table> --%>


	<%-- <h1>Reservation List</h1>
	<table border=1>
		<tr>
			<th>ReservationId</th>
			<th>VehicleId</th>
			<!-- <th>Total Price</th> -->
			<th>pick Up date</th>
			<th>return date</th>
			<th>From</th>
			<th>To</th>
		</tr>
		<c:forEach items="${reservations }" var="reservation">
			<tr>
				<td>${reservation.reservationId}</td>
				<td>${reservation.vehicle.vehicleId}</td>				
				<td>${reservation.totalPrice}</td>
				<td>${reservation.pickupDate}</td>
				<td>${reservation.returnDate }</td>
				<td>${reservation.locationfrom }</td>
				<td>${reservation.locationto }</td>
					<td> <a href = " <c:url value='/editReservation/${reservation.reservationId}' />" >Edit </a> </td>
						<td> <a href="<c:url value='/removeReservation/${reservation.reservationId}' />" >Delete </a> </td>
					
		</c:forEach>
	</table>
	<a href='<c:url value = '/makePayment' />'>Make Payment</a> --%>
</body>
</html>