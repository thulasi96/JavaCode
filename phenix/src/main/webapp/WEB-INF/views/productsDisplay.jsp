<%@include file="userhome.jsp"%>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>



<div class="container-fluid">
    <div class="content-wrapper">	
		<div class="item-container">	
			<div class="container">	
				<div class="col-md-12">
					<div class="product col-md-3 service-image-left">
                    <form action="<c:url value="/addcart/${productId}"/>" method="post">
						<center>
							<img id="item-display" src="<c:url value="/resources/images/${product.productId}.jpg"/>" alt=""></img>
						</center>
					</div>
					
				
				</div>
				
				<div class="col-md-7">
					<div class="product-title">${product.productName}</div>
					<div class="product-desc">${product.productDesc}</div>
					<div class="product-rating"><i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star-o"></i> </div>
					<hr>
					<div class="product-price">INR ${product.price}</div>
					<div class="product-stock">In Stock</div>
					
					<hr>
					
									
					<div class="btn-group cart">
						<input type="submit" class="btn btn-success" value="Add to cart"/>
						
					</div>
					
				</div>
			</div> 
		</div>
</div>
</div>
</form>