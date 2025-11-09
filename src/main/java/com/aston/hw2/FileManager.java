package com.aston.hw2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {

    private String filePath;

    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    public void writeToFile(String data) throws FileOperationException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            writer.write(data);
            System.out.println("Data successfully written to file: " + filePath);
        } catch (IOException e) {
            throw new FileOperationException("Error writing to file: " + filePath, e);
        }
    }

    public String readFromFile() throws FileOperationException {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            StringBuilder content = new StringBuilder();
            for (String line : lines) {
                content.append(line).append("\n");
            }
            System.out.println("Data was successfully read from the file: " + filePath);
            return content.toString().trim();
        } catch (IOException e) {
            throw new FileOperationException("Error reading from file: " + filePath, e);
        }
    }

    public void writeLinesToFile(String[] lines) throws FileOperationException {
        try {
            File file = new File(filePath);
            boolean fileExists = file.exists() && file.length() > 0;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                if (fileExists) {
                    writer.newLine();
                }
                for (int i = 0; i < lines.length; i++) {
                    writer.write(lines[i]);
                    if (i < lines.length - 1) {
                        writer.newLine();
                    }
                }
                System.out.println("Data successfully written to file: " + filePath);
            }
        } catch (IOException e) {
            throw new FileOperationException("Error writing to file: " + filePath, e);
        }
    }

}

