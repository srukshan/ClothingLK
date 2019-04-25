package com.clothing.DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DBConnect {
		//public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException{
		public static Connection getConnection() throws ClassNotFoundException, SQLException{

		//PreparedStatement ps = null;
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/clothinglk";
		String SSLCon = "?autoReconnect=true&useSSL=false";
		String user = "root";
		String pass = "uthpala";
		try {
			con = DriverManager.getConnection(url+SSLCon, user, pass);
		//ps = con.prepareStatement(sql);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
		}
		/*
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
			getPreparedStatement("select * form category");
			System.out.println("Success");
		}
		*/
	/*	public Connection getCon(){
			Connection con;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clothinglk", "root", "uthpala");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return con;
			
		}
		*/

		public static PreparedStatement getPreparedStatement(String sql) {
			// TODO Auto-generated method stub
			
			
			return null;
		}

	
}

