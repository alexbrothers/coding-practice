package leetcode.questions;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {

    private String[] morseLetters = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",
            ".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) {
            throw new IllegalArgumentException();
        }
        if (words.length == 1) {
            return 1;
        }
        Set<String> result = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            result.add(convertWord(words[i]));
        }
        return result.size();
    }

    private String convertWord(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            stringBuilder.append(morseLetters[index]);
        }
        return stringBuilder.toString();
    }

}
