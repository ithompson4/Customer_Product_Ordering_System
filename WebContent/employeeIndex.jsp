<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Employee Manager</title>
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
			<h1>Employee</h1>
			<s:actionerror/> 
     
			<s:form action="addEmployee" method="post">	
				<s:textfield name="employee.employeelastname" label="Employee Last Name" />
				<s:textfield name="employee.mgrlastname" label="Manager Last Name" />	 
				<s:submit value="Add Employee" />
			</s:form>

			<h2>Employees</h2>
			<table id="contact" border="1">
				<tr>
					<th>Employee Id</th>
					<th>Last Name</th>
					<th>Manager Last Name</th>	 
					<th>Delete</th>
				</tr>
				<s:iterator value="employeeList" var="employee">
					<tr>
						<td><s:property value="employeeid"/> </td>
						<td><s:property value="employeelastname"/></td>
						<td><s:property value="mgrlastname"/></td>
						<td><a href="deleteEmployee?id=<s:property value="employeeid"/>">Delete</a></td>
					</tr>	
				</s:iterator>
			</table>
    	</div>
    	
	</body>
</html>