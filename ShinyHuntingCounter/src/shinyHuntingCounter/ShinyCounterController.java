package shinyHuntingCounter;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ShinyCounterController implements Initializable {
	
	@FXML private Label pkmnName;
    @FXML private TextField shinyCount;
    @FXML private Label shinyOdds;
    @FXML private Label generationNum;
    @FXML private Label huntingMethod;
    @FXML private Label startDate;
    @FXML private Button saveButton;
    
    protected static Label nameLabel;
    protected static Label genLabel;
    protected static Label methodLabel;
    protected static Label dateLabel;
    protected static Label oddsLabel;
    protected static TextField count;
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		nameLabel = pkmnName;
		genLabel = generationNum;
		methodLabel = huntingMethod;
		dateLabel = startDate;
		oddsLabel = shinyOdds;
		count = shinyCount;
		
	}
	
    @FXML
    void addOne(ActionEvent event) {
    	int count = Integer.parseInt(shinyCount.getText());
    	count++;
    	shinyCount.setText(String.valueOf(count));
    }

    @FXML
    void subtractOne(ActionEvent event) {
    	int count = Integer.parseInt(shinyCount.getText());
    	count--;
    	shinyCount.setText(String.valueOf(count));
    }

    @FXML
    void save(ActionEvent event) {
    	SaveAndLoad.writeToFile(pkmnName.getText(), generationNum.getText(), huntingMethod.getText(), 
    			startDate.getText(), shinyCount.getText(), shinyOdds.getText());
    	
    }

}
