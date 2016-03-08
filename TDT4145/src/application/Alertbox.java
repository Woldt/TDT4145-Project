package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * Creates and displays a alertbox/popup window which presents the user with what needs to be filled out in the workout vindow.
 * @author SigveAndreEvensen
 * @author ThomasWold
 */
public class Alertbox {
	
	/**
	 * Creates and displays a popup/alertbox.
	 * @param message string contains all the information the user need to get the correct workout shceme..
	 */
	public static void display(String message){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL); //have to close this window before allowed to interact with other windows
		window.setTitle("Not valid Workout");
		window.setMinWidth(400);
		window.setMinHeight(200);
		
		Label label = new Label(message);
		


//AlertBox main-layout: layout og putte knappene inn i.
		BorderPane pane = new BorderPane();
		pane.setTop(label);
		
		Scene scene = new Scene(pane);
		window.setScene(scene);
		window.showAndWait();
		
		
	}

}
