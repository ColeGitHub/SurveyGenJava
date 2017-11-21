package survey;

public class Modify {
	
	public static void modify(Question q, boolean test) {
		modify(q, test);
	}
	
	public static void modify(Ranking q, boolean test) {
		int choice;
		Display.display("Do you wish to modify the prompt? ");
		if (Response.getYesNo()) {
			Display.display("Current prompt: " + q.getPrompt());
			Display.display("Enter new prompt: ");
			q.setPrompt(Response.getString());
		}
		
		Display.display("Do you wish to modify the choices? ");
		if (Response.getYesNo()) {
			Display.display(q.choices);
			Display.display("Enter choice to modify: ");
			choice = Response.getInt(1, q.choices.length);
			Display.display("Enter new choice string: ");
			q.choices[choice] = Response.getString();
		}
		
		if (test) {
			Display.display("Do you wish to modify the correct answer? ");
			if (Response.getYesNo()) {
				Display.display(q.corrAnswer);
				Display.display("Enter new answer: ");
				q.promptForChoices();
				q.setCorrAnswer();
			}
		}
	}
	
	public void modify(Matching q, boolean test) {
		int choice, column;
		Display.display("Do you wish to modify the prompt? ");
		if (Response.getYesNo()) {
			Display.display("Current prompt: " + q.getPrompt());
			Display.display("Enter new prompt: ");
			q.setPrompt(Response.getString());
		}
		
		Display.display("Do you wish to modify the choices? ");
		if (Response.getYesNo()) {
			q.displayChoices();
			Display.display("Enter column to modify: ");
			column = Response.getInt(0,3);
			if (column == 1) {
				Display.display("Enter choice to modify: ");
				choice = Response.getInt(1, q.column1.length);
				Display.display("Enter new choice string: ");
				q.column1[choice] = Response.getString();
			} else {
				Display.display("Enter choice to modify: ");
				choice = Response.getInt(1, q.column1.length);
				Display.display("Enter new choice string: ");
				q.column2[choice] = Response.getString();
			}
		}
		
		if (test) {
			Display.display("Do you wish to modify the correct answer? ");
			if (Response.getYesNo()) {
				Display.display(q.corrAnswer);
				Display.display("Enter new answer: ");
				q.promptForChoices();
				q.setCorrAnswer();
			}
		}
	}
	
	public void modify(TrueFalse q, boolean test) {
		Display.display("Do you wish to modify the prompt? ");
		if (Response.getYesNo()) {
			Display.display("Current prompt: " + q.getPrompt());
			Display.display("Enter new prompt: ");
			q.setPrompt(Response.getString());
		}
		
		if (test) {
			Display.display("Do you wish to modify the correct answer? ");
			if (Response.getYesNo()) {
				Display.display(q.corrAnswer);
				Display.display("Enter new answer (1 for True, 2 for False): ");
				q.setAnswer(Response.getInt(0, 3));
			}
		}
	}
	
	public void modify(Essay q, boolean test) {
		Display.display("Do you wish to modify the prompt? ");
		if (Response.getYesNo()) {
			Display.display("Current prompt: " + q.getPrompt());
			Display.display("Enter new prompt: ");
			q.setPrompt(Response.getString());
		}
	}
	
	public void modify(MultChoice q, boolean test) {
		int choice;
		Display.display("Do you wish to modify the prompt? ");
		if (Response.getYesNo()) {
			Display.display("Current prompt: " + q.getPrompt());
			Display.display("Enter new prompt: ");
			q.setPrompt(Response.getString());
		}
		
		Display.display("Do you wish to modify the choices? ");
		if (Response.getYesNo()) {
			Display.display(q.choices);
			Display.display("Enter choice to modify: ");
			choice = Response.getInt(1, q.choices.length);
			Display.display("Enter new choice string: ");
			q.choices[choice] = Response.getString();
		}
		
		if (test) {
			Display.display("Do you wish to modify the correct answer? ");
			if (Response.getYesNo()) {
				Display.display(q.corrAnswer);
				Display.display("Enter new answer: ");
				q.promptForChoices(true);
				q.setAnswer(q.corrAnswerNum);
			}
		}
	}
	
	public void modify(ShortAnswer q, boolean test) {
		Display.display("Do you wish to modify the prompt? ");
		if (Response.getYesNo()) {
			Display.display("Current prompt: " + q.getPrompt());
			Display.display("Enter new prompt: ");
			q.setPrompt(Response.getString());
		}
		
		if (test) {
			Display.display("Do you wish to modify the correct answer? ");
			if (Response.getYesNo()) {
				Display.display(q.corrAnswer);
				Display.display("Enter new answer: ");
				q.setCorrAnswer(Response.getString(q.getLimit()));
			}
		}
	}
	
}
