package survey;

public class ShortAnswer extends Essay implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2083384745310505416L;
	private int limit;
	public boolean test;
	
	ShortAnswer() {
		
	}
	
	ShortAnswer(int limit) {
		this.limit = limit;
	}
	
	public void take() {
		Display.display(getPrompt());
		userAnswer = Response.getString(getLimit());
	}
	
	public int getLimit() {
		return limit;
	}
	
	public void setLimit(int i) {
		this.limit = i;
	}
	
	public void setCorrAnswer(String str) {
		corrAnswer = str;
	}
	
	public String getCorrAnswer() {
		return corrAnswer;
	}
}
