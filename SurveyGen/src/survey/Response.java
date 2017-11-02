package survey;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Response {
	
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
	
	public static String getString(boolean limit, int limitNum) {
		String rtn = "";
		Scanner scan = new Scanner(System.in);
		
		while (limit) {
			rtn = scan.nextLine();
			if (rtn.length() > limitNum) {
				Display.display("Please enter answer up to " + limitNum + " characters");
				scan.nextLine();
			} else {
				limit = false;
			}
		}
		scan.nextLine();
		
		return rtn;
	}
	
	public static String getString() {
		String rtn = "";
		Scanner scan = new Scanner(System.in);
		
		rtn = scan.nextLine();
		return rtn;
	}
}
