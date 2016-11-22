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
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<p style ="color:red"><c:if test="${errorMessage==0}">You have not reserve any vehicles.</c:if></p>
	
	 <h1>Reservation List</h1>
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
		<c:forEach items="${reservations }" var="reservation">
			<tr>
				<td>${reservation.reservationId}</td>
				<td>${reservation.vehicle.vehicleId}</td>				
				<td>${reservation.totalPrice}</td>
				<td>${reservation.pickupDate}</td>
				<td>${reservation.returnDate }</td>
				<td>${reservation.locationfrom }</td>
				<td>${reservation.locationto }</td>
				
				<%-- <td> <a href = " <c:url value='/editReservation/${reservation.reservationId}' />" >Edit12345 </a> </td> --%>
				
					<td> <a href = " <c:url value='/editReservation/${reservation.reservationId}' />" >Edit </a> </td>
						<%-- <td> <a href="<c:url value='/removeReservation/${reservation.reservationId}' />" >Delete </a> </td> --%>
						
						<td>
							<form:form action="removeReservation/${reservation.reservationId}" method="GET">
								<input type="submit" value="Delete"/>
							</form:form>
						</td>
		</tr>			
		</c:forEach>
	</table>
	
	</div>
</body>
</html>