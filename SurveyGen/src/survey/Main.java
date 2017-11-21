package survey;

import java.io.IOException;
import java.io.File;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Menu menu = new Menu();
		menu.mainMenu();
		//new File("tests/testFolder").mkdir();
	}
}
