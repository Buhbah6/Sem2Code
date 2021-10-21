package selftesting;
import java.util.Arrays;
/**
 * I have separated each question within it's own method, and I have also separated
 * what to run in the main method by question so you may see the results of each
 * @author Anthony Nadeau - 25/02/2021
 */
public class SelfTest2 {
    
    public static void main(String[] args) {
        // Question 1
        int[] oldArray = {0,1,0,3,0,5};
        int[] newArray = question1(oldArray);
        System.out.println(Arrays.toString(oldArray));
        System.out.println(Arrays.toString(newArray));
        
        // Question 2
        int[] setA = {1, 3, 5, 7, 9};
        int[] setB = {2, 4, 6, 8, 10};
        question2(setA, setB);
        System.out.println(Arrays.toString(setA));
        System.out.println(Arrays.toString(setB));
    }
    
    public static int[] question1(int[] nums) {
        int[] newArray = new int[nums.length];
        int iter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                newArray[iter] = nums[i];
                iter++;
            }
        }
        return newArray;
    }
    
    public static void question2(int[] setA, int[] setB) {
        int[] allValues = new int[setA.length + setB.length];
        for (int i = 0; i < setA.length; i++)
            allValues[i] = setA[i];
        for (int i = 0; i < setB.length; i++)
            allValues[setA.length + i] = setB[i];
        Arrays.sort(allValues, 0, allValues.length - 1);
        for (int i = 0; i < setA.length; i++)
            setA[i] = allValues[i];
        for (int i = 0; i < setB.length; i++)
            setB[i] = allValues[setA.length + i];
    }     
}
