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
	<h3>${isNew? 'New Product':'Edit Product'}</h3>
	<form action="${isNew?'addprod':'saveprod'}" method ="post">
		<div>
			<label>ProdId</label>
			<input type ="number" name = "prodId" value="${covidprods.prodId}" required ${isNew?'':'readonly'} }>
		</div>
		<div>
			<label>Product Name</label>
			<input type ="text" name = "prodName" value="${covidprods.prodName}" required >
		</div>
		<div>
			<label>Product Description</label>
			<input type ="text" name = "prodDesc" value="${covidprods.prodDesc}" >
		</div>
		<div>
			<label>Product Price</label>
			<input type ="decimal" name = "prodPrice" value="${covidprods.prodPrice}" required>
		</div>
		<button>Save</button>
	</form>
</body>
</html>