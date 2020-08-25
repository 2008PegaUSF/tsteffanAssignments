package indivCoreJava;

public class QuestionFive {
	public static String substringMethod(String string, int index) {
		char[] subString = new char[index];
		
		for (index = 9; index >= 0; --index) { //For loop cites index for how many characters will be displayed.
			subString[index] = string.charAt(index); //subString array assigned values by charAt method.
		}
		String sub = new String(subString); //New variable is assigned the truncated substring from array.
		System.out.println("Original word: Antidisestablishmentarianism");
		System.out.println("Truncated word: " + sub);
		return sub;
	}
}
