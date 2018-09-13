<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags"  prefix="spring" %>
    <spring:url value="/resources/images/" var="images"></spring:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="bg">
 <%-- <img src="${images}pro.png">  --%>
<h1>Welcome to ur Profile</h1>
<form>
<table>
<tr>
<td>UserName:</td>
<td>${vendor.name}</td>
</tr>
<tr>
<td>Email:</td>
<td>${vendor.email}</td>
</tr>
<tr>
<td>Mobile Number:</td>
<td>${vendor.mobile}</td>
</tr>
<tr>
<td>Company Name:</td>
<td>${vendor.companyName}</td>
</tr>
</table>
<button><a href="edit">Edit</a></button>
</form>

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
        
           background-image: url("https://steamcdn-a.akamaihd.net/steamcommunity/public/images/items/307050/bca1021db33fb6063bdf8e5d311735874d4c61d9.jpg");
         
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
  button,a
  {
  	padding-left:5px;
  }

h1
{
text-align:center;
}