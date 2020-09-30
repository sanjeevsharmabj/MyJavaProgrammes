<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Users Portal</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:if test="${listProducts != true }"> 
		<p><strong>New User Form:</strong></p>
	<form action="newuser">
		<table>
		
		<tr>
			<td>First Name:</td> 
			<td><input type="text" name="firstName"
				value="${usersportal.firstName }" required /></td>

		</tr>
		<tr>
			<td>Last Name:</td> 
			<td><input type="text" name="lastName" value="${usersportal.lastName }"/></td>

		</tr>
		<tr>
			<td>Contact No:</td> <td>
			<input type="text" name="contactNo" value="${usersportal.contactNo }" required /><td>

		</tr>
		<tr>
			<td>Email:</td> <td><input type="text" name="emailAdd"
				value="${usersportal.emailAdd }" /></td>
		</tr>
		
		<tr><td><button>Continue</button></td></tr>
		</table>
	</form>
	</c:if>
	<c:if test ="${msg!=null}">
		<p><strong>${msg}</strong></p>
		
	</c:if>
	<c:if test="${listProducts == true }"> 
		<h3>Hello!! ${firstName}</h3>
    	<br/>
    	<nav>    
        	<a href="userprodlist">List All Products</a>               
    	</nav> 
        
 </c:if>
</body>
</html>