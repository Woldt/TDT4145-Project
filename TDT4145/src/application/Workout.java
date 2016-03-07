package application;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Workout {
	
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	public static String TITLE_PROPERTY = "title";


	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}

}
