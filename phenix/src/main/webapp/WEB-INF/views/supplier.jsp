<%@include file="adminhome.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="<c:url value="/insertsupplier"/>" method="post">
<table align="center">

<tr>
		<td colspan="2"><b>Supplier Management</b></td>
</tr>

<tr>
		<td> SupplierName</td>
		<td> <input type="text" name="supplierName" class="form-control" required/></td>
</tr>

<tr>
		<td> SupplierDesc</td>
		<td> <textarea cols="20" rows="7" class="form-control" name="supplierDesc" required></textarea></td>
</tr>



<tr>

	<td colspan="2">
			<center>
						<input type="submit" value="InsertSupplier" class=" btn btn-block mybtn btn-primary tx-tfm">
			</center>
	</td>
</tr>
</table>
</form>


<br></br>

<table align="center" border="1" width="400">
	
	<tr>
		<td>SL</td>
		<td>SupplierName</td>
		<td>SupplierDesc</td>
		<td colspan="2">
			<center>
			 	Options
			</center>
		</td>
	</tr>
	<c:forEach items="${supplierList}" var="supplier">
	<tr>
		<td>${supplier.supplierId} </td>
		
	
	
	<td>${supplier.supplierName}</td>
	
	<td>${supplier.supplierDesc}</td>
	
	
	
	<td>
		<a href="<c:url value="/EditSupplier/${supplier.supplierId}"/>">Edit</a>
	</td>
	
	<td>
		<a href="<c:url value="/DeleteSupplier/${supplier.supplierId}"/>">Delete</a>  
	</td>
	 
	</tr>
	
	
	</c:forEach>
	
</table>
</body>
</html>
	