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
    	<nav>
        	<a href="newProduct">Add New Product</a>
        	<span>|</span>
        	<a href="logout">Logout</a>        
    	</nav>
    <hr />
     
    <c:if test="${msg != null }">  
        <p><strong>${msg }</strong></p> 
        <br/> 
 	</c:if>  
 	  
    <c:choose>
        <c:when test="${products == null || products.isEmpty() }">
            <p>No Products Available</p>
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
                            <a href="deleteProduct?id=${product.productId}">DELETE</a>
                            <span>|</span>
                            <a href="editProduct?id=${product.productId}">EDIT</a>
                        </td>
                    </tr> 
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>

	<br/> 
	<hr/>
	<jsp:include page="footer.jsp" />
</body>
</html>