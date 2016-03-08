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
	
	public void initialization(){
//		initWorkoutName();
		initType();
		initTypeSpecifics();
		
	}

	private void initType() {
		typeField.getItems().addAll("Strength","Endurance");
	}
	
	//Remeber to use type from workout!!!!
	private void initTypeSpecifics() {
		if(typeField.getValue() == null){
			//Do some view-logic...
		}
		else if(typeField.getValue().equals("Outside")){
			specOneField.setPromptText("Temp");
			specTwoField.setPromptText("Weather");
		}
		else if(typeField.getValue().equals("Inside")){
			specOneField.setPromptText("AC state");
			specTwoField.setPromptText("Weather");
		}
		
	}
	
	
	

}
