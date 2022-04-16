<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta content="301645777112-2rlc9gth0f5d4reimjcm9bf0kj7ahec0.apps.googleusercontent.com"
          name="google-signin-client_id">
    <title>Login / Register</title>
    <link href="https://fonts.googleapis.com" rel="preconnect">
    <link crossorigin href="https://fonts.gstatic.com" rel="preconnect">
    <link
            href="https://fonts.googleapis.com/css2?family=Lobster&family=Roboto:wght@300&display=swap"
            rel="stylesheet">
    <script crossorigin="anonymous"
            src="https://kit.fontawesome.com/3204349982.js"></script>
    <script async defer src="https://apis.google.com/js/platform.js"></script>
    <link href="index.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto"
          rel="stylesheet" type="text/css">
    <script src="https://apis.google.com/js/api:client.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"/>
	<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Lobster" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <%@ page import="Util.*" %>
    
	<!-- Sign in with Google -->
	<meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="1075330918641-djkklqrevh10rbrr9r7292nsvrm0gd7e.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>

</head>
<body>

	<%
	
	// Setup error and field default values
	String error = (String) request.getAttribute("error");
	
	String email = Help.getParameter(request, "email", "");
	String username = Help.getParameter(request, "name", "");
	String password = Help.getParameter(request, "password", "");
	String confPassword = Help.getParameter(request, "conf-password", "");
	String confirm = Help.getParameter(request, "confirm", "");
	
	boolean wasLogin = request.getRequestURI().contains("/Login");
	
	%>
	
	
	<!--  Error -->
	<% if (error != null) { %>
		<div class="d-flex justify-content-center p-3" style="background-color: #ffcfd9">
			<p class="mb-0"><%= error %></p>
		</div>
	<% } %>

	<!-- Header -->
	<div>
	    <nav class="navbar navbar-expand-lg navbar-light bg-white">
		  <div class="container-fluid">
		  	<div class="navbar-brand flex-grow-1">
		  		<a href="index.jsp" style="font-family: Lobster; color: #e74c3c; text-decoration: none; margin-right: 20px">SalEats</a>
		      	
		      	<% if (Help.isLoggedIn(request)) { %>
		          	<span style="font-size: 15px;">Hello <%= Help.getName(request) %>!</span>
		          <% } %>
		  	</div>
		      
		      <ul class="navbar-nav">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
		        </li>
		        <li class="nav-item">
		          <% if (Help.isLoggedIn(request)) { %>
		          	<a class="nav-link" href=<%= response.encodeURL("Logout") %>>Log Out</a>
		          <% } else { %>
		          	<a class="nav-link" href="auth.jsp">Login/Register</a>
		          <% } %>
		        </li>
		      </ul>
		  </div>
		</nav>
		<hr width="100%" style="margin-top: 0px">
	</div>
	
	
	<!-- Body -->
	<div class="container">
		<div class="row" style="margin-top: 40px">
			<div class="col-6 align-self-center" style="padding-left: 30px; padding-right: 30px">
				<h3>Login</h3>
				
				<form method="GET" action="Login">
				  <div class="mb-3">
				    <label for="email" class="form-label">Email</label>
				    <input type="email" class="form-control" name="email" value="<%= wasLogin ? email : "" %>" required>
				  </div>
				  <div class="mb-4">
				    <label for="password" class="form-label">Password</label>
				    <input type="password" class="form-control" name="password" value="<%= wasLogin ? password : "" %>" required>
				  </div>
				  
				  <div class='d-flex flex-row'>
				  	
				  </div>
				  
				  <div class="d-grid gap-2">
					  <button type="submit" class="btn btn-danger"><i class="bi bi-box-arrow-in-right"></i> Login</button>
				 
				  </div>
				  
				</form>
			</div>
			
			<div class="col-6" style="padding-left: 30px; padding-right: 30px">
				<h3>Register</h3>
				
				<form method="GET" action="Register">
					<div class="mb-3">
				    <label for="name" class="form-label">Username</label>
				    <input class="form-control" name="name" value="<%= !wasLogin ? username : "" %>" required>
				  </div>
				  <div class="mb-3">
				    <label for="email" class="form-label">Email</label>
				    <input type="email" class="form-control" name="email" value="<%= !wasLogin ? email : "" %>" required>
				  </div>
				  <div class="mb-3">
				    <label for="password" class="form-label">Password</label>
				    <input type="password" class="form-control" name="password" required>
				  </div>
				  <div class="mb-3">
				    <label for="conf-password" class="form-label">Confirm Password</label>
				    <input type="password" class="form-control" name="conf-password" required>
				  </div>
				  <div class="mb-4 form-check">
				    <input type="checkbox" class="form-check-input" name="confirm" required>
				    <label class="form-check-label" for="confirm">I have read and agreed to all terms and conditions of SalEats.</label>
				  </div>
				  <div class="d-grid gap-2">
					  <button type="submit" class="btn btn-danger"><i class="bi bi-person-plus"></i> Create Account</button>
				  </div>
				  
				</form>
			</div>
		</div>
	</div>

</body>
</html>