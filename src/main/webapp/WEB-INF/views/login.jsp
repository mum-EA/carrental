<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<link href="<c:url value='/resources/css/bootstrap-min.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>

<body>
	<div id="mainWrapper">
		<div class="login-container">
			<div class="login-card">
				<div class="login-form">

					<c:url var="loginUrl" value="/login" />
					<form action="${loginUrl}" method="post" class="form-horizontal">
						<c:if test="${param.error != null}">
							<div class="alert alert-danger">
								<p>Invalid username and password.</p>
							</div>
						</c:if>
						<c:if test="${param.logout != null}">
							<div class="alert alert-success">
								<p>You have been logged out successfully.</p>
							</div>
						</c:if>
						<div class="input-group logintext">
							<label class="input-group-addon" for="username"><i
								class="fa fa-user"></i></label> <input type="text" class="form-control"
								id="username" name="username" placeholder="Enter Username"
								required>
						</div>
						<div class="input-group logintext ">
							<label class="input-group-addon" for="password"><i
								class="fa fa-lock"></i></label> <input type="password"
								class="form-control " id="password" name="password"
								placeholder="Enter Password" required>
						</div>
						
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />

						<div class="form-actions">
							<input type="submit"
								class="btn btn-block btn-primary btn-default" value="<spring:message code="Login" text="deafault text"/>">
						</div>
						<div class="input-group input-sm">

							<label for="remember-me" class="input-group-addon remembermelabel">Remember
								Me   <input type="checkbox" id="remember-me" name="remember-me"
								class="form-control" /></label>
						</div>
					</form>
					<spring:url value="/registernewcustomer" var="urlAddCustomer" />
					<a href="${urlAddCustomer}" class = "signup">Register as new customer</a>
					<%-- 					<a href="<spring:url value="/registercustomer" />"> Signup</a>
 --%>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/template/footer.jsp"%>
</body>
</html>
</body>
</html>