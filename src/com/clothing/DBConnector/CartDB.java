package com.clothing.DBConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.clothing.databaseConnection.db_connect;
import com.clothing.log.error;

public class CartDB {

	private db_connect db = new db_connect();
	private Statement statement;
	
	private void init() {
		try {
			statement = db.getStatement(1);
		} catch (ClassNotFoundException | SQLException e) {
			error.addLog(e,"CartDB > init");
		}
	}
	
	private void conc() {
		try {
			db.closeConnection();
		} catch (SQLException e) {
			error.addLog(e, "CartDB>end");
		}
	}
	
	public HashMap<Integer, Integer> getCart(int id) {
		String q = "SELECT prodID, qty FROM Cart WHERE userID='"+id+"'";
		ResultSet r;
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		try {
			init();
			
			r = statement.executeQuery(q);
			
			while(r.next()) {
				int key = r.getInt("prodID");
				int value = r.getInt("qty");
				hm.put(key, value);
			}
			
			return hm;
		} catch (SQLException e) {
			error.addLog(e, "Cart>getCart");
			return null;
		} finally {
			conc();
		}
	}

	public boolean addToCart(int prodID, int userID, int qty) {
		String q = "INSERT INTO `Cart`(`prodID`, `userID`, `qty`) VALUES ("+prodID+","+userID+","+qty+") ON DUPLICATE KEY UPDATE qty=VALUES(qty)";
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		try {
			init();
			
			int r = statement.executeUpdate(q);
			
			return true;
		} catch (SQLException e) {
			error.addLog(e, "CartDB>addToCart");
			return false;
		} finally {
			conc();
		}
	}

	public boolean RemoveFromCart(int prodID, int userID) {
		String q = "DELETE FROM `Cart` WHERE `prodID`="+prodID+" AND `userID`="+userID;
		
		try {
			init();
			
			int r = statement.executeUpdate(q);
			
			return true;
		} catch (SQLException e) {
			error.addLog(e, "CartDB>RemoveFromCart");
			return false;
		} finally {
			conc();
		}
	}

}
