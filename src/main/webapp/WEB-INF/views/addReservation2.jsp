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
<div class="generic-container">
		<div class="well lead">Enter The following fields for Vehicle ${vehicle.vehicleId }.</div>


		<form:form action="reservation" method="POST" modelAttribute = "reservation">
		
		
			<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" >Pick Up date :</label>
						<div class="col-md-7">
							<form:input type="text" path="pickupDate" class = "form-control input-sm"/>
							<form:errors path="pickupDate" cssStyle="color : red;" />
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" >Return date :</label>
						<div class="col-md-7">
							<form:input type="text" path="returnDate" class = "form-control input-sm"/>
							<form:errors path="returnDate" cssStyle="color : red;" />
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" >Location To</label>
						<div class="col-md-7">
							<form:input type="text" path="locationto" class = "form-control input-sm"/>
							<form:errors path="locationto" cssStyle="color : red;" />
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" >Location From</label>
						<div class="col-md-7">
							<form:input type="text" path="locationfrom" class = "form-control input-sm"/>
							<form:errors path="locationfrom" cssStyle="color : red;" />
						</div>
					</div>
				</div>
				
				<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">

					<input type="submit" value="Reserve" name="add" class="btn btn-primary"//>
				</div>
			</div>
		</form:form>
		
		</br>
		<form:form action="cancelAddReservation" method="GET">
		<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">

					<input type="submit" value="Cancel" name="cancel" class="btn btn-primary"//>
				</div>
			</div>
		</form:form>
		

			<%-- <table>
				<tr style="background-color: yellow">
					<th>Pick Up date :</th>
					<td><form:input type="text" path="pickupDate" /></td>
					<td><form:errors path="pickupDate" cssStyle="color : red;" /></td>
				</tr>

				<tr style="background-color: maroon">
					<th>Return date</th>
					<td><form:input type="text" path="returnDate" /></td>
					<td><form:errors path="returnDate" cssStyle="color : red;" /></td>
				</tr>
				<tr style="background-color: yellow">
					<th>Location to :</th>
					<td><form:input type="text" path="locationto"  /></td>
					<td><form:errors path="locationto" cssStyle="color : red;" /></td>
				</tr>

				<tr style="background-color: maroon">
					<th>location from :</th>
					<td><form:input type="text"	path="locationfrom" /></td>
					<td><form:errors path="locationfrom" cssStyle="color : red;" /></td>
				</tr>

				<!-- <tr>
					<td><input type="submit" value="add"/></td>
				</tr> -->
			</table> --%>
		<%-- 	<input type="submit" value="add"/>
		</form:form>
		<form:form action="cancelAddReservation" method="GET">
			<input type="submit" value="Cancel"/>
		</form:form>
		</div> --%>
		
</div>

</body>
</html>