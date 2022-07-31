package leetcode.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubsets {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> map = createWordsTwoFrequencies(words2);
        for (int i = 0; i < words1.length; i++) {
            String word = words1[i];
            if (isUniversal(word, new HashMap<>(map))) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean isUniversal(String word, Map<Character, Integer> frequencies) {
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (!frequencies.containsKey(current)) {
                continue;
            }
            int count = frequencies.get(current);
            if (count == 1) {
                frequencies.remove(current);
                if (frequencies.isEmpty()) {
                    return true;
                }
            }
            else {
                frequencies.put(current, count - 1);
            }
        }
        return false;
    }

    private Map<Character, Integer> createWordsTwoFrequencies(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            Map<Character, Integer> temp = new HashMap<>();
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char current = word.charAt(j);
                temp.put(current, temp.getOrDefault(current, 0) + 1);
                if (temp.get(current) > map.getOrDefault(current, 0)) {
                    map.put(current, temp.get(current));
                }
            }
        }
        return map;
    }

}
