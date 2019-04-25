package CRUD;

public class Item {

	protected static int ItemId;
	protected static String Name;
	protected static String Description;
	protected static String ShortDescription;
	protected static float Price;
	protected static float Discount;
	protected static int Category;
	protected static String Size;
	
	public static int getItemId() {
		return ItemId;
	}
	public void setItemId(int itemId) {
		ItemId = itemId;
	}
	public static String getName() {
		return Name;
	}
	public  void setName(String name) {
		Name = name;
	}
	public static String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public static String getShortDescription() {
		return ShortDescription;
	}
	public void setShortDescription(String shortDescription) {
		ShortDescription = shortDescription;
	}
	public static float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public static float getDiscount() {
		return Discount;
	}
	public void setDiscount(float discount) {
		Discount = discount;
	}
	public static int getCategory() {
		return Category;
	}
	public void setCategory(int category) {
		Category = category;
	}
	public static String getSize() {
		return Size;
	}
	public void setSize(String size) {
		Size = size;
	}
}
