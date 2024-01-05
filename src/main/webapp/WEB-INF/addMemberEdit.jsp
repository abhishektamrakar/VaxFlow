<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Member Edit</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"  type="text/css" href="resources/addMemberEdit.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<style>
	header{
	background-color:pink;
	    height:60px;
	    position:fixed;
	    width:100%;
	    top: 0;
        z-index: 1000;
	}
	footer{
		background-color:pink;
	    height:60px;
	    position:fixed;
	    width:100%;
	    bottom: 0;
        z-index: 1000;
	}
	aside{
		margin-top:60px;
		margin-bottom:60px;
	}
	span{
	    display: flex;   
		margin-left:2%;       	
	}
	#span1{
		display: inline-block;     
		margin-left: 1%;   
	}
    body{
		background-color:#96EFFF;
	}
	h1{
		text-align:center;
		color:blue;
		font-size:30px;
		font-family:times new roman;
		font-weight:bold;
	}
	label{
		font-size:18px;
		font-family:times new roman;
		color:blue;
	}
	.container{
		margin-left:30%;
		background-color:white;
		margin-right:-300px;
		width:40%;
		padding-left:4%;
		padding-top:3%;
		padding-bottom:3%;
		padding-right:3%;
		opacity:90%;
		border-radius:20px;
	}
	.center{
		margin-left:30%;
		margin-right:26%;
		width:40%;
		font-family:Copperplate;
		font-size:20px;
	}
	table,td,th{
        	border:3px ridge blue;
  			text-align:center;
  			width:50%;
  			margin-left:345px;
  			margin-right:100px;
  			font-size:100%;
  			font-family:Times new roman;
	}
	div{
		display:flex;
	}
	.div1{
		margin-left:5%;
		margin-top:20Px;
		color:#1640D6;
		font-weight:bold;
	}
	.div2{
		margin-left:5%;
		margin-top:20Px;
		color:#1640D6;
		font-size:26px;
		font-weight:bold;
	}
</style>
</head>
<body>
	<header>
		<span>
			<a style="margin-top:12px; margin-bottom:11px;" href="viewMemberDetails" class="btn btn-primary">View Members</a>
		</span>
	</header>
	<aside>
	<h1>Add Member Form</h1>
	<form class="container" action="${pageContext.request.contextPath}/updateById/${id}" method="post">
		<label for="name">Name: </label>
		<input type="text" name="name" id ="name" value="${NAME}" class="form-control">
		<p style="color:red;">${name}</p>
			
		<label for="gender">Gender: </label>&nbsp;&nbsp;
		<span id="span1">
		    <input type="radio" value="Male" name="gender" id="male" 
		           <c:if test="${GENDER eq 'Male'}">checked</c:if>>
		    <label for="male">Male</label>&nbsp;&nbsp;
		    <input type="radio" value="Female" name="gender" id="female" 
		           <c:if test="${GENDER eq 'Female'}">checked</c:if>>
		    <label for="female">Female</label>
		</span>
		<p style="color:red;">${gender}</p>
		
		<label for="dateOfBirth">Date of Birth: </label>
		<input type="date" name="dateOfBirth" id ="dateOfBirth" value="${DATE_OF_BIRTH}"class="form-control">
		<p style="color:red;">${dateOfBirth}</p>
		
		<label for="idProof">Select Id Proof:</label>
		<select name="idProof" id="idProof" class="form-control">
		    <option value="aadharCard" <c:if test="${ID_PROOF eq 'aadharCard'}">selected</c:if>>Aadhar Card</option>
		    <option value="panCard" <c:if test="${ID_PROOF eq 'panCard'}">selected</c:if>>Pan Card</option>
		    <option value="drivingLicense" <c:if test="${ID_PROOF eq 'drivingLicense'}">selected</c:if>>Driving License</option>
		    <option value="voterId" <c:if test="${ID_PROOF eq 'voterId'}">selected</c:if>>Voter Id</option>
		</select>
		<p style="color:red;">${idProof}</p>
		
		<label for="idProofNo">Id Proof No.: </label>
		<input type="text" name="idProofNo" id ="idProofNo" value="${ID_PROOF_NO}" class="form-control">
		<p style="color:red;">${idProofNo}</p>
		
		<label for="vaccineType">Select Vaccine Type: </label>
		<select name="vaccineType" id="vaccineType" class="form-control">
		    <option value="covidShield" <c:if test="${VACCINE_TYPE eq 'covidShield'}">selected</c:if>>Covid Shield</option>
		    <option value="covaxin" <c:if test="${VACCINE_TYPE eq 'covaxin'}">selected</c:if>>Covaxin</option>
		    <option value="sputnik" <c:if test="${VACCINE_TYPE eq 'sputnik'}">selected</c:if>>Sputnik</option>
		</select>
		<p style="color:red;">${vaccineType}</p>
		
		<label for="dose">Select Dose: </label>
		<select name="dose" id="dose" class="form-control">
		    <option value="dose1" <c:if test="${DOSE eq 'dose1'}">selected</c:if>>Dose-1</option>
		    <option value="dose2" <c:if test="${DOSE eq 'dose2'}">selected</c:if>>Dose-2</option>
		    <option value="dose3" <c:if test="${DOSE eq 'dose3'}">selected</c:if>>Dose-3</option>
		</select>
		<p style="color:red;">${dose}</p>
		
		<button class="btn btn-primary">Submit</button>
	</form>
	<br>
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