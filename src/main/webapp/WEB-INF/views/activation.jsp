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
<title>Manage customer status</title>
</head>
<body>
	<div class="generic-container">

		<div class="well lead">Manage customer status</div>
		<spring:url value="/dealactivation" var="custActionUrl" />

		<form:form class="form-horizontal" method="post" modelAttribute="user"
			action="${custActionUrl}">
			<form:hidden path="userId" />
			<spring:bind path="username">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="username">User
							Name: </label>
						<div class="col-md-7">
							<form:input type="text" path="username" id="username"
								class="form-control input-sm" disabled="true" />
							<div class="has-error">
								<form:errors path="username" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
			</spring:bind>

			<spring:bind path="password">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="email">email</label>
						<div class="col-md-7">
							<form:input type="email" path="email" id="email"
								class="form-control input-sm" disabled="true" />
							<div class="has-error">
								<form:errors path="email" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
			</spring:bind>

			<spring:bind path="enabled">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="enabled">Enabled</label>
						<div class="col-md-7">
							<form:radiobutton path="enabled" value = "true" id="enabled"
								class="form-control input-sm" /> Active
								<form:radiobutton path="enabled" value = "false" id="enabled"
								class="form-control input-sm" /> DeActive
							<%-- <div class="has-error">
								<form:errors path="enabled" class="help-inline" />
							</div> --%>
						</div>
					</div>
				</div>
			</spring:bind>


			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">

					<form:button type="submit" class="btn-lg btn-primary pull-right">Change status</form:button>
				</div>
			</div>
		</form:form>
	</div>
	<%@ include file="/WEB-INF/views/template/footer.jsp"%>
</body>
</html>