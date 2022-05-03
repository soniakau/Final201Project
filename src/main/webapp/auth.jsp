<!-- JSP file for authorizing user login or initiating registration -->
<html>
<head>
	<meta charset="UTF-8">
	<title>Login / Register</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="auth.css" type="text/css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<!-- Get error -->
	<%
	String err = (String) request.getAttribute("error");
	%>
	<!-- Displaying error in a banner -->
	<%
	if (err != null) {
	%>
	<!-- insert error banner -->
	<div
		class="d-flex justify-content-center bg-danger bg-gradient text-light p-2"
		style="margin-top: 10px; margin-bottom: 10px;">
		<p><%=err%></p>
	</div>
	<%
	}
	%>
	<nav class="navbar justify-content-center align-items-center">
	  <span class="navbar-brand mb-0">
	  	<h1>Tic-Tac-Toe!</h1>
	  </span>
	</nav>
	<div class="d-flex justify-content-center align-items-center mt-5">
		
	    <div class="card shadow-lg p-3 mb-5 bg-body rounded">
	        <ul class="nav nav-tabs mb-3 justify-content-center align-items-center" id="pills-tab" role="tablist">
	            <li class="nav-item text-center active"> 
	            	<a class="nav-link" id="login-tab" data-toggle="tab" href="#login" role="tab" aria-controls="login" aria-selected="true">Login</a> 
	            </li>
	            <li class="nav-item text-center"> 
	            	<a class="nav-link" id="signup-tab" data-toggle="tab" href="#signup" role="tab" aria-controls="signup" aria-selected="false">Signup</a> 
	            </li>
	        </ul>
	        <div class="tab-content" id="pills-tabContent">
	            <div class="tab-pane fade show active" id="login" role="tabpanel" aria-labelledby="login-tab">
	                <div class="form px-4 pt-5"> 
	                	<form action="LoginDispatcher" method="GET">
			            	<input type="email" name="login_email" class="form-control" placeholder="Email"> 
				            <input type="password" name="login_password" class="form-control" placeholder="Password"> 
				            <button type="submit" class="btn btn-dark btn-block">Login</button>
				        </form>
	                </div>
	            </div>
	            <div class="tab-pane fade show" id="signup" role="tabpanel" aria-labelledby="signup-tab">
	                <div class="form px-4">
	                	<form action="RegisterDispatcher" method="GET">
			                <input type="text" name="name" class="form-control" placeholder="Name"> 
			                <input type="email" name="email" class="form-control" placeholder="Email"> 
			                <input type="password" name="password" class="form-control" placeholder="Password"> 
			                <input type="password" name="confpassword" class="form-control" placeholder="Confirm Password"> 
			                <button type="submit" class="btn btn-dark btn-block">Sign Up</button> 
		                </form>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	<script>
	$(document).ready(function(){
		
		  $(".nav-tabs a").click(function(){
		    $(this).tab('active');
		  });
		});
	</script>
</body>
</html>

