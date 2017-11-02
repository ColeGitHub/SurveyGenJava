package survey;

import java.io.*;

public class Serialize {
	
	protected String relativePath = "surveys";
	
	protected void save(Survey survey) {
		String surveyName, path;
		Display.display("Please enter a name for this file: ");
		surveyName = Response.getString();
		path = relativePath + "/" + surveyName + ".ser";
		try {
			FileOutputStream fileOut = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(survey);
			out.close();
			fileOut.close();
			Display.display("Saved in " + path);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	protected Survey load() {
		Survey survey = new Survey();
		survey.clearQuestions();
		int choice;
		String name;
		File folder = new File(relativePath);
		File[] listOfFiles = folder.listFiles();
		
		for (int i = 0; i < listOfFiles.length; i++) {
			choice = i + 1;
			Display.display(choice + ") " + listOfFiles[i].getName());
		}
		
		choice = Response.getInt(0, listOfFiles.length + 1);
		name = relativePath + "/" + listOfFiles[choice - 1].getName();
		
		   try {
		         FileInputStream fileIn = new FileInputStream(name);
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         survey = (Survey) in.readObject();
		         in.close();
		         fileIn.close();
		      } catch (IOException i) {
		         i.printStackTrace();
		      } catch (ClassNotFoundException c) {
		         System.out.println("Class not found");
		         c.printStackTrace();
		      }
		   
		return survey;
	}
}
