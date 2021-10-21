package as02_sem2_Q2;

/**
 * Exception class used for when an invalid amount of courses are withdrawn
 * @author Anthony Nadeau
 */
public class CourseWithdrawException extends Exception {
    
    /**
     * Constructor for when the exception is thrown
     * @param message passed to the exception from the throw statement
     */
    public CourseWithdrawException(String message) {
        super(message);
    }
}
