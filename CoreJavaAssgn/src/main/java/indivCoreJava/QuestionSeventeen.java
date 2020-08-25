package indivCoreJava;

import java.util.Scanner;

public class QuestionSeventeen {
	public static int simpleInterest() {
		Scanner scanInt = new Scanner(System.in);
		System.out.println("Select your principal.");
		int principal = scanInt.nextInt(); //Reads console and applies value to principal.
		System.out.println("Select your rate.");
		int rate = scanInt.nextInt(); //Reads console and applies value to rate.
		System.out.println("Select your time.");
		int time = scanInt.nextInt(); //Reads console and applies value to time.
		
		int interest = principal * rate * time; //Simple math to produce interest.
		System.out.println("Your simple interest is: " + interest);
		return interest;
	}
}
