package com.clothing.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clothing.CategoryCrud.CategoryCrudDBO;
import com.clothing.CategoryCrud.ReadToUpdate;

/**
 * Servlet implementation class ReadUpdateServlet
 */
@WebServlet("/ReadUpdateServlet")
public class ReadUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadUpdateServlet() {
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
		String cType = request.getParameter("mainCategory");
		
		CategoryCrudDBO dao1 = new CategoryCrudDBO();
		try {
		
		
		ResultSet s1 = dao1.findData(cType);
	
		response.sendRedirect("viewC.jsp");
		
	}
		
	catch(Exception ex) {
		ex.printStackTrace();
	}

	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("ReadUpdateServlet", CategoryCrudDBO.findData());
	}

}
