package indivCoreJava;

import java.util.ArrayList;

public class QuestionTwelve {
	static ArrayList<Integer> numbers = new ArrayList<Integer>();
	static ArrayList<Integer> testOutput = new ArrayList<Integer>();
	static int counter = 0;
	
	public static ArrayList<Integer> enhancedFill() {
		for (int counter = 1; counter <= 100; counter++) {
			numbers.add(counter); //Adds all numbers 1-100.
		}
		for (int counter : numbers) { //Tests for even numbers.
			if ((counter) % 2 == 0) {
				System.out.print(counter + " ");//Prints even numbers.
				testOutput.add(counter); //Adds evens to testOutput AL.
			}	
		}
		System.out.println();
		return testOutput;
	}
}
