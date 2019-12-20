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
        	<h1>Supplier</h1>
        	<s:actionerror/>
		
			<s:form action="addSupplier" method="post">
	        	<s:textfield name="supplier.companyname" label="Supplier Name" />
				<s:textfield name="supplier.country" label="Supplier Country" />	 
				<s:submit value="Add Supplier" />
			</s:form>

			<h2>Suppliers</h2>
		    <table id="contact" border="1">
				<tr>
					<th>Supplier Id</th>
					<th>Name</th>
					<th>Country</th> 
					<th>Delete</th>
				</tr>
            	<s:iterator value="supplierList" var="supplier">
			    	<tr>
						<td><s:property value="supplierid"/></td>
						<td><s:property value="companyname"/></td>
						<td><s:property value="country"/></td>
						<td><a href="deleteSupplier?id=<s:property value="supplierid"/>">Delete</a></td>
			    	</tr>	
				</s:iterator>
			</table>
		</div>
		
	</body>
</html>