<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<title>Credit Card</title>
</head>
<body>

 
	<form:form modelAttribute="creditCard" cssClass="form-horizontal">
	<form:errors path="*" cssClass="alert alert-danger" element="div" />

	<form:errors path="*" cssClass="alert alert-danger" element="div" />

		<div class="form-group">
			<label class="" for="creditCardType"> <spring:message
					code="creditCard.form.type.label" /></label>
			<div class="">
				<form:select id="creditCardType" path="creditCardType.creditCardTypeName" type="text" class="">
				<c:forEach var="creditCardType" items="${creditCardTypes}">
					<option value=${creditCardType.creditCardTypeId}>${creditCardType.creditCardTypeName}</option>
					</c:forEach>
				</form:select>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label" for="nameOnCard"> <spring:message
					code="creditCard.form.nameOnCard.label" /></label>
			<div class="">
				<form:input id="nameOnCard" path="nameOnCard" type="text" class="form-control" />
				<form:errors path="nameOnCard" cssClass="text-danger" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label" for="creditCardNo"><spring:message
					code="creditCard.form.creditCardNo.label" /></label>
			<div class="form-group">
				<form:input id="creditCardNo" path="creditCardNo" type="text" class="form-control" />
				<form:errors path="creditCardNo" cssClass="text-danger" />
			</div>
			<label class="col-sm-2 control-label" for="securityCode"><spring:message
					code="creditCard.form.securityCode.label" /></label>
			<div class="form-group">
				<form:input id="securityCode" path="securityCode" type="text" class="form-control" />
				<form:errors path="securityCode" cssClass="text-danger" />
			</div>
		</div>

		<div class="form-group">
			<label class="" for="expMonth"><spring:message
					code="creditCard.form.expMonth.label" /></label>
			<div class="">
				<form:select id="expMonth" path="expMonth" type="text" class="">
					<form:options items="${months}"/>
				</form:select>
				<form:errors path="expMonth" cssClass="text-danger" />
			</div>
		</div>

		<div class="form-group">
			<label class="" for="expYear"><spring:message
					code="creditCard.form.expYear.label" /></label>
			<div class="">
				<form:input id="expYear" path="expYear" />
				<form:errors path="expYear" cssClass="text-danger" />
			</div>
		</div>

		<div class="form-group">
			<div class="">
				<input type="submit" id="btnAdd" class="btn btn-primary" value="Add" />
			</div>
		</div>

	</form:form>
</body>
</html>
