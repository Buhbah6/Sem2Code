package as01_sem2;
import java.util.Scanner;
import java.util.Random;

// -------------------------------------------------------
// Assignment 1: Robot
// Written by: Anthony Nadeau - 2058983
// For Programming II Section 00001 – Winter 2021
// --------------------------------------------------------
/**
 * This is the Test class, which acts as a Driver for the Robot class.
 * The main purpose of this class is to make a robot object move randomly throughout
 * a grid, until it reaches the top right of the grid.
 * The driver prints the position of the robot after each call of the robot.move() method.
 */
public class Test {

    // Main method
    public static void main(String[] args) {
        // Variable and Object declaration
        int turns = 0;
        Random rand =  new Random();
        Scanner console = new Scanner(System.in);
        
        // The main process starts here by printing the header. 
        printHeader();
        // Both robot name and gridsize are then asked to create the robot and establish the grid.
        Robot robot = new Robot(askRobotName(console));
        int gridSize = askGridSize(console);
        
        // Prints to display the starting point.
        System.out.println("\nTime for " + robot.getName() + " to start walking!!!");
        System.out.println("At the start: " + robot);
        
        // While loop used to repeat the moving process until the robot has won.
        while (!robot.won(gridSize)) {
            char directionVar = robot.getDirection();
            int randomNum = rand.nextInt(gridSize);
            System.out.println("=> Number of steps to take: " + randomNum);
            robot.move(randomNum, gridSize);
            if (directionVar != robot.getDirection())
                System.out.println("\tNew Direction: " + robot.getDirection());
            System.out.println("\tResult: " + robot);
            turns++;
        }
        // Finally, the closing message is displayed when the robot has won.
        closingMessage(robot, turns);
    }
   
    /**
     * Prints a header when called.
     */
    public static void printHeader() {
        System.out.println("= 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 =");
        System.out.println("= 0                           0 =");
        System.out.println("= 0      Robot Adventure      0 =");
        System.out.println("= 0                           0 =");
        System.out.println("= 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 =");
        System.out.println("");
    }
    
    /**
     * Asks the user to input a name for the robot
     * @param console Scanner that scans the inputted name from the console
     * @return a name for the robot.
     */
    public static String askRobotName(Scanner console) {
        System.out.println("What is the name of your robot?");
        return console.nextLine();
    }
    
    /**
     * Asks the user to input a grid size
     * @param console Scanner that scans the inputted grid size from the console.
     * @return grid size
     */
    public static int askGridSize(Scanner console) {
        System.out.println("What is the size of your grid?");
        return console.nextInt();
    }
    
    /**
     * Displays a closing message when the robot has won.
     * @param robot robot object
     * @param turns number of turns that it took the robot to win
     */
    public static void closingMessage(Robot robot, int turns) {
        System.out.printf("\n%s has reached its final destination in %d moves\n", 
                robot.getName(), turns); 
    } 
}