<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<html>
<head>
<title>Add laptop Page</title>
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
				<spring:form class="form-container" action="${contextPath}/editlaptopprocess"
					method="post" modelAttribute="laptop" enctype="multipart/form-data">
					
					<h2>Edit Laptop</h2>
					<div class="form-group">
						<spring:label path="subCategory.subc_id">SubCategory ID</spring:label>
						<spring:input class="form-control" path="subCategory.subc_id"
							type="hidden" value="${subc_id}"
							 />
					</div>
					
					
					<div class="form-group">
						<spring:label path="vendor.v_id">Vendor Id</spring:label>
						<spring:input class="form-control" path="vendor.v_id" type="hidden" value="${v_id}"/>
					
					
					
					</div>
					
					
					<div class="form-group">
						<spring:label path="product_id">Product Id</spring:label>
						<spring:input class="form-control" path="product_id"
							type="hidden" value="${laptop.product_id }"
							 />
					</div>
					

					<div class="form-group">
						<spring:label path="price">Price</spring:label>
						<spring:input  class="form-control" path="price"
							value="${laptop.price}" />
					</div>


						<div class="form-group">
						<spring:label path="ram">Ram</spring:label>
						<spring:input class="form-control" path="ram"
							value="${laptop.ram }" />
					</div>
					
					
					<div class="form-group">
						<spring:label path="rom">Rom</spring:label>
						<spring:input  class="form-control" path="rom"
							value="${laptop.rom}" />
					</div>
					
					
					<div class="form-group">
						<spring:label path="brand">Brand</spring:label>
						<spring:input  class="form-control" path="brand"
							value="${laptop.brand}" />
					</div>
					
		
					<div class="form-group">
						<spring:label path="noOfProducts">Processor</spring:label>
						<spring:input  class="form-control" path="processor"
							value="${laptop.processor}" />
					</div>
						

					<div class="form-group">
						<spring:label path="noOfProducts">Number Of Products</spring:label>
						<spring:input  class="form-control" path="noOfProducts"
							value="${laptop.noOfProducts}" />
					</div>
					
					
					<div class="form-group">
						<spring:label path="image">Image</spring:label>
						<spring:input  class="form-control" path="image"
							type="file" />
					</div>
					<button type="submit" class="btn btn-primary btn-block btn-sm">Edit</button>
				</spring:form>
			</section>
		</section>
	</section>	
</body>
</html>