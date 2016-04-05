<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>

<body>
	
	<section class="container">
		<form:form  modelAttribute="product" class="form-horizontal" enctype="multipart/form-data">
			<fieldset>
				<legend>New product</legend>

	
				<div class="form-group">
					<label class="control-label col-lg-2" for="name">Product Name:</label>
					<div class="col-lg-10">
						<form:input class="form:input-large" id="name" path="productName" type="text" />
						<form:errors path="productName" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="unitPrice">Unit Price:</label>
					<div class="col-lg-10">
						
							<form:input class="form:input-large" id="unitPrice" path="unitPrice" type="text" />
							<form:errors path="unitPrice" cssClass="text-danger"/>
	
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="description">Description</label>
					<div class="col-lg-10">
						<form:textarea  class="form:input-large" id="description" path="description" rows = "2"/>
						<form:errors path="description" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="category">Category:</label>
					<div class="col-lg-10">
						<form:select class="form:input-large"  id="category"  path="category.categoryId" >
						<form:options items="${categories}" itemLabel="categoryName"
							itemValue="categoryId" />
							
					</form:select>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="unitsInStock">Quantity:</label>
					<div class="col-lg-10">
						<form:input class="form:input-large" id="unitsInStock" path="unitsInStock" type="text" />
						<form:errors path="unitsInStock" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="productCondition">Product Condition:</label>
					<div class="col-lg-10">
						<form:radiobutton path="productCondition" value="New" />New 
						<form:radiobutton path="productCondition" value="Old" />used 
						<form:radiobutton path="productCondition" value="Refurbished" />Refurbished
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="productImage">Product Image:</label>
					<div class="col-lg-10">
						<form:input class="form:input-large" id="productImage" path="productImage" type="file" />
					</div>
				</div>


				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
