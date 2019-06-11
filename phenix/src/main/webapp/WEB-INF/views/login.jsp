<%@include file="header.jsp"%>


<body>
    <div class="container">
        <div class="row">
			<div class="col-md-5 mx-auto">
			<div id="first">
				<div class="myform form ">
					 <div class="logo mb-3">
						 <div class="col-md-12 text-center">
							<h1>Login</h1>
						 </div>
					</div>
                   <form action="<c:url value="/perform_login"/>" method="post" name="login">
                           <div class="form-group">
                              <label>Username</label>
                              <input type="username" name="username"  class="form-control" id="username" aria-describedby="usernameHelp" placeholder="Enter username">
                           </div>
                           <div class="form-group">
                              <label>Password</label>
                              <input type="password" name="password" id="password"  class="form-control" aria-describedby="emailHelp" placeholder="Enter Password">
                           </div>
                           <div class="form-group">
                              <p class="text-center">By signing up you accept our <a href="#">Terms Of Use</a></p>
                           </div>
                           <div class="col-md-12 text-center ">
                              <input type="submit" value ="Login" class=" btn btn-block mybtn btn-primary tx-tfm">
                           </div>
                           </form>
                           <div class="border-top card-body text-center">Don't have an account <a href="register">Sign Up</a></div>
							</div> <!-- card.// -->
                           
                           </div>
              </div>
              </div>
              </div>
              </div>
              
         
</body>