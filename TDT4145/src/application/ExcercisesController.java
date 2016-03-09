package application;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ExcercisesController  implements PropertyChangeListener {
	
	private Strength strengthExercise;
	private Endurance enduranceExercise;
	
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

// Making the UI-model:
	private void setStrenghtModel(Strength exerciseModel){
		if(this.strengthExercise != null){
			this.strengthExercise.removePropertyChangeListener(this);
		}
		this.strengthExercise = exerciseModel;
		if(this.strengthExercise != null) {
			this.strengthExercise.addPropertyChangeListener(this);
		}
	
	}
	
	private void setEnduranceModel(Endurance exerciseModel){
		if(this.enduranceExercise != null){
			this.enduranceExercise.removePropertyChangeListener(this);
		}
		this.enduranceExercise = exerciseModel;
		if(this.enduranceExercise != null) {
			this.enduranceExercise.addPropertyChangeListener(this);
		}
	
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if(event.getSource() != this.strengthExercise || event.getSource() != this.enduranceExercise){
			return;
		}
		String propertyName = event.getPropertyName();
		
		
		
	}	
	
	
// Initialization:
	public void initialize(){
		setWorkoutTitle();
		initType();
		initGroup();
		initTypeSpecifics();
	}

	private void initGroup() {
		groupField.getItems().addAll("Neck","Shoulders","Checst","Shield","Triceps","Biceps","Pecs","Abs","Thighs","Calvs","Core");
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
	
//Scene handler: All validation, model update and view update must happend here. First thing we must do, is set the model based on exercise type!!
		@FXML
		private void addBtnClicked(){
			/* Exercise attributes that cannot be Null:
			 * ØvelsesID - int - auto_increment - PK- Unique.
			 * Navn - varchar(45)
			 * Beskrivelse - varchar(45)
			 * 
			 * Strength-tabell:
			 * ØvelsesID - int
			 * Belastning - int
			 * Antall repetisjoner - int
			 * Antall sett - int
			 * 
			 * Utholdenhet-tabell
			 * ØvelsesID - int
			 * Lengde km - int
			 * Minutter - int
			*/
			Boolean state = true;
			String message = "";
			FXMLLoader fxmlLoader = new FXMLLoader();
			Parent scene;
			try{
	// Validate that the Exercise type is set. Create and set correct corresponding exercise model.
				if(typeField.getValue() == null){ //Type need to be chosen before we can do anything, so we can create correct exercise model.
					message += "Exercise TYPE, need to be choosen!\n";
					state = false;
				}
// Strength Exercise
				else if(typeField.getValue().equals("Strength")){ //Do strength exercise validations
					setStrenghtModel(new Strength());
					//do all the validations:
	// Validate Exercise Name 
					if(exerciseField.getText() == null || exerciseField.getText().equals("")){
						state = false;
						message += "Exercise name not filled in.\n";
					}
					else {
						this.strengthExercise.setName(exerciseField.getText());
					}
	// Validate Exercise Description
					if(descriptionField.getText().equals("")){
						state = false;
						message += "Exercise description not filled in.\n";
					}
					else{
						this.strengthExercise.setDescription(descriptionField.getText());
					}
	// Validate Exercise Goal
					if(goalField.getText().equals("")){
						state = false;
						message += "Exercise goal not filled in.\n";
					}
					else{
						//how do we handle the goal of each exercise? do we need a new class/ entity class Goal?
					}
	// Validate group/category
					if(groupField.getValue()== null){
						state = false;
						message += "Exercise group not set.\n ";
					}
					else{
						//how do we handle this relation to other exercises of same group? should it be only the exercises within same workout with same group that should be grouped?
					}
	// Validate type specific 1
					if(Workout.getWorkoutType().equals("Inside")){
						if(specOneField.getValue() == null){
							state = false;
							message += "Exercise spectators not set.\n ";
						}
						else{
							this.strengthExercise.setSpectators(Integer.valueOf(specOneField.getValue()));
						}
						if(specTwoField.getValue()== null){
							state = false;
							message += "Exercise Air condition not set.\n ";
						}
						else{
							this.strengthExercise.setVentilation(specTwoField.getValue());
						}
					}
					else { // type = Outside
						if(specOneField.getValue() == null){
							state = false;
							message += "Exercise temperature not set.\n ";
						}
						else{
							this.strengthExercise.setTemp(Integer.valueOf(specOneField.getValue()));
						}
						if(specTwoField.getValue()== null){
							state = false;
							message += "Exercise weather not set.\n ";
						}
						else{
							this.strengthExercise.setWeather(specTwoField.getValue());
						}
					}
	// Validate reps
					if(repsField.getText().equals("")){
						state = false;
						message += "Exercise repetitions not set.\n ";
					}
					else{
						
					}
	// Validate sets
					if(setsField.getText().equals("")){
						state = false;
						message += "Exercise sets not set.\n ";	
					}
					else {
						
					}
	// Validate Weight
					if(weightField.getText().equals("")){
						state = false;
						message += "Exercise weigth not set.\n ";
					}
					else{
						
					}
	// Validate Length
					//No need to validate or set, because Strength exercises do not need length.

				}
// Endurance Exercise
				else if(typeField.getValue().equals("Endurance")){ //Do endurance exercise validations
					setEnduranceModel(new Endurance());
					//do all the validations:

				}
// Create State validation
				if(state){ //The exercise to add is valid. do something 
					scene = (Parent) fxmlLoader.load(this.getClass().getResourceAsStream("DiaryGUI.fxml"));
					Main.primaryStage.setScene(new Scene(scene));
				}
				else{
					Alertbox.display(message);
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
}
