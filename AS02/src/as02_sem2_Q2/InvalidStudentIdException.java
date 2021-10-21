package as02_sem2_Q2;

/**
 * Exception class used for when an invalid StudentID is checked
 * @author Anthony Nadeau
 */
public class InvalidStudentIdException extends Exception {
    
    /**
     * Constructor for when the exception is thrown
     * @param message passed to the exception from the throw statement
     */
    public InvalidStudentIdException(String message) {
        super(message);
    }
}
