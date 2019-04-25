package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CRUD {
	
private static Connection jdbcConnection;
 
public CRUD(String jdbcURL) {

}
 
public CRUD() {

}

protected void connect() throws SQLException {
    if (jdbcConnection == null || jdbcConnection.isClosed()) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }
        String userName = "rukshans_admin";
    	String password = "VF_C7pNK%WUo";
        
        String host = "rukshansoftwaresolutions.cf";
    	int port = 3306;
    	String database = "rukshans_online_shop_project";
        
        jdbcConnection = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+database,userName,password);
    }
}
 
protected void disconnect() throws SQLException {
    if (jdbcConnection != null && !jdbcConnection.isClosed()) {
        jdbcConnection.close();
    }
}

public String insertItem(String id, String name, String description,
		String shortDesc, String price, String discount, String category,
		String size)throws SQLException {
	String sql = "INSERT INTO Item (item_ID, Name, Description, Short_Desc, Price, Discount, Category, Size) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, Item.getItemId());
		statement.setString(2, Item.getName());
		statement.setString(3, Item.getDescription());
		statement.setString(4, Item.getShortDescription());
		statement.setFloat(5, Item.getPrice());
		statement.setFloat(6, Item.getDiscount());
		statement.setInt(7, Item.getCategory());
		statement.setString(8, Item.getSize());

		String rowInserted = null;
		statement.close();
		disconnect();
		return rowInserted;
}

public List<Item> listAllItems() throws SQLException {
	List<Item> listItem = new ArrayList<>();
	String sql = "SELECT * FROM Item";
	connect();

	Statement statement = jdbcConnection.createStatement();
	ResultSet resultSet = statement.executeQuery(sql);

	while (resultSet.next()) 
	{
		resultSet.getInt("Item_ID");
		resultSet.getString("Name");
		resultSet.getString("Description");
		resultSet.getString("ShortDescription");
		resultSet.getFloat("price");
		resultSet.getFloat("Discount");
		resultSet.getInt("Category");
		resultSet.getString("Size");
	
		Item Item = new Item();
		listItem.add(Item);
		}

			resultSet.close();
			statement.close();
			disconnect();
			return listItem;
}


public String deleteItem(String id, String name, String category) throws SQLException {
	String sql = "DELETE FROM Item where Item_ID = ?";

	connect();

			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setInt(1, Item.getItemId());
			statement.setString(2, Item.getName());
			statement.setInt(3, Item.getCategory());
			
			String rowDeleted = null;
			statement.close();
			disconnect();
			return rowDeleted;
}


public String updateItem(String id, String name, String category) throws SQLException {
	String sql = "UPDATE Item SET name = ?, description = ?, shortDesc = ?, price = ?, discount = ?, category = ?, size = ?";
	sql += " WHERE Item_ID = ?";
	connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setInt(1, Item.getItemId());
			statement.setString(2, Item.getName());
			statement.setInt(7, Item.getCategory());
			
			String rowUpdated = null;
			statement.close();
			disconnect();
			return rowUpdated;
}

public Item getItem(int id, Item Item) throws SQLException {
		String sql = "SELECT * FROM Item WHERE Item_ID = ?";
		connect();

			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
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
			disconnect();
			return Item;
}






}
