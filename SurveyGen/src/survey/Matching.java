package survey;

public class Matching extends Question implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7964985668734173630L;
	public int choices, maxLength = 0;
	public String corrAnswer, userAnswer;
	public String[] corrAnswerLetter;
	public String[] column1;
	public String[] column2;
	public String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
			"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	
	protected void setChoices() {
		int choice;
		Display.display("Enter the number of choices for your question: ");
		choices = Response.getInt(0);
		column1 = new String[choices];
		column2 = new String[choices];
		corrAnswerLetter = new String[choices];
		
		Display.display("Choices for column 1: ");
		for (int i = 0; i < choices; i++) {
			choice = i + 1;
			Display.display("Please enter choice #" + choice);
			column1[i] = Response.getString();
			if (column1[i].length() > maxLength) {
				maxLength = column1[i].length();
			}
		}
		
		Display.display("Choices for column 2: ");
		for (int i = 0; i < choices; i++) {
			choice = i + 1;
			Display.display("Please enter choice " + letters[i]);
			column2[i] = Response.getString();
		}
		
		if (test) {
			promptForChoices();
			setCorrAnswer();
		}
	}
	
	protected void promptForChoices() {
		int choiceNum = column1.length;
		Display.display("Enter correct matchings when prompted" );
		for (int i = 0; i < choiceNum; i++) {
			Display.display((i+1) + ") ");
			corrAnswerLetter[i] = Response.getString(1);
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
	
	public void setCorrAnswer() {
		corrAnswer = "";
		for (int i = 0; i < corrAnswerLetter.length; i++) {
			corrAnswer = corrAnswer + (i + 1) + ") " + corrAnswerLetter[i] + "\n";
		}
	}
	
	public void setUserAnswer() {
		userAnswer = "";
		for (int i = 0; i < corrAnswerLetter.length; i++) {
			corrAnswer = corrAnswer + (i + 1) + ") " + corrAnswerLetter[i] + "\n";
		}
	}
	
	public void take() {
		Display.display(getPrompt());
		displayChoices();
		promptForChoices();
		setUserAnswer();
	}
	
	@Override
	protected void setLimit(int i) {
		// TODO Auto-generated method stub
	}
}
