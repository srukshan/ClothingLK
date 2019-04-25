<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import = "com.clothing.item.*,com.clothing.order.*,java.util.*"
%>

<%
	double shipAmount = 10.0;
	
	int success = 0, orderID = -1;
	
	try{
		success = Integer.parseInt(request.getParameter("success"));
	}catch(Exception e){
		
	}
	try{
		orderID = Integer.parseInt(request.getParameter("order"));
	}catch(Exception e){
		response.sendRedirect("Cart.jsp");
	}
	
	Order orderObj = OrderController.getOrderById(orderID);
	
	if(orderObj == null) {
	    response.sendRedirect("index.jsp");
	}
	
	HashMap<Integer,Integer> cart = orderObj.getOrderItems();

	if(cart == null || cart.size()==0) {
	    response.sendRedirect("Cart.jsp");
	}
	Iterator<Map.Entry<Integer,Integer>> i = cart.entrySet().iterator();
%>

<!DOCTYPE html>
<html>
<head>
<title>Cart - Shopping.LK </title>
<jsp:include page="include/header.jsp" />

<div class="container">
	<div class="row"><h1 class="text-center">ORDER <% if((request.getParameter("success") != null && success == 1) || (request.getParameter("order") != null && orderID != -1)){ %>COMPLETE</h1></div>
	<div class="row">
	<div class="col-md-8">
		<h3>Order Details</h3>
		<div class="col-md-6"><strong>PRODUCT</strong></div>
		<div class="col-md-6 text-right"><strong>TOTAL</strong></div>
		<hr />
		<%
			while(i.hasNext()){ 
				Map.Entry<Integer, Integer> pair = (Map.Entry<Integer, Integer>) i.next();
				SaleProduct p = ProductController.getSaleProduct(pair.getKey());
				double amount = p.getSalePrice()*pair.getValue();
				%>
		
				<div class="col-md-9"><%=p.getTitle() %><strong class="text-muted"> × <%=pair.getValue() %></strong></div>
				<div class="col-md-3 text-right"><strong>Rs.<%=amount %>0</strong></div>
				<hr />
				
				<%
			}
		%>
		<div class="col-md-6"><strong>Subtotal:</strong></div>
		<div class="col-md-6 text-right"><strong>Rs.<% double amount = (orderObj.getAmount()-shipAmount); %><%=amount %>0</strong></div>
		<hr />
		
		<div class="col-md-6"><strong>Shipping:</strong></div>
		<div class="col-md-6 text-right  text-muted">HOME DELIVERY</div>
		<hr />
		
		<div class="col-md-6"><strong>Shipping Charges:</strong></div>
		<div class="col-md-6 text-right"><strong>Rs.<%=shipAmount %>0</strong></div>
		<hr />
		
		<div class="col-md-6"><strong>Total:</strong></div>
		<div class="col-md-6 text-right"><strong>Rs.<%=orderObj.getAmount() %>0</strong></div>
		<hr />
		
		<h2>Shipping Address</h2>
		<i class="text-muted"><%=orderObj.getAddress() %></i>
	</div>
	<div class="col-md-4">
		 <p class="text-success"><strong>Thank you. Your order has been received.</strong></p>
	
	      <ul class="text-muted" style="padding:10px">
	
	        <li>
	          Order number:          <strong><%=orderObj.getOrderID() %></strong>
	        </li>
	        <li>
	          Order Date:          <strong><%=orderObj.getDateNTime().toString() %></strong>
	        </li>
	        <li>
	          Total:          <strong style="text-color:black">Rs.<%=orderObj.getAmount() %>0</strong>
	        </li>
	
	        
	      </ul>

		<div class="clear"></div>
	</div>
	</div>
	<% } else { %>
	Error</h1></div>
	<% } %>
</div>

<jsp:include page="include/footer.jsp" />
</body>
</html>