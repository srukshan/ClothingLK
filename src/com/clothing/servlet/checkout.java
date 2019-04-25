package com.clothing.servlet;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.clothing.databaseConnection.db_connect;
import com.clothing.item.ProductController;
import com.clothing.item.SaleProduct;

import com.clothing.users.User;

/**
 * Servlet implementation class checkout
 */
@WebServlet("/checkout")
public class checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private db_connect db = new db_connect();
	private Statement statement;
	
	public void init() {
		try {
			statement = db.getStatement(1);
		} catch (ClassNotFoundException | SQLException e) {
			com.clothing.log.error.addLog(e,"ProductDB > init");
		}
	}
	
	private void conc() {
		try {
			db.closeConnection();
		} catch (SQLException e) {
			com.clothing.log.error.addLog(e, "ProductDB>end");
		}
	}
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HashMap<Integer,Integer> cart = com.clothing.item.Cart.getCart(session);
        if (session.getAttribute("user") == null) {
            response.sendRedirect("Cart.jsp?error=login");
        } else if(cart == null || cart.size()==0) {
            response.sendRedirect("Cart.jsp");
        }else{
        	int order = doCheckout(cart,(User)session.getAttribute("user"));
        	if(order==-1)
        		response.sendRedirect("checkout.jsp?success=0");
        	else {
        		session.removeAttribute("cart");
        		emptyCart(((User)session.getAttribute("user")).getID());
        		response.sendRedirect("checkout.jsp?success=1&order="+order);
        	}
        }
	}

	private void emptyCart(int userID) {
		try{
			init();
			
			String q = "DELETE FROM `Cart` WHERE `userID`="+userID;
			
			statement.executeUpdate(q);
		}catch(Exception e){
			com.clothing.log.error.addLog(e, "checkout>emptyCart");
		}finally {
			conc();
		}
	}

	public int doCheckout(HashMap<Integer, Integer> cart, User user) {
		
		try{
			init();
			
			Iterator<Map.Entry<Integer,Integer>> i = cart.entrySet().iterator();
			StringBuffer q3 = new StringBuffer();
			q3.append("INSERT INTO `Order_Product`(`OrderID`, `ProductID`, `qty`) VALUES ");
			int amount = 0;
			while(i.hasNext()){ 
				Map.Entry<Integer, Integer> pair = (Map.Entry<Integer, Integer>) i.next();
				SaleProduct p = ProductController.getSaleProduct(pair.getKey());
				amount+=p.getSalePrice()*pair.getValue();
			}
			String q1 = "INSERT INTO `Orders`(`UID`, `Amount`,`Address`) VALUES ("+user.getID()+","+amount+",'"+user.getAddress()+"')";
			
			String q2="SELECT `ID` FROM `Orders` WHERE `UID`="+user.getID()+" ORDER BY `ID` DESC";
			statement.executeUpdate(q1);
			ResultSet r = statement.executeQuery(q2);
			r.next();
			int oid = r.getInt("ID");
			
			i = cart.entrySet().iterator();
			while(i.hasNext()){ 
				Map.Entry<Integer, Integer> pair = (Map.Entry<Integer, Integer>) i.next();
				q3.append("("+oid+","+pair.getKey()+","+pair.getValue()+"),");
			}
			q3.setCharAt(q3.length()-1, ' ');
			String q4 = q3.toString();
			statement.executeUpdate(q4);
			
			return oid;
		}catch(Exception e){
			com.clothing.log.error.addLog(e, "checkout>doCheckout");
			return -1;
		}finally {
			conc();
		}
	}
	
	public String strlast(String str) {
	    if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == 'x') {
	        str = str.substring(0, str.length() - 1);
	    }
	    return str;
	}
	
}
