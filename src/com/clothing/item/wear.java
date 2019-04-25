package com.clothing.item;

import java.util.HashMap;

public class wear extends Product {
	public String Brand;
	
	public wear(int productNo, String title, String desc, String shortDesc, float regularPrice, boolean stock, String Category, String image, String brand) {
		super(productNo, title, desc, shortDesc, regularPrice, stock, Category, image);
		Brand = brand;
	}

	@Override
	protected void setSalePrice(float regularPrice2) {
		SalePrice = (float) (regularPrice2 * 0.8);
	}

	@Override
	public Object getAttribute(String attrib) throws Throwable {
		if(attrib.contentEquals("brand")) return Brand;
		else throw new Exception("Invalid Attribute Get Request");
	}

	@Override
	public void setAttribute(String attibName, Object attrib) throws Throwable {
		if(attibName.contentEquals("brand")) Brand = (String) attrib;
		else throw new Exception("Invalid Attribute Set Request");
	}

	@Override
	protected void displayAttributes() {
		System.out.println("  brand : " + Brand);
	}

	public HashMap<String, Object> getAttributes() {
		HashMap<String, Object> attributes = new HashMap<>();
		try {
			attributes.put("brand", getAttribute("brand"));
			attributes.put("image",image);
		} catch (Throwable e) {}
		
		return attributes;
	}
}
