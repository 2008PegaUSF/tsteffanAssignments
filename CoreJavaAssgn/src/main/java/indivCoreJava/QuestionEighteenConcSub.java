package indivCoreJava;

public class QuestionEighteenConcSub extends QuestionEighteenAbsSuper {

	String string = "Upper And Lower Case Check Sample";
	String stringHolder[] = string.split(" ");

	
	public boolean caseCheck() {
		System.out.println("String is: " + string);
		for (int counter = 0; counter < stringHolder.length; counter++) {
			for (int charInspecCounter = 1; charInspecCounter <= stringHolder[counter].length(); charInspecCounter++) {
			char inspector = stringHolder[counter].charAt(counter);
				if (Character.isUpperCase(inspector)) {
					System.out.println("This string has an upper case.");
					return true;
				}
			}
		}
		System.out.println("This string does not have upper case.");
		return false;
	}
	
	public void convertToUpper() {
		System.out.println(string.toUpperCase());
	}
	
	public void convertToInt() { 
		String rawNum = "20";
		int arbNum = 10;
		System.out.println("The number in the string is " + rawNum);
		int procOutput = Integer.parseInt(rawNum);
		procOutput = procOutput + arbNum;
		System.out.println("The string has been converted to integer and 10 added: " + procOutput);
	}
}
