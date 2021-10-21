package as03;

import java.util.Arrays;
import java.util.Random;

/**
 * Makes the recursive method
 * @author Anthony Nadeau
 */
public class Question2 {
    
    /**
     * Main method 
     */
    public static void main(String[] args) { 
        int[] cities = generateArray();
        System.out.println(">>>>>>Welcome to \"FastestPath\">>>>>>\n");
        System.out.println("For the following path:");
        System.out.println(Arrays.toString(cities));
        int shortestPath = findShortestPath(cities, 0, 0);
        System.out.println("The shortest time to the end is " + shortestPath);
        System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
    }
    
    /**
     * randomly generates an array between 4 and 20 numbers in length
     * @return the generated array
     */
    public static int[] generateArray() {
        Random rand = new Random();
        int noOfCities = rand.nextInt(20);
        noOfCities = (noOfCities > 4) ? noOfCities : 4;
        int[] cities = new int[noOfCities];
        for (int i = 1; i < cities.length; i++) { // i starts at 1 to make the 1st value 0
            cities[i] = rand.nextInt(100); // generates values between 0 and 100
        }
        return cities;
    }
    
    /**
     * Recursive method cycles through the array and compares the values one and two
     * positions ahead of the one it has currently reached, and evaluates which one is smaller.
     * It then chooses the smaller value and updates the position accordingly.
     * However if the value 2 ahead from the current one is the last value, it is chosen regardless
     * of the one before it.
     * @param cities int array being cycled through
     * @param sum sum of the cities being selected (totals up to the shortest path)
     * @param position is the current position that the method has reached in the array
     * @return the shortest path through the array.
     */
    public static int findShortestPath(int[] cities, int sum, int position) {
        try {
            if (cities[position + 1] < cities[position + 2] // if the next position is shorter than the one 2 ahead
                    && position + 2 != cities.length - 1) { // it chooses the first one (unless the 2nd is the last of the array)
                sum += cities[position + 1];
                position++; // updates position to be at the spot where the last number was just picked
            }
            else {
                sum += cities[position + 2];
                position += 2; 
            }
        }
        catch(Exception e) { // if any exception is thrown (ArrayOutOfBoundsException)
            if (position + 2 > cities.length - 1 && position + 1 <= cities.length - 1)
                sum += cities[position + 1]; // adds the next value by default because the one 2 ahead is outside of the array
            return sum;
        }
        return findShortestPath(cities, sum, position); //calls the method again with the updated variables
    }
}