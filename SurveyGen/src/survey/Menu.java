package survey;

public class Menu {
	private String[] menu1 = {"Survey", "Test"};
	private String[] surveyMenu2 = {"Create a new Survey", "Display a Survey", "Load a Survey", "Save a Survey", "Quit"};
	private String[] testMenu2 = {"Create a new Test", "Display a Test", "Load a Test", "Save a Test", "Quit"};
	private String[] menu3 = {"Add a new T/F question", "Add a new multiple choice question","Add a new short answer question",
			"Add a new essay question","Add a new ranking question","Add a new matching question", "Quit"};
	
	public void mainMenu() {
		int choice;
		Display.display(menu1);
		choice = Response.getInt(0, menu1.length + 1);
		
		switch (choice) {
		case 1: surveyMenu();
				break;
		case 2: testMenu();
				break;
		default : break;
		}
	}
	
	public void surveyMenu() {
		Survey survey = new Survey();
		int choice;
		boolean menuLoop = true;
		
		while (menuLoop) {
			Display.display(surveyMenu2);
			choice = Response.getInt(0, surveyMenu2.length + 1);
			
			switch (choice) {
			case 1: survey.clearQuestions();
					questionMenu(survey);
					break;
			case 2: displaySurvey(survey);
					break;
			case 3: survey = loadSurvey();
					break;
			case 4: saveMenu(survey);
					break;
			case 5: mainMenu();
					break;
			default: mainMenu();
					break;
			}
		}
	}
	
	public void testMenu() {
		Test test = new Test();
		int choice;
		boolean menuLoop = true;
		
		while (menuLoop) {
			Display.display(testMenu2);
			choice = Response.getInt(0, testMenu2.length + 1);
			
			switch (choice) {
			case 1: test.clearQuestions();
					questionMenu(test);
					break;
			case 2: displayTest(test);
					break;
			case 3: test = loadTest();
					break;
			case 4: saveMenu(test);
					break;
			case 5: mainMenu();
					break;
			default: mainMenu();
					break;
			}
		}
	}
	
	public void questionMenu(Survey survey) {
		boolean menuLoop = true;
		int choice;
		
		while (menuLoop) {
			Display.display(menu3);
			choice = Response.getInt(0, menu3.length + 1);
			
			switch (choice) {
			case 1:	survey.addTrueFalse();
					break;
			case 2: survey.addMultChoice();
					break;
			case 3: survey.addShortAnswer();
					break;
			case 4: survey.addEssay();
					break;
			case 5: survey.addRanking();
					break;
			case 6: survey.addMatching();
					break;
			case 7: surveyMenu();
					break;
			default: mainMenu();
					break;
			}
		}
	}
	
	public void questionMenu(Test test) {
		boolean menuLoop = true;
		int choice;
		
		while (menuLoop) {
			
			Display.display(menu3);
			choice = Response.getInt(0, menu3.length + 1);
			
			switch (choice) {
			case 1:	test.addTrueFalse();
					break;
			case 2: test.addMultChoice();
					break;
			case 3: test.addShortAnswer();
					break;
			case 4: test.addEssay();
					break;
			case 5: test.addRanking();
					break;
			case 6: test.addMatching();
					break;
			case 7: surveyMenu();
					break;
			default: mainMenu();
					break;
			}
		}
		
	}
	
	public void displaySurvey(Survey survey) {
		for (int i = 0; i < survey.questions.size(); i++) {
			Display.display(survey.questions.get(i), false);
		}
	}
	
	public void displayTest(Test test) {
		for (int i = 0; i < test.questions.size(); i++) {
			Display.display(test.questions.get(i), true);
		}
	}
	
	public void saveMenu(Survey survey) {
		Serialize ser = new Serialize();
		ser.save(survey);
	}
	
	public void saveMenu(Test test) {
		SerializeTest ser = new SerializeTest();
		ser.save(test);
	}
	
	public Survey loadSurvey() {
		Serialize ser = new Serialize();
		return ser.load();
	}
	
	public Test loadTest() {
		SerializeTest ser = new SerializeTest();
		return ser.load();
	}
}
