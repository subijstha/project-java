package com.truth.classes;

import java.io.File;

public class DirectoryManager {

    // Define a static void method called listFilesAndDirectories with a
    // single parameter directoryPath of type String
    public static void listFilesAndDirectories(String directoryPath) {
        // Create a new File object for the directoryPath
        File file = new File(directoryPath);

        // Use the listFiles() method from the File class to get an array of
        // File objects
        File[] filesList = file.listFiles();

        // Check if the array is null or empty
        if (filesList == null) {
            // If it is empty or null, print an appropriate message indicating the same
            System.out.println("The directory is empty..");
        } else {
            // If not, loop through the array and print each file's name
            System.out.println("List of available books: ");
            File[] files = filesList;
            int sizeOfFile = filesList.length;

            for (int i = 0; i < sizeOfFile; i++) {
                File file1 = files[i];
                System.out.println("Title : " + file1.getName());
            }
        }
    }

    // define a static void method called createDirectory with a single
    // parameter directoryPath of type String
    public static void createDirectory(String directoryPath) {

        // create a new File object for the directoryPath
        File directory = new File(directoryPath);

        // check if the directory exists using the exists() method from the File class

        if (!directory.exists()) {
            // If the directory does not exist, create the directory using the mkdirs()
            // method from the File class
            if (!directory.mkdir()) {
                System.out.println("failed  to create a directory");
                return;
            }
            System.out.println("Directory created successfully");
            // Print a message indicating that the directory was created

        } else {
            System.out.println("Directory already exists");

        }
    }
}
