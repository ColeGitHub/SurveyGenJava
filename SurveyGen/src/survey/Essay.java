package survey;

public class Essay extends Question implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6907366463503233537L;
	String userAnswer;
	
	public void take() {
		Display.display(getPrompt());
		userAnswer = Response.getString();
	}

	@Override
	protected void setChoices() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void setLimit(int i) {
		// TODO Auto-generated method stub
	}

}
