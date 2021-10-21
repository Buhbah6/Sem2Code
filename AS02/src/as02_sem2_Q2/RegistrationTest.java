package as02_sem2_Q2;

import java.util.Scanner;

/**
 * Test Class for Question 2
 * @author Anthony Nadeau
 */
public class RegistrationTest {
    
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);  
        boolean successfulRegister = false; // condition for the loop to end
        do {
            Registration register = new Registration(); //makes registration object
            try {
                // Line 18 to 25 take user input to test values to be registered.
                System.out.println("Please enter desired StudentID.");
                register.checkStudentID(console.nextLine());
                System.out.println("Please enter number of courses you'd like to register for "
                        + "(3 are set by default).");
                register.registerCourse(console.nextInt());
                System.out.println("Please enter number of courses you'd like to withdraw from "
                        + "(Must be registered for at least 2 courses)");
                register.withdrawCourse(console.nextInt());
                System.out.println(register); // Prints out the final registration
                successfulRegister = true; // ends the loop
            }
            /**
             * Multi-Catch statement catches any of the following exceptions to 
             * print out the message associated with them
             */
            catch(InvalidStudentIdException | CourseRegisterException | CourseWithdrawException e) {
                System.out.println(e.getMessage());
                console.nextLine(); //used to avoid memory leak of scanner
            }
            /**
             * This catch block is used in case the user inputs a non-int value
             */
            catch (java.util.InputMismatchException e) {
                System.out.println("Invalid value. Must be a whole number");
                console.nextLine(); //used to avoid memory leak of scanner
            }
        }
        while (!successfulRegister);
    }
}
