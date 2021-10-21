package as02_sem2_C;

/**
 * Test Class for PropertyC, Condo, and SFHome
 * @author Anthony Nadeau
 */
public class TestC {
    
    public static void main (String[] args) {
        Condo condo1 = new Condo("7 Main St.", 1, 2, 2012, (float) 0.1);
        Condo condo2 = new Condo("20 Square St.", 2, 1, 2020, (float) 0.02);
        SFHome sfHome1 = new SFHome("65 rue College.", 3, 3, 1988, (float) 0.2);
        SFHome sfHome2 = new SFHome("110 Flowers rd.", 1, 4, 1992, (float) 0.15);
        PropertyC[] properties = {condo1, condo2, sfHome1, sfHome2}; // Creates property array
        
        for (PropertyC property: properties) { // For each loop prints each property
            System.out.println(property);
        }
    }
}
