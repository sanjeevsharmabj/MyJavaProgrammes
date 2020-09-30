<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CKMP - Show Kit</title>
</head>
<body>
	<jsp:include page="header.jsp" />        
    <c:choose>
        <c:when test="${kitAddedProducts == null || kitAddedProducts.isEmpty() }">
            <h3>No Products have been Added to the Kit</h3>
        </c:when>
        <c:otherwise>
        	<p><strong>List of Added Products:</strong></p> 
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
    
    <nav>          
        <a href="addAnotherProduct">Add Another Product</a> 
        <br/>
        <br/>
        <a href="placeorder.jsp"><button>Place Order</button></a>
<!--         <a href="placeorder.jsp">Place Order</a>              -->
    </nav> 
	<br/> 
	<hr/>
	<jsp:include page="footer.jsp" />
    
</body>
</html>