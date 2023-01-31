package application.controller;

/**
 * 
 * @author Lasya Yakkala (iqy403)
 * CS 3443-002
 * 
 *  Controls all FXML elements on the FamilyContactView.FXML page
 * 
 */


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.model.AddressBook;
import application.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

//implements the EventHandler and Initializable interface
public class FamilyContactController implements EventHandler<ActionEvent>, Initializable{
	
	//Initializes all the FXML components
	@FXML Label firstName; 
	@FXML Label familyContactsLabel;
	@FXML AnchorPane background;

	@FXML ListView<String> familyList;
	
	//ObservableList slots is what is being displayed in the ListView
	ObservableList<String> slots = FXCollections.observableArrayList();
	
	User u;
	
	//initialize sets all the GUI components of the FXML view to the necessary attributes before the user interacts with the page
	public void initialize(URL location, ResourceBundle resources) {
		
		//ensures that it is using the same user variable from LoginController
		u = LoginController.u;
		
		//sets file destination to be personalized to each family CSV to the particular person
		String file = "data/family-" + u.userName + ".csv";
		
		//sets address book to be for family
		AddressBook familyBook = new AddressBook("Family");
		familyBook.loadContacts(file);
		
		//header row to explain what the below slots are (name, relation, location, and phone number)
		familyList.getItems().add("Name			Relation		Location		Phone Number");
		ArrayList<String> familyNames = new ArrayList<String>();
		
		//Iterates through the entire address book using a helper function from address book
		for(int f = 0; f < familyBook.bookSize(); f++) {
			//adds each family member line by line using the toString function in address book
			familyNames.add(familyBook.toString());
			
			//sets the colors of the inner slots
			if(f % 2 == 0) {
				familyList.setStyle("-fx-control-inner-background: " + u.getFavColor1() + "; ");
			}
			else {
				familyList.setStyle("-fx-control-inner-background: " + u.getFavColor2() + "; ");
			}
			
		}
		//adds all the items into the slots
		slots.addAll(familyNames);
		familyList.getItems().addAll(slots);
		
		
		//setting the text of the user name label
		firstName.setText(u.getUserName());
		
		//setting background color to user's first favorite color
		background.setStyle("-fx-background-color: " + u.getFavColor1() + "; ");
		
		//setting label colors to user's second favorite color
		familyContactsLabel.setStyle("-fx-text-fill: " + u.getFavColor2() + "; ");
	
	}
	
	//handle method is invoked when the user interacts with any button on the Family Controller view
	@Override
	public void handle(ActionEvent event) {
		
		//generic button variable that will later be referenced using its specific ID
		Button b = (Button) event.getSource();
		
		//If the user selects "logout", will set the location and load the scene to the Login view
		if(b.getId() != null && b.getId().equals("logout")) {
			
			try {

				FXMLLoader loader = new FXMLLoader();
				
				//sets the location of the view to Login
				loader.setLocation(getClass().getResource("../view/Login.fxml"));
				
				Scene scene = new Scene(loader.load());
				
				Main.stage.setScene(scene);
				
				Main.stage.show();
				
			
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//If the user selects "back", will set the location and load the scene to the User view
		if(b.getId() != null && b.getId().equals("back")) {
			
			try {

				FXMLLoader loader = new FXMLLoader();
				
				//sets the location of the view to User view
				loader.setLocation(getClass().getResource("../view/UserView.fxml"));

				Scene scene = new Scene(loader.load());

				Main.stage.setScene(scene);
				Main.stage.show();
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
}