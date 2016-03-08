package application;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;


public class Workout {
	
	private static String workoutTitle; //have to be static so ExcerciseControll can access
	private static String workoutType; //have to be static so ExcerciseControll can access
	private  LocalDate workoutDate;
	private int workoutDuration;
	private int personalFitness;
	private int workoutAccomplishment;
	private String workoutNote;
	
// UI-model setup	
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	public static final String TITLE_PROPERTY = "title";
	public static final String TYPE_PROPERTY = "type";
	public static final String DATE_PROPERTY = "date";
	public static final String DURATION_PROPERTY = "duration";
	public static final String FITNESS_PROPERTY = "fitness";
	public static final String ACCOMPLISHMENT_PROPERTY = "accomplishment";
	public static final String NOTE_PROPERTY = "note";


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

	public void setDuration(String value) {
		//Get minutes from value, cast to int.
		try{
			int oldDuration = this.workoutDuration;
			this.workoutDuration = Integer.valueOf(value.split(" ")[0]); //example 30 min splitted on ' ' --> [30,min]
			pcs.firePropertyChange(DURATION_PROPERTY,oldDuration, this.workoutDuration );
		}
		catch(Exception e){
			
		}
	}

	public void setPersonalFitness(Integer value) {
		if(value == null){
			
		}
		else{
			int oldFitness = this.personalFitness;
			this.personalFitness = value;
			pcs.firePropertyChange(FITNESS_PROPERTY, oldFitness, this.personalFitness);
		}
	}

	public void setWorkoutAccomplishment(Integer value) {
		if(value == null){
			
		}
		else {
			int oldAccomplishment = this.workoutAccomplishment;
			this.workoutAccomplishment = value;
			pcs.firePropertyChange(ACCOMPLISHMENT_PROPERTY, oldAccomplishment, this.workoutAccomplishment);
		}
	}

	public void setWorkoutNote(String text) {
		System.out.println(text);
		if(text.length() <=255 && !text.isEmpty()){
			String oldNote = this.workoutNote;
			this.workoutNote = text;
			pcs.firePropertyChange(NOTE_PROPERTY, oldNote, this.workoutNote);
		}
		else {
			this.workoutNote = "NULL";
		}
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

	public String getWorkoutDuration() {
		String minutes ="";
		if(workoutDuration < 10){
			minutes += "0" + workoutDuration + " min";
		}
		else {
			minutes += workoutDuration + " min";
		}
		
		return minutes;
	}


	public int getPersonalFitness() {
		return personalFitness;
	}

	public int getWorkoutAccomplishment() {
		return workoutAccomplishment;
	}

	public String getWorkoutNote() {
		return workoutNote;
	}
	
	

	@Override
	public String toString() {
		return "Workout [workoutDate=" + workoutDate + ", workoutDuration=" + workoutDuration + ", personalFitness="
				+ personalFitness + ", workoutAccomplishment=" + workoutAccomplishment + ", workoutNote=" + workoutNote
				+ ", pcs=" + pcs + "]";
	}
}
