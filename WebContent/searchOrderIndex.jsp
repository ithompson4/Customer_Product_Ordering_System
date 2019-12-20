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
     
			<s:form action="searchOrder" method="post">
				<table>
					<s:select label="Select Customer" list="customerListDropDown" name="customer" id="customer" />		 
					<s:select label="Select Supplier" list="supplierListDropDown" name="supplier" id="supplier" />						
					<s:select label="Select Employee" list="employeeListDropDown" name="employee" id="employee" />
					<s:select label="Select Product" list="productListDropDown" name="product" id="product" />
					<s:submit value="Search Order" />
				</table>	
			</s:form>

			<h2>Orders Found:</h2>
			<table id="contact" border="1">
				<tr>
					<th>Customer</th>
					<th>Supplier</th>
					<th>Employee</th>
					<th>Product</th>
					<th>Price</th>
					<th>Quantity</th>
				</tr>
            	<s:iterator value="odersFactList" var="orders">
					<tr>
						<td><s:property value="customerDetail"/> </td>
						<td><s:property value="supplierDetail"/></td>
						<td><s:property value="employeeDetail"/></td>
						<td><s:property value="productDetail"/></td>
						<td><s:property value="price"/></td>
						<td><s:property value="quantity"/></td>	 
					</tr>	
				</s:iterator>
			</table>
		</div>
		
    </body>
</html>