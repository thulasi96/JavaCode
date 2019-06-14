<%@include file="userhome.jsp"%>




<div class="container">
    <div class="row">
        <div class="col-xs-12 col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        Payment Details
                    </h3>
                   
                </div>
                <form action="<c:url value="/pay"/>" method="post">
                <div class="panel-body">
                    <form role="form">
                    <div class="form-group">
                        <label for="cardonname">
                            CARD ON NAME</label>
                            <div class="input-group">
                            <input type="text" class="form-control" required />
                            <span class="input-group-addon"></span>
                        </div>
                            <label for="cardNumber">
                            CARD NUMBER</label>
                        <div class="input-group">
                            <input type="text" class="form-control" Pattern="[0-9]{13,16}" id="cardNumber" placeholder="Valid Card Number"
                                 autofocus />
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                        </div>
                    </div>
                    <div class='form-row'>
              <div class='form-group cvc required'>
                <label class='control-label'>CVC</label>
                <input autocomplete='off' class='form-control card-cvc' Pattern="[0-9]{3,3}" placeholder='ex. 311' size='4' type='text'>
              </div>
              <div class='form-group expiration required'>
                <label class='control-label'>Expiration</label>
                <input class='form-control card-expiry-month' required placeholder='MM' size='2' type='text'>
              </div>
              <div class='form-group expiration required'>
                <label class='control-label'>Year</label>
                <input class='form-control card-expiry-year' required placeholder='YYYY' size='4' type='text'>
              </div>
            </div>
                
           
            <br/>
            
            <input class="btn btn-success btn-lg btn-block" type="submit" value="Pay"/>
        </div>
        </form>
    </div>
</div>
</div>
</div>
