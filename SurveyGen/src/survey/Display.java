package survey;

public class Display implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4016180440547007759L;

	// The display class uses overloading to pass strings, string arrays, and questions to different display functions of the same name
	public static void display(String str) {
		System.out.println(str);
	}
	
	public static void display(String[] str) {
		int choice;
		for (int i = 0; i < str.length; i++) {
			choice = i + 1;
			display("	" + choice + ") " + str[i]);	
		}
	}
	
	public static void display(Survey survey) {
		for (int i = 0; i < survey.questions.size(); i++) {
			display(survey.questions.get(i), false);
		}
	}
	
	public static void display(Test test) {
		for (int i = 0; i < test.questions.size(); i++) {
			display(test.questions.get(i), true);
		}
	}
	
	public static void display(Question q, boolean test) {
		display(q.prompt);
		if (q instanceof MultChoice || q instanceof TrueFalse 
				|| q instanceof Ranking) {
			display(q.getChoices());
			if (test) {
				display(q.getCorrAnswer());
			}
		} else if (q instanceof Matching) {
			((Matching) q).displayChoices();
			if (test) {	
				display(q.getCorrAnswer());
			}
		} else if (q instanceof ShortAnswer) {
			if (test) {
				display(q.corrAnswer);
			}
		} 
	}
	
	public static void displayChoice(String[] str, int i) {
		int choice = i + 1;
		System.out.println(choice + ") " + str[i]);
	}
}
