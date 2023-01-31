package application.controller;

/**
 * 
 * @author Lasya Yakkala (iqy403)
 * CS 3443-002
 * 
 *  Controls all elements on the UserView.FXML page
 * 
 */

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

//implements the EventHandler and Initializable interface
public class UserController implements EventHandler<ActionEvent>, Initializable{
	
	//Initializes all the FXML components
	@FXML Label firstName; 
	@FXML Label fullName;
	@FXML Button logout;
	@FXML Button familyContacts;
	@FXML Button workContacts;
	@FXML AnchorPane background;
	
	//initializes the user variable to be used throughout the file
	User u;
	
	//initialize sets all the GUI components of the FXML view to the necessary attributes before the user interacts with the page
	public void initialize(URL location, ResourceBundle resources) {
		//ensures that it is using the same user variable from LoginController
		u = LoginController.u;
		
		//setting the text of the user name and full name labels
		firstName.setText(u.getUserName());
		fullName.setText(u.getFullName());
		
		//setting label colors to user's second favorite color
		fullName.setStyle("-fx-text-fill: " + u.getFavColor2() + "; ");
		
		//setting button colors to user's second favorite color
		familyContacts.setStyle("-fx-background-color: " + u.getFavColor2() + "; ");
		workContacts.setStyle("-fx-background-color: " + u.getFavColor2() + "; ");
		
		//setting background color to user's first favorite color
		background.setStyle("-fx-background-color: " + u.getFavColor1() + "; ");
		
	}
	
	//handle method is invoked when the user interacts with any button on the User view
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
		
		//If the user selects the "workContacts" button, it will set the location and load the scene to the Work Contacts view
		if(b.getId() != null && b.getId().equals("workContacts")) {
			
			try {

				FXMLLoader loader = new FXMLLoader();
				
				//sets the location of the view to the Work Contacts view
				loader.setLocation(getClass().getResource("../view/WorkContactView.fxml"));

				Scene scene = new Scene(loader.load());

				Main.stage.setScene(scene);
				Main.stage.show();
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//If the user selects the "familyContacts" button, it will set the location and load the scene to the Family Contacts view
		if(b.getId() != null && b.getId().equals("familyContacts")) {
			
			try {

				FXMLLoader loader = new FXMLLoader();
				
				//sets the location of the view to Family Contacts view
				loader.setLocation(getClass().getResource("../view/FamilyContactView.fxml"));

				Scene scene = new Scene(loader.load());

				Main.stage.setScene(scene);
				Main.stage.show();
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

