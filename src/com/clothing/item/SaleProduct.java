package com.clothing.item;

import java.util.HashMap;

public class SaleProduct {
	private int ProductNo;
	private String Title;
	private double RegularPrice;
	private double SalePrice;
	private boolean StockStatus;

	public void setRegularPrice(double regularPrice) {
		RegularPrice = regularPrice;
		SalePrice = (regularPrice * 0.9);
	}
	
	/**
	 * @return the productNo
	 */
	public int getProductNo() {
		return ProductNo;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * @return the regularPrice
	 */
	public double getRegularPrice() {
		return RegularPrice;
	}

	/**
	 * @return the salePrice
	 */
	public double getSalePrice() {
		return SalePrice;
	}

	/**
	 * @return the stockStatus
	 */
	public boolean isStockStatus() {
		return StockStatus;
	}

	
	
	public void displayProduct() {
		System.out.println("Product No : " + ProductNo);
		System.out.println("Title : " + Title);
		System.out.println("Regular Price : " + RegularPrice);
		System.out.println("Sale Price : " + SalePrice);
	}

	public SaleProduct(int productNo2, String title, float regularPrice, boolean stock) {
		ProductNo = productNo2;
		Title = title;
		setRegularPrice(regularPrice);
		StockStatus = stock;
	}
}
