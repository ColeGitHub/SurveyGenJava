package survey;


public abstract class Question {
	// Abstract Question class, will give methods to create and edit prompts
	
	protected String prompt, corrAnswer;
	protected String[] choices;
	protected boolean test = false;
	
	protected void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	
	protected String getPrompt() {
		return prompt;
	}
	
	protected void setTest(boolean test) {
		this.test = test;
	}
	
	public String[] getChoices() {
		return choices;
	}
	
	public String getCorrAnswer() {
		return corrAnswer;
	}
	
}
