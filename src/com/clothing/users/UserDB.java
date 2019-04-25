package com.clothing.users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.clothing.log.error;

public class UserDB {
	
	private db_connect db = new db_connect();
	private Statement statement;
	
	private void init() {
		try {
			statement = db.getStatement(1);
		} catch (ClassNotFoundException | SQLException e) {
			error.addLog(e,"CartDB > init");
		}
	}
	
	private void conc() {
		try {
			db.closeConnection();
		} catch (SQLException e) {
			error.addLog(e, "CartDB>end");
		}
	}
	
	public boolean validate(String login, String uPass){
		String q = "SELECT Id FROM User WHERE Login='"+login+"' AND Password='"+uPass+"'";
		
		try {
			init();
			
			ResultSet r = statement.executeQuery(q);
			
			
			if(r.next()) {
				return true;
			}
			return false;
			
		}catch(Exception e) {
			error.addLog(e, "UserDB > checkUser");
			return false;
		}finally {
			conc();
		}
		
	}

	public boolean register(String name, String dateofbirth, String address, String gender,String password, String email) {
		String q = "INSERT INTO `User`(`Name`, `Gender`, `Address`, `Email`, `Login`, `Password`, `Access`) VALUES ('"+name+"','"+gender+"','"+address+"','"+email+"','"+email+"','"+password+"',2)";
				
		try {
			init();
			
			statement.executeUpdate(q);
			
			return true;
		}catch(Exception ex) {
			error.addLog(ex, "UserDB > register");
		}finally {
			conc();
		}
		return false;
	}

	public User getUser(String uName) {
		String q = "SELECT * FROM User WHERE Login='"+uName+"'";
		
		try {
			init();
			
			ResultSet r = statement.executeQuery(q);
			
			
			if(!r.next()) {
				return null;
			}
			
			int id = r.getInt("Id");
			int access = r.getInt("Access");
			String name = r.getString("Name");
			String address = r.getString("Address");
			String email = r.getString("Email");
			String login = r.getString("Login");
			char gender = r.getString("Gender").charAt(0);
			
			return new User(id, access, name, address, email, login, gender);
			
		}catch(Exception e) {
			error.addLog(e, "UserDB > checkUser");
			return null;
		}finally {
			conc();
		}
		
	}
}
