package as02_sem2_C;

import java.util.Scanner;

/**
 * Property C is the property class for Question 1.C (ABSTRACT)
 * @author Anthony Nadeau
 */
public abstract class PropertyC {
    protected String address;
    protected int zoneCode;   //possible values are 1,2,3
    protected int noOfBedrooms;
    protected int yearOfConstruction;
    protected float riskFactor; // (0.0 to 1.0)
    protected static int propertyNum = 0;
    protected int counter = 0;
    
    /**
     * Default Construction
     */
    public PropertyC() {
        this.address = null;
        this.zoneCode = 1;
        this.noOfBedrooms = 0;
        this.yearOfConstruction = 0;
        this.riskFactor = 0;
        propertyNum++;
        counter = propertyNum;
    }
    
    /**
     * Parameterized Constructor
     * @param address address of the property
     * @param zoneCode zone of which the property is in
     * @param noOfBedrooms number of bedrooms within the property
     * @param yearOfConstruction year the property was constructed
     * @param riskFactor degree of risk when investing in the property
     */
    public PropertyC(String address, int zoneCode, int noOfBedrooms, int yearOfConstruction, 
            float riskFactor) {
        this.address = address;
        setZoneCode(zoneCode);
        this.noOfBedrooms = noOfBedrooms;
        this.yearOfConstruction = yearOfConstruction;
        setRiskFactor(riskFactor);
        propertyNum++;
        counter = propertyNum;
    }
    
    /**
     * Copy Constructor
     * @param property property object being copied 
     */
    public PropertyC(PropertyC property) {
        this.address = property.address;
        this.zoneCode = property.zoneCode;
        this.noOfBedrooms = property.noOfBedrooms;
        this.yearOfConstruction = property.yearOfConstruction;
        this.riskFactor = property.riskFactor;
        propertyNum++;
    }
    
    /**
     * Overridden toString
     * @return the object as a string
     */
    @Override
    public String toString() {
        String str = "";
        str += String.format("Property %d:\n", counter);
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
     * Equals method - Checks if 2 properties are the same
     * @param property property being compared
     * @return true or false: if the properties are the same
     */
    public boolean equals(PropertyC property) {
        return this.address.equals(property.address) 
                && this.zoneCode == property.zoneCode
                && this.noOfBedrooms == property.noOfBedrooms
                && this.yearOfConstruction == property.yearOfConstruction
                && this.riskFactor == property.riskFactor;
    }
    
    // The following 3 methods are undefined abstract methods
    public abstract int determineBasePrice();
    public abstract double analyzeInvestment();
    public abstract double evaluatePrice(int basePrice);
    
    public String getAddress() {
        return address;
    }
    
    public int getZoneCode() {
        return zoneCode;
    }
    
    public int getNoOfBedrooms() {
        return noOfBedrooms;
    }
    
    public int getYearOfConstruction() {
        return yearOfConstruction;
    }
    
    public float getRiskFactor() {
        return riskFactor;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setZoneCode(int zoneCode) {
        if (zoneCode != 1 && zoneCode != 2 && zoneCode != 3 ) {
            System.out.println("Invalid Zone Code.");
            System.exit(0);
        }
        this.zoneCode = zoneCode;
    }

    public void setNoOfBedrooms(int noOfBedrooms) {
        this.noOfBedrooms = noOfBedrooms;
    }
    
    public void setYearOfConstruction(int yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }
    
    public void setRiskFactor(float riskFactor) {
        if (riskFactor < 0 || riskFactor > 1) {
            System.out.println("Invalid Risk Factor.");
            System.exit(0);
        }
        this.riskFactor = riskFactor;
    }
}
