<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form action="getModel" method="post">
				<div class="form-group">
					<label for="sel1">SubCategories</label> 
					<select class="form-control "
						id="sel1"  name="subc_id">
						<c:forEach items="${subCategoryList}" var="subcategory">
							<option value="${subcategory.subc_id}">${subcategory.subc_name }</option>
						</c:forEach>
					</select>
					<input type="submit" value="Go"/>
				</div>
		</form>

</body>
</html>