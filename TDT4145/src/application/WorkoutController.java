package application;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.time.LocalDate;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class WorkoutController implements PropertyChangeListener {

	private Workout workout;

	@FXML private TextField workoutField;
	@FXML private DatePicker dateField;
	@FXML private ComboBox<String> typeField; 
	@FXML private ComboBox<String> minuteField; 
	@FXML private ComboBox<String> hourField; 
	@FXML private ComboBox<String> durationField; 
	@FXML private ComboBox<Integer> fitnessField; 
	@FXML private ComboBox<Integer> accomplishmentField; 
	@FXML private TextArea personalNoteField; 
	@FXML private Button createBtn; //In the eventHandler, need to send workoutField value to ExcercisesController.init
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
		if(Workout.TITLE_PROPERTY.equals(propertyName)){
			updateWorkoutTitleView();
		}
		else if(Workout.TYPE_PROPERTY.equals(propertyName)){
			updateWorkoutTypeView();
		}
		else if(Workout.DATE_PROPERTY.equals(propertyName)){
			updateWorkoutDateView();
		}
		else if(Workout.ACCOMPLISHMENT_PROPERTY.equals(propertyName)){
			updateWorkoutAccomplishmentView();
		}
		else if(Workout.DURATION_PROPERTY.equals(propertyName)){
			updateWorkoutDurationView();
		}
		else if(Workout.FITNESS_PROPERTY.equals(propertyName)){
			updateWorkoutFitnessView();
		}
		else if(Workout.NOTE_PROPERTY.equals(propertyName)){
			updateWorkoutNoteView();
		}

	}



	// Start of CONTROLLER Code:
	public void initialize(){
		setModel(new Workout());
		initFrom();
		initDuration();
		initWorkoutType();
		initPersonalFitness();
		initAccomplishment();
	
	}


	// Initialization methods:
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
		typeField.getItems().addAll("Outside","Inside");
	}
	
	private void initPersonalFitness() {
		for(int f = 1; f <= 10; f++){
			fitnessField.getItems().add(f);
		}
	}
	private void initAccomplishment() {
		for(int a = 1; a <= 10; a++){
			accomplishmentField.getItems().add(a);
		}
	}

	

//	View-listeners:
	@FXML
	void titleFieldChange(ObservableValue<? extends String> property, String oldTitle, String newTitle){
		validateTitleView(newTitle);
	}
	private void validateTitleView(String newTitle) {
		if(newTitle.matches("[A-Za-z ]+")){
		}
		else{
			//Do something with the fact that the workout title is invalid
			//throw new IllegalStateException("Not valid workout title");
			System.out.println("NOT VALID workoutTitle");
		}
	}
	
	@FXML
	void titleFieldFocusChange(ObservableValue<? extends Boolean> property, Boolean oldString, Boolean newString){
		if(!newString){
			try {
				updateWorkoutTitleModel();
			} catch (Exception e){
				System.out.println("FEIL her: " + e);
				
			}
		}
	}
	
	@FXML
	public void dateFieldChange() {
		validateDateView();
	}
	
	public void validateDateView(){
		LocalDate today = LocalDate.now();
		LocalDate choosen = dateField.getValue();
		if(!choosen.isAfter(today) && !choosen.equals(today)){
			//make some changes in the view, to notify user that not valid date.
			System.out.println("wrong workout date");
		}
		
	}

	@FXML
	public void dateFieldFocusChange(ObservableValue<? extends Boolean> property, Boolean oldStartDate, Boolean newStartDate){
		System.out.println("focus");
		if(!newStartDate){
			System.out.println("focus1");
			try{
				updateDateModel();
			} catch(Exception e){
				System.err.println(e);
			}
		}
	}
	

// Model-updaters:
	private void updateWorkoutTitleModel(){
		this.workout.setWorkoutTitle(workoutField.getText());
	}

	private void updateDateModel() {
		this.workout.setDate(dateField.getValue());
	}
	
	
	
// View-updaters:
	private void updateWorkoutTitleView() {
		workoutField.setText(Workout.getWorkoutTitle());
	}
	

	private void updateWorkoutTypeView() {
		typeField.setValue(Workout.getWorkoutType());
	}
	

	private void updateWorkoutDateView() {
		dateField.setValue(workout.getWorkoutDate());
	}


	private void updateWorkoutNoteView() {
		personalNoteField.setText(workout.getWorkoutNote());
	}


	private void updateWorkoutFitnessView() {
		fitnessField.setValue(workout.getPersonalFitness());
	}

	private void updateWorkoutDurationView() {
		durationField.setValue(workout.getWorkoutDuration());
	}


	private void updateWorkoutAccomplishmentView() {
		accomplishmentField.setValue(workout.getWorkoutAccomplishment());
	}

	
	
//Scene handler:
	@FXML
	private void createBtnClicked(){
		FXMLLoader fxmlLoader = new FXMLLoader();
		Parent scene;
		try {
			//DO all the validations that needs to be done before new scene. if not already done.  Remember comboboxes default value is null
			/* Validate workoutType */
			if(typeField.getValue() == null){
				//do some logic shit here
			}
			else{
				this.workout.setWorkoutType(typeField.getValue());
			}
			
	/* Validate and set start date*/
			if(dateField.getValue() == null){
				//do some logic shit here
			}
			else {
				this.workout.setDate(dateField.getValue());
			}
	/* Validate and set start time (hour, min)*/
	/* Validate and set duration*/
			if(durationField.getValue() == null){
				//do some logic shit here
			}
			else {
				this.workout.setDuration(durationField.getValue());
			}
	/* Validate and set peronalFitness*/
			if(fitnessField.getValue()== null){
				//do some logic shit here
			}
			else {
				this.workout.setPersonalFitness(fitnessField.getValue());
			}
	/* Validate and set accomplishment*/
			if(accomplishmentField.getValue()== null){
				
			}
			else {
				//update model, with view values. REMEMBER TO ADD pcs.firePropertyChange in workout, and handling that event here under pcs connection  
				this.workout.setWorkoutAccomplishment(accomplishmentField.getValue());
			}
	/* Validate and set personal note*/
			System.out.println("her er note:"+personalNoteField.getText());
			this.workout.setWorkoutNote(personalNoteField.getText());
			
	/*Make new scene, and then set the scene*/
			//check what the modell looks like:
			System.out.println(this.workout.toString());
			scene = (Parent) fxmlLoader.load(this.getClass().getResourceAsStream("ExercisesGUI.fxml"));
			Main.primaryStage.setScene(new Scene(scene));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
