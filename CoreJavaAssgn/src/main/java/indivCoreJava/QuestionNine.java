package indivCoreJava;

import java.util.ArrayList;

public class QuestionNine {
	static ArrayList<Integer> numbers = new ArrayList<Integer>();
	static ArrayList<Integer> primeList = new ArrayList<Integer>();
	static int counter = 0;
	
	public static ArrayList<Integer> fillAndPrint() {
		for (int counter = 0; counter < 100; counter++) {
			numbers.add(counter + 1);
			
			if (isPrime(counter) == true) 
				primeList.add(counter);
				System.out.println(counter);
			}
		return primeList;
		}
	
	public static boolean isPrime(int counter) {
		if (counter < 2) {
			return false;
		}
		
		for (int i = 2; i <= counter / 2; ++i) {
			if ((counter % i ) == 0) {
				return false;
			}
		}
		return true;
	}
}
