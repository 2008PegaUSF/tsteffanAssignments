package indivCoreJava;

import q11Package.Q11PackageClass;

public class QuestionEleven {
	public static float longRange() {
		System.out.println("Two floats from another package: " 
				+ Q11PackageClass.varOne + ", " + Q11PackageClass.varTwo);
		float report = Q11PackageClass.varOne;
		return report;
	}
}
