package survey;

public class ShortAnswer extends Essay{
	private int limit;
	public boolean test;
	private String corrAnswer;
	
	ShortAnswer() {
		
	}
	
	ShortAnswer(int limit) {
		this.limit = limit;
	}
	
	public int getLimit() {
		return limit;
	}
	
	public void setLimit(int i) {
		this.limit = i;
	}
	
	public void setCorrAnswer(String str) {
		this.corrAnswer = str;
	}
	
	public String getCorrAnswer() {
		return corrAnswer;
	}
}
