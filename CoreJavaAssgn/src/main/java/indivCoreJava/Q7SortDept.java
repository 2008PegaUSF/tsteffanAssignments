package indivCoreJava;

import java.util.Comparator;

public class Q7SortDept implements Comparator<Q7Employee> { //Sorts by department.
	public int compare(Q7Employee a, Q7Employee b) {
		return a.department.compareTo(b.department);
	}
}
