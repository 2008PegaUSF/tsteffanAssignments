package indivCoreJava;

public class QuestionOne {
	//Actual bubble sorting function.
    public int[] bubbleSort(int sample[]) { 
        int size = sample.length; 
        for (int iteration = 0; iteration < size - 1; iteration++) 
            for (int index = 0; index < size - 1; index++) 
                if (sample[index] > sample[index + 1]) 
                { 
                	//Compares elements, swaps positions if needed.
                    int temp = sample[index]; 
                    sample[index] = sample[index + 1]; 
                    sample[index + 1] = temp; 
                } 
        return sample;
    } 
    //Prints out sample.
    public void outputSample(int sample[]) { 
        int size = sample.length; 
        for (int index = 0; index < size; ++index) 
            System.out.print(sample[index] + " "); 
        System.out.println(); 
    }
    /*Instantiates object from class, contains array of unsorted integers
    * and runs the above methods.
    */
    public void primarySort() { 
        QuestionOne ob = new QuestionOne(); 
        int sample[] = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4}; 
        ob.bubbleSort(sample); 
        System.out.println("Bubble Sorted Array"); 
        ob.outputSample(sample); 
    }
}