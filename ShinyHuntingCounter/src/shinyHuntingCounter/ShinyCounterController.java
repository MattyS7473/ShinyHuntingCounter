package shinyHuntingCounter;


public class ShinyCounterController {
	
	private String name;
	private String generation;
	private String method;
	private String date;
	private Boolean hasShinyCharm;
	
	// Setters
	public void setName(String newName) {
		name = newName;
	}
	
	public void setGeneration(String newGeneration) {
		generation = newGeneration;
	}
	
	public void setMethod(String newMethod) {
		method = newMethod;
	}
	
	public void setDate(String newDate) {
		date = newDate;
	}
	
	public void setHasShinyCharm(Boolean newValue) {
		hasShinyCharm = newValue;
	}
}
