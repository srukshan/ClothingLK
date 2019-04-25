package com.clothing.users;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.clothing.log.error;

public class UserControl {
	private static User user;
	private static UserDB db = new UserDB();
	
	public static boolean validate(String uName, String Password) {
		try {
			String pass = getEncrypted(Password);
			return db.validate(uName, pass);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			error.addLog(e, "UserControl>validate");
			return false;
		}
	}
	
	public static User getUser(String uName, String Password) {
		if(!validate(uName, Password)) {
			return null;
		}
		return db.getUser(uName);
	}
	
	/*private static String getEncrypted(String s) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] bytesOfMessage = s.getBytes("UTF-8");

		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] thedigest = md.digest(bytesOfMessage);
		return thedigest.toString();
	}

	public static void register(String name, String dateofbirth, String address, String gender,String password, String email) {
		db.register(name,dateofbirth,address,gender,password,email);
	}*/
	
	private static String getEncrypted(String s) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();
		m.update(s.getBytes());
		byte[] digest = m.digest();
		BigInteger bigInt = new BigInteger(1,digest);
		String hashtext = bigInt.toString(16);
		// Now we need to zero pad it if you actually want the full 32 chars.
		while(hashtext.length() < 32 ){
		  hashtext = "0"+hashtext;
		}
		return hashtext; 
	}

	public static boolean register(String name, String dateofbirth, String address, String gender, String password,
			String email) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return db.register(name, dateofbirth, address, gender, getEncrypted(password), email);
		
	}
}
