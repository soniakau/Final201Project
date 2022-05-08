<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Util.*" %>
<!DOCTYPE html>
<html>
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/6e009e6cd4.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
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
		text-decoration: none;
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
    <div class="d-flex justify-content-between flex-row bd-highlight mb-3" style = "width: 100%;border-bottom: 1px solid grey; height: 50px;">
        <a class="align-self-center" href=  "home.jsp" id = "logo">tXc-tOc-t#e</a>
        
        <div class="align-self-center" id=hi>Hi <%= Util.Helper.getName(request) %>!</div>
       
        
        <div class="align-self-center">
	        <% if (Util.Helper.isLoggedIn(request) == "loggedin") { %>
	        	
				<a class=logoutButton href=  "LogoutDispatcher">Logout</a>
			<% } else { %> 
				<a href=  "auth.jsp" id = "loginButton">Login/Register   <i class="fa-solid fa-circle-user"></i></a>
			<% } %>
	        <a href=  "home.jsp" id = "homeButton">Home</a>
        </div>
    </div>
    <img src = "bannerhome.jpeg" id = "banner"></img>
    <br> <br> <br>
    <div class="d-flex flex-row justify-content-start">
		<div class="d-flex flex-column">
			<div class="p-3">
				<a class="createGame" href="create.jsp">Create Game</a>
			</div>
			<div class="p-3">
				<a class= "joinGame" href="join.jsp">Join Game</a>
			</div>
		</div>
	</div>
	 

    <div style= "width:50;height:50">
      <canvas id="myChart" width="50" height="50"></canvas>
    </div>

 
    <script>
//bar
	function getCookie(cname) {
  	let name = cname + "=";
 	 let decodedCookie = decodeURIComponent(document.cookie);
 	 let ca = decodedCookie.split(';');
 	 for(let i = 0; i <ca.length; i++) {
 	   let c = ca[i];
 	   while (c.charAt(0) == ' ') {
 	     c = c.substring(1);
 	   }
  	  if (c.indexOf(name) == 0) {
      	return c.substring(name.length, c.length);
    	}
 	 }
  return "";
}
	const ctx = document.getElementById('myChart').getContext('2d');
	var w = document.cookie;
	var wins = 0; 
	var draws = 0; 
	var losses = 0;
	if (!(w==="") && !(getCookie("username")==="guest"))
	{
		wins = parseInt(getCookie("wins"));
		draws = parseInt(getCookie("draws"));
		losses = parseInt(getCookie("losses"));
	}
	
	const myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['Wins', 'Draws', 'Losses'],
        datasets: [{
            label: '# of Games',
            data: [wins, draws, losses],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)'
            
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)'
               
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});

</script>
</body>
</html>

