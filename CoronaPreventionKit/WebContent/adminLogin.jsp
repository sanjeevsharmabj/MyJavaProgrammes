<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login Page</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:if test="${login!= true }">
		<h2>Admin Login</h2>
	
		<form action="adminLogin">
			<table>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="user" required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
				<td></td>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
	</c:if>
	<c:if test="${login == true }">
		<h2><Strong>Admin Control Page</Strong></h2>
		<p><strong>Hello!! ${username}</strong></p>
		<nav>
			<a href="listprods">Products List</a>
			<span>|</span>
			<a href="newprod">Add New Product</a>
			<span>|</span>
			<a href = "logout">Logout</a>
			<br/>
		</nav>
	</c:if>
	
</body>
</html>