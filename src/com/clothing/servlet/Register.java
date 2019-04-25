package com.clothing.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clothing.log.error;
import com.clothing.users.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String name=request.getParameter("Name");  
		String dateofbirth=request.getParameter("dateofbirth");  
		String address=request.getParameter("address");  
		String gender=request.getParameter("gender"); 
		String email=request.getParameter("Email");
		String password=request.getParameter("password"); 
		String confirmpassword=request.getParameter("ConfirmPassword"); 
		
		if(password.compareTo(confirmpassword)!=0) {
			response.sendRedirect("index.jsp?msg=passwordUnmatched");
			return;
		}
		          
		try {
			if(com.clothing.users.UserControl.register(name,dateofbirth,address,gender,password, email)) {
				response.sendRedirect("index.jsp?msg=registerSuccess");
				return;
			} else {
				response.sendRedirect("index.jsp?msg=registerUnsuccess");
				return;
			}
		} catch (NoSuchAlgorithmException e) {
			error.addLog(e, "Register>doPost");
		}
		  
	}
}