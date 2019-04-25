package com.clothing.CategoryCrud;
import com.clothing.DBConnect.DBConnect;
import java.sql.*;

public class ReadToUpdate {
	private Connection con;
	private ResultSet results;
	static DBConnect db = new DBConnect();
	private String cMainType;
	private String cSubType;
	
	
	public ReadToUpdate() {
		
		try {
			
			con =db.getCon();
		
	}
	public void ReadMainType(String cMainType) {
		this.cMainType = cMainType;
			
		
	}
	public String getcMainType() {
		
	}
		return cMainType;
	}


	public String getcSubType() {
		return cSubType;
	}
	public void setcSubType() {
		
	}
}
