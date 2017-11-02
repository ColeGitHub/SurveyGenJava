package survey;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Put some integers: ");
		int firstInt = scan.nextInt();
		scan.nextLine();
		System.out.println("Put a string: ");
		String firstStr = scan.next();
		System.out.println("First int: " + firstInt);
		System.out.println("First String: " + firstStr);
		scan.close();
	}
}
