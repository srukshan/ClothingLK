<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import = "com.clothing.item.*"
%>

<!DOCTYPE html>
<html>
<head>
<title>Home - Shopping.LK </title>
<jsp:include page="include/header.jsp" />

<% String msg;
if((msg = (String) request.getParameter("msg")) != null){
	if(msg.contains("itemAdded")){ %>
		<div class="alert alert-success" role="alert">
		  <h4 class="alert-heading">Success! Product Added to cart.</h4>
		</div>
	<% } else if(msg.contains("itemRemoved")){ %>
	<div class="alert alert-success" role="alert">
	  <h4 class="alert-heading">Success! Product Removed from cart.</h4>
	</div>
	<% } else { %>
		<div class="alert alert-danger" role="alert">
		  <h4 class="alert-heading">Ops! Something went Wrong.</h4>
		</div>
	<% }
	
} %>

<!-- //banner-top -->
<div id="banner-slideshow">
	<% String[] banners = {"banner1.jpg","banner2.jpg","banner3.jpg","banner4.jpg","banner5.jpg"}; 
	
	for(String banner : banners){
	%>
   <div>
     <img src="images/banners/<%=banner%>" style="width:100vw; height:50vh">
   </div>
   <% } %>
</div>

<!-- //new_arrivals -->
<div class="container" style="margin-top:50px; margin-bottom:50px">
	<div class="grid-title">
	<h1 style="text-align: center;"><strong><span style="font-size: 26pt;">New Arrivals</span></strong></h1>
	</div>
	<div class="product-grid row">
	<%
		Product[] newProducts = ProductController.getNewArrivals();
	
		for(Product product : newProducts){
	%>
		<a href="Product.jsp?ID=<%= product.getProductNo() %>">
		<div class="product-item col-md-3">
			<img src="images/products/<%=product.getImage() %>" class="img-responsive" alt="<%=product.getTitle() %>">
			<p class="text-center lead"><%=product.getTitle() %></p>
			<p class="text-center"><del>$<%=product.getRegularPrice() %></del> <strong>$<%=product.getSalePrice() %></strong></p>
		</div>
		</a>
	<% } %>
</div>
</div>
<!-- //best Sellers -->
<div class="container" style="margin-top:50px; margin-bottom:50px">
	<div class="grid-title">
	<h1 style="text-align: center;"><strong><span style="font-size: 26pt;">Best Sellers</span></strong></h1>
	</div>
	<div class="product-grid row">
	<%
		Product[] bestProducts = ProductController.getBestSellers();
	
		for(Product product : bestProducts){
	%>
		<a href="Product.jsp?ID=<%=product.getProductNo() %>">
		<div class="product-item col-md-3">
			<img src="images/products/<%=product.getImage() %>" class="img-responsive" alt="<%=product.getTitle() %>">
			<p class="text-center lead"><%=product.getTitle() %></p>
			<p class="text-center"><del>$<%=product.getRegularPrice() %></del> <strong>$<%=product.getSalePrice() %></strong></p>
		</div>
		</a>
	<% } %>
	</div>
</div>
<jsp:include page="include/footer.jsp" />
	<script type="text/javascript">
	$("#banner-slideshow > div:gt(0)").hide();

	setInterval(function() {
	  $('#banner-slideshow > div:first')
	    .fadeOut(1000)
	    .next()
	    .fadeIn(1000)
	    .end()
	    .appendTo('#banner-slideshow');
	}, 3000);
	</script>
</body>
</html>
    