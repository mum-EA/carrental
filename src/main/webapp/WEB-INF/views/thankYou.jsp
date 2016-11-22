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
	
	<c:forEach items="${revers }" var="a">
			<tr>
				<td>${a.reservationId}</td>
				<td>${a.vehicle.vehicleId}</td>				
				<td>${a.totalPrice}</td>
				<td>${a.pickupDate}</td>
				<td>${a.returnDate }</td>
				<td>${a.locationfrom }</td>
				<td>${a.locationto }</td>
				<td>${a.vehicle.vehicleId }</td>	
				<td>------------------------</td>
				</tr>
		</c:forEach>

</body>
</html>