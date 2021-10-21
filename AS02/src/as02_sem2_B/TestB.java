package as02_sem2_B;

/**
 * Test Class for PropertyB, Condo, and SFHome
 * @author Anthony Nadeau
 */
public class TestB {
    
    public static void main(String[] args) {
        Condo condo = new Condo();
        SFHome sfhome = new SFHome();
        Condo condo2 = new Condo();
        SFHome sfhome2 = new SFHome();
        PropertyB[] prop = {condo, sfhome, condo2, sfhome2}; // Creates property array
        for (PropertyB property : prop) { // For each loop prints each property
            System.out.println(property);
        }
    }
}
