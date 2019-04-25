package com.clothing.servlet; 
import java.io.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clothing.CategoryCrud.*;
/**
 * Servlet implementation class ClothingServlet
 */
@WebServlet("/CategoryCrudServlet")
public class CategoryCrudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryCrudServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/jsp");
		String aType = request.getParameter("subCategory");
		CategoryCrudDBO dao2 = new CategoryCrudDBO();
		ArrayList<Category> s2 = dao2.displayData(aType);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/jsp");
		String cType = request.getParameter("mainCategory");
		String cTitle = request.getParameter("Title");
		String cDescription = request.getParameter("Description");
		

		
		CategoryCrudDBO dao1 = new CategoryCrudDBO();
		
		String s1 = dao1.insertData(cTitle, cDescription, cType);
		if(s1.equals("success")){
			System.out.println("Data Inserted");
			
		}else{
			System.out.println("some thing is going wrong");
		}
		
		//writer.println("Main Category:"+ getCType);
		//writer.println("Category Title:"+ getCTitle);
	//	writer.println("Category Description:"+ getCDescription);
		
	}
	
}
