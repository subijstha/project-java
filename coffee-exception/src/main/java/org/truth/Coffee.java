package org.truth;

import com.sun.jdi.InvalidTypeException;

public class Coffee {
    // Attributes to store information about the coffee
    String name;                // for example, "Espresso", "Latte", "Mocha"
    String roast;               // for example, "light", "medium", "dark"
    int caffeineLevelInMg;      // calculated based on the roast
    double price;               // in dollars, for example, 2.50



    public double getPrice(){
        return price;
    }
    // Constructor to create a new coffee object with the given information
    public Coffee(String name, String roast, double price) {
        this.name = name;
        this.roast = roast;
        this.price = price;

        // surround the setCaffeineLevel() method call with a try-catch block to handle the exception
        // The constructor calls the method to set the caffeine level based on the roast
        try{

            setCaffeineLevel();
        }catch(InvalidTypeException e){
            //  set the caffeineLevelInMg to 50
            caffeineLevelInMg = 50;
        }
    }

    //  setCaffeineLevel() method throws a InvalidTypeException
    // Method to set the caffeine level of the coffee based on the roast
    public void setCaffeineLevel() throws InvalidTypeException {
        if (roast.equals("light")) {
            caffeineLevelInMg = 50;
        } else if (roast.equals("medium")) {
            caffeineLevelInMg = 100;
        } else if (roast.equals("dark")) {
            caffeineLevelInMg = 150;
        } else {
            // throw a "InvalidTypeException" with a message
            throw new InvalidTypeException("Invalid roast: Please select a valid roast type!");
        }
    }

    // Methods to simulate coffee preparation
    public void grindBeans() {
        System.out.println("\nGrinding beans for " + name + "...");
    }

    public void brewCoffee() {
        System.out.println("\nBrewing your favorite " + name + "...");
    }

    // Method to print the information about the coffee
    public void printInfo() {
        System.out.println("\nYou ordered a " + name + " with a " + roast + " roast.");
        System.out.println("The caffeine level in your coffee is " + caffeineLevelInMg + " mg.");
    }
}
