<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer details</title>
</head>
<body>
	<div class="container">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<h1>User Details</h1>
		<br />

		<div class="row">
			<label class="col-sm-2">User name: </label>
			<div class="col-sm-10">${user.username}</div>
		</div>

		<div class="row">
			<label class="col-sm-2">Email:</label>
			<div class="col-sm-10">${user.email}</div>
		</div>

		<div class="row">
			<label class="col-sm-2">Full name:</label>
			<div class="col-sm-10">${user.name}</div>
		</div>

		<div class="row">
			<label class="col-sm-2">Street</label>
			<div class="col-sm-10">${user.street}</div>
		</div>

		<div class="row">
			<label class="col-sm-2">City:</label>
			<div class="col-sm-10">${user.city}</div>
		</div>

		<div class="row">
			<label class="col-sm-2">State:</label>
			<div class="col-sm-10">${user.state}</div>
		</div>

		<div class="row">
			<label class="col-sm-2">Zip</label>
			<div class="col-sm-10">${user.zip}</div>
		</div>

		<div class="row">
			<label class="col-sm-2">Country</label>
			<div class="col-sm-10">${user.country}</div>
		</div>
		<spring:url value="/updateCustomerInfo" var="updateUrl" />
		<button class="btn btn-primary"
                                          onclick="location.href='${updateUrl}'">Update details</button>

	</div>
</body>
</html>