package survey;

import java.io.IOException;

public class Menu implements java.io.Serializable
{
	private String[] menu1 = {"Survey", "Test"};
	private String[] surveyMenu2 = {"Create a new Survey", "Display a Survey", "Load a Survey", "Save a Survey", 
			"Modify an Existing survey", "Take a Survey", "Tabulate a Survey", "Quit"};
	private String[] testMenu2 = {"Create a new Test", "Display a Test", "Load a Test", "Save a Test", 
			"Modify and Existing Test", "Take a Test", "Tabulate a Test", "Grade a Test", "Quit"};
	private String[] menu3 = {"Add a new T/F question", "Add a new multiple choice question","Add a new short answer question",
			"Add a new essay question","Add a new ranking question","Add a new matching question", "Quit"};
	
	public void mainMenu() throws ClassNotFoundException, IOException {
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
	
	public void surveyMenu() throws ClassNotFoundException, IOException {
		Survey survey = new Survey();
		int choice;
		boolean menuLoop = true;
		
		while (menuLoop) {
			Display.display(surveyMenu2);
			choice = Response.getInt(0, surveyMenu2.length + 1);
			
			switch (choice) {
			case 1: survey = questionMenu(survey);
					break;
			case 2: Display.display(survey);
					break;
			case 3: survey = loadSurvey();
					break;
			case 4: saveMenu(survey);
					break;
			case 5: survey.modify();
					break;
			case 6: survey = loadSurvey();
					survey.take();
					break;
			case 7: survey.tabulate();
					break;
			case 8: mainMenu();
					break;
			default: mainMenu();
					break;
			}
		}
	}
	
	public void testMenu() throws ClassNotFoundException, IOException {
		Test test = new Test();
		int choice;
		boolean menuLoop = true;
		
		while (menuLoop) {
			Display.display(testMenu2);
			choice = Response.getInt(0, testMenu2.length + 1);
			
			switch (choice) {
			case 1: questionMenu(test);
					break;
			case 2: Display.display(test);
					break;
			case 3: test = loadTest();
					break;
			case 4: saveMenu(test);
					break;
			case 5: test.modify();
					break;
			case 6: test = loadTest();
					test.take();
					break;
			case 7: test.tabulate();
					break;
			case 8: test.grade();
					break;
			case 9: mainMenu();
					break;
			default: mainMenu();
					break;
			}
		}
	}
	
	public Survey questionMenu(Survey survey) {
		survey.clearQuestions();
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
			case 7: return survey;
			
			default: return survey;
			}
		}
		
		return survey;
	}
	
	public Test questionMenu(Test test) {
		test.clearQuestions();
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
			case 7: return test;
			default: return test;
			}
		}
			
		return test;
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
