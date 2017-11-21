package survey;


public class MultChoice extends Question implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7740064314304946839L;
	protected String[] choices;
	protected boolean test = false, multAnswers;
	protected int[] corrAnswerNum;
	protected String corrAnswer, userAnswer;
	
	MultChoice() {
		
	}
	
	protected void setChoices() {
		int numChoices, choice;
		String yesNo;
		boolean yn = true;
		
		Display.display("Enter the number of choices for your question: ");
		numChoices = Response.getInt(0);
		choices = new String[numChoices];
		
		Display.display("Does this question have multiple answers? (Y/n)");
		while (yn) {
			yesNo = Response.getString().toUpperCase();
			if (yesNo.equals("Y")) { 
				multAnswers = true; 
				corrAnswerNum = new int[numChoices];
				yn = false;
			} else if (yesNo.equals("N")) { 
				multAnswers = false; 
				yn = false;
			} else {
				Display.display("Please enter 'Y' for yes or 'N' for no");
			}
		}
		
		for (int i = 0; i < numChoices; i++) {
			choice = i + 1;
			Display.display("Please enter choice #" + choice);
			choices[i] = Response.getString();
		}
		
		if (test) {
			promptForChoices(true);
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
	
	protected void promptForChoices(boolean corr) {
		if (!multAnswers) {
			Display.display("Please enter correct choice #: ");
			if (corr) {setAnswer(Response.getInt(0, choices.length + 1));}
			else {setUserAnswer(Response.getInt(0, choices.length + 1));}
		} else {
			Display.display("Enter correct choices when prompted, or enter '0' when you're finished" );
			for (int i = 0; i < corrAnswerNum.length; i++) {
				Display.display("Please enter correct choice #: ");
				corrAnswerNum[i] = Response.getInt(0, corrAnswerNum.length);
				if (corrAnswerNum[i] == 0) {
					break;
				}
			}
			if (corr) {setAnswer(corrAnswerNum);;}
			else {setUserAnswer(corrAnswerNum);}
		}
	}
	
	public void take() {
		Display.display(getPrompt());
		Display.display(choices);
		promptForChoices(false);
	}
	
	protected void setTest(boolean test) {
		this.test = test;
	}
	
	protected void setAnswer(int i) {
		corrAnswer = Integer.toString(i) + ") " + choices[i-1];
	}
	
	protected void setAnswer(int[] arr) {
		corrAnswer = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				break;
			}
			corrAnswer = corrAnswer + Integer.toString(arr[i]) + ") " + choices[arr[i]-1] + "\n";
		}
	}
	
	protected void setUserAnswer(int i) {
		userAnswer = Integer.toString(i) + ") " + this.choices[i-1];
	}
	
	protected void setUserAnswer(int[] arr) {
		userAnswer = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				break;
			}
			userAnswer = userAnswer + Integer.toString(arr[i]) + ") " + choices[arr[i]-1] + "\n";
		}
	}
	
	
	
	public String[] getChoices() {
		return choices;
	}
	
	public String getCorrAnswer() {
		return corrAnswer;
	}

}
