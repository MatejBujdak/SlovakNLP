package sk.textprocessor.output;
import java.nio.file.Path;

import sk.textprocessor.exceptions.InvalidOutputFileException;

import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileHandler {




    public <T>  void createNewFile(String fileName, T outputData) throws InvalidOutputFileException{
        String path = System.getProperty("user.home") + "/Desktop";
        String text = processFileData(outputData);
        String filename = fileName + ".txt";
        String fullPath = Paths.get(path, filename).toString();
        Path filePath = Paths.get(fullPath);

        try{
            Files.createFile(filePath);
            Files.write(filePath, String.join("\n", text).getBytes());
            System.out.println("The file was created successfully");
        } catch(IOException e){
            throw new InvalidOutputFileException("Error: file could not be created");
        }
    }

    public <T> void changeFile(String path, T outputData) throws InvalidOutputFileException {
        String text = processFileData(outputData);
        try {
            FileWriter fw = new FileWriter(path);
            fw.write(String.join("\n", text));
            fw.close();
            System.out.println("The file has been successfully overwritten!");
        } catch (IOException e) {
            throw new InvalidOutputFileException("Error: file not found");
        }
    }

    public <T> String processFileData(T fileData) {
        StringBuilder sb = new StringBuilder();
        if (fileData instanceof String[]) {
            String[] lines = (String[]) fileData;
            for (String line : lines) {
                sb.append(line).append("\n");
            }
        } else if (fileData instanceof LinkedHashMap) {
            LinkedHashMap<String, Double> map = (LinkedHashMap<String, Double>) fileData;
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                sb.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
            }
        }
        return sb.toString();
    }





}







