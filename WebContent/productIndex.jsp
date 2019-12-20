<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Product Manager</title>
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
			<h1>Product Manager</h1>
			<s:actionerror/> 
     
			<s:form action="addProduct" method="post">	
				<s:textfield name="product.productname" label="Product Name" />
				<s:textfield name="product.productcategory" label="Product Category" />	 
				<s:submit value="Add Product" />
			</s:form>

			<h2>Products</h2>
			<table id="contact" border="1">
				<tr>
					<th>Product Id</th>
					<th>Name</th>
					<th>Category</th>	 
					<th>Delete</th>
				</tr>
				<s:iterator value="productList" var="product">
					<tr>
						<td><s:property value="productid"/> </td>
						<td><s:property value="productname"/></td>
						<td><s:property value="productcategory"/></td>
						<td><a href="deleteProduct?id=<s:property value="productid"/>">Delete</a></td>
					</tr>	
				</s:iterator>
			</table>
		</div>
		
	</body>
</html>