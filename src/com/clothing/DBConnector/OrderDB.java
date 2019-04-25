package com.clothing.DBConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.HashMap;

import com.clothing.databaseConnection.db_connect;
import com.clothing.order.Order;

public class OrderDB {

	private db_connect db = new db_connect();
	private Statement statement;
	
	private void init() {
		try {
			statement = db.getStatement(1);
		} catch (ClassNotFoundException | SQLException e) {
			com.clothing.log.error.addLog(e,"OrderDB > init");
		}
	}
	
	private void conc() {
		try {
			db.closeConnection();
		} catch (SQLException e) {
			com.clothing.log.error.addLog(e, "OrderDB>end");
		}
	}
	
	public HashMap<Integer, Integer> getOrderItems(int orderId) {
		String q = "SELECT ProductID, qty FROM Order_Product WHERE OrderID='"+orderId+"'";
		ResultSet r;
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		try {
			init();
			
			r = statement.executeQuery(q);
			
			while(r.next()) {
				int key = r.getInt("ProductID");
				int value = r.getInt("qty");
				hm.put(key, value);
			}
			
			return hm;
		} catch (SQLException e) {
			com.clothing.log.error.addLog(e, "OrderDB>getOrderItems");
			return null;
		} finally {
			conc();
		}
	}

	public Order getOrder(int order, HashMap<Integer, Integer> items) {
		String q = "SELECT * FROM Orders WHERE ID='"+order+"'";
		ResultSet r;
		
		try {
			init();
			
			r = statement.executeQuery(q);
			
			r.next();
			
			int userID = r.getInt("UID");
			double amount = r.getDouble("Amount");
			Timestamp dt = r.getTimestamp("Time");
			String address = r.getString("Address");
			
			return new Order(order, userID, dt, items, amount,address);
		} catch (SQLException e) {
			com.clothing.log.error.addLog(e, "OrderDB>getOrderItems");
			return null;
		} finally {
			conc();
		}
	}
}
