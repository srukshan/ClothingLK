package com.clothing.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clothing.CategoryCrud.*;

/**
 * Servlet implementation class AddCServlet
 */
@WebServlet("/AddCServlet")
public class AddCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/jsp");
		String cType = request.getParameter("mainCategory");
		String cTitle = request.getParameter("Title");
		String cDescription = request.getParameter("Description");
		
		CategoryCrudDBO dao1 = new CategoryCrudDBO();
		try {
		
		
		String s1 = dao1.insertData(cTitle, cDescription, cType);
		if(s1.equals("success")){
		}
		else{
			System.out.println("some thing is going wrong");
		}
		response.sendRedirect("viewC.jsp");
		
	}
		
	catch(Exception ex) {
		ex.printStackTrace();
	}
	}
}
