<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CKMP - Place Order</title>
</head>
<body>
	<jsp:include page="header.jsp" /> 
    
	<c:if test="${EnteredAddress != true }"> 
		<p><strong>Enter Shipping Address:</strong></p>
		<form action="placeOrder">
			<div>  
            	<label>Address:</label>  
            </div> 
			<div>  
            	<label>Line 1</label>  
            	<input type="text" name="AddLine1" required/>  
        	</div>  
        	<div>  
            	<label>Line 2</label>  
            	<input type="text" name="AddLine2" required/>  
        	</div>
        	<br/>
        	<div>  
            	<label>City:</label>  
            	<input type="text" name="City" required/>  
        	</div>
        	<br/>
        	<div>  
            	<label>State:</label>  
            	<input type="text" name="State" required/>  
        	</div>
        	<br/>
        	<div>  
            	<label>Pin Code:</label>  
            	<input type="number" name="PinCode" required/>  
        	</div>
        	<br/>
        	<button>Submit</button>
		</form>
 	</c:if>

	<c:if test="${EnteredAddress == true }"> 
		<div><Strong>Shipping Address: </Strong></div>
		<div>Address Line 1: ${AddLine1}</div>
		<div>Address Line 2: ${AddLine2}</div>
		<div>City: ${City}</div>
		<div>State: ${State}</div>
		<div>Pin Code: ${PinCode}</div>
		<br/>
		<nav>   
			<br/>       
        	<a href="orderSummary">View Order Summary</a>               
 		</nav> 
	</c:if>
	<br/>
	<hr/>
	<jsp:include page="footer.jsp" /> 
</body>
</html>