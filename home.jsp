<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Odibee Sans&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/6e009e6cd4.js" crossorigin="anonymous"></script>
    <style>
    
    .createGame {
    	margin-top: 30px;
    	text-align: center;
    	font-size: 30px;
    	margin-left: 50px;
    	width: 150px;
    	height: 40px;
		background-color: #9e0079;
 		color: white;
 		padding: 15px 25px;
 		text-decoration: none;
 		font-family: 'Odibee Sans', monospace;
	}
	.joinGame{
		
		text-align: center;
		margin-top: 30px;
		font-size: 30px;
		margin-left: 50px;
		width: 150px;
    	height: 40px;
		background-color: #0073e6;
 		color: white;
 		padding: 15px 25px;
 		text-decoration: none;
 		font-family: 'Odibee Sans', monospace;
	}
	.logoutButton  {
		font-size: 20px;
		letter-spacing: 0.1em;
	    float: right;
	    font-family: 'Odibee Sans', monospace;
	    margin-right: 2%;
	    color: #fff;
	    margin-right: 25px;
	    text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #0073e6, 0 0 20px #0073e6, 0 0 25px #0073e6, 0 0 30px #0073e6, 0 0 35px #0073e6;
}
    
    .t {
    	background-color: red;
    	color:white;
    	border-radius: 3px;
    	padding: 5px;
    	
    }
    	
    }
    </style>
    
    
    
</head>
<body style = "background-color: #111111">
    <header style = "width: 100%;border-bottom: 1px solid grey; height: 50px;">
        <a href=  "home.jsp" id = "logo">tXc-tOc-t#e</a>
      
        
        
        <a href=  "auth.jsp" id = "loginButton">Login   <i class="fa-solid fa-circle-user"></i></a>
        <a href=  "home.jsp" id = "homeButton">Home</a>
        <a class=logoutButton href=  "LogoutDispatcher">Logout</a>
        <a href=  "auth.jsp" id = "registerButton">Register</a>
    </header>
    <img src = "bannerhome.jpeg" id = "banner"></img>
    <div id=forms>
    	<div id=gameFormContent>
    		<a class= createGame href="create.jsp">Create Game</a>
    		<a class= joinGame href="join.jsp">Join Game</a>
    	</div>
    </div>
    
    
   
    
</body>
</html>