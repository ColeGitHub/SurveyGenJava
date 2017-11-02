package survey;

public class Ranking extends Matching{
	public String[] choices;
	public String corrAnswer;
	
	protected void setChoices() {
		int numChoices;
		int choice;
		Display.display("Enter the number of choices for your question: ");
		numChoices = Response.getInt(0);
		choices = new String[numChoices];
		
		for (int i = 0; i < numChoices; i++) {
			choice = i + 1;
			Display.display("Please enter choice #" + choice);
			choices[i] = Response.getString();
		}
		
		if (test) {
			Display.display("Please enter correct answer: ");
			corrAnswer = Response.getString();
		}
	}
	
	protected void edit() {
		int choice;
		Display.display("Choose which choice you would like to edit");
		Display.display(choices);
		choice = Response.getInt(0) - 1;
		Display.display("Please enter new text for choice");
		choices[choice] = Response.getString();
	}
	
	protected void setTest(boolean test) {
		this.test = test;
	}
	
	protected void setCorrAnswer(String str) {
		this.corrAnswer = str;
	}
	
	public String[] getChoices() {
		return choices;
	}
}
