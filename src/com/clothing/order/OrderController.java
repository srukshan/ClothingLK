package com.clothing.order;

import java.util.HashMap;

public class OrderController {
	
	public static Order getOrderById(int order){
		com.clothing.DBConnector.OrderDB db = new com.clothing.DBConnector.OrderDB();
		
		HashMap<Integer,Integer> items = db.getOrderItems(order);
		
		return db.getOrder(order, items);
	}
}
