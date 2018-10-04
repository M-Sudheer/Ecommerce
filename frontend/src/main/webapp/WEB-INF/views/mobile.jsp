<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<html>
<head>
<title>Add Mobile Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
	<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
	
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	
</head>
<body>
	
	<section class="container-fluid bg">
		<section class="row justify-content-center">
			<section class="col-12 col-sm-6 col-md-3">
				<spring:form class="form-container" action="mobileprocess"
					method="post" modelAttribute="mobile" enctype="multipart/form-data">
					
					<h2>Add Mobile</h2>
					<div class="form-group">
						<spring:label path="subCategory.subc_id">SubCategory ID</spring:label>
						<spring:input class="form-control" path="subCategory.subc_id"
							type="hidden" value="${subc_id}"
							placeholder="Enter  subcategory id" />
					</div>
					
		

					<div class="form-group">
						<spring:label path="price">Price</spring:label>
						<spring:input  class="form-control" path="price"
							placeholder="Enter  price" />
					</div>

					<div class="form-group">
						<spring:label path="size">Size</spring:label>
						<spring:input  class="form-control" path="size" placeholder="Enter  size" />
					</div>
					
					<div class="form-group">
						<spring:label path="camera">Camera</spring:label>
						<spring:input  class="form-control" path="camera"
							placeholder="Camera Pixels" />
					</div>
					
					<div class="form-group">
						<spring:label path="processor">Processor</spring:label>
						<spring:input class="form-control" path="processor"
							placeholder="Enter processor" />
					</div>
					
					
					<div class="form-group">
						<spring:label path="battery">Battery</spring:label>
						<spring:input  class="form-control" path="battery"
							placeholder="Battery Capacity" />
					</div>
					
		
					<div class="form-group">
						<spring:label path="noOfProducts">Number Of Products</spring:label>
						<spring:input  class="form-control" path="noOfProducts"
							placeholder="Enter no of products" />
					</div>
					
					
					<div class="form-group">
						<spring:label path="image">Image</spring:label>
						<spring:input  class="form-control" path="image"
							type="file" />
					</div>
					<button type="submit" class="btn btn-primary btn-block btn-sm">AddMobile</button>
				</spring:form>
			</section>
		</section>
	</section>	
</body>
</html>