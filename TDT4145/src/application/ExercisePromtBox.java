package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ExercisePromtBox {


	public static void display(Parent newScene, Parent homeScene){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL); //have to close this window before allowed to interact with other windows
		window.setTitle("AddExercise?");
		window.setMinWidth(400);
		window.setMinHeight(200);

		Label label = new Label("Do you want to add another exercise to this workout?");

		Button yes_btn = new Button("Ja");
		Button no_btn = new Button("Nei");

	
		yes_btn.setOnAction(e -> {
			Main.primaryStage.setScene(new Scene (newScene));
			window.close();
		});	

		no_btn.setOnAction(e -> {
			Main.primaryStage.setScene(new Scene (homeScene));
			window.close();
		});


		// Knapper - layout
		HBox layout = new HBox(10);
		layout.setSpacing(10);
		layout.setPadding(new Insets(5));
		layout.getChildren().addAll(label,yes_btn,no_btn);
		layout.setAlignment(Pos.CENTER);


		//AlertBox main-layout: layout og putte knappene inn i.
		BorderPane pane = new BorderPane();
		pane.setTop(label);
		pane.setAlignment(label, Pos.TOP_CENTER);
		pane.setCenter(layout);


		Scene scene = new Scene(pane);
		window.setScene(scene);
		window.showAndWait();

	}

}

