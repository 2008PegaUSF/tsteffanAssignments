package indivCoreJava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class QuestionTwenty {
	public String fileRead() {
		String testReturn = new String(); //String for a return on the test method.
		try {
			File data = new File("Data.txt");
			Scanner reader = new Scanner(data);
			while (reader.hasNextLine()) { //Reads through each line of Data.txt
				String output = reader.nextLine();
				String[] array = output.split(":"); // Splits delineated by ":" into separate array elements.
				Arrays.toString(output.split(":"));
				System.out.println("Name: " + array[0] + " " + array[1]);
				System.out.println("Age: " + array[2] + " years");
				System.out.println("State: " + array[3] + " State\n");
				testReturn = testReturn + "Name: " + array[0] + " " + array[1] + "\n" + "Age: " + array[2] + " years" + "\n" + "State: " + array[3] + " State\n";
			}
		} catch (FileNotFoundException e) {
			System.out.println("WHY AM I DUMB!");
			e.printStackTrace();
		} 
		return testReturn;
	}
}
