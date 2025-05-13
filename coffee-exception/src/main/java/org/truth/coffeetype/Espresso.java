package org.truth.coffeetype;

import org.truth.Coffee;



public class Espresso extends Coffee {

    int numberOfShots;

    // constructor throws a ArithmeticException
    public Espresso(String name, String roast, double price, int numberOfShots) throws ArithmeticException {
        super(name, roast, price);

        // TODO 5: check whether at least 1 serving has been selected, if not, throw an exception with a message
        if(numberOfShots >=  1){
            this.numberOfShots = numberOfShots;
        }else{
            throw new ArithmeticException("Please select at least 1 serving");

        }
    }

    public void printEspressoDetails() {
        System.out.println("You asked for " + numberOfShots + " servings!");
        System.out.println("Every serving of Espresso costs " + getPrice() +
                "$. Your total bill is " + (getPrice() * numberOfShots) + "$.");
    }
}
