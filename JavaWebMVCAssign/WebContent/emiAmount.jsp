<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.wellsfargo.fsd.model.EmiModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMI Amount</title>
</head>
<body>
		<form action="emis">
			<label>Principal <input type = "number" name="principal" required></label><br />
			<label>Duration <input type = "number" name="duration" required></label><br />
			<label>Rate of Interest <input type = "number" name="roi" required></label><br />
			<button>Calculate</button>
		</form>
		<% EmiModel emi = (EmiModel)request.getAttribute("model1"); %>
		<% if(emi!=null) {%>
				<table>
					<tr><td>Principal</td><td><strong><%=emi.getPrincipal() %></strong></td></tr>
					<tr><td>Duration</td><td><strong><%=emi.getDuration() %></strong></td></tr>
					<tr><td>Rate of Interest</td><td><strong><%=emi.getRoi() %></strong></td></tr>
					<tr><td>EMI Amount</td><td><strong><%=emi.getEmiamount() %></strong></td></tr>
				</table>
			<%} %>
</body>
</html>