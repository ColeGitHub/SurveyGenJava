package survey;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Response implements java.io.Serializable{
	
	public static int getInt(int lower) {
		int rtn = 0;
		boolean num = false;
		Scanner scan = new Scanner(System.in);
		
		while (!num) {
			try {
				rtn = scan.nextInt();
				if (rtn > lower) {
					num = true;
				} else {
					Display.display("Please enter number above " + lower);
					scan.nextLine();
				}
			} catch (InputMismatchException e) {
				Display.display("Please enter an integer");
				scan.nextLine();
			}
		}
		scan.nextLine();
		return rtn;
	}
	
	public static int getInt(int lower, int upper) {
		int rtn = 0;
		boolean num = false;
		Scanner scan = new Scanner(System.in);
		
		while (!num) {
			try {
				rtn = scan.nextInt();
				if (rtn > lower || rtn < upper) {
					num = true;
				} else {
					Display.display("Please enter number above " + lower);
					scan.nextLine();
				}
			} catch (InputMismatchException e) {
				Display.display("Please enter an integer");
				scan.nextLine();
			}
		}
		scan.nextLine();
		return rtn;
	}
	
	public static boolean getYesNo() {
		boolean yn = true;
		String yesNo;
		while (yn) {
			yesNo = Response.getString().toUpperCase();
			if (yesNo.equals("Y")) { 
				yn = false;
			} else if (yesNo.equals("N")) { 
				yn = false;
			} else {
				Display.display("Please enter 'Y' for yes or 'N' for no");
			}
		}
		
		return yn;
	}
	
	public static String getString(int limitNum) {
		boolean limit = true;
		String rtn = "";
		Scanner scan = new Scanner(System.in);
		
		while (limit) {
			rtn = scan.nextLine();
			if (rtn.length() > limitNum) {
				Display.display("Please enter answer up to " + limitNum + " characters");
			} else {
				limit = false;
			}
		}
		
		return rtn;
	}
	
	public static String getString() {
		String rtn = "";
		Scanner scan = new Scanner(System.in);
		
		rtn = scan.nextLine();
		return rtn;
	}
}
