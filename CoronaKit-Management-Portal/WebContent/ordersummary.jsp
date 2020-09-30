<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CKMP - Order Summary</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	 
    <h3>Order Summary</h3>
	<hr/>
	
	<p><strong>User Details:</strong></p>
	<div>Name: ${userFullName}</div>
	<div>Email Id: ${userEmailId}</div>
	<div>Contact No: ${userContactNo}</div>
	<hr/>
	
	<p><strong>Shipping Address:</strong></p>
	<div>Address Line 1: ${AddLine1}</div>
	<div>Address Line 2: ${AddLine2}</div>
	<div>City: ${City}</div>
	<div>State: ${State}</div>
	<div>Pin Code: ${PinCode}</div>
	<hr/>
	
	<p><strong>Product Summary:</strong></p>
	<c:choose>  
        <c:when test="${kitAddedProducts == null || kitAddedProducts.isEmpty() }">  
            <p>No Products have been added to Kit</p>  
        </c:when>  
        <c:otherwise>  
        	<table border="1" cellspacing="5px" cellpadding="5px">  
                <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Product Cost</th>
                    <th>Product Description</th>
                    <th>Quantity</th>
                </tr>
                <c:forEach items="${kitAddedProducts }" var="product">
                    <tr>
                        <td>${product.productId}</td>
                        <td>${product.productName}</td>
                        <td>${product.productCost}</td>
                        <td>${product.productDesc}</td>
                        <td>${quantity.get(product.productId)}</td>
                    </tr> 
                </c:forEach> 
            </table>  
        </c:otherwise>  
    </c:choose>
    <hr/>
	<p><strong>Total Cost: ${TotalAmount} INR</strong></p>
	<br/>
	<hr/>
	<jsp:include page="footer.jsp" /> 
</body>
</html>