
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import indivCoreJava.*;
import q11Package.Q11PackageClass;


public class CoreJavaTesterClass {
	QuestionOne q1obj = new QuestionOne();
	QuestionTwenty q20obj = new QuestionTwenty();
	
	//Q1Test needs to return the correctly sorted array.
	@Test
	public void testQuestionOne() {
        int sample[] = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
        int answer[] = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9}; 
		Assertions.assertArrayEquals(answer, q1obj.bubbleSort(sample));
	}
	
	//Q2Test needs to print the first 25 Fibonacci numbers.
	@Test
	public void testQuestionTwo() {
		int[] fibExpect = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ,55, 89, 144, 
				233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 
				28657, 46368};
		Assertions.assertArrayEquals(fibExpect, QuestionTwo.fibEquation());
	}
	
	//Q3Test input string should return reversed.
	@Test
	public void testQuestionThree() {
		char[] expected = {'s', 'g', 'n', 'i', 'h', 'T'};
		Assertions.assertArrayEquals(expected, QuestionThree.reversal("Things"));
	}
	
	//Q4Test needs to return the factorial of the passed in integer.
	@Test
	public void testQuestionFour() {
		Assertions.assertEquals(720, QuestionFour.factorialCalc(6));
	}
	
	//Q5Test
	@Test
	public void QuestionFive() {
		Assertions.assertEquals("Antidisest", QuestionFive.substringMethod("Antidisestablishmentarianism.", 10));
	}
	
	//Q6Test
	@Test
	public void QuestionSix() {
		Assertions.assertFalse(QuestionSix.remainderTest(13));
	}
	
	//Q7Test
	@Test
	public void QuestionSeven() {
		ArrayList<Q7Employee> sorted = new ArrayList<Q7Employee>();
		sorted.add(new Q7Employee(30, "Taylor", "History"));
		sorted.add(new Q7Employee(22, "Ric", "Philosophy"));
		Assertions.assertEquals(sorted.toString(), QuestionSeven.comparatorSort().toString());
	}
	
	//Q8Test
	@Test
	public void QuestionEight() {
		ArrayList<String> checkPal = new ArrayList<String>();
		checkPal.add("madam");
		checkPal.add("civic");
		checkPal.add("radar");
		checkPal.add("kayak");
		checkPal.add("refer");
		checkPal.add("did");
		
		Assertions.assertEquals(checkPal.toString(), QuestionEight.q8Run().toString());
	}
	
	//Q9Test
	@Test
	public void QuestionNine() {
		ArrayList<Integer> solved = new ArrayList<Integer>();
		Integer[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 
				23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 
				67, 71, 73, 79, 83, 89, 97};
		solved.addAll(Arrays.asList(primes));
		Assertions.assertEquals(solved.toString(), QuestionNine.fillAndPrint().toString());
		
	}
	
	//Q10Test
	@Test
	public void QuestionTen() {
		Assertions.assertEquals(10, QuestionTen.ternaryOperation(10, 20));
	}
	
	//Q11Test
	@Test
	public static void QuestionEleven() {
		Assertions.assertEquals(Q11PackageClass.varOne, QuestionEleven.longRange());
	}
	
	//Q12Test
	@Test
	public void QuestionTwelve() {
		ArrayList<Integer> evenConfirm = new ArrayList<Integer>();
		Integer[] fill = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 
				38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 
				78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 100};
		evenConfirm.addAll(Arrays.asList(fill));
		Assertions.assertEquals(evenConfirm, QuestionTwelve.enhancedFill());
	}
	
	//Q13Test
	@Test
	public void QuestionThirteen() {
		String expected = "0101010101";
		Assertions.assertEquals(expected, QuestionThirteen.pyramid());
	}

	//Q14Test
	@Test
	public void QuestionFourteen() {
		String solved = "4.0";
		LocalDate now = LocalDate.now();
		String[] ansArr = {"I", "am", "learning", "Core", "Java"};
		Assertions.assertEquals(solved, QuestionFourteen.switchCase(1));
		Assertions.assertEquals(now.toString(), QuestionFourteen.switchCase(2).toString());
		Assertions.assertEquals(Arrays.toString(ansArr), QuestionFourteen.switchCase(3));
	}
	
	//Q15Test
	@Test
	public void QuestionFifteen() {
		Assertions.assertEquals(8, QuestionFifteen.addition(6, 2));
		Assertions.assertEquals(12, QuestionFifteen.subtraction(15, 3));
		Assertions.assertEquals(9, QuestionFifteen.multiplication(3, 3));
		Assertions.assertEquals(4, QuestionFifteen.division(24, 6));
	}
	
	//Q16Test
	@Test
	public void QuestionSixteen() {
		String[] stdString = {"Domo", "arigato", "mr", "roboto"};
		Assertions.assertEquals(19, QuestionSixteen.stringCounter(stdString));
	}
	//Q17Test
	@Test
	public void QuestionSeventeen() {
		Scanner scan = new Scanner(System.in);
		int principalTest = scan.nextInt();
		int rateTest = scan.nextInt();
		int yearsTest = scan.nextInt();
		Assertions.assertEquals(principalTest*rateTest*yearsTest, QuestionSeventeen.simpleInterest());
	}
	//Q18Test
	@Test
	public void QuestionEighteen() {
		QuestionEighteenConcSub q18obj = new QuestionEighteenConcSub();
		Assertions.assertTrue(q18obj.caseCheck());
	}
	
	//Q19Test
	@Test
	public void QuestionNineteen() {
		QuestionNineteen q19obj = new QuestionNineteen();
		ArrayList<Integer> solution = new ArrayList<Integer>();
		Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		solution.addAll(Arrays.asList(array));
		Assertions.assertEquals(solution, q19obj.arrayFiller());
	}
	
	//Q20Test
	@Test
	public void QuestionTwenty() {

		String solve = 
				"Name: Mickey Mouse\nAge: 35 years\nState: Arizona State\nName: Hulk Hogan"
				+ "\nAge: 50 years\nState: Virginia State\nName: Roger Rabbit\nAge: 22 years"
				+ "\nState: California State\nName: Wonder Woman\nAge: 18 years\nState: Montana State\n";
		String output = q20obj.fileRead();
		Assertions.assertEquals(solve, output);
	}
}
