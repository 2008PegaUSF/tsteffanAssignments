package indivCoreJava;

public class QuestionThree {
	//Method reads input.
	public static char[] reversal(String string) {
		char[] output = new char[6];
		int invertCounter = 0;
		System.out.println(string);
		//For loop reads the character array backwards via decrementing counter.
		//While assigning each character to the charArray in ascending order.
		for (int counter = string.length(); counter > 0; --counter) {
			output[invertCounter++] = string.charAt(counter - 1);
			System.out.print(string.charAt(counter - 1));
		}
		return output;
	}
}
