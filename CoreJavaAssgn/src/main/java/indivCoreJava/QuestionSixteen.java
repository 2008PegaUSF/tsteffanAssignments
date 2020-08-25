package indivCoreJava;

public class QuestionSixteen {
	
	public static int stringCounter(String args[]) { // String used: "Domo arigato Mr Roboto"
		int fullLength = 0;
		for (int index = 0; index < args.length; index++) { //For loop iterates through each string in the array
			fullLength = fullLength + args[index].length();// and adds the length of the string to the total (fullLength).
		}
		System.out.println("The total sum number of characters of the string is: " + fullLength);
		return fullLength;
	}
}
