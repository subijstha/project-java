package com.truth.classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {
    public static void createSampleFile(String directory, String fileName, String content){
        File dir = new File(directory);

        // Create directory if it does not exist
        if (!dir.exists()) {
            boolean created = dir.mkdirs();
            if (created) {
                System.out.println("Directory created: " + dir.getAbsolutePath());
            } else {
                System.out.println("Failed to create directory: " + dir.getAbsolutePath());
            }
        }

        File file = new File(dir, fileName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
            System.out.println("File created: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error creating file: " + file.getAbsolutePath());
            e.printStackTrace();
        }

        
    }
}
