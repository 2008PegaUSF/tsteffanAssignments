package indivCoreJava;

import java.util.Comparator;

public class Q7SortName implements Comparator<Q7Employee> { //Sorts by name.
	public int compare(Q7Employee a, Q7Employee b) {
		return a.name.compareTo(b.name);
	}
}
