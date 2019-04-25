package com.clothing.CategoryCrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.clothing.DBConnect.DBConnect;

public class CategoryCrudDBO {
	static Connection con;
	DBConnect db = new DBConnect();
	
	
	public String insertData(String cTitle, String cDescription, String cType) throws ClassNotFoundException{
		String temp = "";
		String sql = "insert into category(categoryTitle,categoryDescription,categoryType)values(?,?,?)";
		
		
		try {
			con = DBConnect.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cTitle);
			ps.setString(2, cDescription);
			ps.setString(3, cType);
			ps.executeUpdate();
			temp = "success";
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(CategoryCrudDBO.class.getName()).log(Level.SEVERE,null, ex);
			ex.printStackTrace();
		}
		
		return temp;
	}
/*	
public static List<Category> displayData() {
	ArrayList<Category> al = new ArrayList<Category>();
	String sql = "SELECT * FROM where categoryType =?";
	PreparedStatement statement = con.prepareStatement(sql);
	statement.setString(1, Category.getcType());

	try {
	//con = db.getCon();
	ResultSet rs = DBConnect.getPreparedStatement(sql).executeQuery();
	while (rs.next()) {
		//Category category = new Category(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		Category category = new Category( rs.getString("categoryTItle"),rs.getString("categoryType"));
		//String title = rs.getString("categoryTitle");
		//String type = rs.getString("categoryType");
		al.add(category);
	
		
		
		}
	}
	catch(ClassNotFoundException | SQLException ex){
		Logger.getLogger(CategoryCrudDBO.class.getName()).log(Level.SEVERE,null, ex);
		ex.printStackTrace();
	}
	return al;
	}
	public ResultSet findDelete(String cType) throws SQLException, ClassNotFoundException {
		
		Statement myStat = con.createStatement();
		String sql = "SELECT categoryTitle FROM category WHERE categoryType=?";
		ResultSet myRs1 = null;
		try {
			PreparedStatement ps = null;
			ps.setString(1, cType);
			
			
			myRs1 = myStat.executeQuery(sql);
			//while(myRs1.next()){
				
			//}
		}
		catch (SQLException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(CategoryCrudDBO.class.getName()).log(Level.SEVERE,null, ex);
			ex.printStackTrace();
		}
		
		
		return myRs1;
		
	
		}
	/*public Category findDelete(int id, Item Item) throws SQLException {
		String sql = "SELECT * FROM Item WHERE Item_ID = ?";
		connect();

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				resultSet.getInt("Item_ID");
				resultSet.getString("Name");
				resultSet.getString("Description");
				resultSet.getString("ShortDescription");
				resultSet.getFloat("price");
				resultSet.getFloat("Discount");
				resultSet.getInt("Category");
				resultSet.getString("Size");
	
				new Item();
			}

			resultSet.close();
			statement.close();
			return Item;
}
*/
	public String deleteData(String cID){
		String temp = "";
		
		
		try {
			String sql = "DELETE FROM category WHERE categoryID =?";
			con = DBConnect.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cID);
			//ps.setString(2, cType);
			ps.executeUpdate();
			temp = "success";
		} catch (ClassNotFoundException | SQLException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(CategoryCrudDBO.class.getName()).log(Level.SEVERE,null, ex);
			ex.printStackTrace();
		}
		
		return temp;
	}
	/*
	public Category getCategory(String mainCategory, Category category) throws SQLException {
		String sql = "SELECT * FROM Item WHERE categoryTitle = ?";
		con();

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, cTitle);
		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			resultSet.getInt("");
			
			new Item();
			}

		resultSet.close();
		statement.close();
		disconnect();
		return Item;
		*/
}
