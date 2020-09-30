<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Details</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<c:choose>
		<c:when test="${prodaddedtocart ==null|| prodaddedtocart.isEmpty()}">
			<p>No Products Added to Cart</p>
		</c:when>
		<c:otherwise>
			<nav>          
        		<a href="listprodagain">Add Another Product</a> 
        		<span>|</span>
        		<a href="placeOrder.jsp"><button>Place Order</button></a>
        	<br/>
        	<br/>
        	<p><strong><u>List of Products Selected</u></strong></p>
        	<br/>	
     		</nav>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>ProductId</th>
					<th>Product Name</th>
					<th>Product Description</th>
					<th>Quantity</th>
					<th>Total Price</th>
				</tr>
				<c:forEach items="${prodaddedtocart }" var="covidprods">
				<tr>
					<td>${covidprods.prodId}</td>
					<td>${covidprods.prodDesc}</td>
					<td>${covidprods.prodName}</td>
					<td>${quantity.get(covidprods.prodId)}</td>
					<td>${(covidprods.prodPrice)*quantity.get(covidprods.prodId)}</td>
				</tr>
				</c:forEach>
				</table>
		</c:otherwise>
	</c:choose>
</body>
</html>