<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CKMP - Add Product</title>
</head>
<body>
    <jsp:include page="header.jsp" />
    
    <p><strong>Add New Product</strong></p>
    
    <form action="${'addProduct'}" method="post">
        <div>
            <label>Product Id</label>
            <input type="number" name="productId" required />
        </div>    
        <div>
            <label>Product Name</label>
            <input type="text" name="productName" required />
        </div>
        <div>
            <label>Product Cost</label>
            <input type="decimal" name="productCost" required />
        </div>    
        <div>
            <label>Product Description</label>
            <input type="text" name="productDesc" />
        </div>
        <div>       
        	<button>Save</button>  
        </div>      
    </form>
    
    <br/> 
	<hr/>
	<jsp:include page="footer.jsp" />
</body>
</html>