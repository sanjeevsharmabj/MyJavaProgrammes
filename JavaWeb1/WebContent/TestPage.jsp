<%@page import = "java.time.LocalDateTime" %>
<html>
<head>
<title>A simple JSP page</title>
</head>
<body>
	<h1>A Simple JSP Page</h1>
	<%! LocalDateTime dt = LocalDateTime.now(); %>
	<%=dt %>
	<p>
	<%for(int i=1;i<100;i++){%>
		<span><%=i %>,</span>
		<% }%>
	</p>
</body>
</html>