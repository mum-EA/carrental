<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABC car rental system</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
<table class="table table-striped">

	<c:forEach var="car" items="${carList}">
	<tr>
		<td>${car.model}</td>
		<td>${car.description}</td>
		<td><a href="cars/${car.model}">edit</a></td>
	</tr>
	</c:forEach>
	</table>
	<%@ include file="/WEB-INF/views/template/footer.jsp"%>
</body>
</html>