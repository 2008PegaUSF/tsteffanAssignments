package indivCoreJava;

import java.util.ArrayList;

public class QuestionEight {
	static ArrayList<String> allWords = new ArrayList<String>(); //The arraylist that will hold all words.
	static ArrayList<String> palindrome = new ArrayList<String>(); //The arraylist that will hold only palindromes after method below.
	
	public static void arrayFill() { // This method just fills the initial array.
		allWords.add("karan");
		allWords.add("madam");
		allWords.add("tom");
		allWords.add("civic");
		allWords.add("radar");
		allWords.add("jimmy");
		allWords.add("kayak");
		allWords.add("john");
		allWords.add("refer");
		allWords.add("billy");
		allWords.add("did");
	}
	
	public static void palindromeCheck() {

		for (int counter = 0; counter < allWords.size(); counter++) { //Simple for loop that creates a counter also used as an index.
			String sb = allWords.get(counter);
			StringBuilder temp = new StringBuilder(sb); //Using the StringBuilder to compare the original and reversed strings.
			temp = temp.reverse();
			String reverse = temp.toString();
			
			if (sb.equals(reverse) ) {
				palindrome.add(sb);
			} 
		}
		System.out.println(palindrome);
	}
	
	public static ArrayList<String> q8Run() {
		arrayFill();
		palindromeCheck();
		return palindrome;
	}
}
	

