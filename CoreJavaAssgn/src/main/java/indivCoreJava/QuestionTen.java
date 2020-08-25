package indivCoreJava;

public class QuestionTen {
	public static int ternaryOperation(int a, int b) {
		System.out.println("Ternary operation will determine which is smaller " + a + " or " + b + ".");
		int minimum = a < b ? a : b;
		System.out.println(minimum + " is minimum.");
		return minimum;
	}
}
