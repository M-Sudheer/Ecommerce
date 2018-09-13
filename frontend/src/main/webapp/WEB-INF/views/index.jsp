<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:url value="/resources/images" var="images"></spring:url>
 

<head>
  <title>Bootstrap Example</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
</head>
<body>

<h1>Electronic Store</h1>
<p><code>Your Store. Your Place</code></p>

<nav class="navbar navbar-expand-sm bg-dark justify-content-center">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#">Home</a>
    </li>
   <div class="dropdown">
            <button type="button" class="btn dropdown-toggle" data-toggle="dropdown">Products </button>
            <div class="dropdown-menu">
              <a class="dropdown-item" href="Laptop">Laptop</a>
              <a class="dropdown-item" href="Mobiles">Mobiles</a>
              <a class="dropdown-item" href="Refrigerator">Refrigerator</a>
            </div>
  </div>
    <li class="nav-item">
      <a class="nav-link" href="#">About Us</a>
    </li>
    
    <li class="nav-item">
    	<a class="nav-link" href="login.html">Login</a>
    </li>
    
    
    <li class="nav-item">
    	<a class="nav-link" href="signup.html">Sign Up</a>
    </li>
    
    
  </ul>
</nav>
<%-- <img src="${images}/lappy.png"> --%>
<div id="demo" class="carousel slide" data-ride="carousel">

  <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>

  <!-- The slideshow -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="${images}/lappy.png" alt="Los Angeles">
    </div>
    <div class="carousel-item">
      <img src="${images}/laptop.jpg" alt="Chicago">
    </div>
    <div class="carousel-item">
      <img src="${images}/phone.jpg" alt="New York">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>

</div>
</body>
</html>
<style>
h1,p,code
{
	text-align:center;
}
img
{
width:100%;
height:100%;
}

</style>
