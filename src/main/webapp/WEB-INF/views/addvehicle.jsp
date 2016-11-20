<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8" />
<title>Add New Vehicle</title>
</head>

<body>
	<div>Add New Vehicle</div>

	<div>
		<form:form action="vehicle" method="POST" commandname = "vehicle">

			<table border=1>
				<tr>
					<th>Plate Number :</th>
					<td><input type="text" placeholder="Please enter plate number"
						name="plateNumber" /></td>
				</tr>

				<tr>
					<th>Number Of Seats</th>
					<td><input type="number" placeholder="Number Of Seats"
						name="numberOfSeats" /></td>
				</tr>
				<tr>
					<th>Vehicle Type :</th>
					<%-- <td><form:select path="vehicleType">
						<form:options items="${vtype}" />
					</form:select>
					</td> --%>
					<td><input type="text" placeholder="Vehicle Type" name="vehicleType"  /></td>
				</tr>

				<tr>
					<th>Brand :</th>
					<td><input type="text" placeholder="Vehicle Brand"
						name="brand" /></td>
				</tr>
				<tr>
					<th>Manufactured Year :</th>
					<td><input type="text" placeholder="manufactured year"
						name="manufacturedYear" /></td>
				</tr>
				<tr>
					<th>Status :</th>
					<td><input type="text" placeholder="status" name="status" /></td>
				</tr>

				<tr>
					<th>Daily Price :</th>
					<td><input type="number" placeholder="daily price"
						name="dailyPrice" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="add" name="add" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>





