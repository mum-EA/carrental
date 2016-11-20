<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<meta charset="utf-8" />
<title>Edit Vehicle</title>
</head>

<body>
	<div>Edit Vehicle</div>

	<div>
		<form:form action = "../updatevehicle" method = "POST">
		
			<table border = 1>
				<tr>
					
					<th>Plate Number : </th>
					<td>
						<input type="text"  value="${vehicle.plateNumber}" name="plateNumber" />
						<input type="hidden" value="${vehicle.vehicleId}" name="vehicleId"></input>
					</td>
				</tr>
				
				<tr>
					<th>Number Of Seats</th>
					<td><input type="number"  value = "${vehicle.numberOfSeats}" name="numberOfSeats"	 /></td>
				</tr>
				<tr>
					<th>Vehicle Type : </th>
					<td><input type="text"  value = "${vehicle.vehicleType}" name="vehicleType"  /></td>
				</tr>
				
				<tr>
					<th>Brand : </th>
					<td><input type="text" value = "${vehicle.brand}" name="brand"  /></td>
				</tr>
				<tr>
					<th>Manufactured Year : </th>
					<td><input type="text"  value = "${vehicle.manufacturedYear}" name="manufacturedYear"  /></td>
				</tr>
				<tr>
					<th>Status : </th>
					<td><input type="text"  value = "${vehicle.status}" name="status"  /></td>
				</tr>
				
				<tr>
					<th>Daily Price : </th>
					<td><input type="number"  value = "${vehicle.dailyPrice}" name="dailyPrice"  /></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="add" name = "add" /></td>
				</tr>
			</table>
	</form:form>
	</div>
</body>
</html>
