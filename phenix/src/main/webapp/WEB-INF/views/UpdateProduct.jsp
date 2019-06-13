<%@include file="adminhome.jsp"%>

<html>
   

<body>
      <c:url var="updateURL" value="/updateproduct"/>
      <form:form action = "${updateURL}" modelAttribute="product" method="post" enctype="multipart/form-data">
      <table align="center">
      
      <tr>
		<td colspan="2"> Product Management </td>
	  </tr>
      
      <tr>
         <td>ProductId</td>
         <td><form:input class="form-control" path ="productId" readonly="true"/></td>
      </tr>
      
      <tr>
         <td>ProductName</td>
         <td><form:input class="form-control" path ="productName"/></td>
      </tr>
            
            <tr>
               <td>Stock</td>
               <td><form:input class="form-control" path ="stock"/></td>
            </tr>
            <tr>
               <td>Price</td>
               <td><form:input class="form-control" path ="price"/></td>
            </tr>
            <tr>
               <td>Category</td>
               <td><form:select path ="categoryId" class="form-control">
               	   <form:option value="0" label="Select List"/>	
               	   <form:options items="${categoryList}"/>
               	   </form:select>
               </td>
               
            </tr>
            <tr>
               <td>Supplier</td>
               <td><form:select path ="supplierId" class="form-control">
               	   <form:option value="0" label="Select List"/>	
               	   <form:options items="${supplierList}"/>
               	   </form:select>
               </td>
               
               
          
            </tr>
            <tr>
               <td>ProductDesc</td>
               <td><form:textarea cols="20" rows="7" class="form-control" path="productDesc" /></td>
            </tr>
            
            
            
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "UpdateProduct" class=" btn btn-block mybtn btn-primary tx-tfm"/>
               </td>
            </tr>
         </table>  
      </form:form>
   </body>