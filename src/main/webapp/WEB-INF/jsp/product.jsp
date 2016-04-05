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
					<form:form action="/eselling/productsearch" method="get">
						<div class="styled-select">
							<select id="categoryId" name="categoryId">
								<c:forEach var="category" items="${categories}">
									<option value="${category.categoryId}">${category.categoryName}</option>
								</c:forEach>
							</select>
						</div>
						<li id="search"><input type="text" name="search_text"
							id="search_text" placeholder="search a product..." /> <input
							type="submit" name="search_button" id="search_button"
							value="Search" /></li>
					</form:form>
				</ul>

				<br class="clear" />
				<div class="menu">
				<c:if test="${not empty customer}">
					<ul>
						<li><strong>Hello ${customer.firstName}</strong></li>
						<li><a href=" <spring:url value="/logout" />">SignOut</a></li>
						<li><a href="#"><pre id="separator">   |   </pre></a></li>

						<li><a href="<c:url value="/cart/checkout"/>"><img alt=""
								src="../resources/images/cart.png">${cart.numberOfProducts}
								Products</a></li>
						<li><a href="#"><pre id="separator">   |   </pre></a></li>

					</ul>
					</c:if>

				</div>

			</div>

		</div>

			<div id="products">
				<section class="container">
					<div class="row">
						<div class="col-md-5">
							<img src="<c:url value="../${product.productPath}"></c:url>"
								alt="${product.productName}"
								style="float: right; height: 246px;">
						</div>

						<div class="col-md-5">
							<h3>${product.productName}</h3>
							<p>${product.description}</p>
							<p>
								<strong>Category</strong> : ${product.category.categoryName}
							</p>

							<p>
								<c:if test="${product.unitsInStock > 0}">
							Available in stock
						</c:if>
								<c:if test="${product.unitsInStock <= 0}">
							Out of stock
						</c:if>
							</p>


							<p>
								<strong><fmt:formatNumber value="${product.unitPrice}"
										type="currency" /></strong>
							</p>

							<%-- If product is out of stock, disable the link
							A better solution would have been provided by javascript
						<c:if test="${product.unitsInStock <= 0}">
							<c:out value="disabled='disabled'"/></c:if> 
							
							--%>

							<p>
								<a href="<c:url value="/cart/add/${product.productId}"/> "
									class="btn btn-warning btn-large"> <span
									class="glyphicon-shopping-cart glyphicon"></span> <spring:message
										code="product.addtocart" />
								</a> <a href="<spring:url value="/cart/checkout" />"
									class="btn btn-default"> <span
									class="glyphicon-hand-right glyphicon"></span> <spring:message
										code="checkout" />
								</a> <a href="<spring:url value="/loginSuccess" />" class="btn btn-default">
									<span class="glyphicon-hand-left glyphicon"></span> <spring:message
										code="continueshopping" />
								</a>

							</p>

						</div>
					</div>
				</section>


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



					<li><a href="/terms" title="Terms and Conditions">Terms
							and Conditions</a></li>

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
	</div>
</body>
</html>
