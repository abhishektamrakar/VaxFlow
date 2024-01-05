<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"  type="text/css" href="resources/forgotPassword.css" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
</head>
<body>
	<header>
		<span>
            <img class="img1" alt="logo1" src="resources/statics/logo1.png">
        	<pre>                                                                                                                                     </pre>
            <a href="getRegisterPage" class="btn btn-primary">Register</a>
           	<pre> </pre>
            <a href="getLoginPage" class="btn btn-primary">Login</a>
        </span>
	</header>
	<aside>
		<h1>Reset Password</h1>
		<form class="container" action="getForgotPasswordData" method="post">
			<label for="email">Email: </label>
			<input type="email" name="email" id ="email" class="form-control">
			<p>Note: Enter the same mail which you used during registration</p>
			<p style="color:red;">${email}</p>
			
			<label for="password">New Password: </label>
			<input type="password" name="password" id ="password" class="form-control">
			<p style="color:red;">${password1}</p>
			<p style="color:red;">${password2}</p>
			<p style="color:red;">${password3}</p>
			<p style="color:red;">${password4}</p>
			<p style="color:red;">${password5}</p>
			
			<label for="confirmPassword">New Confirm Password: </label>
			<input type="password" name="confirmPassword" id ="confirmPassword" class="form-control">
			<p style="color:red;">${confirmPassword}</p>
			
			<button class="btn btn-primary">Reset</button>
		</form>	
		<span id="span2">
			<h5 style="margin-top:10px;" >Click here to go to Login -></h5>&nbsp;&nbsp;
			<a href="/MVC-Project/getLoginPage"><h5>Login here</h5></a>
		</span>
		<p class="center" style= "color:white; background-color:green; width:fit-content">${yes}</p>
		<p class="center" style= "color:white; background-color:red; width:fit-content">${no}</p>	
	</aside>
	<footer>
	 	<div >
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