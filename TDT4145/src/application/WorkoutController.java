package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class WorkoutController {
	@FXML private TextField workoutID;
	@FXML private DatePicker dateField;
	@FXML private ComboBox<String> typeField; 
	@FXML private ComboBox<Integer> minuteField; 
	@FXML private ComboBox<Integer> hourField; 
	@FXML private ComboBox<Integer> durationField; 
	@FXML private ComboBox<String> feelingField; 
	@FXML private ComboBox<String> accomplishmentField; 
	@FXML private TextArea personalNoteField; 
	@FXML private Button createBtn;
	@FXML private Button cancelBtn;
	@FXML private Button resetBtn;
	
	
	
	
}
