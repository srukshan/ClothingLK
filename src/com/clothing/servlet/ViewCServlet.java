package com.clothing.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clothing.CategoryCrud.CategoryCrudDBO;

/**
 * Servlet implementation class ViewCServlet
 */
@WebServlet("/ViewCServlet")
public class ViewCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
    	request.setAttribute("viewCServlet",CategoryCrudDBO.displayData());
    	RequestDispatcher rd = request.getRequestDispatcher("viewC.jsp");
    	rd.forward(request, response);
    }

	
}
