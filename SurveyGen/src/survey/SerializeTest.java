package survey;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeTest extends Serialize {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1900580436140750254L;
	private String relativePath = "tests";
	
	protected void save(Test test) {
		String surveyName, path;
		Display.display("Please enter a name for this file: ");
		surveyName = Response.getString();
		File newDir = new File(relativePath + "/" + surveyName);
		newDir.mkdir();
		path = relativePath + "/" + surveyName + "/" + surveyName + ".ser";
		try {
			FileOutputStream fileOut = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(test);
			out.close();
			fileOut.close();
			Display.display("Saved in " + relativePath + "/" + surveyName);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	protected Test load() {
		Test test = new Test();
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
		         test = (Test) in.readObject();
		         in.close();
		         fileIn.close();
		      } catch (IOException i) {
		         i.printStackTrace();
		      } catch (ClassNotFoundException c) {
		         System.out.println("Employee class not found");
		         c.printStackTrace();
		      }
		test.filePath = relativePath + "/" + listOfFiles[choice - 1].getName();
		return test;
	}
}
