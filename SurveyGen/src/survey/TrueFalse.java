package survey;

public class TrueFalse extends MultChoice implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3188832209316813721L;
	public final String[] choices = {"True", "False"};
	public String userAnswer;
	public String[] getChoices() {
		return this.choices;
	}
	
	public void setChoices() {
		if (test) {
			int i;
			Display.display("Please enter correct choice #: ");
			i = Response.getInt(0,3);
			this.corrAnswer = Integer.toString(i) + ") " + this.choices[i-1];
		}
	}
	
	public void take() {
		Display.display(getPrompt());
		Display.display(this.choices);
		promptForChoices();
	}
	
	protected void promptForChoices() {
		Display.display("Please enter correct choice #: ");
		setUserAnswer(Response.getInt(0, choices.length + 1));
	}
	
	protected void setUserAnswer(int i) {
		userAnswer = Integer.toString(i) + ") " + this.choices[i-1];
	}
}
