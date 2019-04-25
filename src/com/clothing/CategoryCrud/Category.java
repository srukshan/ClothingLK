package com.clothing.CategoryCrud;

public class Category {
	
	private static String cID;
	private static String cTitle;
	private static String cDescription;
	private static String cType;
	
	public Category(String cTitle, String cDescription, String cType, String cID) {
		super();
		Category.cID = cID;
		Category.cTitle = cTitle;
		Category.cDescription = cDescription;
		Category.cType = cType;
	}
	public static String cID() {
		return cID;
	}
	public void setcID(String cID) {
		Category.cID = cID;
	}
	public static String getcTitle() {
		return cTitle;
	}
	public void setcTitle(String cTitle) {
		Category.cTitle = cTitle;
	}
	public static String getcDescription() {
		return cDescription;
	}
	public void setcDescription(String cDescription) {
		Category.cDescription = cDescription;
	}
	public static String getcType() {
		return cType;
	}
	public void setcType(String cType) {
		Category.cType = cType;
	}
}
