<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>
<html>
<head>
<meta charset="utf-8" />
<title>Add New Vehicle</title>
</head>

<body>
	<div class="generic-container">
		<div class="well lead">Add New Vehicle</div>


		<div>
			<form:form action="vehicle" method="POST" commandName="vehicle"
				enctype="multipart/form-data" class="form-horizontal">

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable">Plate Number : </label>
						<div class="col-md-7">
							<input type="text" placeholder="Please enter plate number"
								name="plateNumber" class = "form-control input-sm" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable">Number Of Seats </label>
						<div class="col-md-7">
							<input type="number" placeholder="Number Of Seats"
								name="numberOfSeats" class = "form-control input-sm"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable">Vehicle Type : </label>
						<div class="col-md-7">
							<form:select path="vehicleType" class="form-control">
								<form:option value="" label="Select Vehicle Type" />
								<form:options path="${availableOptions}" />
							</form:select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable">Brand :</label>
						<div class="col-md-7">
							<input type="text" placeholder="Vehicle Brand" name="brand" class = "form-control input-sm"/>
						</div>
					</div>
				</div>
			
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable">Manufactured Year :</label>
						<div class="col-md-7">
							<input type="text" placeholder="manufactured year"
								name="manufacturedYear" class = "form-control input-sm"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable">Status :</label>
						<div class="col-md-7">
							<form:select path="status" class="form-control">
								<form:option value="" label="Select Availabilty" />
								<form:options path="${availableOptions}" />
							</form:select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable">Daily Price :</label>
						<div class="col-md-7">
							<input type="number" placeholder="daily price" name="dailyPrice" class = "form-control input-sm" />
						</div>
					</div>
				</div>
				<!-- <div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable">Daily Price :</label>
						<div class="col-md-7">
							<input type="number" placeholder="daily price" name="dailyPrice" class = "form-control input-sm"/>
						</div>
					</div>
				</div> -->
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable">Image:</label>
						<div class="col-md-7">
							 <input type="file" name="vehicleImage"
								required/> 
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">

						<input type="submit" value="Add vehicle" name="add"  class="btn btn-primary"/>
					</div>
				</div>

			</form:form>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/template/footer.jsp"%>
</body>
</html>





