package com.clothing.item;

import java.util.HashMap;

public class Default extends Product {

	@Override
	protected void setSalePrice(float regularPrice2) {
		SalePrice = (float) (regularPrice2 * 0.85);
	}

	public Default(int productNo2, String title, String desc, String shortDesc, float regularPrice, boolean stock,
			String Category, String image) {
		super(productNo2, title, desc, shortDesc, regularPrice, stock, Category, image);
	}

	@Override
	public Object getAttribute(String attrib) throws Throwable {
		throw new Exception("Invalid Attribute Get Request");
	}

	@Override
	public void setAttribute(String attibName, Object attrib) throws Throwable {
		throw new Exception("Invalid Attribute Set Request");
	}

	@Override
	protected void displayAttributes() {}

	@Override
	public HashMap<String, Object> getAttributes() {
		HashMap<String, Object> att = new HashMap<String, Object>();
		att.put("image", image);
		return att;
	}

}
