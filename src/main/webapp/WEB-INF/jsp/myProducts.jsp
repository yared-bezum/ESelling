<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title> Vendor Products</title>
</head>
<body>
<div class="container">
				<c:if test="${not empty emptylist}">
<div class="alert alert-success"  >
<spring:message code="novendorproducts"/><br />
</div>
</c:if>
</div>
<!-- <div id="main"> -->
		<!-- <div id="products"> -->
				<div class="row" >
				<c:forEach items="${vendorProducts}" var="product">
				<div class="products" >
					<div class="thumbnail" >
					<!-- <div class="col-md-5"> -->
						<img src="<c:url value="${product.productPath}"></c:url>" alt="image" style = "width:20%; float:left"/>  
					

					<!-- <div class="col-md-5"> -->
					<div class="caption">
					 <h3>${product.productName}</h3>
         <p><strong>Status :</strong><span class="label label-warning"> ${product.approval}</p> 
						<p><strong>Description :</strong> ${product.description}</p>
						<p>
							<strong>Category :</strong>  ${product.category.categoryName}
						</p>			

						<p>
							<strong>Available units in stock </strong> :
							       ${product.unitsInStock}
						</p>
						
						<h4>${product.unitPrice}USD</h4>
					</div>		
                    </div>
					</div>
					</c:forEach>
				</div>
</body>
</html>