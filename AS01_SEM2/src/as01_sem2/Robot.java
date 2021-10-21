package as01_sem2;

// -------------------------------------------------------
// Assignment 1: Robot
// Written by: Anthony Nadeau - 2058983
// For Programming II Section 00001 – Winter 2021
// --------------------------------------------------------
/**
 * This is the Robot class. This class contains all the necessary methods to allow
 * the robot object to move throughout a grid.
 */
public class Robot {
    private String name; // Robot name
    private int x; // X coordinate
    private int y; // Y coordinate
    private char direction; // the direction that the robot is facing.
    
    /**
     * Default constructor: assigns default values to the data members when a robot
     * is instantiated.
     */
    public Robot() {
        this.name = "noName";
        this.x = 0;
        this.y = 0;
        this.direction = 'E';
    }
    
    /**
     * This constructor contains a parameter for a name to be given to the robot.
     * @param name is the name given to the Robot. 
     */
    public Robot(String name) {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.direction = 'E';
    }
    
    /**
     * Copy Constructor: copies the data members of the passed robot object and
     * assigns them to the new robot.
     * @param robot is the passed robot object that is being copied.
     */
    public Robot(Robot robot) {
        this.name = robot.name;
        this.x = robot.x;
        this.y = robot.y;
        this.direction = robot.direction;
    }
    
    /**
     * Overridden toString returns the robot object as a string.
     * @return robot object as a string.
     */
    @Override
    public String toString() {
        return String.format("%s is facing %c and at position (%d, %d)", this.name,
                this.direction, this.x, this.y);
    }
    
    /**
     * Checks to see if 2 robots are in the same position, facing the same direction.
     * @param robot the robot being compared to "this" robot.
     * @return true or false, whether they are in the same place or not.
     */
    public boolean equals(Robot robot) {
        return this.x == robot.x
                && this.y == robot.y
                && this.direction == robot.direction;
    }
    
    /**
     * Switch case checks the direction and changes it in consequence when the 
     * method is called.
     */
    public void changeDirection() {
        switch (direction) {
            case 'E':
                this.direction = 'N';
                break;
            case 'W':
                this.direction = 'S';
                break;
            case 'N':
                this.direction = 'W';
                break;
            default:
                this.direction = 'E';
        }
    }
    
    /**
     * The move method makes the robot move forward in the direction it is facing
     * within the grid by the given steps.
     * @param steps number of steps to be taken by the robot
     * @param gridSize size of the grid that the robot must stay within.
     */
    public void move(int steps, int gridSize)  {
        // the first if statement uses the "isOutOfBounds" method to check if 
        // the robot will end up out of bounds after moving.
        // if true, it changes direction, and checks again using recursion.
        if (isOutOfBounds(gridSize)) { 
            changeDirection();
            move(steps, gridSize); 
        }
        // if false, it uses the "moveHandler" method to move one space at a time.
        // after each move, it calls the move method again to ensure it isn't going out of bounds.
        // each time the robot CAN move, it reduces steps by 1 until steps !> 0.
        else {
            if (steps > 0) {
                moveHandler();
                move(--steps, gridSize);
            }
        }
    }
    
    /**
     * Checks if the robot will be out of bounds when moving my one in the direction
     * it is facing.
     * @param gridSize size of the grid that the robot must stay within.
     * @return true or false, if moving one space in the current direction will make the robot
     * out of bounds.
     */
    public boolean isOutOfBounds(int gridSize) {
        return this.x + 1 > gridSize && getDirection() == 'E' 
                || this.x - 1 < 0 && getDirection() == 'W'
                || this.y + 1 > gridSize && getDirection() == 'N'
                || this.y - 1 < 0 && getDirection() == 'S';
    }
    
    /**
     * This method checks the direction, and moves the robot one space in said direction.
     */
    public void moveHandler() {
        switch (getDirection()) {
            case 'E':
                this.x++;
                break;
            case 'W':
                this.x--;
                break;
            case 'N':
                this.y++;
                break;
            default:
                this.y--;
        }
    }
    
    /**
     * Checks to see if the robot has reached the top right space in the grid
     * @param gridSize size of the grid that the robot must stay within.
     * @return true or false, if the robot has reached the top right space in the grid.
     */
    public boolean won(int gridSize) {
        return this.x == gridSize && this.y == gridSize;
    }
    
    // Accessor and Mutator Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getDirection() {
        return direction;
    }     
}