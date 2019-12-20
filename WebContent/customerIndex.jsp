<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Customer</title>
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
			<h1>Customer</h1>
			<s:actionerror/> 
     
			<s:form action="addCustomer" method="post">
				<s:textfield name="customer.companyname" label="Customer Company" />
				<s:textfield name="customer.city" label="City" />
				<s:textfield name="customer.country" label="Country" />
				<s:submit value="Add Customer" />
			</s:form>

			<h2>Customers</h2>
			<table id="contact" border="1">
				<tr>
					<th>Customer Id</th>
					<th>Company Name</th>
					<th>City</th>
					<th>Country</th>	 
					<th>Delete</th>
				</tr>
				<s:iterator value="customerList" var="customer">
					<tr>
						<td><s:property value="customerid"/> </td>
						<td><s:property value="companyname"/></td>
						<td><s:property value="city"/></td>
						<td><s:property value="country"/></td>
						<td><a href="deleteCustomer?id=<s:property value="customerid"/>">Delete</a></td>
					</tr>	
				</s:iterator>
			</table>
        </div>

	</body>
</html>