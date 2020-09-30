<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CKMP - Products List</title>
</head>
<body>
	<jsp:include page="header.jsp" /> 
    <c:choose>
        <c:when test="${products == null || products.isEmpty() }">
            <h3>No Products Available</h3>
        </c:when>
        <c:otherwise>
        	<p><strong>List of Available Products:</strong></p>  
			<table border="1" cellspacing="5px" cellpadding="5px">
                <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Product Cost</th>
                    <th>Product Description</th>
                    <th>Actions</th>
                </tr>
                <c:forEach items="${products }" var="product">
                    <tr>
                        <td>${product.productId}</td>
                        <td>${product.productName}</td>
                        <td>${product.productCost}</td>
                        <td>${product.productDesc}</td>
                        <td>
                            <a href="addProductsToKit?id=${product.productId}">Add</a>
                        </td>
                    </tr> 
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
    <br/>
 	<c:if test="${addedMsg != null }">  
        <p>${addedMsg }</p> 
        <br/> 
 	</c:if>  
    
    <nav>   
   		<br/>       
        <a href="showKit">Show Kit - Added Products</a>               
    </nav> 
	
	<br/>
	<hr/> 
	<jsp:include page="footer.jsp" />
    
</body>
</html>