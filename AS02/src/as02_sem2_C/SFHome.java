package as02_sem2_C;

/**
 * SFHome class is a class derived from PropertyC
 * @author Anthony Nadeau
 */
public class SFHome extends PropertyC {
    
    /**
     * Default Constructor
     */
    public SFHome() {
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
    public SFHome(String address, int zoneCode, int noOfBedrooms, int yearOfConstruction, 
        float riskFactor) {
        super(address, zoneCode, noOfBedrooms, yearOfConstruction, riskFactor);
    }
    
    /**
     * Copy constructor
     * @param sfHome SFHome being copied
     */
    public SFHome(SFHome sfHome) {
        this(sfHome.address, sfHome.zoneCode, sfHome.noOfBedrooms, sfHome.yearOfConstruction,
                sfHome.riskFactor);
    }
    
    /**
     * Overridden toString
     * @return the object as a string
     */
    @Override
    public String toString() {
        String str = "";
        str += String.format("Property %d:\n", counter);
        str += "Type: Single-Family Home\n";
        str += String.format("Address: %s\n", address); 
        str += String.format("Zone: %d\n", zoneCode); 
        str += String.format("No. of Bedrooms: %d\n", noOfBedrooms); 
        str += String.format("Year of Construction: %d\n", yearOfConstruction); 
        str += String.format("R Factor: %.1f\n\n", riskFactor);
        str += String.format("Investment analysis: %.1f\n", analyzeInvestment());
        str += String.format("Evaluated Price: %f\n\n", evaluatePrice(determineBasePrice()));
        str += "================================";
        return str;
    }
    
    /**
     * Overriding and definition of the method (finds the base price of the SFHome)
     * @return the base price of SFHome
     */
    @Override
    public int determineBasePrice() {
        int[] prices = {500000, 400000, 300000};
        return prices[zoneCode - 1];
    }
    
    /**
     * Overriding and definition of the method (analyzes investment value)
     * @return the investment value of the SFHome
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
