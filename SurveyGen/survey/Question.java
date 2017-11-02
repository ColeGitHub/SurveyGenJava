package survey;

public abstract class Question {
	// Abstract Question class, will give methods to create and 
	// display prompts
	
	protected String prompt;
	
	protected void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	
	protected String getPrompt() {
		return prompt;
	}
	
	protected void display() {
		System.out.println(prompt);
	}
}
