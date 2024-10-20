package com.example.finaltry;
public class TextCounter {
    public int countWords(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        String[] words = input.split("[\\s,\\.]+");
        return words.length;
    }
    public int countCharacters(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        return input.length();
    }
}
