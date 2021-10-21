package as02_sem2_A;

/**
 * Test Class for Property A
 * @author Anthony Nadeau
 */
public class TestA {
    
    public static void main(String[] args) {
        PropertyA prop = new PropertyA();
        PropertyA prop2 = new PropertyA("123 Prog2 St", 2, 6, 1947, (float) 0.9, "Condo"); // Valid property
        System.out.println(prop2.analyzeInvestment()); //Prints the result of the analyze result method
        System.out.println(prop2.evaluatePrice(prop2.determineBasePrice())); 
        // above statement prints the result of the evaluate price method (using determineBasePriceMethod)
    }
}
