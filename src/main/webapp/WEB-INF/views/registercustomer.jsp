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
<title>Customer Registration Form</title>
</head>

<body>
	<div class="generic-container">

		<div class="well lead">Customer registration form</div>
		<spring:url value="/addnewcustomer" var="custActionUrl" />

		<form:form class="form-horizontal" method="post" modelAttribute="user"
			action="${custActionUrl}">
			<%-- 			<form:input type="hidden" path="userId" id="userId" />
 --%>
			<form:hidden path="userId" />
			<spring:bind path="username">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="username">User
							Name: </label>
						<div class="col-md-7">
							<form:input type="text" path="username" id="username"
								class="form-control input-sm" />
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
						<label class="col-md-3 control-lable" for="password">password</label>
						<div class="col-md-7">
							<form:input type="password" path="password" id="password"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="password" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
			</spring:bind>

			<spring:bind path="email">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="email">Email</label>
						<div class="col-md-7">
							<form:input type="text" path="email" id="email"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="email" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
			</spring:bind>
			<spring:bind path="name">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="name">Full Name</label>
						<div class="col-md-7">
							<form:input type="text" path="name" id="name"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="name" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

			</spring:bind>

			<spring:bind path="street">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="street">Street:
						</label>
						<div class="col-md-7">
							<form:input type="text" path="street" id="street"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="street" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

			</spring:bind>
			<spring:bind path="city">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="city">City:</label>
						<div class="col-md-7">
							<form:input type="text" path="city" id="city"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="city" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
			</spring:bind>
			<spring:bind path="state">

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="state">State:</label>
						<div class="col-md-7">
							<form:input type="text" path="state" id="state"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="state" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
			</spring:bind>
			<spring:bind path="email">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="email">Zip</label>
						<div class="col-md-7">
							<form:input type="text" path="zip" id="zip"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="zip" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
			</spring:bind>
			<spring:bind path="country">

				<div class="row">
					<div class="form-group col-md-12 country-div">
						<label class="col-md-3 control-lable" for="country">Country:</label>
						<div class="col-md-7">
							<form:input type="text" path="country" id="country"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="country" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

			</spring:bind>
			<%--  <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="userProfiles">Roles</label>
                    <div class="col-md-7">
                        <form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="userProfiles" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div> --%>

			<%-- <div class="row">
                <div class="form-actions floatRight">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div> --%>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">

					<form:button type="submit" class="btn-lg btn-primary pull-right">Submit</form:button>
				</div>
			</div>
		</form:form>
	</div>
	<%@ include file="/WEB-INF/views/template/footer.jsp"%>
</body>
</html>