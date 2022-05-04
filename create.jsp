import GameData.java;

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create</title>

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
        	<span><a href="http://localhost:8080/abubna_CSCI201_Assignment2/index.jsp">HOME</a>&nbsp&nbsp&nbsp&nbsp&nbsp
        	<a href="http://localhost:8080/abubna_CSCI201_Assignment2/auth.jsp">LOGIN</a>&nbsp&nbsp
        	<a href="http://localhost:8080/abubna_CSCI201_Assignment2/auth.jsp">REGISTER</a>
        	</span>
        </span> 	
        	
        <br>
        <hr>
        <br>
        <h1 style="text-align: center; font-size: 66px; font-family: Schoolbell;" >CREATE A GAME</h1>
        <br>
        <br>
        <p style="text-align: center; font-size: 36px; font-family: Schoolbell;">Your game code is below. Share it with your opponent</p>
        <br>
	    
	    <p style="margin-left: 47%; font-size: 26px;" id = "code"></p>
	    <script>
	    	GameData.gameID = document.getElementById("code").innerHTML = Math.floor(Math.random()* 100000);
	    </script>
	       
</body>
</html>