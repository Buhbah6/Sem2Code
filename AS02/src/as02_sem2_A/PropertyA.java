package as02_sem2_A;

import java.util.Scanner;
// -------------------------------------------------------
// Assignment 2: Properties and Registration 
// Written by: Anthony Nadeau - 2058983
// For Programming II Section 00001 – Winter 2021
// --------------------------------------------------------
/**
 * Property A is the property class for Question 1.A
 * @author Anthony Nadeau
 */
public class PropertyA {
    private String address;
    private int zoneCode;   //possible values are 1,2,3
    private int noOfBedrooms;
    private int yearOfConstruction;
    private float riskFactor; // (0.0 to 1.0)
    private String type;
    
    /**
     * Default Constructor
     */
    public PropertyA() {
        this.address = null;
        this.zoneCode = 1;
        this.noOfBedrooms = 0;
        this.yearOfConstruction = 0;
        this.riskFactor = 0;
        this.type = null;
    }
    
    /**
     * Parameterized Constructor
     * @param address address of the property
     * @param zoneCode zone of which the property is in
     * @param noOfBedrooms number of bedrooms within the property
     * @param yearOfConstruction year the property was constructed
     * @param riskFactor degree of risk when investing in the property
     * @param type type of property (Condo or SFHome)
     */
    public PropertyA(String address, int zoneCode, int noOfBedrooms, int yearOfConstruction, 
            float riskFactor, String type) {
        this.address = address;
        setZoneCode(zoneCode);
        this.noOfBedrooms = noOfBedrooms;
        this.yearOfConstruction = yearOfConstruction;
        setRiskFactor(riskFactor);
        setType(type);
    }
    
    /**
     * Copy Constructor
     * @param property property object being copied 
     */
    public PropertyA(PropertyA property) {
        this.address = property.address;
        this.zoneCode = property.zoneCode;
        this.noOfBedrooms = property.noOfBedrooms;
        this.yearOfConstruction = property.yearOfConstruction;
        this.riskFactor = property.riskFactor;
        this.type = property.type;
    }
    
     /**
     * Overridden toString
     * @return the object as a string
     */
    @Override
    public String toString() {
        String str = "";
        str += String.format("Type: %s\n", type);
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
    public boolean equals(PropertyA property) {
        return this.address.equals(property.address) 
                && this.zoneCode == property.zoneCode
                && this.noOfBedrooms == property.noOfBedrooms
                && this.yearOfConstruction == property.yearOfConstruction
                && this.riskFactor == property.riskFactor
                && this.type.equals(property.type);
    }
    
    /**
     * analyzes value of investment
     * @return value of Investment based on the riskFactor
     */
    public double analyzeInvestment() {
        return this.riskFactor * 50;
    }
    
    /**
     * Uses the type of property and the zone code to establish the base price of
     * the property
     * @return the base price of the property
     */
    public int determineBasePrice() {
        int[] condoPrices = {300000, 200000, 10000};
        int[] sfHomePrices = {500000, 400000, 300000};
        if (type.equalsIgnoreCase("Condo")) 
            return condoPrices[zoneCode - 1];
        else
            return sfHomePrices[zoneCode - 1];
    }
    
    /**
     * Evaluates the price of the property 
     * @param basePrice base price of the property
     * @return the final price of the property
     */
    public double evaluatePrice(int basePrice) {
        return basePrice + (0.05 * basePrice * noOfBedrooms) + 
                (yearOfConstruction * 100) / 2;
    }
    
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
    
    public String getType() {
        return type;
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
    
    public void setType(String type) {
        if (!type.equals("Condo") && !type.equals("SFHome")) {
            System.out.println("Invalid Type.");
            System.exit(0);
        }           
        this.type = type;
    }
}
