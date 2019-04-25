package com.clothing.item;

import java.util.HashMap;

public class cloth extends Product{
	private String size;
	private int age;
	
	public cloth(int productNo, String title, String desc, String shortDesc, float regularPrice, boolean stock, String Category, String image, String size, int age) {
		super(productNo, title, desc, shortDesc, regularPrice, stock, Category, image);
		this.size = size;
		this.age = age;
		
	}

	@Override
	protected void setSalePrice(float regularPrice2) {
		SalePrice = (float) (regularPrice2 * 0.85);
	}

	@Override
	public Object getAttribute(String attrib) throws Throwable {
		if(attrib.contentEquals("size")) return size;
		else if(attrib.contentEquals("age")) return age;
		else throw new Exception("Invalid Attribute Get Request");
	}

	@Override
	public void setAttribute(String attibName, Object attrib) throws Throwable {
		if(attibName.contentEquals("size")) size = (String) attrib;
		else if(attibName.contentEquals("age")) age = (int) attrib;
		else throw new Exception("Invalid Attribute Set Request");
	}

	@Override
	protected void displayAttributes() {
		System.out.println("  size : " + size);
		System.out.println("  age : " + age);
	}

	@Override
	public HashMap<String, Object> getAttributes() {
		HashMap<String, Object> attributes = new HashMap<>();
		try {
			attributes.put("size", getAttribute("size"));
			attributes.put("age", getAttribute("age"));
			attributes.put("image",image);
		} catch (Throwable e) {}
		
		return attributes;
	}

}
