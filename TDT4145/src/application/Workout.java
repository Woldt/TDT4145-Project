package application;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Workout {
	
	private static String workoutTitle;
	private static String workoutType;
	
	
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	public static String TITLE_PROPERTY = "title";
	public static final String TYPE_PROPERTY = "type";


	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}

	public void setWorkoutTitle(String workoutTitle) {
		String oldValue = "";
		if(!workoutTitle.matches("[a-zA-Z ]+")){
			throw new IllegalStateException("Not valid workoutTitle");
		}
		else if(workoutTitle.isEmpty()){
			oldValue = this.workoutTitle;
			this.workoutTitle = "";
			pcs.firePropertyChange(TITLE_PROPERTY, oldValue, workoutTitle);
		}
		else{
			oldValue = this.workoutTitle;
			this.workoutTitle = workoutTitle;
			pcs.firePropertyChange(TITLE_PROPERTY, oldValue, workoutTitle);
		}
	}

	public static String getWorkoutTitle() {
		return workoutTitle;
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
	
	
	public static String getWorkoutType(){
		return workoutType;
	}

}
