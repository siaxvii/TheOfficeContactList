package application.model;

/**
 * 
 * @author Lasya Yakkala (iqy403)
 * This class represents a WorkContact object (with type Contact), with the parent class of Contact
 *
 */

public class WorkContact extends Contact{
	//Initializes method's required value
	public String title;
	
	/*
	 * Defines the values for the WorkContact object of type Contact, passes in the String variables
	 * name, title, and phoneNum, in order according to the CSV file
	 */
	public WorkContact(String name, String title, String phoneNum) {
		super(name, phoneNum); //Extends the values from the parent class, Contact 
		this.title = title;
	}
	
	//returns the string representation of each work contact
	public String toString() {
		return String.format("%-30s %-45s %-30s" , name, title, phoneNum);
	}
	
	//initiate getters and setters
	public String getTitle() {   //gets the title of each work contact, no parameters because it's a getter
		return title;
	}

	public void setTitle(String title) {  //sets the title of each work contact, passes in the String variable title
		this.title = title;
	}
	
}
