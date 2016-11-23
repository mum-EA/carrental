<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@ page isELIgnored="false"%> --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Payment</title>
</head>

<body>

<div class="generic-container">

		<div class="well lead">Make payment</div>
	<form:form method="post" modelAttribute="payment" action="payment">
	
	Language : <a href="?language=en_US">English</a>
		<a href="?language=es_ES">Spanish</a>
		<br>
		<br>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable"><spring:message code="SelectPaymentType" text="deafault text"/></label>
				<div class="col-md-7">
					<form:select id="paymentType" path="paymentType">
						<form:option value="creditCard" label="CREDIT CARD" />
						<form:option value="visaCard" label="VISA CARD" />
					</form:select>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable"><spring:message code="CardNumber" text="deafault text"/></label>
				<div class="col-md-7">
					<form:input type="text" path="cardNumber" />
					<form:errors path="cardNumber" cssStyle="color : red;" />
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable"><spring:message code="CCV" text="deafault text"/></label>
				<div class="col-md-7">
					<form:input type="text" path="ccv" />
					<form:errors path="ccv" cssStyle="color : red;" />
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable"><spring:message code="CardExpireDate" text="deafault text"/></label>
				<div class="col-md-7">
					<form:input type="text" path="cardExpiryDate" />
					<form:errors path="cardExpiryDate" cssStyle="color : red;" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" value="Make Payment" name="add" />
			</div>
		</div>
	</form:form>

	<form:form method="post" modelAttribute="payment"
		action="cancelpayments">

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" value="Cancel" name="add" />
			</div>
		</div>
	</form:form>


	<%-- <table>
		<tr style="background-color: yellow">
			<td>Select Payment Type</td>
			<td><form:select id="paymentType" path="paymentType">
					<form:option value="creditCard" label="CREDIT CARD" />
					<form:option value="visaCard" label="VISA CARD" />
				</form:select></td>
		</tr>
		<tr style="background-color: maroon">
			<td>Card Number</td>
			<td><form:input id="cardNumber" path="cardNumber" type="text" />
				<form:errors path="cardNumber" cssStyle="color : red;" /></td>
		</tr>

		<tr style="background-color: yellow">
			<td>CCV Number</td>
			<td><form:input id="ccv" path="ccv" type="text" /> <form:errors
					path="ccv" cssStyle="color : red;" /></td>
		</tr>
		<tr style="background-color: maroon">
			<td>Card Expire Date</td>
			<td><form:input id="cardExpiryDate" path="cardExpiryDate"
					type="text" /> <form:errors path="cardExpiryDate"
					cssStyle="color : red;" /></td>
		</tr>

	</table>
	
		<button>Make Payment</button>
	</form:form>

	<form:form method="post" modelAttribute="payment"
		action="cancelpayments">
		<button>Cancel</button>
	</form:form>
 --%>

	<%-- <p>
			Select Payment Type
			<form:select id="paymentType" path="paymentType">
				<form:option value="creditCard" label="CREDIT CARD" />
				<form:option value="visaCard" label="VISA CARD" />
			</form:select>
		</p>
		<p>
			Card Number :
			<form:input id="cardNumber" path="cardNumber" type="text" />
			<form:errors path="cardNumber" cssStyle="color : red;" />
		</p>
		<p>
			CCV Number :
			<form:input id="ccv" path="ccv" type="text" />
			<form:errors path="ccv" cssStyle="color : red;" />
		</p>
		<p>
			Card Expire Date :
			<form:input id="cardExpiryDate" path="cardExpiryDate" type="text" />
			<form:errors path="cardExpiryDate" cssStyle="color : red;" />
		</p>
		<button>Make Payment</button>
	</form:form>
	
	<form:form method="post" modelAttribute="payment"
		action="cancelpayments">
		<button>Cancel</button>
	</form:form> --%>
</div>
</body>
</html>