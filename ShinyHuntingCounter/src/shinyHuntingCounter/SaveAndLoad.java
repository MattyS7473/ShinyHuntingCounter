package shinyHuntingCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

public class SaveAndLoad {
	
	public static void writeToFile(String name, String generation, String method, String date, String count, String odds) {
		try {
			FileWriter save = new FileWriter("saves/" + name + " - " + date + ".txt");
			
			save.write(name + '\n');
			save.write(generation + '\n');
			save.write(method + '\n');
			save.write(date + '\n');
			save.write('\n' + count);
			save.write('\n' + odds);
			
			save.close();
			
			Alert alert = new Alert(AlertType.INFORMATION, "File saved");
    		alert.showAndWait();
			
		} catch(IOException e) {
			System.out.println("An error occurred.");
      	   	e.printStackTrace();	
		}
	}
	
	public static String[] readFromFile() {
		
		String[] textData = new String[6];
		
		Scanner read = null;
		
		try {
			read = new Scanner(selectFile());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		textData[0] = read.nextLine();
		textData[1] = read.nextLine();
		textData[2] = read.nextLine();
		textData[3] = read.nextLine();
		
		read.nextLine();
		
		textData[4] = read.nextLine();
		textData[5] = read.nextLine();
		
		return textData;
	}
	
	public static File selectFile() {
		FileChooser fc = new FileChooser();	
		fc.setInitialDirectory(new File(System.getProperty("user.home")));
		
		File selectedFile = fc.showOpenDialog(null);
		if (selectedFile != null) {
			return selectedFile;
		} else {
			return null;
		}
			
	}
	
}
