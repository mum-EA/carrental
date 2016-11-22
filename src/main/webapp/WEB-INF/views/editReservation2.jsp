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
<title>Add Reservation</title>
</head>
<body>

Enter The following fields for Vehicle ${vehicle.vehicleId }.

		<form:form action = "updateReservation" method = "POST" modelAttribute="reservation">
		
		<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" >Pick Up date :</label>
						<div class="col-md-7">
							<form:input type="text" path="pickupDate" value = "${reservation.pickupDate }" />
							<form:errors path="pickupDate" cssStyle="color : red;" />
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" >Return date :</label>
						<div class="col-md-7">
							<form:input type="text" path="returnDate" value = "${reservation.returnDate }" />
							<form:errors path="returnDate" cssStyle="color : red;" />
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" >Location To</label>
						<div class="col-md-7">
							<form:input type="text" path="locationto" value = "${reservation.locationto }"/>
							<form:errors path="locationto" cssStyle="color : red;" />
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" >Location From</label>
						<div class="col-md-7">
							<form:input type="text" path="locationfrom" value = "${reservation.locationfrom }" />
							<form:errors path="locationfrom" cssStyle="color : red;" />
						</div>
					</div>
				</div>
				
				<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">

					<input type="submit" value="Update" name="add" />
				</div>
			</div>
		</form:form>
		
		
			
			<%-- <table border=1>
				<tr>
					<th>Pick Up date :</th>
					<td><input type="text" name="pickupDate" value = ${reservation.pickupDate }></td>
					<form:errors path="pickupDate" cssStyle="color : red;" />
				</tr>

				<tr>
					<th>Return date</th>
					<td><input type="text" name="returnDate" value = ${reservation.returnDate } ></td>
					<form:errors path="returnDate" cssStyle="color : red;" />
				</tr>
				<tr>
					<th>Location to :</th>
					
					<td><input type="text" name="locationto"  value = ${reservation.locationto }></td>
					<form:errors path="locationto" cssStyle="color : red;" />
				</tr>

				<tr>
					<th>location from :</th>
					<td><input type="text"	name="locationfrom" value = ${reservation.locationfrom }></td>
					<form:errors path="locationfrom" cssStyle="color : red;" />
				</tr>

				<tr>
					<td><input type="submit" value="Update" name="add" /></td>
				</tr>
			</table>
		</form:form>
		</div>
 --%>
</body>
</html>