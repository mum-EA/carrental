<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>
<html>
<head>
<meta charset ="utf-8" />
<title> ABC rental company vehicles</title>
</head>
<body>
	<table class="table table-hover">
		<thead>
				<tr>
					<th>#ID</th>
					<th>Plate Number</th>
					<th>Number Of Seats</th>
					<th>Vehicle Type</th>
					<th>Brand</th>
					<th>Manufactured Year</th>
					<th>Status</th>
					<th>Daily Price</th>
					<th> Image </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items = "${vehicles}" var = "vehicle">
					<tr>	
						<td> <c:out value = "${vehicle.vehicleId}" /> </td>
						<td> <c:out value = "${vehicle.plateNumber}" /> </td>
						<td> <c:out value="${vehicle.numberOfSeats}" /> </td>
						<td> <c:out value="${vehicle.vehicleType}" /> </td>
						<td> <c:out value="${vehicle.brand}" /> </td>
						<td> <c:out value="${vehicle.manufacturedYear}" /> </td>
						<td> <c:out value="${vehicle.status}" /> </td>
						<td> <c:out value="${vehicle.dailyPrice}" /> </td>
						<td><img src="data:image/png;base64,${vehicle.base64imageFile}" width="150" height="100" /></td>
						<td> <a href = " <c:url value='/editvehicle/${vehicle.vehicleId}' />" >Edit </a> </td>
						<td> <a href="<c:url value='/remove/${vehicle.vehicleId}' />" >Delete </a> </td>
					</tr>
				</c:forEach>
			</tbody>
	
	</table>
		<%@ include file="/WEB-INF/views/template/footer.jsp"%>
</body>
</html>
<%-- ${vehicle.vehicleId} --%>
