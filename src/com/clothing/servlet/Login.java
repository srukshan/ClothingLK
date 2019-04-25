package com.clothing.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clothing.users.User;
import com.clothing.users.UserControl;
import com.clothing.users.UserDB;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n=request.getParameter("uname");
		String p=request.getParameter("password");
		
		User user = UserControl.getUser(n, p);
		if(user==null) {
			response.sendRedirect("index.jsp?msg=loginDetailIncorrect");
		}
		else {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("index.jsp?msg=loginSuccess");
		}
		
		out.close();
	}

}