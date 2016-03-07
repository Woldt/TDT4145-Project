package application;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class WorkoutController implements PropertyChangeListener {

	private Workout workout;

	@FXML private TextField workoutField;
	@FXML private DatePicker dateField;
	@FXML private ComboBox<String> typeField; 
	@FXML private ComboBox<String> minuteField; 
	@FXML private ComboBox<String> hourField; 
	@FXML private ComboBox<String> durationField; 
	@FXML private ComboBox<String> feelingField; 
	@FXML private ComboBox<String> accomplishmentField; 
	@FXML private TextArea personalNoteField; 
	@FXML private Button createBtn;
	@FXML private Button cancelBtn;
	@FXML private Button resetBtn;

	//	MAKING THE UI-model: 
	private void setModel(Workout workout){
		if(this.workout != null){
			this.workout.removePropertyChangeListener(this);
		}
		this.workout = workout;

		if(this.workout != null){
			this.workout.addPropertyChangeListener(this);
		}
	}


	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if(event.getSource() != this.workout){
			return;
		}
		String propertyName = event.getPropertyName();

	}


	// Start of CONTROLLER Code:
	public void initialize(){
		setModel(new Workout());
		initFrom();
		initDuration();
		initWorkoutType();


	}

	private void initFrom() {
		for(int i = 7; i < 24; i++){
			if(i < 10 ? hourField.getItems().add("0"+i) : hourField.getItems().add(String.valueOf(i)));
		}
		for(int j = 0; j < 60; j += 15){
			if(j < 10 ? minuteField.getItems().add("0"+ j) : minuteField.getItems().add(String.valueOf(j)));
		}
	}


	private void initDuration() {
		for(int d = 0; d <= 300; d += 30){
			if(d < 10 ? durationField.getItems().add("0"+d+" min") : durationField.getItems().add(String.valueOf(d+" min")));
		}
	}	
	
	
	private void initWorkoutType() {
		typeField.getItems().addAll("Uteaktivitet","Inneaktivitet");
	}



}