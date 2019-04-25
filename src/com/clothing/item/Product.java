package com.clothing.item;

import java.util.HashMap;

public abstract class Product {
	
	private int ProductNo;
	private String Title;
	private String Desc;
	private String ShortDesc;
	private float RegularPrice;
	protected float SalePrice;
	private boolean StockStatus;
	private String Category;
	protected String image;
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setRegularPrice(float regularPrice) {
		RegularPrice = regularPrice;
		setSalePrice(regularPrice);
	}
	
	public abstract HashMap<String, Object> getAttributes();
	
	protected abstract void setSalePrice(float regularPrice2);
	
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
	 * @return the desc
	 */
	public String getDesc() {
		return Desc;
	}

	/**
	 * @return the shortDesc
	 */
	public String getShortDesc() {
		return ShortDesc;
	}

	/**
	 * @return the regularPrice
	 */
	public float getRegularPrice() {
		return RegularPrice;
	}

	/**
	 * @return the salePrice
	 */
	public float getSalePrice() {
		return SalePrice;
	}

	/**
	 * @return the stockStatus
	 */
	public boolean isStockStatus() {
		return StockStatus;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return Category;
	}

	/**
	 * @return the attributes
	 * @throws Throwable 
	 */
	public abstract Object getAttribute(String attrib) throws Throwable;

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		Title = title;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		Desc = desc;
	}

	/**
	 * @param shortDesc the shortDesc to set
	 */
	public void setShortDesc(String shortDesc) {
		ShortDesc = shortDesc;
	}

	/**
	 * @param stockStatus the stockStatus to set
	 */
	public void setStockStatus(boolean stockStatus) {
		StockStatus = stockStatus;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		Category = category;
	}
	
	public abstract void setAttribute(String attibName, Object attrib) throws Throwable;

	public void displayProduct() {
		System.out.println("Product No : " + ProductNo);
		System.out.println("Title : " + Title);
		System.out.println("Description : " + Desc);
		System.out.println("Short Description : " + ShortDesc);
		System.out.println("Regular Price : " + RegularPrice);
		System.out.println("Sale Price : " + SalePrice);
		System.out.println("Category : " + Category);
		System.out.println("Image : " + image);
		System.out.println("Attribute : ");
		
		displayAttributes();
	}
	
	protected abstract void displayAttributes();

	public Product(int productNo2, String title, String desc, String shortDesc, float regularPrice, boolean stock, String Category, String image) {
		ProductNo = productNo2;
		Title = title;
		Desc = desc;
		ShortDesc = shortDesc;
		setRegularPrice(regularPrice);
		StockStatus = stock;
		this.Category = Category;
		this.image = image;
	}
}