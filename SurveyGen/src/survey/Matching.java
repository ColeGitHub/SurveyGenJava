package survey;

public class Matching extends Question{
	public int choices, maxLength = 0;
	public String corrAnswer;
	public String[] column1;
	public String[] column2;
	public String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
			"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	
	protected void setChoices() {
		int numChoices;
		int choice;
		Display.display("Enter the number of choices for your question: ");
		numChoices = Response.getInt(0);
		column1 = new String[numChoices];
		column2 = new String[numChoices];
		
		Display.display("Choices for column 1: ");
		for (int i = 0; i < numChoices; i++) {
			choice = i + 1;
			Display.display("Please enter choice #" + choice);
			column1[i] = Response.getString();
			if (column1[i].length() > maxLength) {
				maxLength = column1[i].length();
			}
		}
		
		Display.display("Choices for column 2: ");
		for (int i = 0; i < numChoices; i++) {
			choice = i + 1;
			Display.display("Please enter choice " + letters[i]);
			column2[i] = Response.getString();
		}
		
		if (test) {
			Display.display("Please enter correct answer as string of letters with no spaces: ");
			boolean corr = true;
			while (corr) {
				corrAnswer = Response.getString();
				if (corrAnswer.length() != column1.length) {
					Display.display("Incorrect length, please try again");
				} else {
					corr = false;
				}
			}
		}
	}
	
	public void displayChoices() {
		String str;
		// To correctly format this output, spaces are appended to all choices shorter than the longest choice
		for (int i = 0; i < column1.length; i++) {
			while (column1[i].length() < maxLength) {
				column1[i] = column1[i] + " ";
			}
			str = "   " + Integer.toString(i + 1) + ") " + column1[i] + "   " + letters[i] + ") " + column2[i];
			Display.display(str);
		}
	}
	
	public String getCorrAnswer() {
		return corrAnswer;
	}
}
