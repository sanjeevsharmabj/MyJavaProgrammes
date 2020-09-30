<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Covid-19 Kit</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h3><Strong>Admin Control Page</Strong></h3>
		<p><strong>Hello!! ${username}</strong></p>
		<nav>
			<a href="listprods">Products List</a>
			<span>|</span>
			<a href="newprod">Add New Product</a>
			<span>|</span>
			<a href = "logout">Logout</a>
			<br/>
		</nav>
	

	<c:choose>
		<c:when test="${covidprodts==null||covidprodts.isEmpty()}">
			<p>No Covid-19 Products Available</p>
		</c:when>
		<c:otherwise>
			<br>
			<u><h3>Master Products Table</h3></u>
			<br/>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>ProductId</th>
					<th>Product Name</th>
					<th>Product Description</th>
					<th>Product Price</th>
					<th>Actions</th>
				</tr>
				<c:forEach items="${covidprodts}" var="covidprods">
					<tr>
						<td>${covidprods.prodId}</td>
						<td>${covidprods.prodName}</td>
						<td>${covidprods.prodDesc}</td>
						<td>${covidprods.prodPrice}</td>
						<td>
							<a href = "deleteprod?id=${covidprods.prodId}">DELETE</a>
							<span>|</span>
							<a href = "editprod?id=${covidprods.prodId}">EDIT</a>	
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>