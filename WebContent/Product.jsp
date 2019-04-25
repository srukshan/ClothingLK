<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import = "com.clothing.item.*,java.util.*"
%>

<%
	int prodID;
	Product product = null;

	try{
		prodID = Integer.parseInt(request.getParameter("ID"));
		product = ProductController.getProduct(prodID);
	}catch(Exception e){
		product = null;
	}
	
%>

<!DOCTYPE html>
<html>
<head>
<title>Product - Shopping.LK </title>
<jsp:include page="include/header.jsp" />
<% if(product!=null){
	session.setAttribute("productID", product.getProductNo());
	%>
<div class="Product-container">
<div class="row">
	<div class="col-md-6 text-center">
		<img src="images/products/<%=product.getImage() %>" style="width:auto;height:100%" alt="<%=product.getTitle() %>">
	</div>
	<div class="col-md-6">
		<br>
		<h4><%= product.getCategory().replace(",", " > ") %></h4>
		<br>
		<h1><%= product.getTitle() %></h1>
		<hr>
		<h2><del>$<%=product.getRegularPrice() %></del> <strong>$<%=product.getSalePrice() %></strong></h2>
		<br>
		<%= product.getShortDesc() %>
		<br>
		<% if(product.isStockStatus()){ %>
		<p><span style="color: #008000;">
			<%= "In stock" %>
		</span></p>
		<br><br>
		<form type="post" action="addToCart" class="form-inline">
		<input class="form-control" name="qty" type="number" value=1>
		<input type="submit" class="btn btn-primary" value="Add to Cart">
		</form>
			<% } else { %>
			<p><span style="color: #ff0000;">
			<%= "No Stock Available" %>
			</span></p>
			<% } %>
		<br>
		<% Iterator<Map.Entry<String,Object>> it = product.getAttributes().entrySet().iterator(); 
		   while(it.hasNext()){
			   Map.Entry<String, Object> pair = (Map.Entry<String, Object>) it.next();
			   if(pair.getKey()=="image") continue;
		%>
		<p><strong><%= pair.getKey() %></strong> : <mark><%= pair.getValue() %></mark></p>
		<% } %>
		<br><br>
	</div>
</div>
<div class="text-center" style="background-color: #999999">
		<h1>Description</h1>
		<hr>
		<%= product.getDesc()%>
		<br>
		<br>
	</div>
</div>
<% } %>
<jsp:include page="include/footer.jsp" />
</body>
</html>
    