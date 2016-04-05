<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= ISO-8859-1">
<style type="text/css"></style>
<link href="../resources/css/all.css" rel="stylesheet" type="text/css" />
<link href="../resources/css/index.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>

	<!-- Header goes here--->
	<div class="container">
		<div id="header">
			<div class="right"
				style="padding-right: 16px; padding-top: 12px; width: 115px; height: 40px; float: right; margin-top: -59px; margin-right: 30px;">
				<ul>
					<li class="right"><a href="#"> <img align="right"
							alt="Spanish" src="../resources/images/Sp.png"
							style="margin-right: -20px" title="Español" class="drop5">
					</a></li>
					<li class="right"><a href="#"> <img align="right"
							alt="French" src="../resources/images/Fr.png"
							style="margin-right: 6px" title="Français" class="drop5">
					</a></li>
					<li class="right"><a href="#"> <img align="right"
							alt="English" src="../resources/images/UK1.png"
							style="padding-right: 5px; opacity: 1;" title="English"
							class="drop5">
					</a></li>
				</ul>
			</div>
			<span class="logo left"> <a href="/home"> <img
					alt="E-Selling System" title="E-Selling System"
					src="../resources/images/logo.png" />
			</a>
			</span>

			<div class="right" id="share" style="width: 650px">
				<ul class="nav">
				<form:form  action="#" method="get">
					<div class="styled-select">
						<select id="categoryId" name="categoryId">
						 <c:forEach var="category" items="${categories}">
							<option value="${category.categoryId}">${category.categoryName}</option>
						 </c:forEach>
						</select>
					</div>
					<li id="search">
						
							<input type="text" name="search_text" id="search_text" placeholder="search a product..." /> 
							<input type="submit" name="search_button" id="search_button" value="Search"/>
						
					</li>
					</form:form>
				</ul>

				<br class="clear" />
				<div class="menu">
					<ul>
						<li><strong>Hello ${customer.firstName}</strong></li>	
			<li><a href=" <spring:url value="/logout" />" >SignOut</a> </li>
						<li><a href="#"><pre id="separator">   |   </pre></a></li>

						<li><a href="<c:url value="/cart/mycart"/>"><img alt=""
								src="../resources/images/cart.png">${cart.numberOfProducts}
								Products</a></li>
								<li><a href="#"><pre id="separator">   |   </pre></a></li>
								
					</ul>
					<br style="clear: left" />
				</div>

			</div>

		</div>
	</div>
	<div id="main">

		<div id="products">

			<form:form method="POST" modelAttribute="productOrder"
				class="form-horizontal">
				<%--     <div class="clear">
    <fieldset>
        <legend><spring:message code="cart.account.information"/></legend>
        <table>
            <tr><td><spring:message code="account.firstname" /></td><td>${order.account.firstName}</td></tr>
            <tr><td><spring:message code="account.lastname" /></td><td>${order.account.lastName}</td></tr>
        </table>
    </fieldset> --%>
				<div class="clear">
					<div style="float: left;">
						<fieldset>
							<legend>
								<spring:message code="cart.checkout.shipping" />
							</legend>
							<table>
								<tr>
									<td><label for="shippingAddress.street" class="error">
											<spring:message code="address.street" />
									</label></td>
									<td><form:input id="shippingAddress.street"
											path="shippingAddress.street" /></td>
									<td><form:errors path="shippingAddress.street" /></td>
								</tr>
								<tr>
									<td><label for="shippingAddress.state" class="error">
											<spring:message code="address.state" />
									</label></td>
									<td><form:input id="shippingAddress.state"
											path="shippingAddress.state" /></td>
									<td><form:errors path="shippingAddress.state" /></td>
								</tr>
								<tr>
									<td><label for="shippingAddress.zipcode" class="error">
											<spring:message code="address.zipcode" />
									</label></td>
									<td><form:input id="shippingAddress.zipcode"
											path="shippingAddress.zipcode" /></td>
									<td><form:errors path="shippingAddress.zipcode" /></td>
								</tr>
							</table>
						</fieldset>
					</div>
					<%-- <div>
        <fieldset>
            <legend><spring:message code="cart.checkout.billing"/></legend>
                <div><form:label path="billingSameAsShipping"><spring:message code="cart.checkout.billingSameAsShipping"/></form:label><form:checkbox path="billingSameAsShipping" /></div>
                
                <table style="display: ${order.billingSameAsShipping ? "none;" : "block;"}">
                    <tr><td><form:label path="billingAddress.street" cssErrorClass="error"><spring:message code="address.street" /></form:label></td><td><form:input path="billingAddress.street" disabled="${order.billingSameAsShipping}"/></td><td><form:errors path="billingAddress.street"/></td></tr>
                    <tr><td><form:label path="billingAddress.houseNumber" cssErrorClass="error"><spring:message code="address.houseNumber" /></form:label></td><td><form:input path="billingAddress.houseNumber" disabled="${order.billingSameAsShipping}"/></td><td><form:errors path="billingAddress.houseNumber"/></td></tr>
                    <tr><td><form:label path="billingAddress.boxNumber" cssErrorClass="error"><spring:message code="address.boxNumber" /></form:label></td><td><form:input path="billingAddress.boxNumber" disabled="${order.billingSameAsShipping}"/></td><td><form:errors path="billingAddress.boxNumber"/></td></tr>
                    <tr><td><form:label path="billingAddress.city" cssErrorClass="error"><spring:message code="address.city" /></form:label></td><td><form:input path="billingAddress.city" disabled="${order.billingSameAsShipping}"/></td><td><form:errors path="billingAddress.city"/></td></tr>
                    <tr><td><form:label path="billingAddress.postalCode" cssErrorClass="error"><spring:message code="address.postalCode" /></form:label></td><td><form:input path="billingAddress.postalCode" disabled="${order.billingSameAsShipping}"/></td><td><form:errors path="billingAddress.postalCode"/></td></tr>
                    <tr><td><form:label path="billingAddress.country" cssErrorClass="error"><spring:message code="address.country" /></form:label></td><td><form:select path="billingAddress.country" items="${countries}" disabled="${order.billingSameAsShipping}"/></td><td><form:errors path="billingAddress.country"/></td></tr>        
                </table>    
        </fieldset>
        </div> --%>
				</div>
				<div class="clear">
					<fieldset>
						<legend>
							<spring:message code="cart.checkout.order" />
						</legend>
						<table>
							<thead>
								<tr>
									<th><spring:message code="product.productName" /></th>
									<th><spring:message code="order.quantity" /></th>
									<th><spring:message code="product.unitPrice" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${productOrder.orderDetails}" var="detail"
									varStatus="status">
									<tr>
										<td><img
											src="<c:url value="../${detail.product.productPath}"></c:url>"
											alt="${product.productName}"
											style="float: right; height: 246px;"></td>
										<td>${detail.product.productName}</td>
										<td><form:input
												path="orderDetails[${status.index}].quantity" size="2" /></td>
										<td>${detail.price}</td>
									</tr>
								</c:forEach>
								<tr>
									<td colspan="2" align="right"><b><spring:message
												code="order.total" /></b></td>

									<td>${productOrder.orderPrice}</td>
								</tr>
							</tbody>
						</table>
					</fieldset>
				</div>

				<button id="order" name="order">
					<spring:message code="button.order" />
				</button>
				<button id="update" name="update">
					<spring:message code="button.update" />
				</button>
				<button id="cancel" name="cancel">
					<spring:message code="button.cancel" />
				</button>

			</form:form>
		</div>

	</div>

	<!--Footer goes here --->
	<div id="footer">
		<div id="footer_details_menu">
			<ul>

				<li style="color: #232f3e;"><strong>HEAD OFFICE</strong></li>
				<li>Fairfield, IA 52557</li>
				<li>1000 N 4th st</li>
				<li>Tel: +641 562-2564 / 5 / 6</li>
				<li>Fax: +641 333-6521</li>
				<li>E-mail: inquiry@esellingsystem.com</li>

			</ul>



			<ul class="footer_menu">

				<li><a href="/eselling/welcome" title="Home">Home</a></li>



			</ul>



			<ul class="footer_menu" style="border: none;">



				<li><a href="/terms" title="Terms and Conditions">Terms and
						Conditions</a></li>

			</ul>



			<ul class="footer_menu" style="border: none;">

				<li><a href="skype:eselling.system?call"
					onclick="return skypeCheck();" title="Support Center">Support
						Center</a></li>


			</ul>

			<ul class="footer_menu" style="border: none;">



				<li><a href="/contacts" title="Contacts">Contacts</a></li>

			</ul>


			<div class="clear"></div>
		</div>
	</div>

</body>
</html>
