<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import = "com.clothing.item.*,java.util.*,com.clothing.users.*"
%>

<%
	HashMap<Integer,Integer> cart = Cart.getCart(session);
	
%>

<!DOCTYPE html>
<html>
<head>
<title>Cart - Shopping.LK </title>
<jsp:include page="include/header.jsp" />

<div class="container">
	<% if(cart == null || cart.size() == 0) { %><div><br><br><br><h1 class="text-center">Cart Empty</h1><br><br><br></div>
	<% } else { 
		Iterator<Map.Entry<Integer,Integer>> i = cart.entrySet().iterator();
	%><div><br><h1 class="text-center">My Cart</h1><br></div>
	
	<div class="row">
		<table class="table table-hover">
			<thead>
				<tr>
				<th class="col-md-1">#</th>
				<th class="col-md-4">Title</th>
				<th class="col-md-2">Unit Price</th>
				<th class="col-md-2">Quantity</th>
				<th class="col-md-1"></th>
				<th class="text-right col-md-2">Amount</th>
				</tr>
			</thead>
			<tbody>
				<% 
				int count = 0;
				double total = 0;
				while(i.hasNext()){ 
					count++;
					Map.Entry<Integer, Integer> pair = (Map.Entry<Integer, Integer>) i.next();
					SaleProduct p = ProductController.getSaleProduct(pair.getKey());
				%>
				
				<tr>
					<th scope="row"><%= count %></th>
					<td><a href="Product.jsp?ID=<%=p.getProductNo() %>"><%=p.getTitle() %></a></td>
					<td><%=p.getSalePrice() %>0</td>
					<td><%=pair.getValue() %></td>
					<td class="text-center"><a href="removeFromCart?ID=<%=p.getProductNo() %>"><span class="glyphicon glyphicon-remove"></span></a></td>
					<td class="text-right"><% double amount = p.getSalePrice()*pair.getValue(); total += amount; %><%=amount %>0</td>
				</tr>
				
				<% } %>
				<tr>
					<th scope="row"></th>
					<td></td>
					<td></td>
					<td></td>
					<td class="text-right">Total (Rs.)</td>
					<td class="text-right"><%=total %>0</td>
				</tr>
			</tbody>
		</table>
		<% session.setAttribute("checkout_total", total);
		%>
	</div>
	
	<% if (session.getAttribute("user") == null) { %>
		<div class="text-danger">
			Please Log In before Checking out your cart.
		</div>
	<% }else{ %>
	<div class="text-right">
		<br>
		<form action="checkout" method="post">
			<input type="submit" class="btn btn-primary btn-lg" value="Check Out">
		</form>
		<br>
	</div>
	<% } %>
	<br>
	<% } %>
</div>

<jsp:include page="include/footer.jsp" />
</body>
</html>