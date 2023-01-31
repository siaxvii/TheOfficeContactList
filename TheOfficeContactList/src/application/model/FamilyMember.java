package application.model;

/**
 * 
 * @author Lasya Yakkala (iqy403)
 * This class represents a FamilyMember object (with type Contact), with the parent class of Contact
 * 
 */

public class FamilyMember extends Contact{
	//Initializes method's required values
	public String name;
	public String phoneNum;
	public String relation;
	public String location;
	
	/*
	 * Defines the values for the FamilyMember object of type Contact, passes in the String variables
	 * name, relation, phoneNum, and location, in order according to the CSV file
	 */
	public FamilyMember(String name, String relation, String phoneNum, String location){
		super(name, phoneNum);  //Extends the values from the parent class, Contact
		
		this.name = name;
		this.phoneNum = phoneNum;
		this.relation = relation;
		this.location = location;
	}
	
	//Returns the string representation of each family member contact
	public String toString() {
		return name + "		" + relation + "		" + location + "		" + phoneNum + "\n";
	}

	
	//initiate getters and setters
	public String getName() {  //gets the name of the family member contact, no parameters because it's a getter
		return name;
	}

	public void setName(String name) {  //sets the name of the family member contact, passes in the String variable name
		this.name = name;
	}

	public String getPhoneNum() {  //gets the phone number of the family member contact, no parameters because it's a getter
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {   //sets the phone number of the family member contact, passes in the String variable phoneNum
		this.phoneNum = phoneNum;
	}

	public String getRelation() {   //gets the relationship of the family member contact, no parameters because it's a getter
		return relation;
	}

	public void setRelation(String relation) {  //sets the relationship of the family member contact, passes in the String variable relation
		this.relation = relation;
	}

	public String getLocation() {   ////gets the location of the family member contact, no parameters because it's a getter
		return location;
	}

	public void setLocation(String location) {  //sets the location of the family member contact, passes in the String variable location
		this.location = location;
	}
	
}
