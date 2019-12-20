<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
	    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <title>Supplier</title>
	    <link rel="stylesheet" href="style.css" type="text/css" />
    </head>    
    <body>
		<div id="header">																												
			<ul class="menu">
				<li><a href = "productIndex">Add Product</a></li>
				<li><a href = "employeeIndex">Add Employee</a></li>
				<li><a href = "customerIndex">Add Customer</a></li>
				<li><a href = "supplierIndex">Add Supplier</a></li>
				<li><a href = "orderIndex">Add Order</a></li>
	        	<li><a href = "searchOrderIndex">Search Order</a></li>
	        	<li><a href = "orderIndex">Update Order</a></li>
			</ul>
		</div>	

        <div id="container">
			<h1>Order</h1>
			<s:actionerror/>      
			<s:form action="updateOrderValues" method="post">
				<s:textfield name="customer"   label="Customer" value="%{customer}" disabled="true" />
	            <s:textfield name="supplier"   label="Supplier" value="%{supplier}" disabled="true" />
	            <s:textfield name="employee"   label="Employee" value="%{employee}" disabled="true" />
	            <s:textfield name="product"   label="Product" value="%{product}" disabled="true" />			
				<s:textfield name="quantity" label="Quantity" value="%{quantity}" required="true" />					
				<s:textfield name="price" label="Price" value="%{price}" required="true" />	
				<s:label value="%{msg}"></s:label>	
				<s:submit value="Update Order" />
			</s:form>
        </div>
        
    </body>
</html>