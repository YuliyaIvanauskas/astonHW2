package com.aston.hw2;

public class Main {

    public static final String[] LINES = new String[]{
        "Line 1",
        "Line 2",
        "Line 3"
    };
    private static final String DATA_TO_WRITE = "Write a program that will write data to and read data from a file. Create a custom exception and wrap errors when reading and writing from the file in it.";
    
    public static void main(String[] args) {
        String filePath = "data.txt";
        FileManager fileManager = new FileManager(filePath);
        
        fileWriteTest(fileManager);

        fileReadingTest(fileManager);

        writingStringArrayTest(fileManager, LINES);

        errorHandlingTest();
    }

    private static void errorHandlingTest() {
        FileManager nonExistentFile = new FileManager("non_existent_file.txt");
        try {
            String data = nonExistentFile.readFromFile();
            System.out.println(data);
        } catch (FileOperationException e) {
            System.err.println("Read error: " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("Reason: " + e.getCause().getMessage());
            }
        }
    }

    private static void writingStringArrayTest(FileManager fileManager, String[] lines) {
        try {

            fileManager.writeLinesToFile(lines);
        } catch (FileOperationException e) {
            System.err.println("Recording error: " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("Reason: " + e.getCause().getMessage());
            }
            e.printStackTrace();
        }
    }

    private static void fileReadingTest(FileManager fileManager) {
        try {
            String dataRead = fileManager.readFromFile();
            System.out.println(dataRead);
        } catch (FileOperationException e) {
            System.err.println("Read error: " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("Reason: " + e.getCause().getMessage());
            }
            e.printStackTrace();
        }
    }

    private static void fileWriteTest(FileManager fileManager) {
        try {
            fileManager.writeToFile(DATA_TO_WRITE);
        } catch (FileOperationException e) {
            System.err.println("Recording error: " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("Reason: " + e.getCause().getMessage());
            }
            e.printStackTrace();
        }
    }
}

