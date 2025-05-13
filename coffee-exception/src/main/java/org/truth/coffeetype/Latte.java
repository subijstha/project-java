package org.truth.coffeetype;

import org.truth.Coffee;

public class Latte extends Coffee {
    String milkType;
    String syrupFlavor;

    // the constructors throws a InvalidTypeException
    public Latte(String name, String roast, double price, String milkType, String syrupFlavor) throws IllegalArgumentException{
        super(name, roast, price);

        // check whether a valid milkType is selected, if not throws an exception with a message
        if(milkType.equalsIgnoreCase("whole" )||
                milkType.equalsIgnoreCase( "skim") ||
                milkType.equalsIgnoreCase("almond") ||
                milkType.equalsIgnoreCase("oat")){
            this.milkType = milkType;
        }else{
            throw new IllegalArgumentException("Please select a valid milk type!!");
        }
        this.syrupFlavor = syrupFlavor;
    }

    public void printLatteDetails() {
        System.out.println("Your latte has " + milkType + " milk and " + syrupFlavor + " flavor.");
        System.out.println("Your total bill is " + getPrice() + "$.");
    }
}

