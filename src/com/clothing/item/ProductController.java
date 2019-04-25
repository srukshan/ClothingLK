package com.clothing.item;

import java.util.ArrayList;

import com.clothing.DBConnector.ProductDB;
import com.clothing.item.temp.Storage;

public class ProductController {
	private static ProductDB prodDB = new ProductDB();
	private static Storage store = new Storage();
	
//	public static Product getProduct(int prodID) {
//		Product product;
//		
//		List<Object> prodTemp = prodDB.getProductDetails(prodID);
//		String category[] = ((String) prodTemp.get(6)).split(",");
//		switch(category[1]) {
//		case "Cloth":
//			product = new cloth((int) prodTemp.get(0), (String) prodTemp.get(1), (String) prodTemp.get(2), (String) prodTemp.get(3), (float) prodTemp.get(4), (boolean) prodTemp.get(5), (String) prodTemp.get(6), (String) prodTemp.get(7), Integer.parseInt((String) prodTemp.get(8)));
//			break;
//		case "Wear":
//			product = new wear((int) prodTemp.get(0), (String) prodTemp.get(1), (String) prodTemp.get(2), (String) prodTemp.get(3), (float) prodTemp.get(4), (boolean) prodTemp.get(5), (String) prodTemp.get(6), (String) prodTemp.get(7));
//			break;
//		default:
//			product = new Default((int) prodTemp.get(0), (String) prodTemp.get(1), (String) prodTemp.get(2), (String) prodTemp.get(3), (float) prodTemp.get(4), (boolean) prodTemp.get(5), (String) prodTemp.get(6));
//		}
//		
//		return product;
//	}
	
	public static Product[] getBestSellers() {
		ArrayList<Integer> products;
		
		products = prodDB.getBestSellersList();
		
		return getProducts(products);
	}
	
	public static Product[] getNewArrivals() {
		ArrayList<Integer> products;
		
		products = prodDB.getNewArrivalList();
		
		return getProducts(products);
	}
	
	public static Product[] search(String search) {
		ArrayList<Integer> products;
		
		products = prodDB.Search(search);
		
		if(products == null) return null;
		
		return getProducts(products);
	}
	
	private static Product[] getProducts(ArrayList<Integer> products) {
		if(products == null) return null;
		
		Product productsArr[] = new Product[products.size()];
		
		for(int i = 0; i < products.size(); i++) {
			productsArr[i] = getProduct(products.get(i));
		}
		
		return productsArr;
	}
	
	private static SaleProduct[] getSaleProducts(ArrayList<Integer> products) {
		if(products == null) return null;
		
		SaleProduct productsArr[] = new SaleProduct[products.size()];
		
		for(int i = 0; i < products.size(); i++) {
			productsArr[i] = getSaleProduct(products.get(i));
		}
		
		return productsArr;
	}
	
	public static SaleProduct getSaleProduct(int prodID) {
		
		return prodDB.getSaleProduct(prodID);
	}
	
	public static Product getProduct(int prodID) {
		Product p = store.getProduct(prodID);
		if(p == null) {
			p = prodDB.getProduct(prodID);
			store.putProduct(p);
		}
		return p;
	}
	
	public static Product getNewProduct(int prodID) {
		Product p = prodDB.getProduct(prodID);
		store.putProduct(p);
		
		return p;
	}
	
	public static String getCategory(int prodID) {
		return prodDB.getCategory(prodID).split(",")[1];
	}
	
	public static boolean setCategory(int prodID, String Parent, String SubCat) {
		return prodDB.setCategory(prodID, Parent, SubCat);
	}
}
