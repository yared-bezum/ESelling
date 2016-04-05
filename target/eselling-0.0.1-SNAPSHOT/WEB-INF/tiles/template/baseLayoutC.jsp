<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">



</head>
<title>Online Shopping</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css"></style>
<link href="resources/css/all.css" rel="stylesheet" type="text/css" />
<link href="resources/css/index.css" rel="stylesheet" type="text/css" />


<body>
	<div class="container">
		<div id="header">
			<div class="right"
				style="padding-right: 16px; padding-top: 12px; width: 115px; height: 40px; float: right; margin-top: -59px; margin-right: 30px;">
				<ul>
					<li class="right"><a href="#"> <img align="right"
							alt="Spanish" src="resources/images/Sp.png"
							style="margin-right: -20px" title="Español" class="drop5">
					</a></li>
					<li class="right"><a href="#"> <img align="right"
							alt="French" src="resources/images/Fr.png"
							style="margin-right: 6px" title="Français" class="drop5">
					</a></li>
					<li class="right"><a href="#"> <img align="right"
							alt="English" src="resources/images/UK1.png"
							style="padding-right: 5px; opacity: 1;" title="English"
							class="drop5">
					</a></li>
				</ul>
			</div>
			<span class="logo left"> <a href="/eselling/"> <img
					alt="E-Selling System" title="E-Selling System"
					src="resources/images/logo.png" />
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
					<ul>

						<li><strong>Hello ${customer.firstName}</strong></li>
						<li><a href=" <spring:url value="/logout" />">SignOut</a></li>
						<li><a href="#"><pre id="separator">   |   </pre></a></li>
					</ul>
				</div>
			</div>

		</div>
		<%-- <h1>
				<tiles:insertAttribute name="heading" />
			</h1> --%>
		<p>
			<tiles:insertAttribute name="tagline" />
		</p>
	</div>

	<div class="row">
		<tiles:insertAttribute name="body" />
	</div>

	<div class="footer">
		<tiles:insertAttribute name="footer" />
	</div>

</body>
</html>
