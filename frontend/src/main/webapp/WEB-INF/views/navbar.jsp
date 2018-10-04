<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@page isELIgnored="false" %>
<nav class="navbar navbar-expand-sm bg-danger navbar-dark ">

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse " id="collapsibleNavbar">
		<ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link text-white" href="/">Home</a></li>
            
			<!-- Dropdown -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle  text-white" href="#" id="navbardrop"
				data-toggle="dropdown">Electronics</a>
				
				<div class="dropdown-menu">
              <a class="dropdown-item" href="customerlaptop">Laptop</a>
              <a class="dropdown-item" href="Mobiles">Mobiles</a>
              <a class="dropdown-item" href="Refrigerator">Refrigerator</a>
            </div>
				<c:forEach  items="${Electronics}" var="electronic">
					<a class="dropdown-item" href="product/${Electronics.subc_id}">${Electronics.subcname}</a> 
		        </c:forEach>
				</div>
				</li>
</ul>
	</div>
</nav>