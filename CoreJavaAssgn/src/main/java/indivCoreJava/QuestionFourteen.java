package indivCoreJava;

import java.time.LocalDate;
import java.util.Arrays;

public class QuestionFourteen {
	public static String switchCase(int numInput) {
		
		switch (numInput) {
		case 1:
			int number = 16;
			double solved = Math.sqrt(number);
			System.out.println("Square root of 16 is: " + solved);
			String strSolved = Double.toString(solved);
			return strSolved;
		case 2:
			LocalDate currentDate = LocalDate.now();
			strSolved = currentDate.toString();
			System.out.println(currentDate);
			return strSolved;
		case 3:
			String string = "I am learning Core Java";
			String strArray[] = string.split(" ");
			
			for (int count = 0; count < strArray.length; count++) {
				System.out.print(strArray[count] + " ");
			}
			strSolved = Arrays.toString(strArray);
			return strSolved;
		default:
			System.out.println("Error. Bad input.");
			strSolved = "";
			return strSolved;
		}
	}
}
