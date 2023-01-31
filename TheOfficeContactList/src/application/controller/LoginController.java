package application.controller;

/**
 * 
 * @author Lasya Yakkala (iqy403)
 * CS 3443-002
 * LoginController deals with the GUI components on the Login FXML view 
 * 
 */


import application.Main;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements EventHandler<ActionEvent>{
	//initialize FXML components
	@FXML TextField user; 
	@FXML PasswordField pass;
	@FXML Label error;
	
	//static User variable so we're using the same variable throughout the file
	public static User u;

	//If the user selects a button, goes through handle case
	@Override
	public void handle(ActionEvent event) {
		
		//generic button variable that will later be referenced using its specific ID
		Button b = (Button) event.getSource();
		
		//sets string variables to the user name and password fields from the FXML view
		String userName = user.getText();
		String passPhrase = pass.getText();
		
		//assigns validate function to the User variable initialized statically earlier
		u = User.validate(userName, passPhrase);
		
		//If the user selects the login button and the user name and password are not a match, print out error message
		if( b.getId() != null && b.getId().equals("login") && u == null ) {
				error.setText("Invalid login credentials");
				return;
		}
		
		//If the user selects the login button and the user name and password are a match, they will be taken to the User view
		if(b.getId() != null && b.getId().equals("login") && u != null) {
		
			try {
				
				FXMLLoader loader = new FXMLLoader();
						
				//sets the location of the view to User View
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
