<%@include file="adminhome.jsp"%>


<form action="<c:url value="/UpdateCategory"/>" method="post">
<table align="center">



<tr>
		<td> CategoryId</td>
		<td> <input type="text" value="${category.categoryId}"readonly class="form-control" name="categoryId"/></td>
</tr>

<tr>
		<td> CategoryName</td>
		<td> <input type="text" value="${category.categoryName}"  class="form-control" name="categoryName"/></td>
</tr>

<tr>
		<td> CategoryDesc</td>
		<td> <input type="text" value="${category.categoryDesc}" class="form-control" name="categoryDesc" /></td>
</tr>

<tr>

	<td colspan="2">
			<center>
						<input type="submit" value="UpdateCategory" class=" btn btn-block mybtn btn-primary tx-tfm">
			</center>
	</td>
</tr>
</form>
</table>
</body>



