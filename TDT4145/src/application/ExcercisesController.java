package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ExcercisesController {
	
	@FXML Label workoutTitle;
	@FXML Label	repsTimesSets;
	@FXML TextArea descriptionField;
	@FXML TextField exerciseField;
	@FXML TextField weightField;
	@FXML TextField goalField;
	@FXML TextField repsField;
	@FXML TextField setsField;
	@FXML TextField lenghtField;
	@FXML ComboBox<String> groupField;
	@FXML ComboBox<String> specOneField;
	@FXML ComboBox<String> specTwoField;
	@FXML ComboBox<String> typeField;
	@FXML Button moreBtn;
	@FXML Button addBtn;
	
	public void initialize(){
		setWorkoutTitle();
		initType();
		initGroup();
		initTypeSpecifics();
	}

	private void initGroup() {
		groupField.getItems().addAll("Neck","Shoulders","Checst","Shield","Triceps","Biceps","Pecs","Abs","Thighs","Calvs");
	}

	
	private void initType() {
		typeField.getItems().addAll("Strength","Endurance");
	}
	
	//Remeber to use type from workout!!!!
	private void initTypeSpecifics() {
		String workoutType = Workout.getWorkoutType();
		System.out.println(workoutType);
		if(workoutType == null){
			//Do some view-logic...
		}
		else if(workoutType.equals("Outside")){
			specOneField.setPromptText("Temp");
			specOneField.setValue("0°C");
			for(int t = -10;t <= 25;t++){
				if(t == 25 ? specOneField.getItems().add(t+"+°C") : specOneField.getItems().add(t+"°C"));
			}
			specTwoField.setPromptText("Weather");
			specTwoField.getItems().addAll("Sunny","Cloudy","Rain","Fog","Snow","Wind","Other");
		}
		else if(workoutType.equals("Inside")){
			specOneField.setPromptText("AC state");
			specOneField.getItems().addAll("Good","Heavy Air","Bad");
			specTwoField.setPromptText("Spectators");
			for(int s = 0; s <= 11; s++){
				if(s < 10 ? specTwoField.getItems().add("0"+s) : s == 11 ? specTwoField.getItems().add(s+"+") : specTwoField.getItems().add(String.valueOf(s)));
			}
		}
		
	}
	
	private void setWorkoutTitle(){
		workoutTitle.setText(Workout.getWorkoutTitle());
		
	}	
	

}
