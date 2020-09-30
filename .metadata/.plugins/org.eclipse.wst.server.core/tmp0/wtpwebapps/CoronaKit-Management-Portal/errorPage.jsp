<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CKMP - Error</title>
</head>
<body>
    <jsp:include page="header.jsp" />
    <h3>Error: ${errMsg }</h3>
    <p>
        Sorry for the inconvenience!
        Please Contact Administrator
    </p>
	<br/> 
	<hr/>
	<jsp:include page="footer.jsp" />
</body>
</html>