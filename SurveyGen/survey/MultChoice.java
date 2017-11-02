package survey;


public class MultChoice extends Question{
	
	protected String[] choices;
	
	protected void display() {
		
		System.out.println(prompt);
		displayChoices();
		
	}
	
	protected void displayChoices() {
		
		int choice;
		
		for (int i = 0; i < choices.length; i++) {
			choice = i+1;
			System.out.println(choice + ") " + choices[i]);
		}
	}
	
	protected void edit() {
		int choice;
		
		System.out.println("Choose which choice you would like to edit");
		displayChoices();
		System.out.print(">> ");
		
	}
}
