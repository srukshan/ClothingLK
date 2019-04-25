package com.clothing.order;

import java.sql.Timestamp;
import java.util.HashMap;

public class Order {
	private int orderID;
	private int userID;
	private Timestamp dateNTime;
	private HashMap<Integer, Integer> orderItems;
	private double amount;
	private String address;
	
	public Order(int orderID, int userID, Timestamp dateNTime, HashMap<Integer, Integer> orderItems, double amount, String address) {
		this.orderID = orderID;
		this.userID = userID;
		this.dateNTime = dateNTime;
		this.orderItems = orderItems;
		this.amount = amount;
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}

	public int getOrderID() {
		return orderID;
	}
	public int getUserID() {
		return userID;
	}
	public Timestamp getDateNTime() {
		return dateNTime;
	}
	public HashMap<Integer, Integer> getOrderItems() {
		return orderItems;
	}
	public double getAmount() {
		return amount;
	}
}
