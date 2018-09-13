<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1" isELIgnored="false"%>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
   <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
   
  <spring:url value="/resources/images" var="images"></spring:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<title></title>
</head>
<body>
    <div class="bg">
		<div class="container-fluid bg">
    		<div class="row">
 				<springform:form action="login" method="POST" modelAttribute="login" class="form-container">
					<img src="${images}/icon.png"> 					
 						<div class="form-group">
 						
 						<i class="fas fa-envelope-open"></i>
 						<label for="email">Email Id:</label>
   				<springform:input path="email" class="form-control" id="email"/>
 			</div>
 			
 			<div class="form-group">
 				<i class="fas fa-unlock"></i>
   					<label for="pwd" >Password:</label>	
   					<springform:input type="password" path="password" class="form-control" id="pwd" />
   					<!-- <i class="fa fa-eye" aria-hidden="true"></i> -->
 			</div>
 			
 			
 			
 			<div class="form-group form-check">
     			<input class="form-check-input" type="checkbox">
     			<label class="form-check-label">Remember me</label>
 			</div>
 		<button type="submit" class="btn btn-success btn-block">login</button>
	</springform:form>	
   </div> 
 </body>
</html>
<style>

img
{
width:70%;
padding-bottom:10px;
padding-top:0px;
padding-left:60px;
}

.row
{
padding-top:1px;
}

 .bg {
        
           background-image: url("https://www.pixelstalk.net/wp-content/uploads/2016/10/Dark-Pink-Wallpapers-HD-Free-Download-620x388.jpg");
         
           width: 100%;
           height: 100vh;

           background-position: center;
           background-repeat: no-repeat;
           background-size: cover;
       }
       
 form
 {
           padding-left: 600px;
           padding-top: 150px;
       }
   