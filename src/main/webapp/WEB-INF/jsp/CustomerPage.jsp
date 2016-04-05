<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title></title>
</head>
<body>

	<div id="main">

		<div id="products">
			<ul>
				<c:forEach items="${products}" var="product">
					<li id="product1" class="products">
						<div class="innerproduct">
							<div>
								<div class="titleOptions">
									<a href="<spring:url value="/products/product?id=${product.productId}" />"> <img
										src="<c:url value="${product.productPath}"></c:url>"
										height="246px" width="190px">
									</a>
								</div>
								<div class="productinfo">
									<div class="productdescription">
										<a href="<spring:url value="/products/product?id=${product.productId}" />"> <span class="large bold">
												${product.productName} </span>
										</a>
									</div>
									<div class="productprice">
										<a href="<spring:url value="/products/product?id=${product.productId}" />"> <span class="bold large red">$${product.unitPrice }</span>
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

</body>
</html>
