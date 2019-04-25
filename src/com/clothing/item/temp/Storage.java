package com.clothing.item.temp;

import java.util.Date;
import java.util.HashMap;

import com.clothing.item.Product;

public class Storage {
	private static HashMap<Integer,Product> products = new HashMap<>();
	private static HashMap<Integer,Long> time = new HashMap<>();
	
	private void checkExpired(int prodID) {
		try {
			if(new Date().getTime() - time.get(prodID) > 600000) {
				products.remove(prodID);
				time.remove(prodID);
			}
		}catch(Exception e) {}
	}
	
	public Product getProduct(int prodID) {
		checkExpired(prodID);
		try{
			return products.get(prodID);
		}catch(NullPointerException e) {
			return null;
		}
	}
	
	public void putProduct(Product p) {
		try {
			products.put(p.getProductNo(), p);
			time.put(p.getProductNo(), new Date().getTime());
		}catch(Exception e) {}
	}
}
