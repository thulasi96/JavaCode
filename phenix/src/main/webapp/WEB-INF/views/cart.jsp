<%@include file="userhome.jsp"%>



 </nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Phoenix-CART</h1>
     </div>
</section>


<div class="container mb-4">
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col"> </th>
                            <th scope="col">Product</th>
                            <th scope="col">Available</th>
                            <th scope="col" class="text-center">Quantity</th>
                            <th scope="col" class="text-right">Price</th>
                            <th> </th>
                        </tr>
                    </thead>
                    <tbody> 
                    
  					<c:forEach items="${cartList}" var="CartList">
  					<form action="<c:url value="/updatecart/${CartList.cartId}"/>" method="post">
  						<tr>
  							<td></td>
                            <td>${CartList.productName}</td>
                            <td>In Stock</td>
                            <td><input class="form-control" type="text" value="${CartList.quantity}" name="quantity"/></td>
                            <td class="text-right">${CartList.price}</td>
                            <td class="text-right">
                            <input type="submit" value="Update" class="btn btn-sm btn-danger"/>
                            <a href="<c:url value="/Removecart/${CartList.cartId}"/>" class="btn btn-sm btn-danger"> Remove</a>
                            </td>
                            
                        </tr>         
                        </form> 
                        </c:forEach>
   						
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>Sub-Total</td>
                            <td class="text-right">${grandtotal}</td>
                        </tr>
       
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><strong>Total</strong></td>
                            <td class="text-right"><strong>${grandtotal}</strong></td>
                        </tr>
                        
                    </tbody>
        
                </table>
        
            </div>
        </div>
        
        <div class="col mb-2">
            <div class="row">
            
                <div class="col-sm-12  col-md-6">
                <a href="<c:url value="/productpage"/>">
                    <button class="btn btn-block btn-light">
                    Continue Shopping
                    </button>
                </a>   
                </div>
                
                
                <div class="col-sm-12 col-md-6 text-right">
                <a href="<c:url value="/orderconfirm/${product.productId}"/>">
                    <button class="btn btn-lg btn-block btn-success text-uppercase" value="orderconfirm">
                    Checkout
                    </button>
                   </a> 
                </div>
                
            </div>
        </div>
    </div>
</div>

	
                      
                        
                        
                        
                        