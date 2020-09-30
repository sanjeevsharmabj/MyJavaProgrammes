<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CKMP - Login</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	
	<c:if test="${loginSuccess != true }"> 
		<p><strong>Admin Login</strong></p>
		<form action="login">
        	<div>
            	<label>User Name</label>
            	<input type="text" name="userName" required />
        	</div>
        	<div>
            	<label>Password</label>
            	<input type="text" name="password" required />
        	</div>
        	<br/>
        	<div>       
        		<button>Login</button>  
        	</div> 
     	</form>
     </c:if>
     <c:if test="${loginSuccess == true }"> 
        <p><strong>Welcome ${userName}</strong></p>   
    	<nav>          
        	<a href="newProduct">Add New Product</a>  
        	<span>|</span>  
        	<a href="logout">Logout</a>          
    	</nav>     
 </c:if> 
		<br/> 
	<hr/>
	<jsp:include page="footer.jsp" />
</body>
</html>