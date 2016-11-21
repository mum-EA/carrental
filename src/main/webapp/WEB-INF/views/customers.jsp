<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer information</title>
</head>
<body>

	<table class="table table-hover">

<%-- 		<spring:url value="/managecustomer" var="custActionUrl" />
 --%>
 		<tr>
 		<th>Full Name</th>
 		<th>User Name</th>
 		<th>Activation status</th>
 		<th>Email</th>
 		<th>Action</th>
 		</tr>
		<c:forEach var="user" items="${customers}">
				<tr>
					<td>${user.name}</td>
					<td>${user.username}</td>
					<td>${user.enabled}</td>
					<td>${user.email}</td>
					<td><a href="managecustomer/${user.username}">Enable/Disable</a></td>
				</tr>

		</c:forEach>

	</table>

</body>
</html>