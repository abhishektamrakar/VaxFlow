<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/login.css" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
</head>
<body>
	<header>
		<span>
        	<img class="img1" alt="logo1" src="resources/statics/logo1.png">
        </span>
	</header>
	<aside>
		<h1>Login</h1>
		<form class="container" action="getLoginData" method="post">
			<label for="email">Email: </label>
			<input type="email" name="email" id ="email" class="form-control">
			<p style="color:red;">${email}</p>
			
			<label for="password">Password: </label>
			<input type="password" name="password" id ="password" class="form-control">
			<p style="color:red;">${password}</p>
			
			<button class="btn btn-primary">Login</button>
		</form>
		<div style="margin-left:58%;">
			<a href="getForgotPasswordPage"><h5>Forgot Password?</h5></a>
		</div>
		<span id="span2">
			<h5>Don't have an account?</h5>&nbsp;&nbsp;
			<a href="/MVC-Project/getRegisterPage"><h5>Register here</h5></a>
		</span>
		<h5 class="center" style= "color:white; background-color:green; width:fit-content">${yes}</h5>
		<h5 class="center" style= "color:white; background-color:red; width:fit-content">${no}</h5>
	</aside>
	<footer>
	 	<div>
        <div class="div1">
          <i class="fa fa-phone"></i><pre> </pre><p>08069878321</p>
          <pre>         </pre>
          <i class="fa fa-envelope"></i><pre> </pre><p>hello@thetapacademy.com</p>
	      <pre>          </pre>
	      <i class="fa fa-map-marker"></i><pre> </pre><p>BTM Layout, Bangalore</p>
	      <pre>          </pre>
	      <i class="fa fa-map-marker"></i><pre> </pre><p>Rajajinagar, Bangalore</p>
	    </div>
       	  <pre>       </pre>
    	<div class="div2">
          <i class="fa fa-facebook"></i><pre>  </pre>
          <i class="fa fa-twitter"></i><pre>  </pre>
          <i class="fa fa-linkedin"></i><pre>  </pre>
          <i class="fa fa-github"></i><pre>  </pre>  
        </div>      
     </div>
	</footer>
</body>
</html>