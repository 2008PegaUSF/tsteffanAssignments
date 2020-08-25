package indivCoreJava;

import java.util.Comparator;

public class Q7SortAge implements Comparator<Q7Employee> { //Sorts by age.
	public int compare(Q7Employee a, Q7Employee b) {
		return a.age - b.age;
	}
}
