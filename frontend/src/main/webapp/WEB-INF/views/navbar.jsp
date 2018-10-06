<%@include file="contextpaths.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

            <li class="nav-item dropdown"><a
               class="nav-link dropdown-toggle  text-primary" href="#"
               id="navbardrop" data-toggle="dropdown"> Electronics </a>
               <div class="dropdown-menu">
                   <c:forEach items="${electronics}" var="electronic">
                       <a class="dropdown-item"
                           href="${contextPath}/products/${electronic.subc_id}">${electronic.subc_name}</a>
                   </c:forEach>
               </div></li>

</body>
</html>