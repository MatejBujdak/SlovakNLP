
package sk.textprocessor.input;

import sk.textprocessor.exceptions.InvalidInputFileException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputReader {

    public String readFile(String fileName) throws InvalidInputFileException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder text = new StringBuilder();
            String line;

            while (( line = br.readLine()) != null) {
                text.append(line).append("\n");
            }
            return text.toString();

        } catch (IOException e) {
            throw new InvalidInputFileException("Error: Incorrectly specified file");
        }
    }
}




