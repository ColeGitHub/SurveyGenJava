package survey;

import java.io.*;

public class Serialize implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6283033698426762752L;
	protected String relativePath = "surveys";
	//new File("tests/testFolder").mkdir();
	protected void save(Survey survey) {
		String surveyName, path;
		Display.display("Please enter a name for this file: ");
		surveyName = Response.getString();
		new File(relativePath + "/" + surveyName).mkdir();
		path = relativePath + "/" + surveyName + "/" + surveyName + ".ser";
		
		try {
			FileOutputStream fileOut = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(survey);
			out.close();
			fileOut.close();
			Display.display("Saved in " + relativePath + "/" + surveyName);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	protected Survey load() {
		Survey survey = null;
		int choice;
		String name;
		File folder = new File(relativePath);
		File[] listOfFiles = folder.listFiles(File::isDirectory);
		
		for (int i = 0; i < listOfFiles.length; i++) {
			choice = i + 1;
			Display.display(choice + ") " + listOfFiles[i].getName());
		}
		
		choice = Response.getInt(0, listOfFiles.length + 1);
		name = relativePath + "/" + listOfFiles[choice - 1].getName() + "/" + listOfFiles[choice - 1].getName() + ".ser";
		   try {
		         FileInputStream fileIn = new FileInputStream(name);
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         survey = (Survey) in.readObject();
		         in.close();
		         fileIn.close();
		      } catch (IOException i) {
		         i.printStackTrace();
		      } catch (ClassNotFoundException c) {
		         System.out.println("Employee class not found");
		         c.printStackTrace();
		      }
		survey.filePath = relativePath + "/" + listOfFiles[choice - 1].getName();
		return survey;
	}
	
	protected void saveAnswers(String[] arr, String filePath) {
		String surveyName, path;
		int numFiles = new File(filePath).list().length;
		path = filePath + "/answers" + Integer.toString(numFiles) + ".ser";
	
		try {
			FileOutputStream fileOut = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(arr);
			out.close();
			fileOut.close();
			Display.display("Saved in " + path);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	protected static String[][] loadAnswers(String filePath) throws IOException, ClassNotFoundException {
		String[][] answers = new String[0][0];
		String[] answer;
		String path;
		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();
		if (listOfFiles.length < 2) {
			return answers;
		}
		
		for (int i = 1; i < listOfFiles.length; i++) {
			path = filePath + "/answers" + Integer.toString(i) + ".ser";
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			answer = (String[]) in.readObject();
			
			if (i == 1) {
				answers = new String[listOfFiles.length - 1][answer.length];
			}
			
			answers[i-1] = answer;
		}
		
		return answers;
	}
}
