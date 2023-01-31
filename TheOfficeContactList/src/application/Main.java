package application;
	
/**
 * 
 * @author Lasya Yakkala (iqy403)
 * CS 3443-002
 * 
 *  Starts the program with the right FXML 
 * 
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;



public class Main extends Application {
	public static Stage stage;

	//Below code block sets the stage for the first view the user sees as the app is launched
	@Override
	public void start(Stage primaryStage) {
		
		stage = primaryStage;
		
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/Login.fxml"));

			AnchorPane layout = (AnchorPane) loader.load();

			Scene scene = new Scene(layout);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
	
}
