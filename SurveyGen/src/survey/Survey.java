package survey;

import java.util.ArrayList;


public class Survey implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<Question> questions = = null;
		
	Survey() {
	    questions = new ArrayList<Question>();
	}
	
	protected void setP(Question q) {
		Display.display("Please enter question prompt");
		q.setPrompt(Response.getString());
	}
	
	protected void addMultChoice() {
		Question q = new MultChoice();
		setP(q);
		q.setChoices();
		questions.add(q);
	}
	
	protected void addTrueFalse() {
		TrueFalse q = new TrueFalse();
		setP(q);
		questions.add(q);
	}
	
	protected void addShortAnswer() {
		ShortAnswer q = new ShortAnswer();
		setP(q);
		Display.display("Please enter character limit of answer");
		q.setLimit(Response.getInt(0));
		questions.add(q);
	}
	
	protected void addEssay() {
		Essay q = new Essay();
		setP(q);
		questions.add(q);
	}
	
	protected void addRanking() {
		Ranking q = new Ranking();
		setP(q);
		q.setChoices();
		questions.add(q);
	}
	
	protected void addMatching() {
		Matching q = new Matching();
		setP(q);
		q.setChoices();
		questions.add(q);
	}
	
	protected void clearQuestions() {
		questions.clear();
	}
}
