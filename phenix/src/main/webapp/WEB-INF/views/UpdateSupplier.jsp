<%@include file="adminhome.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="<c:url value="/updatesupplier"/>" method="post">
<table align="center">



<tr>
		<td> SupplierId</td>
		<td> <input type="text" value="${supplier.supplierId}"readonly class="form-control" name="supplierId"/></td>
</tr>

<tr>
		<td> SupplierName</td>
		<td> <input type="text" value="${supplier.supplierName}" class="form-control" name="supplierName" /></td>
</tr>

<tr>
		<td> SupplierDesc</td>
		<td> <input type="text" value="${supplier.supplierDesc}" class="form-control" name="supplierDesc"/></td>
</tr>

<tr>

	<td colspan="2">
			<center>
						<input type="submit" value="UpdateSupplier" class=" btn btn-block mybtn btn-primary tx-tfm">
			</center>
	</td>
</tr>
</table>
</form>