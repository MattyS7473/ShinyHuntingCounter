package shinyHuntingCounter;


import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/////////////////////////////////////////////////////////////////////////////////////////
//																					   //
//  This class governs the Input form for the Shiny Hunting Counter					   //
//																					   //
/////////////////////////////////////////////////////////////////////////////////////////
public class InputGUIController {
	
	ShinyCounterController scc = new ShinyCounterController();
	
	// List items for the ComboBoxes
	ObservableList<String> genList = FXCollections.observableArrayList(
			"Generation 1",
			"Generation 2",
			"Generation 3",
			"Generation 4",
			"Generation 5",
			"Generation 6",
			"Generation 7",
			"Generation 8");
	
	ObservableList<String> methodList = FXCollections.observableArrayList(
			"Random Encounter",
			"Soft resetting",
			"Masuda Method",
			"PokeRadar",
			"Horde Encounter",
			"Friend Safari",
			"Chain Fishing",
			"DexNav",
			"S.O.S Chaining",
			"Ultra Wormhole",
			"Catch Combo",
			"K.O. Method",
			"Dynamax Adventures");
	
	// Variables for each element
    @FXML private TextField nameInput;
    @FXML private ChoiceBox genComboBox;
    @FXML  private ChoiceBox methodComboBox;
    @FXML  private DatePicker dateStarted;
    @FXML  private CheckBox shinyCharmCheckbox;
    @FXML  private Button loadButton;
    @FXML  private Button newButton;
    
    // This method sets up the comboBoxes for the generation and the method fields
    @FXML private void initialize() {
    	genComboBox.setItems(genList);
    	methodComboBox.setItems(methodList);
    }

    @FXML void newPressed(ActionEvent event) {
    	// Save the data the the user has inputted and replace the scene
    	try {
    		
    		scc.setName(nameInput.getText());
    		scc.setGeneration((String) genComboBox.getValue());
    		scc.setMethod((String) methodComboBox.getValue());
    		scc.setDate(dateStarted.getValue().toString());
    		scc.setHasShinyCharm(shinyCharmCheckbox.isSelected());
    		
    		switchScene(event);

    	} catch (Exception e) {
    		// Prevents the user from continuing if they have not added all the entries required
    		Alert alert = new Alert(AlertType.ERROR, "Please make sure all fields are entered");
    		alert.showAndWait();
    	}
    	
    	
	}
    
    // This method switches the scene to the one in ShinyCounter.fxml
    // After this method calls, everything else will be handled by the ShinyCounterController class
    private void switchScene(ActionEvent event) {
    	try {
			Parent counterParent = FXMLLoader.load(getClass().getResource("ShinyCounter.fxml"));
			Scene counterScene = new Scene(counterParent);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(counterScene);
			window.setTitle("Shiny Counter");
			window.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

}
