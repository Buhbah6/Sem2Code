package selftesting;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

/**
 *
 * @author thego
 */
public class Question3 {
    
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<Double> scoreList = new ArrayList<Double>();
        menu(nameList, scoreList, console);
    }
    
    public static void addPlayer(ArrayList names, ArrayList scores, Scanner console) {
        if (names.size() < 10) {
            boolean validScore = false;
            console.nextLine();
            System.out.println("Please enter the Player's name: ");
            names.add(console.nextLine());
            while (validScore == false) {
                try {
                    System.out.println("Please enter the Player's score");
                    scores.add(console.nextDouble());
                    validScore = true;
                }
                catch (Exception e) {
                    console.nextLine();
                    System.out.println("Invalid Score: Please try again.");
                }
            }
        }
        else
            System.out.println("Max Players Reached.");
    }
    
    public static void printPlayerInfo(ArrayList names, ArrayList scores) {
        if (names.isEmpty()) {
            System.out.println("No players found, please select a different function.");
            return;
        }
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("Name: %s | Score: %s\n",names.get(i), scores.get(i));
        }
    }
    
    public static void showScore(ArrayList names, ArrayList scores, Scanner console) {
        boolean validName = false;
        if (names.isEmpty()) {
            System.out.println("No players found, please select a different function.");
            return;
        }
        while (!validName) {
            try {
                console.nextLine();
                System.out.println("Please enter the Player's name");
                System.out.println("Score: " + scores.get(names.indexOf(console.nextLine())));
                validName = true;
            }
            catch (Exception e) {
                console.nextLine();
                System.out.println("Name not found. Please try again.");
            }
        }
    }
    
    public static void removePlayer(ArrayList names, ArrayList scores, Scanner console) {
        boolean validName = false;
        if (names.isEmpty()) {
            System.out.println("No players found, please select a different function.");
            return;
        }
        while (!validName) {
            try {
                console.nextLine();
                System.out.println("Please enter the Player's name");
                int idxOfPlayer = names.indexOf(console.nextLine());
                names.remove(idxOfPlayer);
                scores.remove(idxOfPlayer);
                System.out.println("Player Deleted.");
                validName = true;
            }
            catch (Exception e) {
                console.nextLine();
                System.out.println("Name not found. Deletion unsuccessful. Please try again.");
            }
        }
    }
    
    public static void menu(ArrayList names, ArrayList scores, Scanner console) {
        System.out.println("Please select your function:\n");
        System.out.println("\tA. Add a new player");
        System.out.println("\tB. Print all player info");
        System.out.println("\tC. Search high score by player name");
        System.out.println("\tD. Remove a player\n");
        System.out.println("Select 'E' if you'd like to exit the program.\n");
        menuFunctions(console.next().charAt(0), names, scores, console);   
    }
    
    public static void menuFunctions(char a, ArrayList names, ArrayList scores, Scanner console ) {
        switch (Character.toUpperCase(a)) {
            case 'A':
                addPlayer(names, scores, console);
                continueProgram(names, scores, console);
                break;
            case 'B':
                printPlayerInfo(names, scores);
                continueProgram(names, scores, console);
                break;
            case 'C':
                showScore(names, scores, console);
                continueProgram(names, scores, console);
                break;
            case 'D':
                removePlayer(names, scores, console);
                continueProgram(names, scores, console);
                break;
            case 'E':
                exitProgram(names, scores, console);
                break;
            default:
                System.out.println("Function unavailable.");
                continueProgram(names, scores, console);
        } 
    }
    
    public static void continueProgram(ArrayList names, ArrayList scores, Scanner console) {
        System.out.println("Would you like to Continue?");
        System.out.println("'Y' for yes\tor\t'N' for no");
        boolean validOption = false;
        while (!validOption) {
            String response = console.next().toUpperCase();
            if (response.equals("Y")) {
                System.out.println("Returning to main menu.");
                System.out.println("\n--------------------------------------------");
                menu(names, scores, console);
                validOption = true;
            }
            else if (response.equals("N")) {
                exitProgram(names, scores, console);
                validOption = true;
            }
            else {
            console.nextLine();
            System.out.println("Invalid option, Please try again.");
            }
        }
    }
    
    public static void exitProgram(ArrayList names, ArrayList scores, Scanner console) {
        System.out.println("Are you sure you'd like to exit?");
        System.out.println("'Y' for yes\tor\t'N' for no");
        boolean validOption = false;
        while (!validOption) {
            String response = console.next().toUpperCase();
            if (response.equals("Y")) {
                System.out.println("Thank you for using our services!");
                validOption = true;
            }
            else if (response.equals("N")) {
                System.out.println("Returning to main menu.");
                menu(names, scores, console);
                validOption = true;
            }
            else {
            console.nextLine();
            System.out.println("Invalid option, Please try again.");
            }
        }
    }
}
