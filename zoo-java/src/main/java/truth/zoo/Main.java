package truth.zoo;

import truth.zoo.animals.*;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tiger tiger = new Tiger();
        Dolphin dolphin = new Dolphin();
        Penguin penguin = new Penguin();

        boolean continueZooMenu = true;

        while (continueZooMenu) {
            switch (displayMainMenu(scanner)) {
                case 1 -> handleTigerMenu(scanner, tiger);
                case 2 -> handleDolphinMenu(scanner, dolphin);
                case 3 -> handlePenguinMenu(scanner, penguin);
                case 4 -> saveAnimalsToFile(tiger, dolphin, penguin);
                case 5 -> loadAnimalsFromFile();
                default -> System.out.println("Invalid option.");
            }

            System.out.print("Continue Zoo menu? (1 for yes / 2 for no): ");
            continueZooMenu = scanner.nextInt() == 1;
        }
    }

    private static int displayMainMenu(Scanner scanner) {
        System.out.println("\n======= ZOO MENU =======");
        System.out.println("1. Tiger");
        System.out.println("2. Dolphin");
        System.out.println("3. Penguin");
        System.out.println("4. Save Animals to File");
        System.out.println("5. Load Animals from File");
        System.out.print("Select an option: ");
        return scanner.nextInt();
    }

    private static void handleTigerMenu(Scanner scanner, Tiger tiger) {
        boolean continueTiger = true;
        while (continueTiger) {
            switch (displayAnimalMenu(scanner, "Tiger")) {
                case 1 -> {
                    System.out.print("Enter number of stripes: ");
                    tiger.setNumberOfStripes(scanner.nextInt());
                    System.out.print("Enter speed: ");
                    tiger.setSpeed(scanner.nextInt());
                    System.out.print("Enter sound level: ");
                    tiger.setSoundLevel(scanner.nextInt());
                }
                case 2 -> System.out.println(tiger);
                case 3 -> tiger.walking();
                case 4 -> {
                    tiger.eatingFood();
                    tiger.eatingCompleted();
                }
                default -> System.out.println("Invalid option.");
            }
            System.out.print("Continue with Tiger? (1 for yes / 2 for no): ");
            continueTiger = scanner.nextInt() == 1;
        }
    }

    private static void handleDolphinMenu(Scanner scanner, Dolphin dolphin) {
        boolean continueDolphin = true;
        while (continueDolphin) {
            switch (displayAnimalMenu(scanner, "Dolphin")) {
                case 1 -> {
                    scanner.nextLine();
                    System.out.print("Enter color: ");
                    dolphin.setColor(scanner.nextLine());
                    System.out.print("Enter swimming speed: ");
                    dolphin.setSwimmingSpeed(scanner.nextInt());
                }
                case 2 -> System.out.println(dolphin);
                case 3 -> dolphin.swimming();
                case 4 -> {
                    dolphin.eatingFood();
                    dolphin.eatingCompleted();
                }
                default -> System.out.println("Invalid option.");
            }
            System.out.print("Continue with Dolphin? (1 for yes / 2 for no): ");
            continueDolphin = scanner.nextInt() == 1;
        }
    }

    private static void handlePenguinMenu(Scanner scanner, Penguin penguin) {
        boolean continuePenguin = true;
        while (continuePenguin) {
            switch (displayAnimalMenu(scanner, "Penguin")) {
                case 1 -> {
                    System.out.print("Is the penguin swimming (true/false): ");
                    penguin.setSwimming(scanner.nextBoolean());
                    System.out.print("Enter walk speed: ");
                    penguin.setWalkSpeed(scanner.nextInt());
                    System.out.print("Enter swim speed: ");
                    penguin.setSwimSpeed(scanner.nextInt());
                }
                case 2 -> System.out.println(penguin);
                case 3 -> {
                    if (penguin.isSwimming())
                        penguin.swimming();
                    else
                        penguin.walking();
                }
                case 4 -> {
                    penguin.eatingFood();
                    penguin.eatingCompleted();
                }
                default -> System.out.println("Invalid option.");
            }
            System.out.print("Continue with Penguin? (1 for yes / 2 for no): ");
            continuePenguin = scanner.nextInt() == 1;
        }
    }

    private static int displayAnimalMenu(Scanner scanner, String animalName) {
        System.out.println("\n--- " + animalName.toUpperCase() + " MENU ---");
        System.out.println("1. Set Properties");
        System.out.println("2. View Properties");
        System.out.println("3. Movement");
        System.out.println("4. Eating Behavior");
        System.out.print("Choose an option: ");
        return scanner.nextInt();
    }

    private static void saveAnimalsToFile(Tiger tiger, Dolphin dolphin, Penguin penguin) {
        String baseDir = "zoo-java/animal-data"; // Target directory to store files

        // Ensure directory exists
        File directory = new File(baseDir);
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            if (!created) {
                System.err.println("❌ Failed to create directory: " + baseDir);
                return;
            }
        }

        try (
                ObjectOutputStream tigerOut = new ObjectOutputStream(new FileOutputStream(baseDir + "/tiger.txt"));
                ObjectOutputStream penguinOut = new ObjectOutputStream(new FileOutputStream(baseDir + "/penguin.txt"));
                ObjectOutputStream dolphinOut = new ObjectOutputStream(
                        new FileOutputStream(baseDir + "/dolphin.txt"))) {
            tigerOut.writeObject(tiger);
            penguinOut.writeObject(penguin);
            dolphinOut.writeObject(dolphin);

            System.out.println("✅ All animals saved to files in: " + new File(baseDir).getAbsolutePath());
        } catch (IOException e) {
            System.err.println("❌ Error writing objects to file: " + e.getMessage());
        }
    }

    private static void loadAnimalsFromFile() {
        String baseDir = "zoo-java/animal-data";

        File tigerFile = new File(baseDir + "/tiger.txt");
        File penguinFile = new File(baseDir + "/penguin.txt");
        File dolphinFile = new File(baseDir + "/dolphin.txt");

        if (!tigerFile.exists() || !penguinFile.exists() || !dolphinFile.exists()) {
            System.err.println("❌ One or more animal files do not exist in: " + new File(baseDir).getAbsolutePath());
            return;
        }

        try (
                ObjectInputStream tigerIn = new ObjectInputStream(new FileInputStream(tigerFile));
                ObjectInputStream penguinIn = new ObjectInputStream(new FileInputStream(penguinFile));
                ObjectInputStream dolphinIn = new ObjectInputStream(new FileInputStream(dolphinFile))) {
            Tiger tiger = (Tiger) tigerIn.readObject();
            Penguin penguin = (Penguin) penguinIn.readObject();
            Dolphin dolphin = (Dolphin) dolphinIn.readObject();

            System.out.println("✅ Loaded animals from files:");
            System.out.println(tiger);
            System.out.println(penguin);
            System.out.println(dolphin);

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("❌ Error reading objects from file: " + e.getMessage());
        }
    }
}

