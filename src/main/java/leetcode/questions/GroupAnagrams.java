package leetcode.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            throw new IllegalArgumentException();
        }
        Map<String, List<String>> map = createMap(strs);
        return new ArrayList<>(map.values());
    }

    private Map<String, List<String>> createMap(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String count = countLetters(strs[i]);
            List<String> anagrams = map.getOrDefault(count, new ArrayList<>());
            anagrams.add(strs[i]);
            map.put(count, anagrams);
        }
        return map;
    }

    private String countLetters(String str) {
        int[] counts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int letter = str.charAt(i) - 'a';
            counts[letter]++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < counts.length; i++) {
            stringBuilder.append('#');
            stringBuilder.append(counts[i]);
        }
        return stringBuilder.toString();
    }

}
