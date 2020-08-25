package indivCoreJava;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionSeven {
	public static ArrayList<Q7Employee> comparatorSort() {
		ArrayList<Q7Employee> array = new ArrayList<Q7Employee>();
		array.add(new Q7Employee(22, "Ric", "Philosophy"));
		array.add(new Q7Employee(30, "Taylor", "History"));
		
		System.out.println("Raw output.");
		for (int count = 0; count < array.size(); count++) { //For loop prints out all two entries in the ArrayList.
			System.out.println(array.get(count));
		}
		
		Collections.sort(array, new Q7SortAge()); //This line calls the sort method of the array, using the Q7SortAge comparator class.
		System.out.println("Sorted by Age");
		for (int count = 0; count < array.size(); count++) {
			System.out.println(array.get(count));
		}
		
		Collections.sort(array, new Q7SortName());
		System.out.println("Sorted by Name");
		for (int count = 0; count < array.size(); count++) {
			System.out.println(array.get(count));
		}
		
		Collections.sort(array, new Q7SortDept());
		System.out.println("Sorted by Department");
		for (int count = 0; count < array.size(); count++) {
			System.out.println(array.get(count));
		}
		return array;
	}
}
