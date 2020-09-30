<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Place Order</title>
</head>
<body>
	<jsp:include page="header.jsp" /> 
    
	<c:if test="${enteraddress != true }"> 
		<p><strong>Enter Shipping Address:</strong></p>
		<form action="placeorder">
			<div>
			<label>Address:</label> <input type="text" name="address"
				value="${usersportal.address}" required />
			</div>
			<br/>
        	<button>Order</button>
		</form>
 	</c:if>

	<c:if test="${enteraddress == true }"> 
		<div><Strong>Shipping Address: </Strong></div>
		<div>Address: ${address}</div>
		<br/>
		<nav>   
			<br/>       
        	<a href="orderSummary">Order Summary</a>               
 		</nav> 
	</c:if>
	<br/>
	<hr/> 
</body>
</html>