package com.clothing.item;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.clothing.users.User;

public class Cart {
	
	@SuppressWarnings("unchecked")
	public static HashMap<Integer, Integer> getCart(HttpSession s) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		User user = (User) s.getAttribute("user");
		try {
			hm.putAll((HashMap<Integer, Integer>) s.getAttribute("cart"));
			if (user != null) {
	            user = (User) s.getAttribute("user");
	            hm.putAll((new com.clothing.DBConnector.CartDB()).getCart(user.getID()));
	        }
		}catch(Exception e) {}
		s.setAttribute("cart", hm);
		return hm;
	}

	public static boolean add(HttpSession session, int id, int qty) {
		try {
			HashMap<Integer, Integer> hm = getCart(session);
			
			hm.put(id, qty);
			session.setAttribute("cart", hm);
			
			if(session.getAttribute("user") != null) {
				additem(id,((User)session.getAttribute("user")).getID(),qty);
			}
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean remove(HttpSession session, int id) {
		try {
			HashMap<Integer, Integer> hm = getCart(session);
			
			hm.remove(id);
			session.setAttribute("cart", hm);
			
			if(session.getAttribute("user") != null) {
				removeitem(id,((User)session.getAttribute("user")).getID());
			}
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private static void additem(int prodID, int userID, int qty) {
		com.clothing.DBConnector.CartDB db = new com.clothing.DBConnector.CartDB();

		db.addToCart(prodID, userID, qty);
	}

	private static HashMap<Integer, Integer> getCart(int id) {
		com.clothing.DBConnector.CartDB db = new com.clothing.DBConnector.CartDB();
		
		return db.getCart(id);
	}

	public static boolean removeitem(int prodID, int userID) {
		com.clothing.DBConnector.CartDB db = new com.clothing.DBConnector.CartDB();
		
		return db.RemoveFromCart(prodID, userID);
	}

}
