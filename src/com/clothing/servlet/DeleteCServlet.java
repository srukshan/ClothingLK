package com.clothing.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.clothing.CategoryCrud.CategoryCrudDBO;
import com.clothing.item.ProductController;
import com.clothing.item.SaleProduct;

/**
 * Servlet implementation class DeleteCServlet
 */
@WebServlet("/DeleteCServlet")
public class DeleteCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/jsp");
		String cID = request.getParameter("mainCategory");
		//String cTitle = request.getParameter("subCategory");
		
		
		CategoryCrudDBO dao1 = new CategoryCrudDBO();
		try {
		
		
		String s1 = dao1.deleteData(cID);
		if(s1.equals("success")){
		}
		else{
			System.out.println("some thing is going wrong");
		}
		response.sendRedirect("deleteC.jsp");
		
	}
		
	catch(Exception ex) {
		ex.printStackTrace();
		}
	}
}
