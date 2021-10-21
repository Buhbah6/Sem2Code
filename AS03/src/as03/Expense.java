package as03;

import java.io.Serializable;
// -------------------------------------------------------
// Assignment 3
// Written by: Anthony Nadeau - 2058983
// For Programming II Section 00001 – Winter 2021
// --------------------------------------------------------
public class Expense implements Serializable{
    private int month;
    private String purchaseName;
    private double price;
    
    /**
     * Default constructor
     */
    public Expense() {
        this.month = 1;
        this.purchaseName = null;
        this.price = 0;          
    }
    
    /**
     * Constructor with all the data members
     * @param month month of purchase
     * @param purchaseName name of purchase
     * @param price price of purchase
     */
    public Expense(int month, String purchaseName, double price) {
        this.month = month;
        this.purchaseName = purchaseName;
        this.price = price;
    }
    
    /**
     * Copy constructor
     * @param exp Expense object being copied
     */
    public Expense(Expense exp) {
        this.month = exp.month;
        this.purchaseName = exp.purchaseName;
        this.price = exp.price;
    }
    
    /**
     * Overriden toString converts an object to a string
     * @return the object as a String
     */
    @Override
    public String toString() {
        String str = "";
        str += String.format("The month of the expense is %d\n", this.month);
        str += String.format("The name of the expense is %s\n", this.purchaseName);
        str += String.format("The price of the expense is %f\n", this.price);
        return str;
    }
    
    /**
     * Compares two objects to see if they are identical
     * @param exp expense object
     * @return true or false if the objects are the same
     */
    public boolean equals(Expense exp) {
        return this.month == exp.month
                && this.purchaseName.equals(exp.purchaseName)
                && this.price == exp.price;
    }
    
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getPurchaseName() {
        return purchaseName;
    }

    public void setPurchaseName(String purchaseName) {
        this.purchaseName = purchaseName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }   
}