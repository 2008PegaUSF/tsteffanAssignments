package indivCoreJava;

public class QuestionSix {
	public static boolean remainderTest(int Number) {
		if ((Number / 2) * 2 == Number) {
			System.out.println("This number is even.");
			return true;
		} else {
			System.out.println("This number is odd.");
			return false;
		}
	}
}
