<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Member</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"  type="text/css" href="resources/addMember.css" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
</head>
<body>
	<header>
		<span>
			<img class="img1" alt="logo1" src="resources/statics/logo1.png">
        	<pre>   </pre>
			<a href="viewMemberDetails" class="btn btn-primary">View Members</a>
			<pre>                                                                                                                          </pre>
			<a href="logout.jsp" class= "btn btn-primary">Logout</a>
		</span>
	</header>
	<aside>
	<h1>Add Member Form</h1>
	<form class="container" action="getAddMemberData" method="post">
		<label for="name">Name: </label>
		<input type="text" name="name" id ="name" class="form-control">
		<p style="color:red;">${name}</p>
			
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
		
		<label for="idProof">Select Id Proof:</label>
		<select name="idProof" id="idProof" class="form-control">
			<option value="aadharCard">Aadhar Card</option>
			<option value="panCard">Pan Card</option>
			<option value="drivingLicense">Driving License</option>
			<option value="voterId">Voter Id</option>
		</select>
		<p style="color:red;">${idProof}</p>
		
		<label for="idProofNo">Id Proof No.: </label>
		<input type="text" name="idProofNo" id ="idProofNo" class="form-control">
		<p style="color:red;">${idProofNo}</p>
		
		<label for="vaccineType">Select Vaccine Type: </label>
		<select name="vaccineType" id="vaccineType" class="form-control">
			<option value="covidShield">Covid Shield</option>
			<option value="covaxin">Covaxin</option>
			<option value="sputnik">Sputnik</option>
		</select>
		<p style="color:red;">${vaccineType}</p>
		
		<label for="dose">Select Dose: </label>
		<select name="dose" id="dose" class="form-control">
			<option value="dose1">Dose-1</option>
			<option value="dose2">Dose-2</option>
			<option value="dose3">Dose-3</option>
		</select>
		<p style="color:red;">${dose}</p>
		
		<button class="btn btn-primary">Submit</button>
	</form>
	<br>
	<p class="center" style= "color:white; background-color:green; width:fit-content">${yes}</p>
	<p class="center" style= "color:white; background-color:red; width:fit-content">${no}</p>
	<table>
    	<tr>
    		<th>NAME</th>
    		<th>GENDER</th>
    		<th>DATE_OF_BIRTH</th>
    		<th>ID_PROOF</th>
    		<th>ID_PROOF_NO</th>
    		<th>VACCINE_TYPE</th>
    		<th>DOSE</th>
    		<th>EDIT</th>
    		<th>DELETE</th>
    	</tr>
    <c:forEach var="member" items="${members}">
    	<tr>
    		<td>${member.getMemberName()}</td>
    		<td>${member.getMemberGender()}</td>
    		<td>${member.getMemberDOB()}</td>
    		<td>${member.getIdProof()}</td>
    		<td>${member.getIdProofNO()}</td>
    		<td>${member.getVaccineType()}</td>
    		<td>${member.getDose()}</td>
    		<td><a href="editMemberDetails/${member.getMemberID()}" class="btn btn-success">Edit</a></td>
    		<td><a href="deleteMemberByIdProofNo/${member.getIdProofNO()}" class="btn btn-danger">Delete</a></td>
    		
    	</tr>
    </c:forEach>
    <p class="center" style= "color:white; background-color:red; width:fit-content">${no1}</p>
    <p class="center" style= "color:white; background-color:red; width:fit-content">${no2}</p>
    <p class="center" style= "color:white; background-color:red; width:fit-content">${no3}</p>
    </table>
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