<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
<meta http-equiv="Content-Type" content=
"text/html; charset=ISO-8859-1">

<title>Login</title>
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
				<c:if test="${not empty error}">
<div class="alert alert-danger"  >
<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br />
</div>
</c:if>
</div>
		
<section class="container">
<form action="<c:url value="/j_spring_security_check"></c:url>"  class="form-horizontal" method="post">
<fieldset>
				<legend>LogIn</legend>

<div class="form-group">
<label class="control-label col-lg-2" for="firstName">UserName:</label>
<div class="col-lg-10">
<input class="form:input-large" placeholder="User Name" name='j_username' type="text">
</div>
</div>

<div class="form-group">
<label class="control-label col-lg-2" for="firstName">Password:</label>
<div class="col-lg-10">
<input class="form:input-large" placeholder="Password" name='j_password' type="password" value="">
</div>
</div>

<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="LogIn"/>
					</div>
				</div>	
			</fieldset>
	</form>
	</section>
</body>
</html>