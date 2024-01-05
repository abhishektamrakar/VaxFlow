<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"  type="text/css" href="resources/homePage.css" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
</head>
<body>
	<header>
	<script>
		function go() {
			window.location
					.replace(
							"logout.jsp",
							'window',
							'toolbar=1,location=1,directories=1,status=1,menubar=1,scrollbars=1,resizable=1');
			self.close()
		}
	</script>
	<span>
		<img class="img1" alt="logo1" src="resources/statics/logo1.png">
		<pre>    </pre>
		<a href="addMemberPage" class="btn btn-primary" >Add Member</a>
		<pre>                                                                                     </pre>
		<%
			String str = request.getParameter("email");
			session.setAttribute("EMAIL", request.getParameter("email"));
		%>
		<h5 style="color:blue; margin-top:25px;">User:
		<%=session.getAttribute("EMAIL")%></h5>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<%
			if (session.getAttribute("EMAIL").equals("")) {
		%>
		<a href="login.jsp"><b>Login</b></a>
		<%
		} else {
		%>
			<a href="javascript:go()" class= "btn btn-primary">Logout</a>
		<%
		}
		%>
	</span>
	</header>
	<aside>
	<span id=span1>
		<div class="card" style="background-color:#D0A2F7;">
		  <div class="container">
		    	<h4 style="text-align:center; padding-top:5px; color:#F3F8FF;"><b>Registration Count</b></h4>
		    	<h1 style="font-size:250px; color:blue; padding-left:30px;">${memberCount}</h1>
	  	  </div>
		</div>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<div class="card" style="background-color:#3559E0;">
		  <div class="container">
		    <p style="color:#F3F8FF; font-family:'Roboto',sans-serif;">COVID-19 most often causes respiratory symptoms that can feel much like a cold, the flu, or pneumonia. COVID-19 may attack more than your lungs and respiratory system. Other parts of your body may also be affected by the disease. Most people with COVID-19 have mild symptoms, but some people become severely ill.</p>
		  </div>
		</div>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<div class="card" style="background-color:#EE7214;">
		  <div class="container">
		     <img alt="covidsheild" src="resources/statics/covidSheild.jpg" width=100% height=250px;> 
		     <h4 style="text-align:center; padding-top:18px; color:#F3F8FF;"><b>Covid Shield</b></h4>
		  </div>
		</div>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<div class="card" style="background-color:#6DB9EF;">
		  <div class="container">
		     <img alt="covaxin" src="resources/statics/covaxin.jpg" width=100% height=250px;>
		     <br>
		    <h4 style="text-align:center; padding-top:18px; color:#F3F8FF;"><b>Covaxin</b></h4>
		  </div>
		</div>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<div class="card" style="background-color:#7ED7C1;">
		  <div class="container">
		     <img alt="sputnik" src="resources/statics/sputnik.jpg" width=100% height=250px;">
		     <h4 style="text-align:center; padding-top:18px; color:#F3F8FF;"><b>Sputnik</b></h4> 
		  </div>
		</div>
	</span>
	</aside>
	<footer>
	 	<div class="footer">
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