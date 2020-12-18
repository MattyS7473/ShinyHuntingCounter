package shinyHuntingCounter;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/////////////////////////////////////////////////////////////////////////////////////////
//
//  Created by: Matty Slyzys on December 5th, 2020
//
//  This program is essentially a counter. When a user first starts this program,
//  a GUI will prompt them to input some data about the Pokémon they are trying to 
//  find, the odds of finding it and any shiny hunting methods they are using. 
//  They can also imput a file about another shiny hunt they have saved.
//
//  After this, a new GUI will open showing a counter and some information about the 
//  hunt. At any point, the user can click a button to inciriment the counter (or 
//  decrease if the user misclicked). Additionally, the user can also save their 
//  progress to be upened up upon rerunning the program.
//
/////////////////////////////////////////////////////////////////////////////////////////

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("InputGUI.fxml"));
			Scene scene = new Scene(root,400,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.getIcons().add(new Image("/ShinyHuntingIcon.png"));
			primaryStage.setTitle("Setup");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
