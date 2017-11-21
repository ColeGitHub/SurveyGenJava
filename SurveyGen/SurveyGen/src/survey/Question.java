package survey;


public abstract class Question implements java.io.Serializable {
	// Abstract Question class, will give methods to create and edit prompts
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1584251193249090786L;
	protected String prompt, corrAnswer, userAnswer;
	protected String[] choices;
	protected boolean test = false;
	
	protected abstract void setChoices();
	public abstract void take();
	
	protected void setLimit(int i) {
		
	}
	
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
	
	public String getUserAnswer() {
		return this.userAnswer;
	}
	
}
