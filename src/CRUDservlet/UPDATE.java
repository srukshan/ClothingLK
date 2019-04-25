package CRUDservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UPDATE
 */
@WebServlet("/UPDATE")
public class UPDATE extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("ItemId");
		String name = request.getParameter("Name");
		String category = request.getParameter("Category");
		
		CRUD.CRUD item1 = new CRUD.CRUD();
		try{
			String s2 = item1.updateItem(id, name, category);
			if(s2.equals("success")){
			}
			else{
				System.out.println("some thing is going wrong");
			}
			response.sendRedirect("UPDATE.jsp");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
