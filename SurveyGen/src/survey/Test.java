package survey;

import java.util.ArrayList;

public class Test extends Survey{
	ArrayList<Question> questions = new ArrayList<Question>();
	
	Test() {
	
	}
	
	protected void addMultChoice() {
		MultChoice q = new MultChoice();
		q.setTest(true);
		setP(q);
		q.setChoices();
		questions.add(q);
	}
	
	protected void addTrueFalse() {
		TrueFalse q = new TrueFalse();
		q.setTest(true);
		setP(q);
		questions.add(q);
	}
	
	protected void addShortAnswer() {
		ShortAnswer q = new ShortAnswer();
		setP(q);
		Display.display("Please enter character limit of answer");
		q.setLimit(Response.getInt(0));
		Display.display("Please enter correct answer");
		q.setCorrAnswer(Response.getString(true, q.getLimit()));
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
		Display.display("Please enter correct answer");
		q.setCorrAnswer(Response.getString(true, q.column1.length));
		questions.add(q);
	}
	
	protected void addMatching() {
		Matching q = new Matching();
		setP(q);
		q.setTest(true);
		q.setChoices();
		questions.add(q);
	}
}
