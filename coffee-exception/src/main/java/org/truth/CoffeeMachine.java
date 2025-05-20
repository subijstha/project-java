package org.truth;

import org.truth.coffeetype.Espresso;
import org.truth.coffeetype.Latte;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        // Create a Scanner object to read input
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Coffee Machine!");
            System.out.println("Select an option to continue:");
            System.out.println("1. Espresso");
            System.out.println("2. Latte");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1, 2, or 3): ");

            // Read user's choice
            int choice = keyboard.nextInt();

            switch (choice) {
                case 1:
                    // Initialize the name of Espresso
                    String espressoName = "Espresso";

                    // Initialize the price of Espresso per serving
                    double espressoPrice = 2.50;

                    // Ask the user for the type of roast and store it in espressoRoast
                    System.out.print("What Roast would you like? (light, medium, dark): ");
                    String espressoRoast = keyboard.next();

                    // Ask the user for the number of shots and store it in numberOfShots
                    System.out.print("How many servings would you like? (a number please): ");
                    int numberOfShots = keyboard.nextInt();

                    //  myEspresso object with a try-catch block to handle the ArithmeticException.

                    Espresso myEspresso =null;
                    try{
                        myEspresso = new Espresso(espressoName, espressoRoast, espressoPrice, numberOfShots);
                    }catch(ArithmeticException e){
                        System.out.println("Error in creating your Espresso. Invalid number of shots.");
                        System.out.println("Please enter a valid number of servings. (a non zero number please!!) ");
                        numberOfShots = keyboard.nextInt();
                    }finally{
                        myEspresso = new Espresso(espressoName, espressoRoast, espressoPrice,numberOfShots);
                    }

                    // TODO 8: declare the myEspresso object before the try block and set it to null.

                    // TODO 9: inside the catch block, ask the user to enter number of shots and store it in numberOfShots

                    // TODO 10: add a finally block, and initialize the myEspresso object again

                    myEspresso.grindBeans();

                    myEspresso.brewCoffee();

                    myEspresso.printInfo();

                    myEspresso.printEspressoDetails();

                    break;
                case 2:

                    // Initialize the name of Latte
                    String latteName = "Latte";

                    // Initialize the price of Latte
                    double lattePrice = 3.50;

                    // Ask the user for the type of roast and store it in latteRoast
                    System.out.print("What Roast would you like? (light, medium, dark): ");
                    String latteRoast = keyboard.next();

                    // Ask the user for the milk type and store it in milkType
                    System.out.print("What milk type would you like? (whole, skim, almond, oat): ");
                    String milkType = keyboard.next();

                    // Ask the user if they want syrup or not
                    System.out.print("Would you like syrup? (yes/ no): ");
                    String syrupWanted = keyboard.next();

                    String syrupFlavor = "no";
                    // if syrupWanted is yes, Ask the user for the syrup flavor and store it in syrupFlavor
                    if (syrupWanted.equals("yes")) {
                        System.out.print("Which flavor would you like? (vanilla, caramel, hazelnut): ");
                        syrupFlavor = keyboard.next();
                    }

                    Latte myLatte = null;
                    // surround the myLatte object with a try-catch block to handle the IllegalArgumentException.
                    try{

                        myLatte = new Latte(latteName, latteRoast, lattePrice, milkType, syrupFlavor);
                    }catch(IllegalArgumentException e){
                        System.out.println("Error invalid choice!! :-" + milkType);
                        System.out.println("Please choose a valid type of milk among the available options! ");
                        milkType = keyboard.next();
                    }finally{
                        myLatte = new Latte(latteName, latteRoast, lattePrice, milkType, syrupFlavor);
                    }

                    // e myLatte object before the try block aninside the catch block, ask the user to enter milkType again

                    //  add a finally block, and initialize the myLatte object again

                    myLatte.grindBeans();

                    myLatte.brewCoffee();

                    myLatte.printInfo();

                    myLatte.printLatteDetails();

                    break;
                case 3:
                    System.out.println("Thank you for using the Coffee Machine!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }
}
