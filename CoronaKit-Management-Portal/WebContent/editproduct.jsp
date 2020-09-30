<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CKMP - Edit Product</title>
</head>
<body>
    <jsp:include page="header.jsp" />
    
    <p><strong>Edit Product</strong></p>
    
    <form action="${'saveProduct'}" method="post">
        <div>
            <label>Product Id</label>
            <input type="number" name="productId" value="${product.productId}" required />
        </div>    
        <div>
            <label>Product Name</label>
            <input type="text" name="productName" value="${product.productName}" required />
        </div>
        <div>
            <label>Product Cost</label>
            <input type="decimal" name="productCost" value="${product.productCost}" required />
        </div>    
        <div>
            <label>Product Description</label>
            <input type="text" name="productDesc" value="${product.productDesc}" />
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