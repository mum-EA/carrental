<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset ="utf-8" />
<title> Update the Vehicle </title>
</head>
<body>
<div>
	All Vehicles
</div>
	<table>
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
						<td><img src="data:image/png;base64,${imageBase64}" width="150" height="100" /></td>
						<td> <a href = " <c:url value='/editvehicle/${vehicle.vehicleId}' />" >Edit </a> </td>
						<td> <a href="<c:url value='/remove/${vehicle.vehicleId}' />" >Delete </a> </td>
					</tr>
				</c:forEach>
			</tbody>
	
	</table>
</body>
</html>
<%-- ${vehicle.vehicleId} --%>
