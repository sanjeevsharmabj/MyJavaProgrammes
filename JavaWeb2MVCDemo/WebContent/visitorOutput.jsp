<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visitor OutPut page</title>
</head>
<body>
	<%String msg = (String)request.getAttribute("msg");%>
	<%if(msg!=null){%>
		<h2><%=msg%></h2>
		<%}%>
</body>
</html>