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

@WebServlet("/addToCart")
public class addToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int qty = Integer.parseInt(request.getParameter("qty"));
			int id =  (int) request.getSession().getAttribute("productID");
			HttpSession session = request.getSession();
			SaleProduct p;
			
			if((p = ProductController.getSaleProduct(id)) != null) {
				if(!p.isStockStatus() || !com.clothing.item.Cart.add(session, id, qty)) {
					response.sendRedirect("index.jsp?msg=error");
				}
				else
					response.sendRedirect("index.jsp?msg=itemAdded");
			}
		}catch(Exception e) {

		}
		
	}

}
