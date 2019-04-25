package com.clothing.users;

public class User {
	
	private int Id, Access;
	private String Name, Address, Email, Login;
	private char Gender;
	
	public User(int id, int access, String name, String address, String email, String login, char gender) {
		Id = id;
		Access = access;
		Name = name;
		Address = address;
		Email = email;
		Login = login;
		Gender = gender;
	}

	public int getID() {
		return Id;
	}

	public int getAccess() {
		return Access;
	}

	public String getName() {
		return Name;
	}

	public String getAddress() {
		return Address;
	}

	public String getEmail() {
		return Email;
	}

	public String getLogin() {
		return Login;
	}

	public char getGender() {
		return Gender;
	}
	
	
}
