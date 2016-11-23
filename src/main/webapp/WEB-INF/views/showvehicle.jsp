<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>
<html>
<head>
<meta charset="utf-8" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<title>ABC rental company vehicles</title>
</head>
<body>
	<div class="generic-container">
		<div class="well lead">Add New Vehicle</div>
	<div id="div1"></div>
	<input id="searchText" type="text" placeholder="Type to search">
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
				<th>Image</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${vehicles}" var="vehicle">
				<tr>
					<td><c:out value="${vehicle.vehicleId}" /></td>
					<td><c:out value="${vehicle.plateNumber}" /></td>
					<td><c:out value="${vehicle.numberOfSeats}" /></td>
					<td><c:out value="${vehicle.vehicleType}" /></td>
					<td><c:out value="${vehicle.brand}" /></td>
					<td><c:out value="${vehicle.manufacturedYear}" /></td>
					<td><c:out value="${vehicle.status}" /></td>
					<td><c:out value="${vehicle.dailyPrice}" /></td>
					<td><img
						src="data:image/png;base64,${vehicle.base64imageFile}" width="150"
						height="100" /></td>
					<td><a
						href=" <c:url value='/editvehicle/${vehicle.vehicleId}' />">Edit
					</a></td>
					<td><a href="<c:url value='/remove/${vehicle.vehicleId}' />"
						onclick="if(!(confirm('Are you sure you want to delete this user?'))) return false">Delete
					</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	<%@ include file="/WEB-INF/views/template/footer.jsp"%>


	</div>
		<script type="text/javascript">
		$("#searchText").keyup(function() {
			var searchQuery = $("#searchText").val();

			searchProduct(searchQuery);
		});

		function searchProduct(searchQuery) {
			$("#div1").html("");
			$.ajax({
				url : "/carrental/admin/searchvehicle/" + searchQuery,
				type : "GET",
				error : function(response) {
					$("#div1").html("Not found!");
				},
				success : function(result, status) {
					var obj = jQuery.parseJSON(JSON.stringify(result));
					$("#div1").html(
							"Vehicle found with number plate: "
									+ obj.plateNumber + "with brand name "
									+ obj.brand);
				}

			});
		}
	</script>
</body>
</html>
<%-- ${vehicle.vehicleId} --%>
