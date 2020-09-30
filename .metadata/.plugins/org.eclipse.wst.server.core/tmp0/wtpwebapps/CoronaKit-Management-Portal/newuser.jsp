<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CKMP - User</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	    
	<c:if test="${listProductPage != true }"> 
		<p><strong>New User Form:</strong></p>
		<form action="newUser">
			<div>
            	<label>First Name</label>
            	<input type="text" name="firstName" required />
        	</div>
        	<div>
            	<label>Last Name</label>
           		<input type="text" name="lastName" required />
        	</div>    
        	<div>
            	<label>Email Id</label>
            	<input type="text" name="emailId" required />
        	</div>
        	<div>
            	<label>Contact No</label>
            	<input type="number" name="contactNo" required />
        	</div>    
        	<br/>
        	<div>       
        		<button>Next</button>  
        	</div>
		</form>
 	</c:if>

	<c:if test="${listProductPage == true }"> 
		<h3>Welcome ${userFullName}</h3>
    	<br/>
    	<nav>    
        	<a href="listAllProducts">List All Products</a>               
    	</nav> 
        
 </c:if> 
<br/> 
<hr/>
<jsp:include page="footer.jsp" /> 
</body>
</html>