package com.clothing.servlet;


import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.clothing.item.ProductController;
import com.clothing.item.SaleProduct;

/**
 * Servlet implementation class removeFromCart
 */
@WebServlet("/removeFromCart")
public class removeFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int id = Integer.parseInt(request.getParameter("ID"));
			
			HttpSession session = request.getSession();
			
			SaleProduct p;
			
			if((p = ProductController.getSaleProduct(id)) != null) {
				if(!com.clothing.item.Cart.remove(session, id)) {
					response.sendRedirect("index.jsp?msg=error");
				}
			}
			
			response.sendRedirect("index.jsp?msg=itemRemoved");
		}catch(Exception e) {
			return;
		}
	}

}
