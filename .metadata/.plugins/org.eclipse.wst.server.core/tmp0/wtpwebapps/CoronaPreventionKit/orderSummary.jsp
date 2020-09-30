<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Summary</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	 
    <h3>Final Order Summary</h3>
	<hr/>
	
	<p><strong>User Details:</strong></p>
	<div>Name: ${firstName} ${lastName}</div>
	<div>Email Id: ${emailAdd}</div>
	<div>Contact No: ${contactNo}</div>
	<hr/>
	
	<p><strong>Shipping Address:</strong></p>
	<div>Address: ${address}</div>
	<hr/>
	
	<p><strong>Order Summary:</strong></p>
	<c:choose>  
        <c:when test="${prodaddedtocart == null || prodaddedtocart.isEmpty() }">  
            <p>No Products have been added to cart!!</p>  
        </c:when>  
        <c:otherwise>  
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
    <hr/>
	<p><strong>Final Price: ${TotalPrice} INR</strong></p>
	<br/>
	<hr/>

</body>
</html>