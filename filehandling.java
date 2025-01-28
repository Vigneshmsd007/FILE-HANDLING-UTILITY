

import java.io.*;
import java.nio.file.*;

public class filehandling {

    // Method to write data to a file
    public static void writeToFile(String fileName, String data) {
        try {
        	int a=10/2;
            // Create a FileWriter to write to the file
            FileWriter writer = new FileWriter(fileName, false); // 'true' allows appending data
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            // Write the data to the file
            bufferedWriter.write(data);
            bufferedWriter.newLine();  // Adds a new line after writing

            // Close the buffered writer
            bufferedWriter.close();

            System.out.println("Data has been written to the file.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // Method to read data from a file
    public static void readFromFile(String fileName) {
        try {
            // Create a BufferedReader to read the file
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;

            // Read and print each line from the file
            System.out.println("Contents of the file:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Close the buffered reader
            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("An error occurred while reading from the file.");
            e.printStackTrace();
        }
    }

    // Method to modify content in a file (here, we replace a word in the file)
    public static void modifyFile(String fileName, String oldWord, String newWord) {
        try {
            // Read all content from the file
            String content = new String(Files.readAllBytes(Paths.get(fileName)));

            // Replace the old word with the new word
            content = content.replace(oldWord, newWord);

            // Write the modified content back to the file
            Files.write(Paths.get(fileName), content.getBytes());

            System.out.println("File has been modified.");
        } catch (IOException e) {
            System.err.println("An error occurred while modifying the file.");
            e.printStackTrace();
        }
    }

    // Main method to demonstrate file operations
    public static void main(String[] args) {
        String fileName = "example.txt";  // File name for operations

        // Writing data to the file
        writeToFile(fileName, "Hello, this is a sample text file.");
        writeToFile(fileName, "We can perform various operations on this file.");

        // Reading data from the file
        readFromFile(fileName);

        // Modifying the file (replace "sample" with "demo")
        modifyFile(fileName, "sample", "demo");

        // Reading the modified data from the file
        readFromFile(fileName);
    }
}

