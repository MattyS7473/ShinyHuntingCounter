package shinyHuntingCounter;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
//
// Created by: Matty Slyzys on December 5th, 2020
//
// This program is essentially a counter. When a user first starts this program,
// a GUI will prompt them to input some data about the Pokémon they are trying to 
// find, the odds of finding it and any shiny hunting methods they are using. 
// They can also imput a file about another shiny hunt they have saved.
//
// After this, a new GUI will open showing a counter and some information about the 
// hunt. At any point, the user can click a button to inciriment the counter (or 
// decrease if the user misclicked). Additionally, the user can also save their 
// progress to be upened up upon rerunning the program.
//
// This program also assumes each method is at its maximum possible odds
//
/////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////
//																					   //
//  This class governs the Input form for the Shiny Hunting Counter					   //
//																					   //
/////////////////////////////////////////////////////////////////////////////////////////
public class InputGUIController extends ShinyCounterController implements Initializable {
	
	Stage secondaryStage = new Stage();
	
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ShinyCounter.fxml"));
			Scene scene = new Scene(root, 400, 600);
			secondaryStage.setScene(scene);
			secondaryStage.getIcons().add(new Image("/ShinyHuntingIcon.png"));
			secondaryStage.setTitle("Setup");
			secondaryStage.setResizable(false);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		genComboBox.setItems(genList);
    	methodComboBox.setItems(methodList);
		
	}
	
    @FXML
    void newPressed(ActionEvent event) {
    	nameLabel.setText(nameInput.getText());
    	genLabel.setText(genComboBox.getValue().toString());
    	methodLabel.setText(methodComboBox.getValue().toString());
    	dateLabel.setText(dateStarted.getValue().toString());
    	
    	oddsLabel.setText(findOdds(genComboBox.getValue().toString(), methodComboBox.getValue().toString(), shinyCharmCheckbox.isSelected()));
    	
    	System.out.println(shinyCharmCheckbox.isSelected());
    	// close InputGUI and display the counter
    	Main.primaryStage.close();
    	secondaryStage.show();
    	
    }
    
    public String findOdds(String generation, String method, Boolean hasShinyCharm) {
		int odds = 8192;
		int rerolls = 1;

		
		switch (generation) {
		case "Generation 1":
			break;
		case "Generation 2":
			break;
		case "Generation 3":
			break;
		case "Generation 4":
			
			if (method.equals("Masuda Method")) {
				rerolls = 4;
			} else if (method.equals("PokeRadar")) {
				rerolls = 1;
				odds = 200;
			}
			break;
			
		case "Generation 5":
			
			if (method.equals("Masuda Method")) {
				rerolls = 5;
			}
			
			if (hasShinyCharm) {
				rerolls += 3;
			}
			
			break;
			
		case "Generation 6":
			
			odds = (int) odds / 2;
			
			if (method.equals("Masuda Method")) {
				rerolls = 5;
				if (hasShinyCharm) {
					rerolls += 3;
				}
			} else if (method.equals("PokeRadar")) {
				rerolls = 1;
				odds = 200;
			} else if (method.equals("DexNav")) {
				rerolls = 8;
			} else if (method.equals("Horde Encounter")) {
				rerolls = 5;
				if (hasShinyCharm) {
					rerolls += 3;
				}
			} else if (method.equals("Friend Safari")) {
				rerolls = 8;
			} else if (method.equals("Chain Fishing")) {
				rerolls = 41;
				if (hasShinyCharm) {
					rerolls += 3;
				}
			}
		
			break;
			
		case "Generation 7":
			
			odds = (int) odds / 2 ;
			
			if (method.equals("Masuda Method")) {
				rerolls = 5;
				if (hasShinyCharm) {
					rerolls += 3;
				}
			} else if (method.equals("S.O.S Chaining")) {
				rerolls = 13;
				if (hasShinyCharm) {
					rerolls += 3;
				}
			} else if (method.equals("Ultra Wormhole")) {
				rerolls = 1;
				odds = 4;
			}
			
			break;
			
		case "Generation 8":

			odds = (int) odds / 2;
			
			if (method.equals("Masuda Method")) {
				rerolls = 5;
				if (hasShinyCharm) {
					rerolls += 3;
				}
			} else if (method.equals("Catch Combo")) {
				rerolls = 12;
				if (hasShinyCharm) {
					rerolls += 3;
				}
			} else if (method.equals("K.O. Method")) {
				rerolls = 5;
				if (hasShinyCharm) {
					rerolls += 3;
				}
			} else if (method.equals("Dynamax Adventures")) {
				rerolls = 1;
				odds = 300;
				if (hasShinyCharm) {
					odds = 100;
				}
			}
			
			break;
		}
		System.out.println(rerolls);
		System.out.println(odds);
		return Integer.toString((int) odds / rerolls);
		
	}
    
    @FXML
    void load(ActionEvent event) {
    	String[] data;
    	data = SaveAndLoad.readFromFile();
    	
    	nameLabel.setText(data[0]);
    	genLabel.setText(data[1]);
    	methodLabel.setText(data[2]);
    	dateLabel.setText(data[3]);
    	
    	count.setText(data[4]);
    	oddsLabel.setText(data[5]);
    	
    	System.out.println(shinyCharmCheckbox.isSelected());
    	// close InputGUI and display the counter
    	Main.primaryStage.close();
    	secondaryStage.show();
    }

}
