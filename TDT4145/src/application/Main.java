package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader();
		Parent root = (Parent) fxmlLoader.load(this.getClass().getResourceAsStream("DiaryGUI.fxml"));
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("InsaneWorkout 3000");
		
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(Main.class, args);
		
	}

}
