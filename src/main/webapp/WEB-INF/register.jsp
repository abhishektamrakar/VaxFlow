<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"  type="text/css" href="resources/register.css" >
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
	<h1>Registration Form</h1>
	<form class="container" action="getRegisterData" method="post">
		<label for="userName">User Name: </label>
		<input type="text" name="userName" id ="userName" class="form-control">
		<p style="color:red;">${userName}</p>
		
		<label for="password">Password: </label>
		<input type="password" name="password" id ="password" class="form-control">
		<p style="color:red;">${password1}</p>
		<p style="color:red;">${password2}</p>
		<p style="color:red;">${password3}</p>
		<p style="color:red;">${password4}</p>
		<p style="color:red;">${password5}</p>
		
		<label for="confirmPassword">Confirm Password: </label>
		<input type="password" name="confirmPassword" id ="confirmPassword" class="form-control">
		<p style="color:red;">${confirmPassword}</p>
		
		<label for="email">Email: </label>
		<input type="email" name="email" id ="email" class="form-control">
		<p style="color:red;">${email}</p>
		
		<label for="mobileNumber">Mobile Number: </label>
		<input type="number" name="mobileNumber" id ="mobileNumber" class="form-control">
		<p style="color:red;">${mobileNumber}</p>
		
		<label for="gender">Gender: </label>&nbsp;&nbsp;
		<span id="span1">
		    <input type="radio" value="Male" name="gender" id="male">
		    <label for="male">Male</label>&nbsp;&nbsp;
		    <input type="radio" value="Female" name="gender" id="female">
		    <label for="female">Female</label>
		</span>
		<p style="color:red;">${gender}</p>
		
		<label for="dateOfBirth">Date of Birth: </label>
		<input type="date" name="dateOfBirth" id ="dateOfBirth" class="form-control">
		<p style="color:red;">${dateOfBirth}</p>

		<button class="btn btn-primary">Register</button>
	</form>
	<span id="span2">
		<h5 style="margin-top:10px;">Have aldready an account?</h5>&nbsp;&nbsp;
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