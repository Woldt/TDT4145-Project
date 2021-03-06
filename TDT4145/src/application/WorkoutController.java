package application;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
		else if(Workout.HOUR_PROPERTY.equals(propertyName)){
			updateWorkoutHourView();
		}
		else if(Workout.MINUTE_PROPERTY.equals(propertyName)){
			updateWorkoutMinuteView();
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
	
	@FXML
	public void startHourChange(){
		updateStartHourModel();
	}

	@FXML
	public void startMinChange(){
		updateStartMinModel();
	}

	
// Model-updaters:
	private void updateWorkoutTitleModel(){
		this.workout.setWorkoutTitle(workoutField.getText());
	}

	private void updateDateModel() {
		this.workout.setDate(dateField.getValue());
	}
	
	private void updateStartHourModel(){
		this.workout.setWorkoutHour(hourField.getValue());
		
	}
	
	private void updateStartMinModel(){
		this.workout.setWorkoutMinute(minuteField.getValue());			
		
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
	
	private void updateWorkoutHourView(){
		hourField.setValue(workout.getWorkoutHour());
	}

	private void updateWorkoutMinuteView(){
		minuteField.setValue(workout.getWorkoutMinute());
	}

	
	
	
//Scene handler:
	@FXML
	private void createBtnClicked(){
		FXMLLoader fxmlLoader = new FXMLLoader();
		Parent scene;
		Boolean state = true;
		String message ="";
		try {
			//DO all the validations that needs to be done before new scene. if not already done.  Remember comboboxes default value is null
			/* Validate workoutType */
			if(typeField.getValue() == null){
				state = false;
				message += "Workout type not set\n";
			}
			else{
				this.workout.setWorkoutType(typeField.getValue());
			}
			
	/* Validate and set start date*/
			if(dateField.getValue() == null){
				state = false;
				message += "Workout date not set\n";
			}
			else {
				this.workout.setDate(dateField.getValue());
			}
	/* Validate and set start time (hour, min)*/
	/* Validate and set duration*/
			if(durationField.getValue() == null){
				state = false;
				message += "Workout duration not set\n";
			}
			else {
				this.workout.setDuration(durationField.getValue());
			}
	/* Validate and set peronalFitness*/
			if(fitnessField.getValue()== null){
				//do some logic shit here, so that the modell dosent get set without a value
				//don't let the button change scene before all values/ attributs are set!
				state = false;
				message += "Workout fitness not set\n";
			}
			else {
				this.workout.setPersonalFitness(fitnessField.getValue());
			}
	/* Validate and set accomplishment*/
			if(accomplishmentField.getValue()== null){
				state = false;
				message += "Workout accomplishment not set\n";
			}
			else {
				//update model, with view values. REMEMBER TO ADD pcs.firePropertyChange in workout, and handling that event here under pcs connection  
				this.workout.setWorkoutAccomplishment(accomplishmentField.getValue());
			}
	/* Validate and set personal note*/
			System.out.println("her er note:"+personalNoteField.getText());
			this.workout.setWorkoutNote(personalNoteField.getText());
			
	/*Make new scene, and then set the scene*/
			if(state){
				scene = (Parent) fxmlLoader.load(this.getClass().getResourceAsStream("ExercisesGUI.fxml"));
				String time = workout.getWorkoutHour() + ":" + workout.getWorkoutMinute();
					
//				System.out.println(Tabell.INSERT.TRENINGS�KT(workout.getWorkoutDate().toString(), time, workout.getWorkoutDurationTime(), workout.getPersonalFitness(), workout.getWorkoutAccomplishment(), workout.getWorkoutNote()));
				Database.insert(Tabell.INSERT.TRENINGS�KT(workout.getWorkoutDate().toString(), time, workout.getWorkoutDurationTime(), workout.getPersonalFitness(), workout.getWorkoutAccomplishment(), workout.getWorkoutNote()));
				Main.primaryStage.setScene(new Scene(scene));
			}
			else {
				message += "These needs to set, before new workout is valid";
				Alertbox.display(message);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML private TableView<List<String>> workoutList;
	
	@FXML
	private void loadWorkouts(Event event) {
		if (((Tab) event.getTarget()).isSelected()) {
			workoutList.getSelectionModel().selectedItemProperty().removeListener(showOvelser);
			workoutList.getColumns().clear();
			workoutList.getItems().clear();
			ArrayList<String> result = Database.select(Tabell.SELECT.TRENINGS�KT());
			if (result.size() > 0) {
				String[] firstSplit = result.get(0).split(",");
				for (int i = 0; i < result.get(0).split(",").length; i ++) {
					final String kolonneNavn = firstSplit[i].split(";")[0];
					TableColumn<List<String>,String> kolonne = new TableColumn<>(kolonneNavn);
					final int colIndex = i;
					kolonne.setCellValueFactory(data -> {
		                List<String> rowValues = data.getValue();
		                String cellValue ;
		                if (colIndex < rowValues.size()) {
		                    cellValue = rowValues.get(colIndex);
		                } else {
		                     cellValue = "" ;
		                }
		                return new ReadOnlyStringWrapper(cellValue);
		            });
					workoutList.getColumns().add(kolonne);
				}
				for (String row : result) {
					String[] split = row.split(",");
					ArrayList<String> verdier = new ArrayList<String>();
					for (int i = 0; i < split.length; i ++) {
						verdier.add(split[i].split(";")[1]);
					}
					workoutList.getItems().add(verdier);
				}
			}
			workoutList.getSelectionModel().selectedItemProperty().addListener(showOvelser);
		}
	}
	
	private ChangeListener<List<String>> showOvelser = new ChangeListener<List<String>>() {

		@Override
		public void changed(ObservableValue<? extends List<String>> observable, List<String> oldValue, List<String> newValue) {
			
			BorderPane root = new BorderPane();
			
			
			VBox iBox = new VBox(10);
			VBox uBox = new VBox(10);
			
			
			String query1 = "SELECT �velse.*,"
							+ " Innend�rs�velse.Luftventilasjon, Innend�rs�velse.AntallTilskuere"
							+ ", Utholdenhet.LengdeKM, Utholdenhet.Minutter"
							+ " FROM �velse INNER JOIN Best�rAv ON �velse.�velsesID = Best�rAv.�velsesID AND Best�rAv.TreningsID = " + newValue.get(0)
							+ " INNER JOIN Innend�rs�velse ON �velse.�velsesID = Innend�rs�velse.�velsesID"
							+ " INNER JOIN Utholdenhet ON �velse.�velsesID = Utholdenhet.�velsesID"
							;
			
			String query2 = "SELECT �velse.*,"
							+ " Innend�rs�velse.Luftventilasjon, Innend�rs�velse.AntallTilskuere"
							+ ", StyrkeOgKondisjon.Belastning, StyrkeOgKondisjon.AntallRepetisjoner, StyrkeOgKondisjon.AntallSett"
							+ " FROM �velse INNER JOIN Best�rAv ON �velse.�velsesID = Best�rAv.�velsesID AND Best�rAv.TreningsID = " + newValue.get(0)
							+ " INNER JOIN Innend�rs�velse ON �velse.�velsesID = Innend�rs�velse.�velsesID"
							+ " INNER JOIN StyrkeOgKondisjon ON �velse.�velsesID = StyrkeOgKondisjon.�velsesID"
							;
			
			String query3 = "SELECT �velse.*,"
							+ " Utend�rs�velse.Temperatur, Utend�rs�velse.V�rtype"
							+ ", Utholdenhet.LengdeKM, Utholdenhet.Minutter"
							+ " FROM �velse INNER JOIN Best�rAv ON �velse.�velsesID = Best�rAv.�velsesID AND Best�rAv.TreningsID = " + newValue.get(0)
							+ " INNER JOIN Utend�rs�velse ON �velse.�velsesID = Utend�rs�velse.�velsesID"
							+ " INNER JOIN Utholdenhet ON �velse.�velsesID = Utholdenhet.�velsesID"
							+ " GROUP BY �velse.�velsesID"
							;
			
			String query4 = "SELECT �velse.*,"
							+ " Utend�rs�velse.Temperatur, Utend�rs�velse.V�rtype"
							+ ", StyrkeOgKondisjon.Belastning, StyrkeOgKondisjon.AntallRepetisjoner, StyrkeOgKondisjon.AntallSett"
							+ " FROM �velse INNER JOIN Best�rAv ON �velse.�velsesID = Best�rAv.�velsesID AND Best�rAv.TreningsID = " + newValue.get(0)
							+ " INNER JOIN Utend�rs�velse ON �velse.�velsesID = Utend�rs�velse.�velsesID"
							+ " INNER JOIN StyrkeOgKondisjon ON �velse.�velsesID = StyrkeOgKondisjon.�velsesID"
							;
			
			TableView<List<String>> q1 = createView(Database.select(query1));
			TableView<List<String>> q2 = createView(Database.select(query2));
			TableView<List<String>> q3 = createView(Database.select(query3));
			TableView<List<String>> q4 = createView(Database.select(query4));
			
			if (q1 != null) {
				root.setTop(new Label("Innend�rs�velser"));
				iBox.getChildren().addAll(new Label("Utholdenhet"), q1);
			}
			if (q2 != null) {
				root.setTop(new Label("Innend�rs�velser"));
				iBox.getChildren().addAll(new Label("Styrke og kondisjon"), q2);
			}
			if (q3 != null) {
				root.setTop(new Label("Utend�rs�velser"));
				iBox.getChildren().addAll(new Label("Utholdenhet"), q3);
			}
			if (q4 != null) {
				root.setTop(new Label("Utend�rs�velser"));
				iBox.getChildren().addAll(new Label("Styrke og kondisjon"), q4);
			}
			
			if (q1 == null && q2 == null && q3 == null && q4 == null) {
				root.setCenter(new Label("Denne trenings�kten inneholder ingen �velser"));
				BorderPane.setAlignment(root.getCenter(), Pos.CENTER);
				root.getCenter().setStyle("-fx-font-weight: bold");
				root.setMinHeight(200);
				root.setMinWidth(400);
			}
			else {				
				root.setCenter(iBox);
			}
			
			if (root.getTop() != null) {				
				BorderPane.setAlignment(root.getTop(), Pos.CENTER);
				root.getTop().setStyle("-fx-font-weight: bold");
			}
			
			
			
			Stage resultStage = new Stage();
			Scene resultScene = new Scene(root);
			resultStage.setTitle("�vinger i treningen");
			resultStage.setScene(resultScene);
			resultStage.show();
			
			resultStage.focusedProperty().addListener((e1, e2, e3) -> {
				resultStage.close();
			}); 
		}
	};
	
	private TableView<List<String>> createView(List<String> values) {
		
		if (values.size() == 0) {
			return null;
		}
		
		TableView<List<String>> root = new TableView<List<String>>();
		
		String[] firstSplit = values.get(0).split(",");
		for (int i = 0; i < values.get(0).split(",").length; i ++) {
			
			final String kolonneNavn = firstSplit[i].split(";")[0];
			TableColumn<List<String>,String> kolonne = new TableColumn<>(kolonneNavn);
			final int colIndex = i;
			
			kolonne.setMinWidth(120);
			kolonne.setMaxWidth(120);
			
			kolonne.setCellValueFactory(data -> {
                List<String> rowValues = data.getValue();
                String cellValue;
                if (colIndex < rowValues.size()) {
                    cellValue = rowValues.get(colIndex);
                }
                else {
                     cellValue = "" ;
                }
                return new ReadOnlyStringWrapper(cellValue);
            });
			root.getColumns().add(kolonne);
		}
		for (String row : values) {
			String[] split = row.split(",");
			ArrayList<String> verdier = new ArrayList<String>();
			for (int i = 0; i < split.length; i ++) {
				verdier.add(split[i].split(";")[1]);
			}
			root.getItems().add(verdier);
		}
		return root;
	}
}
