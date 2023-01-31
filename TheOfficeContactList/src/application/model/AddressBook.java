package application.model;

/**
 * 
 * @author Lasya Yakkala (iqy403)
 * AddressBook represents an address book that holds the name of the address book,
 * and an ArrayList of Contact objects along with two two object methods that loads and adds the contacts
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	//Initializes method's required values
	public String bookName;
	public ArrayList<Contact> contacts; 
	Scanner scnr = null; //Starts scanner off null, later being assigned to a value
	
	//j variable is set here to be used globally, for the helper function
	public int j = 0;
	
	//This method passes in the name of the address book and defines the values for all the associated variables
	public AddressBook(String bookName){
		this.bookName = bookName; 
		this.contacts = new ArrayList<Contact>();
	}
	
	//Takes in a single contact and adds them to that book
	public void addContact(Contact newContact) {
		this.contacts.add(newContact);
	}
	
	//This object method takes in a file name and adds each contact to the file to that address book, with a try catch statement
	public void loadContacts(String fileName) {
		
		try {
			Contact temp = null;
			
			//int numSpaces = 0;
			//String last;
			scnr = new Scanner(new File(fileName));
			if(scnr != null) {
				while(scnr.hasNextLine()) {
					String line = scnr.nextLine();
					String[] data = line.split(","); //splits each line where there is a comma, into separate data values allotted into different spots in the data array

					int val = data.length;
					
					//if there are 4 columns in the CSV file
					if(val == 4) {
						temp = new FamilyMember(data[0], data[1], data[2], data[3]);   //assigns data[] with each value in the cells of one row
					}
					
					//if there are 3 columns in the CSV file
					else if (val == 3) {
						temp = new WorkContact(data[0], data[1], data[2]);
					}
					
					this.addContact(temp); //adds the contact at the end of the while loop
				}
				
			}
		}
		
		//handles any I/O exceptions
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//returns the size of the address book, used as a helper function
	public int bookSize() {
		return contacts.size();
		
	}
	
	
	//returns the respective objects as a series of strings to the user
	public String toString() {
		String phrase = "";
		
		phrase += contacts.get(j);
		
		//moves on to the next line
		j++;
		
		return phrase;
	}

	//initiate getters and setters
	
	public String getBookName() {  //gets the name of the book, no parameters because it's a getter
		return bookName;
	}

	public void setBookName(String bookName) { //sets the name of the address book, passes bookName as a parameter
		this.bookName = bookName;
	}

	public ArrayList<Contact> getContacts() {  //gets the contacts, no parameters because it's a getter
		return contacts;
	}

	public void setContacts(ArrayList<Contact> contacts) {  //sets the contacts of the address book, passes the ArrayList Contact as a parameter
		this.contacts = contacts;
	}
	
}

