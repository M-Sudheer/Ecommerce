<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
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
				<spring:form class="form-container" action="laptopprocess"
					method="post" modelAttribute="laptop">
					<h2>Add Laptop</h2>
					<div class="form-group">
						<spring:label path="subCategory.subc_id">SubCategory ID</spring:label>
						<spring:input class="form-control" path="subCategory.subc_id"
							type="hidden" value="${subc_id}"
							placeholder="Enter  subcategory id" />
					</div>
					<div class="form-group">
						<spring:label path="vendor.v_id">Vendor Id</spring:label>
						<spring:input class="form-control" path="vendor.v_id"
							type="hidden" value="${v_id }"  />
					</div>



					<div class="form-group">
						<spring:label path="price">product _price</spring:label>
						<spring:input  class="form-control" path="price"
							placeholder="Enter  price" />
					</div>

					<div class="form-group">
						<spring:label path="ram">Ram</spring:label>
						<spring:input  class="form-control" path="ram"
							placeholder="Enter  ram size" />
					</div>
					
					<div class="form-group">
						<spring:label path="rom">Rom</spring:label>
						<spring:input  class="form-control" path="rom"
							placeholder="Enter  rom size" />
					</div>
					
					
					<div class="form-group">
						<spring:label path="brand">Brand</spring:label>
						<spring:input  class="form-control" path="brand"
							placeholder="Enter  brand name" />
					</div>
					
		

					<div class="form-group">
						<spring:label path="processor">Processor</spring:label>
						<spring:input class="form-control" path="processor"
							placeholder="Enter processor" />
					</div>

					<div class="form-group">
						<spring:label path="noOfProducts">Number Of Products</spring:label>
						<spring:input  class="form-control" path="noOfProducts"
							placeholder="Enter no of products" />
					</div>
					<button type="submit" class="btn btn-primary btn-block">AddLaptop</button>
				</spring:form>
			</section>
		</section>
	</section>
	
</body>

</html>