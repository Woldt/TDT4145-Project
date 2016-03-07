package application;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Workout {
	
	private String workoutTitle;
	
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	public static String TITLE_PROPERTY = "title";


	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}

	public void setWorkoutTitle(String workoutTitle) {
		String oldValue = "";
		if(! workoutTitle.matches("[a-zA-z]")){
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

	public String getWorkoutTitle() {
		return this.workoutTitle;
	}

}
