package as03;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.util.Scanner;

/**
 * Driver Class for the Expense Class
 * @author Anthony Nadeau
 */
public class ExpensesTest {
    private static File file = new File("Expenses.ser"); // File having the array stored to
    
    /**
     * Main method 
     */
    public static void main(String[] args) {
        Expense[] exp = new Expense[50]; // Array of 50
        Scanner console = new Scanner(System.in);
        System.out.println("====Welcome to the Expense Tracking System====\n");
        menu(console, exp);
    }
    
    /**
     * Reads the file and stores the data in an array
     * @param exp the array storing the data
     * @return the amount of instantiated objects in the array
     */
    public static int readFromFile(Expense[] exp) {
        int purchaseCounter = 0;
        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            exp = (Expense[]) ois.readObject(); // reads the object and casts it to an Expense array
            ois.close();
        }
        catch (Exception e) {
            System.out.println("Unable to read file.");
        }
        for (Expense ex : exp) {
            if (ex != null)
                purchaseCounter++; // increases purchaseCounter when an instantiated object is detected.
        }
        return purchaseCounter;
    }
    
    /**
     * Writes an array object to a File
     * @param exp the array being written to the file;
     */
    public static void writeToFile(Expense[] exp) {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(exp); //writes the array to the file
            oos.close();
        }
        catch (Exception e) {
            System.out.println("Unable to write to file.");
        }
    }
    
    /**
     * calculates the amount spent on expenses in a given month
     * @param month the month of which the amount is being calculated.
     * @param exp the array containing the expenses
     * @return the amount spent in a given month.
     */
    public static double getMonthlyPurchase(int month, Expense[] exp) {
        double sum = 0;
        for (Expense ex : exp) {
            if (ex != null && month == ex.getMonth()) // checks that the object isn't null
                sum += ex.getPrice();                 // and the month parameter is the same as the expense's month
        }
        return sum;
    }
    
    /**
     * User menu, allows the user to navigate the methods
     * @param scan scanner that takes user input
     * @param exp the array being accessed in the methods
     */
    public static void menu(Scanner scan, Expense[] exp) {
        boolean validOption = false; // looping condition
        int purchaseCounter = readFromFile(exp);
        while (!validOption) {
        System.out.println("-Menu"); // Menu options
        System.out.println("1- Add a new Purchase.");
        System.out.println("2- View amount spent in a given month.");
        System.out.println("3- Exit.");
            System.out.println("What would you like to do?");
            try {               
                int choice = scan.nextInt();
                switch (choice) {
                    case 1: // adds to the array
                        System.out.println("Please enter month of purchase.");
                        int newMonth = scan.nextInt();
                        System.out.println("Please enter the name of the item purchased.");
                        scan.next(); // to avoid scanner memory leaks
                        String name = scan.nextLine();
                        System.out.println("Please enter price of item purchased.");
                        double price = scan.nextDouble();
                        exp[purchaseCounter] = new Expense(newMonth, name, price); // adds an object to the array
                        purchaseCounter++; // updates in case new object is added
                        break;
                    case 2: // gets monthly purchase
                        System.out.println("Please enter the month you'd like to "
                                + "see the amount spent during.");
                        int month = scan.nextInt();
                        double monthlyBill = getMonthlyPurchase(month, exp); // calls the method
                        System.out.println("\n*************************************\n");
                        System.out.println(String.format("The amount of money "
                                + "spent in month %d is %.2f\n", month, monthlyBill)); //prints the result
                        System.out.println("*************************************\n");
                        break;
                    case 3: // exits the program
                        System.out.println("Thank you for using our system!");
                        System.exit(0);
                        validOption = true;
                } 
            }
            catch (Exception e) { // Displays error message, catches any exception (InputMismatchException)
                System.out.println("Invalid Option, Please try again.");
                scan.next(); // to avoid scanner memory leaks
            }
        }
        writeToFile(exp); // Writes all the data to the file once the loop is over
    }
}
