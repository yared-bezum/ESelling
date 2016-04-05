<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Registration</title>

</head>

<body>

	<section class="container">
	<form:form modelAttribute="customer" class="form-horizontal" method="POST" enctype="utf8">
	<fieldset>
				<legend>New Administrator</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				
				<div class="form-group">
				<label class="control-label col-lg-2" for="firstName">First Name:</label>
				<div class="col-lg-10">
				<form:input  class="form:input-large" id="firstName" path="firstName" value="" /> 
				 <form:errors path="firstName" cssClass="text-danger"/>
			</div>
				</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="lastName">Last Name:</label>
				<div class="col-lg-10">
				<form:input class="form:input-large" id="lastName" path="lastName" value="" />
				<form:errors path="lastName" cssClass="text-danger" />
			</div>
				</div>
				
				<div class="form-group">
				<label class="control-label col-lg-2" for="email">Email:</label>
				<!-- <div class="col-lg-10"> -->
				<form:input class="form:input-large" id="email" path="email" value="" />
				  <form:errors path="email" cssClass="text-danger" />  
				
			</div>
				
				
				<div class="form-group">
			<label class="control-label col-lg-2" for="phone">Phone Number:</label>
			<div class="col-lg-10">
				<form:input  class="form:input-large"  id="phone" path="phone" value="" /> 
				  <form:errors path="phone" cssClass="text-danger" /> 
				</div>
				</div>
				
			<div class="form-group">
				<label class="control-label col-lg-2" for="street">Street:</label>
				<div class="col-lg-10">
				<form:input  class="form:input-large"  id="street" path="address.street" value="" type="text" />
					 <form:errors path="address.street" cssClass="text-danger" /> 
		</div>
				</div>
				
               <div class="form-group">
				<label class="control-label col-lg-2" for="state">State:</label>	
			<div class="col-lg-10">	
              <form:select  class="form:input-large" id="state" path="address.state">
				 <form:option value="0" label="-state-" /> 
						<form:options items="${states}" />
						<%-- <form:errors path="address.state" cssClass="text-danger" /> --%>
					</form:select>
					</div>
				</div>
				
			
            <div class="form-group">
				<label class="control-label col-lg-2" for="zipcode">Zip Code:</label>
				<div class="col-lg-10">	
				<form:input  class="form:input-large" id="zipcode" path="address.zipcode" value="" type="text" />
					 <form:errors path="address.zipcode" cssClass="text-danger" /> 
			</div>
				</div>
				
					<!-- <label class="control-label col-lg-2" for="authority">Role</label> -->
					<form:hidden path="credentials.authority[0].authority"
						value="ROLE_ADMIN" /> <%-- <form:errors path="credentials.authority[0].authority" cssClass="text-danger"/> --%>		
		
			<form:hidden path="credentials.enabled" value="TRUE" />


			<div class="form-group">
			<label class="control-label col-lg-2" for="username">User Name:</label>
				<div class="col-lg-10">	
				<form:input class="form:input-large" id ="username" path="credentials.username" value="" />
				  <form:errors path="credentials.username" cssClass="text-danger" /> 
			</div>
				</div>
			
              <div class="form-group">
			
				<label class="control-label col-lg-2" for="password">Password:</label>
				<div class="col-lg-10">	
				<form:input class="form:input-large" id= "password" path="credentials.password" value=""
						type="password" /> <%-- <form:errors path="password" cssClass="text-danger" /> --%>					
		</div>
				</div>
				
			<div class="form-group">
				<label class="control-label col-lg-2" for="verifyPassword">Verify Password:</label>
               <div class="col-lg-10">	
				<form:input class="form:input-large" id="verifyPassword" path="credentials.verifyPassword" value="" type="password" /> 
						 <form:errors path="credentials.verifyPassword" cssClass="text-danger" /> 
						
				</div>
				</div>
			

			<div class="form-group">
			<label class="control-label col-lg-2" for="creditCardNo">Card Number:</label>
			<div class="col-lg-10">	
				<form:input class="form:input-large" id=" creditCardNo" path="creditCard.creditCardNo" value=""
						type="text" /> 
			 <form:errors path="creditCard.creditCardNo" cssClass="text-danger" /> 
			</div>
				</div>
			
		<div class="form-group">
				<label class="control-label col-lg-2" for="expMonth">CardType:</label>
					<div class="col-lg-10">
				<form:select class="form:input-large" id="expMonth" path="creditCard.creditCardType">
			
						<form:options items="${creditType}" />
					  <form:errors path="creditCard.creditCardType" cssClass="text-danger" /> 
					</form:select>
			</div>
				</div>
				
			<div class="form-group">
			<label class="control-label col-lg-2" for="nameOnCard">Name On Card:</label>
			<div class="col-lg-10">	
				<form:input class="form:input-large" id="nameOnCard" path="creditCard.nameOnCard" value=""
						type="text" />
		 <form:errors path="creditCard.nameOnCard"  cssClass="text-danger" /> 
			</div>
				</div>
			
			<div class="form-group">
				<label class="control-label col-lg-2" for="expMonth">Expire Month:</label>
					<div class="col-lg-10">
				<form:select class="form:input-large" id="expMonth" path="creditCard.expMonth">
			
						<form:options items="${months}" />
					 <form:errors path="creditCard.expMonth" cssClass="text-danger" /> 
					</form:select>
			</div>
				</div>

			<div class="form-group">
				<label class="control-label col-lg-2" for="expYear">Expire Year:</label>
				<div class="col-lg-10">
			<form:select  class="form:input-large" id="expYear" path="creditCard.expYear">
						<form:options items="${years}" />
				 <form:errors path="creditCard.expYear" cssClass="text-danger"/> 
					</form:select>
			</div>
				</div>
				
				<div class="form-group">
				<label class="control-label col-lg-2" for="securityCode">3 Digit Security Code:</label>
				<div class="col-lg-10">
				<form:input class="form:input-large" id="securityCode" path="creditCard.securityCode" value="" type="password" />
		 <form:errors path="creditCard.securityCode" cssClass="text-danger"/> 
				</div>
				</div>

		<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Register"/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>


</html>