<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>
	<h3><%=LocalDate.now() %></h3>
	<jsp:include page="banner.jsp"></jsp:include>
	
	<form action="ServletA">
		<label>Message
				<input type="text" name = "m1">		
		</label>	
		<button name="btn" value = "f">Forward</button>
		<button name="btn" value = "r">Redirect</button>
	</form>
</body>
</html>