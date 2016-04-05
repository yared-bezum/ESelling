<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<title>Online Shopping</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css"></style>
<link href="resources/css/all.css" rel="stylesheet" type="text/css" />
<link href="resources/css/index.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<!-- Header goes here--->
	

	<!--Main Content goes here --->
	
	<div class="container">
				<c:if test="${not empty successful}">
<div class="alert-success"  >
<spring:message code="successful"/><br />
</div>
</c:if>
</div>
	<div id="main">

		<div id="products">
			<ul>
				<c:forEach items="${products}" var="product">
					<li id="product1" class="products">
						<div class="innerproduct">
							<div>
								<div class="titleOptions">
									<a href="<spring:url value="/products/product?id=${product.productId}" />"> 
										<img src="<c:url value="${product.productPath}"></c:url>" alt="image"  height="246px" width="190px"/>  
									</a>
								</div>
								<div class="productinfo">
									<div class="productdescription">
										<a href="<spring:url value="/products/product?id=${product.productId}" />"> <span class="large bold">
												${product.productName} </span>
										</a>
									</div>
									<div class="productprice">
										<a href="<spring:url value="/products/product?id=${product.productId}" />"> <span class="bold large red"><fmt:formatNumber value="${product.unitPrice}" type="currency"/></span>
										</a>
									</div>
								</div>
							</div>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>



	</div>

	<!--Footer goes here --->
	
</body>

</html>
