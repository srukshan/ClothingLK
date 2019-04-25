package CRUDservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ADD
 */
@WebServlet("/ADD")
public class ADD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ADD() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/jsp");
		String id = request.getParameter("ItemId");
		String name = request.getParameter("Name");
		String description = request.getParameter("Description");
		String shortDesc = request.getParameter("ShrotDescription");
		String price = request.getParameter("price");
		String discount = request.getParameter("discount");
		String category = request.getParameter("Category");
		String size = request.getParameter("Size");
		
		CRUD.CRUD item1 = new CRUD.CRUD();
		try{
			String s1 = item1.insertItem(id, name, description, shortDesc, price, discount, category, size);
			if(s1.equals("success")){
			}
			else{
				System.out.println("some thing is going wrong");
			}
			response.sendRedirect("UPDATE.jsp");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
