<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>

    <script src="https://kit.fontawesome.com/3204349982.js"
            crossorigin="anonymous"></script>
            
            
                         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
                       
         <link href="https://fonts.googleapis.com/css?family=Schoolbell&v1" rel="stylesheet">

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/3204349982.js" crossorigin="anonymous"></script>

</head>
<style>
saleats{
	font-family: Lobster;
	font-size: 46px;
	color: #b0331f;
	padding-left: 55px;
}

.topnav .search-container{
	float:center;
}

</style>
<body>
<br>
<saleats> <a href="http://localhost:8080/abubna_CSCI201_Assignment2/index.jsp" style="color: #b0331f;"> #  </a> </saleats>
        
        <span class="tr-links" style = "margin-left: 1100px; text-align:right; font-size: 20px; color: gray; font-family: Schoolbell; ">
        	<span><a href="">HOME</a>
        	<a href="">LOGIN</a>
        	<a href="">REGISTER</a>
        	</span>
        </span> 	
        	
        <br>
        <hr>
        <br>
        <h1 style="text-align: center; font-size: 66px; font-family: Schoolbell;" >JOIN A GAME</h1>
        <br>
        <br>
        <p style="text-align: center; font-size: 36px; font-family: Schoolbell;">Enter the game code down below</p>
        <br>
	    <div class = "topnav">
	    	<div class = "search-container">
		    	 <form method="GET" action="Join">
		        	<input style="margin-left: 45%; text-align: center;" type = "text" placeholder = "ex. 42651" name="gameCode">
		        	<button type="submit">Join</button>
		        </form>
		        
	    	</div>  
	    </div>
	    
	       
</body>
</html>