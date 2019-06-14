<%@include file="header.jsp"%>


<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
</head>

    
    
<div class="row justify-content-center">
<div class="col-md-6">
<div class="card">
<header class="card-header">
	<a href="login" class="float-right btn btn-outline-primary mt-1">Log in</a>
	<h4 class="card-title mt-2">Sign up</h4>
</header>
<article class="card-body">
<form action="<c:url value="/registration"/>" method="post">
	<div class="form-row">
		<div class="col form-group">
			<label>First name </label>   
		  	<input type="text" name="firstname" required class="form-control" placeholder="First Name">
		</div> <!-- form-group end.// -->
		
		<div class="col form-group">
			<label>Last name</label>
		  	<input type="text" name="lastname" required class="form-control" placeholder="Last Name">
		</div> <!-- form-group end.// -->
	</div> <!-- form-row end.// -->
	
		<div class="form-group">
                    <label>Date of Birth</label>
                    
                        <input id="datepicker" width="270" name="dob" required/>
                        <script>
        				$('#datepicker').datepicker({
           				 uiLibrary: 'bootstrap'
        					});
   						 </script>
   						 
                    </div>
	
	<div class="form-group">
		<label>Username</label>
		<input type="username" name="username" required class="form-control" placeholder="Username">
		<small class="form-text text-muted">We'll never share your username with anyone else.</small>
	</div> <!-- form-group end.// -->
	
	
	
	<div class="form-group">
		<label>Create password</label>
	    <input name="password" class="form-control" required type="password">
	   
	</div> <!-- form-group end.// --> 
	
	
	 
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Register  </button>
        
    </div> <!-- form-group// -->      
    <small class="text-muted">By clicking the 'Sign Up' button, you confirm that you accept our <br> Terms of use and Privacy Policy.</small>                                          
</form>
</article> <!-- card-body end .// -->

<div class="border-top card-body text-center">Have an account? <a href="login">Log In</a></div>
</div> <!-- card.// -->
</div> <!-- col.//-->

</div> <!-- row.//-->


</div> 