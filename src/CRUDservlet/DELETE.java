package CRUDservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DELETE
 */
@WebServlet("/DELETE")
public class DELETE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DELETE() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/jsp");
		String id = request.getParameter("ItemId");
		String name = request.getParameter("Name");
		String category = request.getParameter("Category");
		
		CRUD.CRUD item1 = new CRUD.CRUD();
		try{
			String s2 = item1.deleteItem(id, name, category);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
