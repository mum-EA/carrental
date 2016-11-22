<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>
<html>
<head>
<meta charset="utf-8" />
<title>Edit Vehicle</title>
</head>

<body>
<div class="generic-container">
		<div class="well lead">Edit vehicle information</div>

		
		<form:form action="../updatevehicle" method="POST">

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable">Plate Number: </label>
					<div class="col-md-7">
						<input type="text" value="${vehicle.plateNumber}"
							name="plateNumber" class = "form-control input-sm"/> <input type="hidden"
							value="${vehicle.vehicleId}" name="vehicleId"></input>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable">Number Of Seats: </label>
					<div class="col-md-7">
						<input type="number" value="${vehicle.numberOfSeats}"
							name="numberOfSeats" class = "form-control input-sm"/>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable">Vehicle Type : </label>
					<div class="col-md-7">
						<input type="text" value="${vehicle.vehicleType}"
							name="vehicleType" class = "form-control input-sm" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable">Brand : </label>
					<div class="col-md-7">
						<input type="text" value="${vehicle.brand}" name="brand" class = "form-control input-sm"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable">Manufactured Year : </label>
					<div class="col-md-7">
						<input type="text" value="${vehicle.manufacturedYear}"
							name="manufacturedYear" class = "form-control input-sm"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable">Status : </label>
					<div class="col-md-7">
						<input type="text" value="${vehicle.status}" name="status" class = "form-control input-sm"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable">Daily Price : </label>
					<div class="col-md-7">
						<input type="number" value="${vehicle.dailyPrice}"
							name="dailyPrice" class = "form-control input-sm"/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">

					<input type="submit" value="add" name="add" />
				</div>
			</div>

		</form:form>
	</div>
		<%@ include file="/WEB-INF/views/template/footer.jsp"%>
</body>
</html>
