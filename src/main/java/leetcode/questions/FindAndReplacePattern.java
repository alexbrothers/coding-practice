package leetcode.questions;

import java.util.*;

public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        if (words == null || words.length == 0 || pattern == null || pattern.length() == 0) {
            throw new IllegalArgumentException();
        }
        Set<String> seen = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (seen.contains(words[i]) || matchesPattern(words[i], pattern)) {
                result.add(words[i]);
            }
            seen.add(words[i]);
        }
        return result;
    }

    private boolean matchesPattern(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        Map<Character, Character> mappings = new HashMap<>();
        Set<Character> mappedCharacters = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char currentWordCharacter = word.charAt(i);
            char currentPatternCharacter = pattern.charAt(i);
            if (mappings.containsKey(currentPatternCharacter)) {
                Character mapped = mappings.get(currentPatternCharacter);
                if (mapped != currentWordCharacter) {
                    return false;
                }
            }
            else {
                if (mappedCharacters.contains(currentWordCharacter)) {
                    return false;
                }
                mappings.put(currentPatternCharacter, currentWordCharacter);
                mappedCharacters.add(currentWordCharacter);
            }
        }
        return true;
    }

}
