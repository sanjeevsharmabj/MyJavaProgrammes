<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Available Products</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<c:choose>
		<c:when test="${covidprodts==null||covidprodts.isEmpty()}">
			<p>No Covid-19 Products Available</p>
		</c:when>
		<c:otherwise>
			<nav>   
   				<br/>       
        		<a href="showKit">OrderCart</a>               
    		</nav>
    		<br/>
			<p><strong><u>Available Products</u></strong></p>
			
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>ProductId</th>
					<th>Product Name</th>
					<th>Product Description</th>
					<th>Product Price</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${covidprodts}" var="covidprods">
					<tr>
						<td>${covidprods.prodId}</td>
						<td>${covidprods.prodName}</td>
						<td>${covidprods.prodDesc}</td>
						<td>${covidprods.prodPrice}</td>
						<td><a href="addtokit?id=${covidprods.prodId}">AddtoCart</a></td>
					</tr>
				</c:forEach>	
			</table>
		</c:otherwise>
	</c:choose>
	<c:if test="${addMsg != null }">  
        <p>${addMsg }</p> 
        <br/> 
 	</c:if> 
</body>
</html>
