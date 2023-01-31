package application.model;

/**
 * 
 * @author Lasya Yakkala (iqy403)
 * CS 3443-002
 * 
 * The User class will contain a method called validate which should take in a user name and password. This method can be an object method or a class method, and must be called from the controller for the purpose of authenticating the user for log in.
 * Each User has a user name and a password. Users will also have a full name, as well as a list of roles that they play (each user can have 0 or more roles).
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
	
	//initializes all the string variables for the constructor
	public String userName;
	public String password;
	public String fullName;
	public String favColor1;
	public String favColor2;
	
	//all these values are read in line by line from the Login.csv file
	public User(String fullName, String userName, String password, String favColor1, String favColor2) {
		this.fullName = fullName;
		this.userName = userName;
		this.password = password;
		this.favColor1 = favColor1;
		this.favColor2 = favColor2;
	}

	//this function ensures that the user name corresponds to the password on the CSV file and parses input from Login.CSV in order to do so
	public static User validate(String user, String pass) {
		Scanner scnr;
		User newU = null;	//initializes user object to null
		
		try {
			File f = new File("data/login.csv");
			scnr = new Scanner(f);
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
			while(scnr.hasNextLine()) {
				String line = scnr.nextLine();
				String[] data = line.split(",");
				
				//reads in information for the user per line
				newU = new User(data[0], data[1], data[2], data[3], data[4]);
				
				//if the user name and password are corresponding to the same user, return the user object back to LoginController, because it is validated now
				if(user.equals(newU.userName) && pass.equals(newU.password)) {
					return newU;
				}
				
			}
			
		scnr.close();	//closes the scanner
		return null;	//user name and password are not corresponding to the same user, so returns null. 
		
	}
	
	

	// ===== GETTERS AND SETTERS =============
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFavColor1() {
		return favColor1;
	}

	public void setFavColor1(String favColor1) {
		this.favColor1 = favColor1;
	}

	public String getFavColor2() {
		return favColor2;
	}

	public void setFavColor2(String favColor2) {
		this.favColor2 = favColor2;
	}

	
}
