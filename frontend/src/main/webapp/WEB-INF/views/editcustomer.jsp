<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
</head>

<body>
<springform:form action="updatecustomer" method="post" modelAttribute="customer">
<table>

<tr>
<td>id</td>
<td><springform:input path="id" type="hidden" value="${customerDetails.id}"/></td>
</tr>

<tr>
<td>UserName:</td>
<td><springform:input path="name" value="${customerDetails.name}"/></td>
</tr>



<tr>
<td>Email:</td>
<td><springform:input path="email" value="${customerDetails.email}"/></td>
</tr>

<tr>
<td>Mobile Number:</td>
<td><springform:input path="mobile" value="${customerDetails.mobile}"/></td>
</tr>

<tr>
<td>password</td>
<td><springform:input path="password" value="${customerDetails.name}" type="hidden"/></td>
</tr>

<tr>
<td><input type="submit" value="UpdateCustomer"></td>
</tr>
 
 
 
 <%-- <div class="bg">
			<div class="container-fluid bg">
				<div class="row">
						<springform:form  action="updatecustomer" method="post" modelAttribute="customer">
			
			<div class="form-group">
			<label for="v_id">User_Id</label>
			<springform:input path="v_id" class="form-control" id="v_id" type="hidden"/>
			</div>
			
			<div class="form-group">
			<label for="name">User Name:</label>	
			<springform:input path="name" class="form-control" id="name"/>	
			</div>
			
			<div class="form-group">
			<label for="email">Email Id:</label>
			<springform:input path="email" class="form-control" id="email"/>
			</div>
			
			
			
			
			<div class="form-group">
			<label for="mobile">Mobile Number:</label>	
			<springform:input path="mobile" class="form-control" id="mobile"/>		
			</div>	
		
			<div class="form-group">
			<label for="password">Password:</label>	
			<springform:input path="password" class="form-control" id="password"/>		
			</div>
			
			
 <tr>
<td><input type="submit" value="UpdateCustomer"></td>
</tr>
 --%>
</table>
</springform:form>
</body>
</html>


<style>
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
    		padding-left: 550px;
    		padding-top: 50px;
    	}
</style>