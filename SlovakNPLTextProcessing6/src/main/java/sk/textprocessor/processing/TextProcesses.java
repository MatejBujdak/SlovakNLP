package sk.textprocessor.processing;

import sk.textprocessor.arguments.ArgumentParser;
import java.lang.StringBuilder;
import cz.cuni.mff.ufal.morphodita.*;


import java.util.*;
import java.util.List;



public class TextProcesses {


    //    tokenization
    public String[] tokenize(String text){

        boolean comma = false;
        StringBuilder stacked_word = new StringBuilder();
        StringBuilder output = new StringBuilder();
        String[] array;
        String punctuation = ".,<>'/\\\"}{[]|!@#$%^&*()_-=+:;?`~";
        for(int i = 0; i < text.length();i++) {

            String current_char = text.substring(i, i + 1);

            if (((current_char.matches("[\\d,]")) && (text.substring(i + 1, i + 2).matches("[\\d,]"))) &&
                    !(((current_char.equals(","))) && ( text.charAt(i+1) == ','
                    )) && !(  current_char.charAt(0)  == ',' && stacked_word.length() == 0)
                     ) {
                if(comma && current_char.equals(",")){  //checks for a second comma in stack_work
                    comma = false;
                }else if(current_char.equals(",")){
                    comma = true;
                    stacked_word.append(current_char);
                }else{
                    stacked_word.append(current_char);
                }


            }

            if (!(stacked_word.length() == 0)) {
                output.append(" ").append(stacked_word);
                stacked_word.setLength(0);
                comma = false;
                if (current_char.matches("\\d")) output.append(current_char).append(" ");
                else output.append(" ").append(current_char).append(" ");
            } else if (punctuation.contains(current_char)) {
                output.append(" ").append(current_char).append(" ");

            } else {
                output.append(current_char);
            }

        }

        StringBuilder result = new StringBuilder();

        //removes duplicate spaces in the code
        for(int i = 0; i < output.length(); i++) {
            if(output.substring(i,i+1).equals(" ") && output.substring(i+1,i+2).equals(" ")){
                continue;
            }
            result.append(output.charAt(i));
        }

        //split the text if there is a space
        array = result.toString().trim().split(" ");

        //LowerCasing
        if(ArgumentParser.isLowerCasing()){
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i].toLowerCase();
        }
    }
        return array;
    }

//    extractSentences
    public String[] extractSentences(String text) {
        ArrayList<String> sentences = new ArrayList<>();

        Abbreviation skr = new Abbreviation();
        boolean dictionary = false;

        int sentenceLastChar = 0;
        int wordLastChar = 0;
        String word;

        for (int i = 1; i < text.length() - 3; i++) {
            String ch = text.substring(i, i + 3);

            if (text.charAt(i + 2) == ' ') {
                word = text.substring(wordLastChar, i + 2).trim().toLowerCase();
                wordLastChar = i + 3;
                dictionary = skr.isAbbreviation(word);
            }

            if ((ch.matches("[!?.\"']\\s[^a-z]")) && !dictionary && !text.substring(i-1,i).matches("[ŠČŤŽÝÁÍÉÚÄÔŇĚŔĽA-Z]") ) {
                sentences.add(text.substring(sentenceLastChar, i + 1).trim());
                sentenceLastChar = i + 1;
            }
        }
        sentences.add(text.substring(sentenceLastChar).trim());
        String[] sentenceArray = new String[sentences.size()];
        sentenceArray = sentences.toArray(sentenceArray);

        //LowerCasing
        if(ArgumentParser.isLowerCasing()){
            for (int i = 0; i < sentenceArray.length; i++) {
                sentenceArray[i] = sentenceArray[i].toLowerCase();
            }
        }

        return sentenceArray;
    }


    public String[] lemmatize(String text){
        //Loading the model
        String modelPath = "src/taggers/slovak-morfflex-pdt-170914.tagger";
        Tagger tagger = Tagger.load(modelPath);

        String dictPath = "src/taggers/slovak-morfflex-170914.dict";
        Morpho morpho = Morpho.load(dictPath);

        //Lematization of each word in the text
        List<String> words = Arrays.asList(this.tokenize(text));
        String[] lemmasArray = new String[words.size()];
        int i = 0;
        for (String word : words) {
            TaggedLemmas lemmas = new TaggedLemmas();
            Forms forms = new Forms();
            forms.add(word);
            tagger.tag(forms, lemmas);
            String lemma = lemmas.get(0).getLemma();
            List<String> rawLemmas = Collections.singletonList(morpho.rawLemma(lemma));
            String rawLemma = rawLemmas.get(0);
            lemmasArray[i++] = rawLemma;
        }

        if(ArgumentParser.isLowerCasing()){
            for (int k = 0; i < lemmasArray.length; i++) {
                lemmasArray[k] = lemmasArray[k].toLowerCase();
            }
        }

        return lemmasArray;
    }



    public LinkedHashMap<String, String> analyze(String text){

        String modelPath = "src/taggers/slovak-morfflex-pdt-170914.tagger";
        Tagger tagger = Tagger.load(modelPath);

        List<String> words = Arrays.asList(this.tokenize(text));
        LinkedHashMap<String, String> tags = new LinkedHashMap<>();
        for (String word : words) {
            TaggedLemmas lemmas = new TaggedLemmas();
            Forms forms = new Forms();
            forms.add(word);
            tagger.tag(forms, lemmas);
            String tag = lemmas.get(0).getTag();
            if (!tag.contains("X@")) {
                tags.put(word, tag);
            }
        }

        if (ArgumentParser.isLowerCasing()) {
            for (Map.Entry<String, String> entry : tags.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue().toLowerCase();
                tags.put(key, value);
            }
        }

        return tags;
    }


}








