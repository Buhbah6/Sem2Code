package as01_sem2;
import java.util.Scanner;
import java.util.Random;

// -------------------------------------------------------
// Assignment 1: Robot
// Written by: Anthony Nadeau - 2058983
// For Programming II Section 00001 – Winter 2021
// --------------------------------------------------------
/**
 * The RobotRace class uses the robot class from Q1 to create multiple robot objects
 * and make them race to see who can make it to the top right corner first.
 */
public class RobotRace {
   
    // Main Method
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random rand = new Random();
        
        // Main event starts with printing the header
        printHeader();
        // Grid size is asked and the array of robots is made using askRobotNum() method.
        int gridSize = askGridSize(console);
        int turns = 1;
        boolean hasWon = false;
        Robot[] robotArr = new Robot[askRobotNum(console)];
        
        console.nextLine(); // <- this line is used to keep the 1st iteration of the
        // for loop from ignoring the "console.nextLine()"
        // The for loop asks the user to input a name for each robot.
        for (int i = 0; i < robotArr.length; i++) {
            System.out.printf("Name of robot %d:", i + 1);
            robotArr[i] = new Robot(console.nextLine());
        }
        // While loop is used to repeat the process used to make the robots move.
        while (hasWon == false) {
            System.out.println("");
            System.out.println("Move number " + turns);
            System.out.println("=============");
            turns++;
            
            // For each loop within the while loop is used to cycle through the 
            // robots within the array and make each one move, as well as print
            // their respective results.
            for (Robot robot : robotArr) {
                char directionVar = robot.getDirection();
                int randomNum = rand.nextInt(gridSize);
                System.out.println("*" + robot + "and needs to take " + randomNum + " steps.");
                robot.move(randomNum, gridSize);
                if (directionVar != robot.getDirection())
                    System.out.println("New Direction: " + robot.getDirection());
                System.out.println("Result: " + robot);
                System.out.println("--------------------------------------------");
            }
            // For loop within the while loop is used to cycle through each robot
            // in the array to see if one of them has won. If the won() method
            // returns true, then the closing message is printed.
            for (int i = 0; i < robotArr.length; i++) {
                if (robotArr[i].won(gridSize)) {
                    System.out.printf("\n=> It took %d rounds for %s to win the race!!!",
                            turns - 1, robotArr[i].getName());
                    System.out.println("\n\nGood Game, Well Played");
                    hasWon = true;
                    break;
                }
            }
        }
    }
    
    /**
     * Like the method of the same name in the Test class, this method prints
     * out a header when called.
     */
    public static void printHeader() {
        System.out.println("= 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 =");
        System.out.println("= 0                                   0 =");
        System.out.println("= 0     It's Robot Racin' Time!!!     0 =");
        System.out.println("= 0                                   0 =");
        System.out.println("= 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 =");
        System.out.println("");
    }
    
    /**
     * Asks the user to input a grid size that must be at least 2.
     * @param console Scanner that scans the inputted grid size from the console 
     * @return grid size
     */
    public static int askGridSize(Scanner console) {
        int gridSize;
        do {
            System.out.println("What is the size of your grid? (Must be at least 2): ");
            gridSize = console.nextInt();
        }
        while (gridSize < 2);
        return gridSize;
    }
    
    /**
     * Asks the user to input the number of robots that should be included in the race.
     * @param console Scanner that scans the inputted number of robots from the console.
     * @return number of robots participating in the race.
     */
    public static int askRobotNum(Scanner console) {
        int robotNum;
        do {
            System.out.println("How many robots will race? (Must have at least "
                    + "one robot in the race): ");
            robotNum = console.nextInt();
        }
        while (robotNum < 1);
        return robotNum;
    }
}