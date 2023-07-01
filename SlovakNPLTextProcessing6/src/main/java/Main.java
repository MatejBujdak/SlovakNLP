import sk.textprocessor.arguments.ArgumentParser;
import sk.textprocessor.exceptions.*;

import sk.textprocessor.input.InputReader;
import sk.textprocessor.output.FileHandler;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        InputReader InputReader = new InputReader();
        FileHandler FileHandler = new FileHandler();

        try {
            ArgumentParser Argument = new ArgumentParser(args);
            String inputText = InputReader.readFile(ArgumentParser.getInputFile());


//            new file controller

            if(!ArgumentParser.getNewFileName().equals("")){
                FileHandler.createNewFile(ArgumentParser.getNewFileName(),Argument.processTextArgument(inputText));

            }
            if(ArgumentParser.isChangeFile()){
                FileHandler.changeFile(Argument.processTextArgument(inputText),ArgumentParser.getInputFile());

            }
            if(ArgumentParser.isPrintText()){
                Object result = Argument.processTextArgument(inputText);
                System.out.println(result);
                if (result instanceof String[]) {
                    String[] output = (String[]) result;
                    for(String i : output){
                        System.out.println(i);
                    }

                } else if (result instanceof LinkedHashMap) {
                    LinkedHashMap<String, String> output = (LinkedHashMap<String, String>) result;
                    for (Map.Entry<String, String> entry : output.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                }
            }

//
        } catch (UnknownParametersException | InvalidInputFileException | InvalidParametersCombinationException | InvalidOutputFileException | RuntimeException  |
                 InvalidTextProcessingTypeException e) {
            System.err.println(e.getMessage());
        }


    }
}
