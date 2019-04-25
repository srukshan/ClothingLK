package com.clothing.DBConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.clothing.databaseConnection.db_connect;
import com.clothing.item.Default;
import com.clothing.item.Product;
import com.clothing.item.SaleProduct;
import com.clothing.item.cloth;
import com.clothing.item.wear;

public class ProductDB {
	private db_connect db = new db_connect();
	private Statement statement;
	
	private void init() {
		try {
			statement = db.getStatement(1);
		} catch (ClassNotFoundException | SQLException e) {
			com.clothing.log.error.addLog(e,"ProductDB > init");
		}
	}
	
	private void conc() {
		try {
			db.closeConnection();
		} catch (SQLException e) {
			com.clothing.log.error.addLog(e, "ProductDB>end");
		}
	}
	
	public ArrayList<Integer> Search(String q){
		//String query = "SELECT `prod_ID` FROM `Product` WHERE `Title` LIKE '%"+q+"%'";
		String query = "SELECT p.`prod_ID` FROM `Product` p, `Category` c, `Category` c2 WHERE p.`Category`=c.`catID` AND c2.`catID`=c.`parent` AND (p.`Title` LIKE '%"+q+"%' OR c.`Title` LIKE '%"+q+"%' OR c2.`Title` LIKE '%"+q+"%')";
		return getProductList(query);
	}
	
	public ArrayList<Integer> getNewArrivalList(){
		String query = "SELECT `prod_ID` FROM `Product` ORDER BY `price` LIMIT 4";
		return getProductList(query);
	}
	
	public ArrayList<Integer> getBestSellersList(){
		String query = "SELECT `prod_ID` FROM `Product` ORDER BY `price` DESC LIMIT 4";
		return getProductList(query);
	}
	
	public ArrayList<Integer> getProductList(String query){
		ArrayList<Integer> prod = new ArrayList<>();
		ResultSet r;
		
		try {
			init();
			
			r = statement.executeQuery(query);
			
			while(r.next()) {
				prod.add(r.getInt("prod_ID"));
			}
			
			return prod;
		} catch (SQLException e) {
			com.clothing.log.error.addLog(e, "ProductDB>search");
			return null;
		} finally {
			conc();
		}
	}
	
	private boolean checkCategory(String cat) {
		
		String query = "SELECT `Title` FROM `Category` WHERE `Title` = " + cat;
		
		return checkQuery(query);
	}
	
	private boolean checkCategoryLong(String cat) {
		String[] cats = cat.split(",");
		
		String query = "SELECT `Title` FROM `Category` WHERE `Title` = '" + cats[1] + "' AND `parent` = '" + cats[0] + "'";
		
		return checkQuery(query);
	}
	
	private boolean checkUpdateQuery(String q) {
		int r = 0;
		try {
			init();
			
			r = statement.executeUpdate(q);
			return r!=0;
		} catch (SQLException e) {
			com.clothing.log.error.addLog(e, "ProductDB>checkUpdateQuery");
			return false;
		} finally {
			conc();
		}
	}
	
	private boolean checkQuery(String q) {
		ResultSet r = null;
		try {
			init();
			
			r = statement.executeQuery(q);
			return r.next();
		} catch (SQLException e) {
			com.clothing.log.error.addLog(e, "ProductDB>checkQuery");
			return false;
		} finally {
			conc();
		}
	}
	
	private int getCatID(int productID) {
		ResultSet r = null;
		try {
			init();
			r = statement.executeQuery("SELECT `Category` FROM `Product` WHERE `prod_ID` = "+productID);
			if(!r.next()) return -1;
			
			return r.getInt("Category");
			
		} catch (Exception e) {
			com.clothing.log.error.addLog(e, "ProductDB>getCatID");
			return -1;
		} finally {
			conc();
		}
	}
	
	private int getCatID(String cat) {
		ResultSet r = null;
		try {
			init();
			String cats[] = cat.split(",");
			r = statement.executeQuery("SELECT c1.`catID` FROM `Category` c1, `Category` c2 WHERE c1.`parent` = c2.`catID` AND c1.`Title`='"+cats[1]+"' AND c2.`Title`='"+cats[0]+"'");
			if(!r.next()) return -1;
			
			return r.getInt("catID");
			
		} catch (Exception e) {
			com.clothing.log.error.addLog(e, "ProductDB>getCatID");
			return -1;
		} finally {
			conc();
		}
	}

	public boolean addProduct(Product p) {
		return false;
	}
	
	public boolean updateProductAll(Product p) {
		if(
				updateAttributes(p.getProductNo(),p.getAttributes()) &&
				setCategory(p.getProductNo(), p.getCategory().split(",")[0], p.getCategory().split(",")[1]) &&
				updateProduct(p.getProductNo(),"Description",p.getDesc()) &&
				updateProduct(p.getProductNo(),"Title",p.getTitle()) &&
				updateProduct(p.getProductNo(),"Short Description",p.getShortDesc()) &&
				updateProduct(p.getProductNo(),"Price",p.getRegularPrice()) &&
				updateProduct(p.getProductNo(),"StockStatus",p.isStockStatus())
			)
			return true;
		else
			return false;
	}
	
	public boolean updateAttributes(int pNo, HashMap<String, Object> h) {
		if(!checkUpdateQuery("DELETE FROM `Product_Attribute` WHERE `pod_ID` = " + pNo)) return false;
		
		return false;
	}
	
	public <E> boolean updateProduct(int productID, String columnName, E newValue) {
		String type = newValue.getClass().getName();
		
		String q = "";
		
		switch(columnName) {
		case "Category" :
			return setCategory(productID ,getCategory(productID).split(",")[0], newValue.toString());
		case "Title" :
		case "Description" : 
			q = "UPDATE `Product` SET `"+columnName+"` = '"+newValue.toString()+"'";
		case "Short Description" :
			if(columnName == "Short Description") {
				q = "UPDATE `Product` SET `Short_Desc` = '"+newValue.toString()+"'";
			}
			if(type!="String") return false;
			else {
				q.concat(newValue.toString());
			}
			break;
		case "Product ID" :
			return false;
		case "Price" :
			if(type!="Double") return false;
			else {
				q = "UPDATE `Product` SET `price` = "+newValue.toString();
			}
			break;
		case "StockStatus" : 
			if(type!="Integer") return false;
			else {
				q = "UPDATE `Product` SET `stock_status` = "+newValue.toString();
			}
			break;
		default:
			return false;
		}
		
		q.concat(" WHERE `Product`.`prod_ID` = "+productID);
		
		return checkUpdateQuery(q);
		
		
	}
	
	public boolean setCategory(int ProductID, String Parent, String SubCat) {
		
		
		if(!checkCategory(Parent)) {
			String q = "INSERT INTO `Category` (`Title`, `parent`) VALUES ('"+Parent+"', 0)";
			
			if(checkUpdateQuery(q)) {
				return setCategory(ProductID, Parent, SubCat);
			}else {
				return false;
			}
		}else {
			if(!checkCategory(SubCat)) {
				return false;
			}
			String q = "UPDATE `Product` SET `Category` = '"+getCatID(Parent+","+SubCat)+"' WHERE `Product`.`prod_ID` = "+ProductID;
			
			return checkUpdateQuery(q);
		}
	}
	
	public String getCategory(int ProductID) {
		String ans = "",q = "SELECT c.`parent`, c.`Title` FROM Product p, Category c WHERE p.`Category` = c.`catID` AND p.`prod_ID` = "+ProductID;
		
		init();
		
		ResultSet r;
		try {
			
			
			r = statement.executeQuery(q);
			r.next();
			String subCat = r.getString("Title");
			
			q = "SELECT `Title` FROM `Category` WHERE `catID`="+r.getInt("parent");
			
			r = statement.executeQuery(q);
			r.next();
			ans = r.getString("Title")+","+subCat;
			
		} catch (Exception e) {
			com.clothing.log.error.addLog(e,"ProductDB > getCategory > try");
		}finally {
			conc();
		}
			
		return ans;
	}
	
//	public List<Object> getProductDetails(int ProductID) {
//		List<Object> Product = new ArrayList<Object>();
//		
//		String q = "SELECT * FROM `Product`";
//		
//		try {
//			init();
//			
//			ResultSet r = statement.executeQuery(q);
//			
//			Product.add(0, r.getInt("prod_ID"));
//			Product.add(1, r.getString("Title"));
//			Product.add(2, r.getString("Description"));
//			Product.add(3, r.getString("Short_Desc"));
//			Product.add(4, r.getFloat("price"));
//			Product.add(5, r.getBoolean("stock_status"));
//			Product.add(6, getCategory(ProductID));
//			
//			q = "SELECT pa_value FROM `Product_Attribute` WHERE prod_ID = "+ProductID;
//			
//			r = statement.executeQuery(q);
//			int count = 7;
//			while(r.next()) {
//				Product.add(count++, r.getString("pa_value"));
//				System.out.println(Product.get(count-1));
//			}
//			
//			return Product;
//		} catch (SQLException e) {
//			log.error.addLog(e,"ProductDB > getProductDetails");
//		} finally {
//			try {
//				db.closeConnection();
//			} catch (SQLException e) {
//				log.error.addLog(e,"ProductDB > getProductDetails > sql");
//			}
//		}
//		
//		return null;
//	}
	
	public Product getProduct(int ProductID) {

		Product p;
		String q = "SELECT * FROM `Product` WHERE `prod_ID` = " + ProductID;
		
		try {
			init();
			
			ResultSet r = statement.executeQuery(q);
			
			if(r.next()) {
				int pID =  r.getInt("prod_ID");
				String title = r.getString("Title");
				String desc = r.getString("Description");
				String sdesc = r.getString("Short_Desc");
				float price = r.getFloat("price");
				boolean stock =  r.getBoolean("stock_status");
				conc();
				String cat = getCategory(ProductID);
				init();
				
				q = "SELECT `pa_value` FROM `Product_Attribute` WHERE prod_ID = "+ProductID+" ORDER BY `att_ID`";
				
				r = statement.executeQuery(q);
				r.next();
				String s1 = r.getString("pa_value");
				if(!r.next()) {
					p = new Default(pID, title, desc, sdesc, price, stock, cat, s1);
				}else {
					String s2 = r.getString("pa_value");
					if(!r.next()) {
						p = new wear(pID, title, desc, sdesc, price, stock, cat, s1, s2);
					}else {
						int s3 = Integer.parseInt(r.getString("pa_value"));
						p = new cloth(pID, title, desc, sdesc, price, stock, cat, s1, s2, s3);
					}
				}
				
				return p;
			}
		} catch (SQLException e) {
			com.clothing.log.error.addLog(e,"ProductDB > getProduct");
		} finally {
			conc();
		}
		
		return null;
	}

	public SaleProduct getSaleProduct(int prodID) {
		// TODO Auto-generated method stub
		SaleProduct p;
		String q = "SELECT * FROM `Product` WHERE `prod_ID` = " + prodID;
		
		try {
			init();
			
			ResultSet r = statement.executeQuery(q);
			
			if(r.next()) {
				int pID =  r.getInt("prod_ID");
				String title = r.getString("Title");
				float price = r.getFloat("price");
				boolean stock =  r.getBoolean("stock_status");
				
				p = new SaleProduct(pID, title, price, stock);
				
				return p;
			}
		} catch (SQLException e) {
			com.clothing.log.error.addLog(e,"ProductDB > getSaleProduct");
		} finally {
			conc();
		}
		
		return null;
	}
}
