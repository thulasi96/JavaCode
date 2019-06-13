<%@include file="adminhome.jsp"%>



<body>

<form action="<c:url value="/insertcategory"/>" method="post">
<table align="center" >

<tr>
		<td colspan="2"><b>Category Management</b></td>
</tr>



<tr>
		<td> CategoryName</td>
		<td> <input type="text" name="categoryName" class="form-control" required/></td>
		
</tr>



<tr>
		<td> CategoryDesc</td>
		<td> <textarea cols="20" rows="7" name="categoryDesc" class="form-control" required></textarea></td>
</tr>
 
<tr>

	<td colspan="2">
			<center>
						<input type="submit" value="InsertCategory" class=" btn btn-block mybtn btn-primary tx-tfm">
			</center>
	</td>
</tr>

</table>
</form>


<br></br>

<table align="center" align="center" border="2" width="400">
	<tr>
		<td>SL#</td>
		<td>CategoryName</td>
		<td>CategoryDesc</td>
		<td colspan="2">
			<center>
			 	Options
			</center>
		</td>
	</tr>
	<c:forEach items="${categoryList}" var="category">
	<tr>
		<td>${category.categoryId} </td>
	
	<td>${category.categoryName}</td>
	
	<td>${category.categoryDesc}</td>
	
	<td>
		<a href="<c:url value="/EditCategory/${category.categoryId}"/>">Edit</a>
	</td>
	
	<td>
		<a href="<c:url value="/DeleteCategory/${category.categoryId}"/>">Delete</a>  
	</td>
	 
	</tr>
	</c:forEach>
</table>
</body>
</html>
	