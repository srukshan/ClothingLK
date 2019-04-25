package com.clothing.databaseConnection;
import java.sql.*;

public class db_connect {
	//users
	private String al2_user = "rukshans_cust";
	private String al2_pass = "]OA(U+4nD]Gi";
	private String al1_user = "rukshans_admin";
	private String al1_pass = "VF_C7pNK%WUo";
	
	//userSelect
	private String userName;
	private String password;
	
	//database connection Details
	private String dbms = "com.mysql.jdbc.Driver";
	private String host = "rukshansoftwaresolutions.cf";
	private int port = 3306;
	private String database = "rukshans_online_shop_project";
	
	//database Objects
	private Connection con;
	private Statement stat;
	
	//Connect to the database
	private void getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName(dbms);
	    con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+database,userName,password);
	    stat = con.createStatement();
	}
	
	public Statement getStatement(int accessLevel) throws ClassNotFoundException, SQLException {
		setAccess(accessLevel);
		getConnection();
		
		return stat;
	}
	
	//Disconnect from the database
	public void closeConnection() throws SQLException {
		if(con!=null)
			con.close();
		if(stat!=null)
			stat.close();
	}
	
	//setup user according to access level
	private void setAccess(int accessLevel) {
		if(accessLevel == 1) {
			userName = al1_user;
			password = al1_pass;
		}else {
			userName = al2_user;
			password = al2_pass;
		}
	}
}
