package application;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;

import javafx.scene.control.DatePicker;

public class Workout {
	
	private static String workoutTitle; //have to be static so ExcerciseControll can access
	private static String workoutType; //have to be static so ExcerciseControll can access
	private  LocalDate workoutDate;
	
// UI-model setup	
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	public static final String TITLE_PROPERTY = "title";
	public static final String TYPE_PROPERTY = "type";
	public static final String DATE_PROPERTY = "date";


	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}

// Set methods
	public void setWorkoutTitle(String workoutTitle) {
		System.out.println(workoutTitle);
		String oldValue = "";
		if(workoutTitle == null){
			System.out.println("teztAss");
		}
		else if(workoutTitle.isEmpty()){
			oldValue = this.workoutTitle;
			this.workoutTitle = "";
			pcs.firePropertyChange(TITLE_PROPERTY, oldValue, workoutTitle);
		}
		else if(workoutTitle.matches("[a-zA-Z ]+")){
			oldValue = this.workoutTitle;
			this.workoutTitle = workoutTitle;
			pcs.firePropertyChange(TITLE_PROPERTY, oldValue, workoutTitle);
		}
		else{
			throw new IllegalStateException("Not valid workoutTitle");
		}
	}
	
	public void setWorkoutType(String workoutType){
		String oldValue ="";
		if(workoutType.equals("Inside")){
			oldValue = Workout.workoutType;
			Workout.workoutType = workoutType;
			pcs.firePropertyChange(TYPE_PROPERTY,oldValue,workoutType);
		}
		else if(workoutType.equals("Outside")){ 
			oldValue = Workout.workoutType;
			Workout.workoutType = workoutType;
			pcs.firePropertyChange(TYPE_PROPERTY,oldValue,workoutType);
		}
		else if(workoutType == null){
			//do something crazy
		}
	}
	
	public void setDate(LocalDate dateField) {
		LocalDate today = LocalDate.now();
		System.out.println(dateField);
		LocalDate oldDate = LocalDate.now();
		if(dateField == null){
		}
		else if(!dateField.isAfter(today) && !dateField.equals(today)){
			throw new IllegalArgumentException("workout date must be today or later");
		}
		oldDate = this.workoutDate;
		this.workoutDate = dateField;
		pcs.firePropertyChange(DATE_PROPERTY, oldDate, workoutDate);
		
	}

	
// Get methods	
	public static String getWorkoutTitle() {
		return workoutTitle;
	}
	
	public static String getWorkoutType(){
		return workoutType;
	}

	public LocalDate getWorkoutDate() {
		return workoutDate;
	}

}
