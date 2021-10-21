package as02_sem2_C;

/**
 * Condo class is a class derived from PropertyC
 * @author Anthony Nadeau
 */
public class Condo extends PropertyC {
    
    /**
     * Default Constructor
     */
    public Condo() {
        super();
    }
    
    /**
     * Parameterized Constructor
     * @param address address of the property
     * @param zoneCode zone of which the property is in
     * @param noOfBedrooms number of bedrooms within the property
     * @param yearOfConstruction year the property was constructed
     * @param riskFactor degree of risk when investing in the property
     */
    public Condo(String address, int zoneCode, int noOfBedrooms, int yearOfConstruction, 
        float riskFactor) {
        super(address, zoneCode, noOfBedrooms, yearOfConstruction, riskFactor);
    }
    
    /**
     * Copy constructor
     * @param condo condo being copied
     */
    public Condo(Condo condo) {
        this(condo.address, condo.zoneCode, condo.noOfBedrooms, condo.yearOfConstruction,
                condo.riskFactor);
    }
    
    /**
     * Overridden toString
     * @return the object as a string
     */
    @Override
    public String toString() {
        String str = "";
        str += String.format("Property %d:\n", counter);
        str += "Type: Condo\n";
        str += String.format("Address: %s\n", address); 
        str += String.format("Zone: %d\n", zoneCode); 
        str += String.format("No. of Bedrooms: %d\n", noOfBedrooms); 
        str += String.format("Year of Construction: %d\n", yearOfConstruction); 
        str += String.format("R Factor: %.1f\n\n", riskFactor);
        str += String.format("Investment analysis: %f\n", analyzeInvestment());
        str += String.format("Evaluated Price: %f\n\n", evaluatePrice(determineBasePrice()));
        str += "================================";
        return str;
    }
    
    /**
     * Overriding and definition of the method (finds the base price of the condo)
     * @return the base price of condo
     */
    @Override
    public int determineBasePrice() {
        int[] prices = {300000, 200000, 100000};
        return prices[zoneCode - 1];
    }
    
    /**
     * Overriding and definition of the method (analyzes investment value)
     * @return the investment value of the condo
     */
    @Override
    public double analyzeInvestment() {
        return riskFactor * 50;
    }
    
    /**
     * Overriding and definition of the method (evaluates final price)
     * @return the final price of the property
     */
    @Override
    public double evaluatePrice(int basePrice) {
        return basePrice + (0.05 * basePrice * noOfBedrooms) +
                (yearOfConstruction * 100) / 2;
    }
}
