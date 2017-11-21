package survey;

public class Ranking extends Matching implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2950383555074666747L;
	public String[] choices;
	public String corrAnswer, userAnswer;
	public int[] corrAnswerNum;
	
	protected void setChoices() {
		int numChoices;
		int choice;
		Display.display("Enter the number of choices for your question: ");
		numChoices = Response.getInt(0);
		choices = new String[numChoices];
		corrAnswerNum = new int[numChoices];
		
		for (int i = 0; i < numChoices; i++) {
			choice = i + 1;
			Display.display("Please enter choice #" + choice);
			choices[i] = Response.getString();
		}
		
		if (test) {
			promptForChoices();
			setCorrAnswer();
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
	
	protected void promptForChoices() {
		int choiceNum = choices.length;
		Display.display("Enter correct rankings when prompted" );
		for (int i = 0; i < choiceNum; i++) {
			Display.display("Please enter rank " + (i+1) + ": ");
			corrAnswerNum[i] = Response.getInt(0, corrAnswerNum.length);
		}
	}
	
	public void take() {
		Display.display(getPrompt());
		Display.display(choices);
		promptForChoices();
		setUserAnswer();
	}
	
	protected void setTest(boolean test) {
		this.test = test;
	}
	
	public void setCorrAnswer() {
		corrAnswer = "";
		for (int i = 0; i < corrAnswerNum.length; i++) {
			corrAnswer = corrAnswer + Integer.toString(corrAnswerNum[i]) + ") " + choices[corrAnswerNum[i] - 1] + "\n";
		}
	}
	
	public void setUserAnswer() {
		userAnswer = "";
		for (int i = 0; i < corrAnswerNum.length; i++) {
			userAnswer = userAnswer + Integer.toString(corrAnswerNum[i]) + ") " + choices[corrAnswerNum[i] - 1] + "\n";
		}
	}
	
	public String[] getChoices() {
		return choices;
	}
	
	public String getCorrAnswer() {
		return corrAnswer;
	}
}
