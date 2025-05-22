package com.truth.classes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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

    // : Define a static void method called renameDirectory with two
    // parameters: currentDirectory and newDirectory of type String
    public static void renameDirectory(String currentDirectory, String newDirectory) {
        // create two File objects for the currentDirectory and newDirectory

        File oldDir = new File(currentDirectory);
        File newDir = new File(newDirectory);

        // Check if the new directory already exists using the exists() method
        // from the File class
        if (newDir.exists()) {
            System.out.println("The new Directory already exists");
        } else {
            // Use the renameTo() method from the File class to rename the old
            // directory to the new directory
            if (!oldDir.renameTo(newDir)) {
                // If the rename fails, print an error message
                System.out.println("Failed to rename Directory");

            } else {
                // If the rename is successful, print a success message
                System.out.println("Directory has been renamed successfully.");
                ;
            }

        }

    }

    // Define a static void method called copyFiles with two parameters sourceDir
    // and destDir of type String
    public static void copyFiles(String sourceDir, String destDir) {
        // create Path objects for the sourceDir and destDir using the Paths.get()
        // method
        Path sourcePath = Paths.get(sourceDir);
        Path destinationPath = Paths.get(destDir);

        // Write a try-catch block to handle IOException because creating a new
        // directory and copying files can throw an IOException
        try {
            // Check if the destination directory exists using the exists() method from the
            // Files class
            if (!Files.exists(destinationPath)) {
               
                // If the destination directory does not exist, create the directory using the
                // createDirectories() method from the Files class
                Files.createDirectories(destinationPath);
            }

            // Iterate through the files in the source directory using a loop
            File sourceDirectory = new File(sourceDir);
           
            File[] files = sourceDirectory.listFiles();
          
            // For each file, create a Path object using the file's name and the destDir
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        Path destFilePath = destinationPath.resolve(file.getName());

                        // Use the copy() method from the Files class to copy the file to the
                        // destination directory
                        Files.copy(file.toPath(), destFilePath, StandardCopyOption.REPLACE_EXISTING);
                        // Print a message indicating that the file was copied
                        System.out.println("Copied: " + file.getName());
                    } else {
                        System.out.println("Source directory is empty or does not exists");

                    }
                }

            }
        } catch (IOException e) {
            System.out.println("Errror copying files : " + e.getMessage());
        }
    }


    public static void deleteFile(String fileName) {
        //  create a File object using the provided fileName
        File file = new File(fileName);

        // Attempt to delete the file using the delete() method from the File
        // class
        if (file.delete()) {
            // If the file is deleted successfully, print a message indicating the same
            System.out.println("file deleted successfully " + fileName);

        } else {
            // If the file deletion fails, print an error message
            System.out.println("failed to delete file : " + fileName);

        }
    }

}
