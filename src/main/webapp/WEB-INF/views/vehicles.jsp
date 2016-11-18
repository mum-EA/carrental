<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
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

</body>
</html>