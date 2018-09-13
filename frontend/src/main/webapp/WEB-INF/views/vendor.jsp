<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags"  prefix="springtag"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>

<c:if test="${!empty vendorList}">
	<table class="table table-bordered table-sm">
		<thead>
			<tr>
				<th>user_id</th>
				<th>name</th>
				<th>email</th>
				<th>mobile</th>
				<!-- <th>role</th> -->
				<th>status</th>
				<th>operation</th>
			</tr>
		</thead>
		
	<c:forEach items="${vendorList}" var="vendor">
	<tbody>
	
	<tr>
		<td><c:out value="${vendor.v_id}"></c:out></td>
		<td><c:out value="${vendor.name}"></c:out></td>
		<td><c:out value="${vendor.email}"></c:out></td>
		<td><c:out value="${vendor.mobile}"></c:out></td>
		<%-- <td><c:out value="${vendor.role}"></c:out></td> --%>
		<td><c:out value="${vendor.status}"></c:out></td>
		
		
		
		<c:set var="status" scope="session" value="${vendor.status}"/>
		
		<c:choose>
		<c:when test="${status==false}">
		<td><a href="accept/${vendor.v_id}"><input type="button" value="Activate"></a></td>
		</c:when>
		<c:when test="${status==true}">
		<td><a href="accept/${vendor.v_id}"><input type="button" value="Deactivate"></a></td>
		</c:when>
		
		</c:choose>
		</tr>
		</tbody>
		</c:forEach>
	</table>
</c:if>
</body>
</html>