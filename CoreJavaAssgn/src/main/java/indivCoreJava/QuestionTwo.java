package indivCoreJava;

import java.util.Arrays;

public class QuestionTwo {              
	
	//Method initializes variables and contains for loop that runs calculation.
	public static int[] fibEquation() {
		int firstNumber = 0;
		int secondNumber = 1;
		int sumOfNumbers = 0;
		int[] sequence = new int[25]; //Results of calculations are placed into array in order.
		
		for (int i = 0; i <= 24; ++i) {
			sequence[i] = firstNumber;
			sumOfNumbers = firstNumber + secondNumber;
			firstNumber = secondNumber;
			secondNumber = sumOfNumbers;					
		}
		
		//Prints ordered array to user.
		System.out.println("Fibonacci Sequence");
		System.out.println(Arrays.toString(sequence));
		return sequence;
	}	
}