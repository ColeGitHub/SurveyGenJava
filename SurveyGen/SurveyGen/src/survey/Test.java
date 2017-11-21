package survey;

import java.util.ArrayList;

public class Test extends Survey implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6024950810548753834L;
	ArrayList<Question> questions = null;
	double earnedPoints;
	double grade;
	
	Test() {
		questions = new ArrayList<Question>();
	}
	
	public void grade() {
		double points = 100/questions.size();
		earnedPoints = 0;
		String output;
		Question q;
		for (int i = 0; i < questions.size(); i++) {
			q = questions.get(i);
			if (!(q instanceof Essay)) {
				if (q.getCorrAnswer().equals(q.getUserAnswer())) {
					earnedPoints += points;
				}
			}
		}
		grade = earnedPoints;
		output = Double.toString(earnedPoints) + "/100";
		Display.display(output);
	}
	
	protected void addMultChoice() {
		Question q = new MultChoice();
		q.setTest(true);
		setP(q);
		q.setChoices();
		questions.add(q);
	}
	
	protected void addTrueFalse() {
		Question q = new TrueFalse();
		q.setTest(true);
		setP(q);
		q.setChoices();
		questions.add(q);
	}
	
	protected void addShortAnswer() {
		ShortAnswer q = new ShortAnswer();
		setP(q);
		Display.display("Please enter character limit of answer");
		q.setLimit(Response.getInt(0));
		Display.display("Please enter correct answer");
		q.setCorrAnswer(Response.getString(q.getLimit()));
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
		q.setTest(true);
		q.setChoices();
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
