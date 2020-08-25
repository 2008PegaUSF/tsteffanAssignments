package indivCoreJava;

public class QuestionThirteen {
	
	public static String pyramid() {
		int n = 0;
		String testString = "";
		for (int lineCounter = 1; lineCounter < 5; lineCounter++) {
			for (int binCounter = 0; binCounter < lineCounter; binCounter++) {
				System.out.print(n);
				testString = testString + n;
				n = n ^ 1;
			}
			System.out.println();
		}
		return testString;
	}
}
