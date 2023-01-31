package application.model;

/**
 * 
 * @author Lasya Yakkala (iqy403)
 * This abstract class will represent a Contact object, extended
 * Extended by FamilyMember.java and WorkContact.java
 * 
 */

public abstract class Contact {
	//Initializes method's required values
	public String name;
	public String phoneNum;
	
	//Defines the variables of the Contact object, passes the name and phone number of each contact
	public Contact(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
	}

	//Getters and setters are initiated here
	
	public String getName() {  //Gets the name of each contact, no parameters because it's a getter
		return name;
	}

	public void setName(String name) {  //Sets the name of each contact, passes in the String variable name as a parameter
		this.name = name;
	}

	public String getPhoneNum() {  //Gets the phone number of each contact, no parameters because it's a getter
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {  //Sets the phone number of each contact, passes in the String variable phone number as a parameter
		this.phoneNum = phoneNum;
	}
	
}

