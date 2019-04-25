package com.clothing.users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class usersDB {
	private db_connect db = new db_connect();
	private Statement statement;
	
	private void init () {
		
		try {
			statement = db.getStatement(1);
		} catch (ClassNotFoundException | SQLException e) {
			com.clothing.log.error.addLog(e, "userDB>init ");
		}
	}
	
	public void test() {
		init();
		
		String query = "SELECT `Title` FROM `Category` WHERE `catID` = 1";
		
		ResultSet result;
		
		try {
			result = statement.executeQuery(query);
			
			if(result.next()) {
				System.out.println("Title : " + result.getString("Title"));
			}
		} catch (SQLException e1) {
			com.clothing.log.error.addLog(e1, "userDB>test>execute q");
		}
		
		try {
			db.closeConnection();
		} catch (SQLException e) {
			com.clothing.log.error.addLog(e, "userDB>test>sql");
		}
	}
}
