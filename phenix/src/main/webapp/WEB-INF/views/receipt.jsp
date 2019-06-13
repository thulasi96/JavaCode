<%@include file="userhome.jsp"%>

<div class="container">
    <div class="row">
        <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
            

            <div class="row">
                <div class="text-center">
                    <h1>Receipt</h1>
                </div>
                </span>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Product</th>
                            <th>#</th>
                            <th class="text-center">Price</th>
                            <th class="text-center">Total</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cartList}" var="CartList">
                        <tr>
                            <td class="col-md-9"><em>${CartList.productName}</em></h4></td>
                            <td class="col-md-1" style="text-align: center">${CartList.quantity}</td>
                            <td class="col-md-1 text-center">${CartList.price}</td>
                            <td class="col-md-1 text-center">${CartList.price}</td>
                        </tr>
                        </c:forEach>
                        
                        <tr>
                            <td>   </td>
                            <td>   </td>
                            <td class="text-right">
                            <p>
                                <strong>Subtotal: </strong>
                            </p>
                            </td>
                            <td class="text-center">
                            <p>
                                <strong>${grandtotal}</strong>
                            </p>
                           </td>
                        </tr>
                        <tr>
                            <td>   </td>
                            <td>   </td>
                            <td class="text-right"><h4><strong>Total: </strong></h4></td>
                            <td class="text-center text-danger"><h4><strong>${grandtotal}</strong></h4></td>
                            <td class="text-right"><h4><strong>Paid </strong></h4></td>
                        </tr>
                    </tbody>
                </table>
                
            </div>
        </div>
    </div>