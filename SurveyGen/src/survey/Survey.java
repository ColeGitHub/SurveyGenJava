package survey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Survey implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<Question> questions = null;
	String[] answers;
	String filePath;
	
	Survey() {
		questions = new ArrayList<Question>();
	}
	
	public void modify() {
		boolean modifying = true;
		int question = 0;
		while (modifying) {
			Display.display("Please enter question number to modify or enter 0 to exit: ");
			question = Response.getInt(0, this.questions.size());
			if (question == 0) {
				modifying = false;
			} else {
				Modify.modify(this.questions.get(question), false);
			}
		}
	}
	
	public void take() {
		Serialize ser = new Serialize();
		answers = new String[this.questions.size()];
		for (int i = 0; i < this.questions.size(); i++) {
			this.questions.get(i).take();
			this.answers[i] = this.questions.get(i).userAnswer;
		}
		ser.saveAnswers(answers, filePath);
	}
	
	public void tabulate() throws ClassNotFoundException, IOException {
		String[][] answersArr = Serialize.loadAnswers(filePath);
		for (int i = 0; i < questions.size(); i++) {
			Display.display(questions.get(i), false);
			Display.display("Replies: ");
			for (int j = 0; j < answersArr.length; j++) {
				Display.display(answersArr[j][i]);
			}
			Display.display("Tabulate:");
			countAnswer(answersArr, i);
		}
	}
	
	protected void countAnswer(String[][] answers, int index) {
		HashMap<String, Integer> answerCount = new HashMap<String, Integer>();
		
		for (int i = 0; i < answers.length; i++) {
			String item = answers[index][i];
			if (answerCount.containsKey(item)) {
				answerCount.put(item, answerCount.get(item) + 1);
			} else {
				answerCount.put(item, 1);
			}
		}
		
		for (Map.Entry<String, Integer> counts : answerCount.entrySet()) {
			System.out.println(counts.getKey() + ": " + counts.getValue());
		}
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
		Question q = new TrueFalse();
		setP(q);
		questions.add(q);
	}
	
	protected void addShortAnswer() {
		Question q = new ShortAnswer();
		setP(q);
		Display.display("Please enter character limit of answer");
		q.setLimit(Response.getInt(0));
		questions.add(q);
	}
	
	protected void addEssay() {
		Question q = new Essay();
		setP(q);
		questions.add(q);
	}
	
	protected void addRanking() {
		Question q = new Ranking();
		setP(q);
		q.setChoices();
		questions.add(q);
	}
	
	protected void addMatching() {
		Question q = new Matching();
		setP(q);
		q.setChoices();
		questions.add(q);
	}
	
	protected void clearQuestions() {
		questions.clear();
	}
}
