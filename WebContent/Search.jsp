<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import = "com.clothing.item.*"
%>

<%
	String query = request.getParameter("q");

	if(query == "" || query == null){
		response.sendRedirect("index.jsp");
	}
%>

<!DOCTYPE html>
<html>
<head>
<title>Search - Shopping.LK - <%=query %></title>
<jsp:include page="include/header.jsp" />
<% Product[] products = ProductController.search(query); %>

<div class="container" style="margin-top:50px; margin-bottom:50px">
	<div class="grid-title">
	<h1 style="text-align: center;"><strong><span style="font-size: 26pt;">
	<%try{ products[0].isStockStatus();  %>
	Products for the Search query - <%=query %>
	</span></strong></h1>
	</div>
	<div class="product-grid row">
	<%
		for(Product product : products){
	%>
		<a href="Product.jsp?ID=<%= product.getProductNo() %>">
		<div class="product-item col-md-3">
			<img src="images/products/<%=product.getImage() %>" class="img-responsive" alt="<%=product.getTitle() %>">
			<p class="text-center lead"><%=product.getTitle() %></p>
			<p class="text-center"><del>$<%=product.getRegularPrice() %></del> <strong>$<%=product.getSalePrice() %></strong></p>
		</div>
		</a>
	<% } } catch(Exception e) { %>
	No Products for the query
	</span></strong></h1>
	<% } %>
</div>
</div>

<jsp:include page="include/footer.jsp" />
</body>
</html>