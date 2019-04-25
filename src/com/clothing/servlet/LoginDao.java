package com.clothing.servlet;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDao {

	public static boolean validate(String name, String password) {
		boolean status=false;
		try{			
			String q = "select * from `User` where name="+name+" and pass="+password;
			
			com.clothing.users.db_connect db = new com.clothing.users.db_connect();
			Statement s = db.getStatement(1);
			
			
			
			ResultSet rs=s.executeQuery(q);
			status=rs.next();
			
			
		}catch(Exception e){System.out.println(e);}
		return status;
		}
		}