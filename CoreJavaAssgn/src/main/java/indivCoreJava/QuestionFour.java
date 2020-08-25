package indivCoreJava;

public class QuestionFour {
	public static int factorialCalc(int x) {
		//x is the passed in factorial target number. Integer acts as the ascending number in the factorial.
		//facNum is the expressed solution.
		int facNum = 1;
		for (int integer = 1; integer <= x; integer++) {
			facNum = facNum * integer;
		}
		System.out.println("Factorial of " + x);
		System.out.println(facNum);
		return facNum;
	}
}
