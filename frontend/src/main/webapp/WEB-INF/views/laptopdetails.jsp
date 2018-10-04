<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Specifications</h3>
<table>
<tr>
<td>Ram:</td>
<td>${laptop.ram}</td>
</tr>
<tr>
<td>Rom:</td>
<td>${laptop.rom}</td>
</tr>
<tr>
<td>Brand:</td>
<td>${laptop.brand}</td>
</tr>
<tr>
<td>Processor:</td>
<td>${laptop.processor}</td>
</tr>
<tr>
<td>No of Products:</td>
<td>${laptop.noOfProducts}</td>
</tr>

</table>
</body>
</html>


<style>
html,body,h3
{
padding-top:2px;
font-style:italic;
}
html,body,table
{

float:right;
padding-right:160px;
font-size:40px;
 
}

</style>