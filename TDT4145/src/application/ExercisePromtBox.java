package application;

import java.io.IOException;
import java.util.ArrayList;

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


	public static void display(Parent newScene, Parent homeScene, String type){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL); //have to close this window before allowed to interact with other windows
		window.setTitle("AddExercise?");
		window.setMinWidth(400);
		window.setMinHeight(200);

		Label label = new Label("Do you want to add another exercise to this workout?");

		Button yes_btn = new Button("Ja");
		Button no_btn = new Button("Nei");
	
		ArrayList<String> treningsID = Database.select("Select count(*) from Treningsøkt;");
		ArrayList<String> øvelsesID = Database.select("Select count(*) from Øvelse;");
		
		System.out.println(treningsID.get(0).toString());
		System.out.println(øvelsesID.get(0).toString());
	
		System.out.println(treningsID.get(0).split(";")[1]);
	
		yes_btn.setOnAction(e -> {
			Main.primaryStage.setScene(new Scene (newScene));
			insertAll(type, treningsID, øvelsesID);
			window.close();
		});	

		no_btn.setOnAction(e -> {
			Main.primaryStage.setScene(new Scene (homeScene));
			insertAll(type, treningsID, øvelsesID);
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

	private static void insertAll(String type, ArrayList<String> treningsID, ArrayList<String> øvelsesID)throws NumberFormatException {
		if(type.equals("Strength")){
			Database.insert(Tabell.INSERT.ØVELSE(Workout.getWorkoutTitle(),Strength.description, Strength.getGroup() ));
			Database.insert(Tabell.INSERT.MÅL(Workout.getWorkoutDate().toString(), Strength.description, Integer.valueOf(øvelsesID.get(0).split(";")[1])+1));
			Database.insert(Tabell.INSERT.STYRKE_OG_KONDISJON(Integer.valueOf(øvelsesID.get(0).split(";")[1])+1, Strength.getBelastning(), Strength.getRepetitions(), Strength.getSets()));
			erstattesAVGruppeInnsetting(øvelsesID,'S');
		}
		else{ // Endurance
			Database.insert(Tabell.INSERT.ØVELSE(Workout.getWorkoutTitle(),Endurance.description, Endurance.getGroup() ));
			Database.insert(Tabell.INSERT.MÅL(Workout.getWorkoutDate().toString(), Endurance.description, Integer.valueOf(øvelsesID.get(0).split(";")[1])+1));
			Database.insert(Tabell.INSERT.UTHOLDENHET(Integer.valueOf(øvelsesID.get(0).split(";")[1])+1, Endurance.getLength(), Endurance.getMinutes()));
			erstattesAVGruppeInnsetting(øvelsesID,'E');

		}
		if(Workout.getWorkoutType().equals("Outside")){
			Database.insert(Tabell.INSERT.UTENDØRSØVELSE(Integer.valueOf(øvelsesID.get(0).split(";")[1])+1, type.equals("Strength")? Strength.getTemp() : Endurance.getTemp(), type.equals("Strength")? Strength.getWeather() : Endurance.getWeather()));
		}
		else{ // Inside
			Database.insert(Tabell.INSERT.INNENDØRSØVELSE(Integer.valueOf(øvelsesID.get(0).split(";")[1])+1, type.equals("Strength")? Strength.getVentilation() : Endurance.getVentilation(), type.equals("Strength")? Strength.getSpectators() : Endurance.getSpectators()));
			
		}
		//Not workout type or exercise type specific
		
		Database.insert(Tabell.INSERT.BESTÅR_AV(Integer.valueOf(treningsID.get(0).split(";")[1]), Integer.valueOf(øvelsesID.get(0).split(";")[1])+1));
	}

	private static void erstattesAVGruppeInnsetting(ArrayList<String> øvelsesID, char ch) throws NumberFormatException {
		String group;
		if(ch == 'S'){
			group = Strength.getGroup();
		}
		else{
			group = Endurance.getGroup();
		}
		ArrayList<String> resultSet = Database.select(Tabell.SELECT.ERSTATTES_AV_INSERT(group));
		for(String tuple : resultSet){
			Database.insert(Tabell.INSERT.ERSTATTES_AV(Integer.valueOf(øvelsesID.get(0).split(";")[1])+1, Integer.valueOf(tuple.split(";")[1].split(",")[0])));
		}
	}

}

