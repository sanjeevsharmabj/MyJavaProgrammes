<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Covid-19 Kit</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:if test ="${msg!=null}">
		<p><strong>${msg}</strong></p>
		
	</c:if>
</body>
</html>